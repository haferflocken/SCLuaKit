package scluacheck.verify

import scluacheck.ast._

import scala.collection.mutable.ArrayBuffer

/**
  * Pass 2 of type checking, which uses the symbol tables from pass 1.
  * This class takes in an AST and the symbol tables and fills in the types of any functions
  * whose types can be inferred using only the data within the file (the "basic" functions).
  * It also attempts to fill in the types of any identifiers which it can fill in.
  *
  * This type checking yields errors when any metamethods are in use.
  *
  * Implementation note: any function whose corresponding function in BuildSymbolTableVisitor
  * creates a new symbol table must traverse into that symbol table.
  */
object InferBasicFunctionTypesVisitor extends ASTVisitor[TypedNode] {
  private var returnTypes : ArrayBuffer[Type] = null // The return types of the function we are in.
  private var _warnings : ArrayBuffer[String] = null
  private var _errors : ArrayBuffer[String] = null
  var globalTable : SymbolTable = null
  var localTable : SymbolTable = null

  // TODO uncomment when this class is complete:
  def warnings = _warnings
  def errors = _errors

  override def visit(n : StatementList) : TypedNode = { visitList(n); new TypedNode(n, NilType) }
  override def visit(n : ExprList) : TypedNode = { visitList(n); new TypedNode(n, NilType) }

  // The type of a file is always NilType.
  override def visit(n : FileNode) : TypedNode = {
    _warnings = new ArrayBuffer[String]
    _errors = new ArrayBuffer[String]
    visitList(n.statements)
    new TypedNode(n, NilType)
  }

  // Statements all have the NilType, but assignment statements can affect the types of their variables.
  override def visit(n : AssignmentStatement) : TypedNode = {
    visitList(n.vars)
    visitList(n.values)
    new TypedNode(n, NilType)
  }

  // Function calls are not type checked in this pass.
  override def visit(n : FunctionCallStatement) : TypedNode = { visit(n.call); new TypedNode(n, null) }

  override def visit(n : ExplicitBlockStatement) : TypedNode = {
    localTable = localTable.subTables(n)
    visitList(n.statements)
    localTable = localTable.parentTable
    new TypedNode(n, NilType)
  }

  override def visit(n : WhileStatement) : TypedNode = {
    visit(n.condition)
    localTable = localTable.subTables(n)
    visitList(n.body)
    localTable = localTable.parentTable
    new TypedNode(n, NilType)
  }

  override def visit(n : RepeatUntilStatement) : TypedNode = {
    localTable = localTable.subTables(n)
    visitList(n.body)
    visit(n.condition)
    localTable = localTable.parentTable
    new TypedNode(n, NilType)
  }

  override def visit(n : IfStatement) : TypedNode = {
    visit(n.condition)
    localTable = localTable.subTables(n)
    visitList(n.thn)
    localTable = localTable.parentTable
    if (n.els != null)
      visit(n.els)
    new TypedNode(n, NilType)
  }

  override def visit(n : ReturnStatement) : TypedNode = {
    if (n.returnValues != null) {
      val exprs = n.returnValues.elements
      // If any return types have already been inferred, Type.or them with the types we are inferring now.
      val firstBound = Math.min(exprs.size, returnTypes.size)
      for (i <- Range(0, firstBound)) {
        val tn = visit(exprs(i))
        returnTypes(i) = Type.or(tn.t, returnTypes(i))
      }
      // Add any additional types we are inferring to the return types.
      for (i <- Range(firstBound, exprs.size)) {
        returnTypes += visit(exprs(i)).t
      }
    }
    new TypedNode(n, NilType)
  }

  override def visit(n : BreakStatement) : TypedNode = new TypedNode(n, NilType)
  override def visit(n : ContinueStatement) : TypedNode = new TypedNode(n, NilType)

  override def visit(n : ForNumericStatement) : TypedNode = {
    visit(n.start)
    visit(n.end)
    visit(n.inc)

    localTable = localTable.subTables(n)
    visitList(n.body)
    localTable = localTable.parentTable

    new TypedNode(n, NilType)
  }

  override def visit(n : ForEachStatement) : TypedNode = {
    visit(n.collection)

    localTable = localTable.subTables(n)
    visitList(n.body)
    localTable = localTable.parentTable

    new TypedNode(n, NilType)
  }

  override def visit(n : LocalVariableDeclarationStatement) : TypedNode = { visitList(n.values); new TypedNode(n, NilType) }

  override def visit(n : LogicalBinopExpression) : TypedNode = new TypedNode(n, Type.or(visit(n.lhs).t, visit(n.rhs).t))

  override def visit(n : BitwiseBinopExpression) : TypedNode = {
    val lhs = visit(n.lhs)
    val rhs = visit(n.rhs)
    checkAndInfer(n, lhs, NumberType, "Bitwise expressions may only operate on numbers.")
    checkAndInfer(n, rhs, NumberType, "Bitwise expressions may only operate on numbers.")
    new TypedNode(n, NumberType) // Return a number even if we error out so we can continue type checking properly.
  }

