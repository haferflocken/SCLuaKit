package scluacheck.verify

import scluacheck.ast._

/**
  * Build a symbol table for the Lua AST. This is the first pass of type checking.
  *
  * The methods globalTable and localTable return the most recent result of running this visitor on a FileNode.
  */
object BuildSymbolTableVisitor extends ASTVisitor[Unit] {
  private var _globalTable : SymbolTable = null
  private var _localTable : SymbolTable = null

  def globalTable = _globalTable
  def localTable = _localTable

  override def visit(n : StatementList) : Unit = visitList(n)
  override def visit(n : ExprList) : Unit = visitList(n)

  // Visiting a file node resets things before visiting.
  override def visit(n : FileNode) : Unit = {
    _globalTable = new SymbolTable(null, Seq(), Map())
    _localTable = new SymbolTable(null, Seq(), Map())
    visit(n.statements)
  }

  override def visit(n : AssignmentStatement) : Unit = {
    visit(n.values) // This is visited before the bindings because the bindings are not yet in scope.
    visit(n.vars)
  }

  override def visit(n : FunctionCallStatement) : Unit = visit(n.call)
  override def visit(n : ExplicitBlockStatement) : Unit = visitNewScope(n, n.statements)
  override def visit(n : WhileStatement) : Unit = { visit(n.condition); visitNewScope(n, n.body) }

  override def visit(n : RepeatUntilStatement) : Unit = {
    var newLocalTable = new SymbolTable(_localTable, Seq(), Map())
    _localTable = newLocalTable
    visit(n.body)
    visit(n.condition)

    newLocalTable = _localTable
    _localTable = _localTable.parentTable
    _localTable.addSubTable(n, newLocalTable)
  }

  override def visit(n : IfStatement) : Unit = {
    visit(n.condition)
    visitNewScope(n, n.thn)
    if (n.els != null)
      visit(n.els)
  }

  override def visit(n : ReturnStatement) : Unit = visitList(n.returnValues)

  override def visit(n : BreakStatement) : Unit = {}
  override def visit(n : ContinueStatement) : Unit = {}

  override def visit(n : ForNumericStatement) : Unit = {
    var newLocalTable = new SymbolTable(_localTable, Seq(), Map())
    _localTable = newLocalTable
    _localTable = _localTable.addSymbol(n.index.id)
    visit(n.start)
    visit(n.end)
    visit(n.inc)
    visit(n.body)

    newLocalTable = _localTable
    _localTable = _localTable.parentTable
    _localTable.addSubTable(n, newLocalTable)
  }

  override def visit(n : ForEachStatement) : Unit = {
    var newLocalTable = new SymbolTable(_localTable, Seq(), Map())
    _localTable = newLocalTable
    _localTable = _localTable.addSymbol(n.i1.id)
    if (n.i2 != null)
      _localTable = _localTable.addSymbol(n.i2.id)
    visit(n.collection)
    visit(n.body)

    newLocalTable = _localTable
    _localTable = _localTable.parentTable
    _localTable.addSubTable(n, newLocalTable)
  }

  override def visit(n : LocalVariableDeclarationStatement) : Unit = {
    visitList(n.values) // This is visited before the identifiers because the identifiers are not in scope yet.
    for (i <- n.names)
      _localTable = _localTable.addSymbol(i.id)
  }
  
  override def visit(n : LogicalBinopExpression) : Unit = { visit(n.lhs); visit(n.rhs) }
  override def visit(n : BitwiseBinopExpression) : Unit = { visit(n.lhs); visit(n.rhs) }
  override def visit(n : RelationalBinopExpression) : Unit = { visit(n.lhs); visit(n.rhs) }
  override def visit(n : ConcatenationExpression) : Unit = { visit(n.lhs); visit(n.rhs) }
  override def visit(n : ArithmeticBinopExpression) : Unit = { visit(n.lhs); visit(n.rhs) }
  override def visit(n : NotExpression) : Unit = visit(n.e)
  override def visit(n : NegationExpression) : Unit = visit(n.e)
  override def visit(n : FunctionCallExpression) : Unit = { visit(n.func); visit(n.args) }
  override def visit(n : TableAccessExpression) : Unit = { visit(n.table); visit(n.field) }
  override def visit(n : ParentheticalExpression) : Unit = visit(n.e)

  override def visit(n : IdentifierExpression) : Unit = {
    if (!_localTable.lookup(n.id) && !_globalTable.lookup(n.id)) {
      _globalTable = _globalTable.addSymbol(n.id)
    }
  }

  override def visit(n : BooleanLiteral) : Unit = {}
  override def visit(n : NumericLiteral) : Unit = {}
  override def visit(n : StringLiteral) : Unit = {}
  override def visit(n : NilLiteral) : Unit = {}

  override def visit(n : FunctionDeclarationExpression) : Unit = {
    var newLocalTable = new SymbolTable(_localTable, Seq(), Map())
    _localTable = newLocalTable
    if (n.params != null) {
      for (p <- n.params)
        _localTable = _localTable.addSymbol(p.id)
    }
    if (n.hasVarArgs)
      _localTable = _localTable.addSymbol("...")

    newLocalTable = _localTable
    _localTable = _localTable.parentTable
    _localTable.addSubTable(n, newLocalTable)
  }

  // Keys in tables are not added to the symbol tables, but we visit them along with the values.
  override def visit(n : TableConstructorExpression) : Unit = { visit(n.keys); visit(n.values) }

  override def visit(n : UpValueExpression) : Unit = visit(n.id)

  // Varargs cannot exist in the global table.
  override def visit(n : VarArgsExpression) : Unit = _localTable.lookup("...")

  private def visitNewScope(scopeName : ASTNode, chunk : StatementList) : Unit = {
    var newLocalTable = new SymbolTable(_localTable, Seq(), Map())
    _localTable = newLocalTable
    visit(chunk)

    newLocalTable = _localTable
    _localTable = _localTable.parentTable
    _localTable.addSubTable(scopeName, newLocalTable)
  }
}

class SymbolTable(val parentTable : SymbolTable, val symbols : Seq[String], var subTables : Map[ASTNode, SymbolTable]) {
  def lookup(s : String) : Boolean = symbols.contains(s) || (parentTable != null && parentTable.lookup(s))

  def addSymbol(s : String) = new SymbolTable(parentTable, symbols :+ s, subTables)
  def addSubTable(k : ASTNode, v : SymbolTable) : Unit = { subTables = subTables + (k -> v) }

  override def toString : String = toIndentedString("")

  private def toIndentedString(prefix : String) : String = {
    var out = prefix + symbols.mkString("{", ", ", "}")
    for ((_, s) <- subTables) {
      out += "\n" + s.toIndentedString(prefix + "  ")
    }
    out
  }
}