  override def visit(n : RelationalBinopExpression) : TypedNode = {
    val lhs = visit(n.lhs)
    val rhs = visit(n.rhs)
    if (n.op == RelationalBinop.EQ || n.op == RelationalBinop.NE) {
      if (lhs.t != null && rhs.t != null && !Type.intersects(lhs.t, rhs.t))
        reportWarning(n, "Equality expression is constant because the operands have different types.")
    } else {
      val expectedType = Type.or(NumberType, StringType)
      checkAndInfer(n, lhs, expectedType, "Relational expression contains operands which may not support the operator.")
      checkAndInfer(n, rhs, expectedType, "Relational expression contains operands which may not support the operator.")
    }
    new TypedNode(n, BooleanType) // Relational operators must always return a boolean.
  }

  override def visit(n : ConcatenationExpression) : TypedNode = {
    val lhs = visit(n.lhs)
    val rhs = visit(n.rhs)
    val expectedType = Type.or(NumberType, StringType)
    checkAndInfer(n, lhs, expectedType, "Concatenation expression relies on the \"concat\" metamethod.")
    checkAndInfer(n, rhs, expectedType, "Concatenation expression relies on the \"concat\" metamethod.")
    new TypedNode(n, StringType) // String concatenation must always return a string.
  }

  override def visit(n : ArithmeticBinopExpression) : TypedNode = {
    val lhs = visit(n.lhs)
    val rhs = visit(n.rhs)
    val expectedType = Type.or(NumberType, StringType)
    checkAndInfer(n, lhs, expectedType, "Arithmetic expression relies on a metamethod.")
    checkAndInfer(n, rhs, expectedType, "Arithmetic expression relies on a metamethod.")
    new TypedNode(n, NumberType)
  }

  override def visit(n : NotExpression) : TypedNode = { visit(n.e); new TypedNode(n, BooleanType) } // "not" always returns true or false.

  override def visit(n : NegationExpression) : TypedNode = {
    val t = visit(n.e)
    checkAndInfer(n, t, Type.or(NumberType, StringType), "Arithmetic negation can only be performed on numbers and certain strings.")
    new TypedNode(n, NumberType) // Arithmetic negation always returns a number.
  }

  // Function calls are type-checked in a later pass.
  override def visit(n : FunctionCallExpression) : TypedNode = { visit(n.func); visitList(n.args); new TypedNode(n, null) }

  // TODO record-style tables could be type checked if they were identified as records
  // Table access expressions can potentially return anything.
  override def visit(n : TableAccessExpression) : TypedNode = { visit(n.table); visit(n.field); new TypedNode(n, OmniType) }

  override def visit(n : ParentheticalExpression) : TypedNode = visit(n.e)

  override def visit(n : IdentifierExpression) : TypedNode = {
    val local = localTable.lookup(n.id)
    if (local != null)
      return new TypedNode(n, local.t)
    val global = globalTable.lookup(n.id)
    if (global != null)
      return new TypedNode(n, global.t)
    reportError(n, "Symbol table was not built correctly.")
    new TypedNode(n, NilType)
  }

  override def visit(n : BooleanLiteral) : TypedNode = new TypedNode(n, BooleanType)
  override def visit(n : NumericLiteral) : TypedNode = new TypedNode(n, NumberType)
  override def visit(n : StringLiteral) : TypedNode = new TypedNode(n, StringType)
  override def visit(n : NilLiteral) : TypedNode = new TypedNode(n, NilType)

  // The goal of visiting a function declaration is to infer its return types and the types of its parameters.
  override def visit(n : FunctionDeclarationExpression) : TypedNode = {
    val prevReturnTypes = returnTypes
    returnTypes = new ArrayBuffer[Type]

    localTable = localTable.subTables(n)
    visitList(n.body)

    val argTypes = new ArrayBuffer[Type]
    if (n.params != null) {
      for (p <- n.params) {
        argTypes += localTable.lookup(p.id).t
      }
    }
    localTable = localTable.parentTable

    val fnType = new TypedNode(n, FunctionType(returnTypes, argTypes))
    // TODO detect bad function types?
    // TODO keep function type around?

    returnTypes = prevReturnTypes
    fnType
  }

  override def visit(n : TableConstructorExpression) : TypedNode = { visitList(n.keys); visitList(n.values); new TypedNode(n, TableType) }
  override def visit(n : UpValueExpression) : TypedNode = visit(n.id)
  override def visit(n : VarArgsExpression) : TypedNode = new TypedNode(n, TableType)

  private def reportWarning(n : ASTNode, message : String) : Unit = {
    _warnings += n.line + ":" + n.column + " -> " + message
  }

  private def reportError(n : ASTNode, message : String) : Unit = {
    _errors += n.line + ":" + n.column + " -> " + message
  }

  private def checkAndInfer(callingNode : ASTNode, tn : TypedNode, expectedType : Type, errorMessage : String) : Unit = {
    // If the type is null, we set it to the expected type if it is an IdentifierExpression.
    // The type should only be null if tn.node is an identifier or a function call.
    if (tn.t == null) {
      tn.node match {
        case id : IdentifierExpression =>
          tn.t = expectedType
          val local = localTable.lookup(id.id)
          if (local != null) {
            local.t = expectedType
          } else {
            val global = globalTable.lookup(id.id)
            // global is guaranteed not to be null.
            global.t = expectedType
          }
        case _ : FunctionCallExpression =>
        case _ : FunctionCallStatement =>
      }
    }
    // If the type is not null, we make sure it intersects the expected type.
    // If it doesn't, raise an error.
    else if (!Type.intersects(tn.t, expectedType)) {
      reportError(callingNode, errorMessage)
    }
  }
}

/**
  * A node and its type.
  */
class TypedNode(val node : ASTNode, var t : Type)
