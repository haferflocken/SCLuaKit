package scluacheck.ast

/**
  * Prints the AST as pseudo-Lua. Singleton version of the base pretty printer.
  */
object ASTPrettyPrintVisitor extends BasePrettyPrintVisitor

/**
  * Prints the AST as pseudo-Lua. Methods should not have dangling newlines.
  * The convention is that visiting an expression will not return a string with indentation on the first line,
  * but visiting a statement will.
  *
  * Designed as a base class for pretty print visitors with Lua-like output.
  */
abstract class BasePrettyPrintVisitor extends ASTVisitor[String] {

  protected def join(strs : Seq[String], separator : String) : String = {
    var out = ""
    if (strs.nonEmpty) {
      out += strs.head
      for (s <- strs.slice(1, strs.size))
        out += separator + s
    }
    out
  }

  protected def indentStrings(inStrs : Seq[String]) : String = {
    val s = (for (i <- inStrs) yield i.split("\n")).flatten
    "  " + join(s, "\n  ")
  }

  protected def indentVisitList(l : StatementList) : String = indentStrings(visitList(l))

  protected def commaSeparate(s : Seq[String]) : String = join(s, ", ")

  override def visit(n : StatementList) : String = throw new java.lang.Error("Not implemented")
  override def visit(n : ExprList) : String = throw new java.lang.Error("Not implemented")

  override def visit(n : FileNode) : String = join(visitList(n.statements), "\n")

  override def visit(n : AssignmentStatement) : String = {
    val vars = visitList(n.vars)
    val values = visitList(n.values)

    commaSeparate(vars) + " = " + commaSeparate(values)
  }

  override def visit(n : FunctionCallStatement) : String = visit(n.call)

  override def visit(n : ExplicitBlockStatement) : String = {
    "do" + "\n" + indentVisitList(n.statements) + "\n" + "end"
  }

  override def visit(n : WhileStatement) : String =
    "while " + visit(n.condition) + " do\n" + indentVisitList(n.body) + "\n" + "end"

  override def visit(n : RepeatUntilStatement) : String =
    "repeat" + "\n" + indentVisitList(n.body) + "\n" + "until " + visit(n.condition)

  override def visit(n : IfStatement) : String = {
    var out = "if " + visit(n.conditions.head) + " then\n"
    out += indentVisitList(n.bodies.head).trim()

    for (i <- Range(1, n.conditions.size)) {
      val c = n.conditions(i)
      out += "\nelseif " + visit(c) + " then\n" + indentVisitList(n.bodies(i)).trim()
    }

    if (n.conditions.size < n.bodies.size)
      out += "\nelse\n" + indentVisitList(n.bodies.last).trim()

    out + "\nend"
  }

  override def visit(n : ReturnStatement) : String = "return " + commaSeparate(visitList(n.returnValues))

  override def visit(n : BreakStatement) : String = "break"

  override def visit(n : ContinueStatement) : String = "continue"

  override def visit(n : ForNumericStatement) : String = {
    val out = "for " + visit(n.index) + " = " + visit(n.start) + ", "
    out + visit(n.end) + ", " + visit(n.inc) + " do\n" + indentVisitList(n.body) + "\n" + "end"
  }

  override def visit(n : ForEachStatement) : String = {
    var out = "for " + visit(n.i1)
    if (n.i2 != null)
      out += ", " + visit(n.i2)
    out + " in " + visit(n.collection) + " do\n" + indentVisitList(n.body) + "\n" + "end"
  }

  override def visit(n : LocalVariableDeclarationStatement) : String = {
    var out = "local " + commaSeparate(n.names.map((e : IdentifierExpression) => visit(e)))
    if (n.values != null)
      out += " = " + commaSeparate(visitList(n.values))
    out
  }

  override def visit(n : LogicalBinopExpression) : String = visit(n.lhs) + " " + visitLogicalOp(n.op) + " " + visit(n.rhs)
  override def visit(n : BitwiseBinopExpression) : String = visit(n.lhs) + " " + visitBitwiseOp(n.op) + " " + visit(n.rhs)
  override def visit(n : RelationalBinopExpression) : String = visit(n.lhs) + " " + visitRelationalOp(n.op) + " " + visit(n.rhs)
  override def visit(n : ConcatenationExpression) : String = visit(n.lhs) + " .. " + visit(n.rhs)
  override def visit(n : ArithmeticBinopExpression) : String = visit(n.lhs) + " " + visitArithmeticOp(n.op) + " " + visit(n.rhs)
  override def visit(n : NotExpression) : String = "not " + visit(n.e)
  override def visit(n : NegationExpression) : String = "-" + visit(n.e)
  override def visit(n : FunctionCallExpression) : String = visit(n.func) + "(" + commaSeparate(visitList(n.args)) + ")"
  override def visit(n : TableAccessExpression) : String = visit(n.table) + "[" + visit(n.field) + "]"
  override def visit(n : ParentheticalExpression) : String = "(" + visit(n.e) + ")"
  override def visit(n : IdentifierExpression) : String = n.id
  override def visit(n : BooleanLiteral) : String = n.v.toString
  override def visit(n : NumericLiteral) : String = n.v.toString
  override def visit(n : StringLiteral) : String =  "\"" + n.v + "\""
  override def visit(n : NilLiteral) : String = "nil"

  override def visit(n : FunctionDeclarationExpression) : String = {
    var out = "function("
    out += commaSeparate(n.params.map((e : IdentifierExpression) => visit(e)))
     if (n.hasVarArgs) {
       if (n.params.nonEmpty)
         out += ", ..."
       else
         out += "..."
    }
    out + ")\n" + indentVisitList(n.body) + "\n" + "end"
  }

  override def visit(n : TableConstructorExpression) : String = {
    if (n.keys.elements.isEmpty)
      return "{}"

    val values = visitList(n.values)

    var out = ""
    if (n.keys.elements.nonEmpty) {
      var k = n.keys.elements.head
      out += visitTableEntry(k, 1.0, values.head)

      for (i <- Range(1, n.keys.elements.size)) {
        k = n.keys.elements(i)
        out += ",\n" + visitTableEntry(k, (i + 1).toDouble, values(i))
      }
    }

    "{\n" + out + "\n" + "}"
  }

  override def visit(n : UpValueExpression) : String = "upValue(" + visit(n.id) + ")"
  override def visit(n : VarArgsExpression) : String = "..."

  // This function resugars table entries.
  private def visitTableEntry(k : Expression, index : Double, v : String) : String = {
    k match {
      case nL : NumericLiteral =>
        if (nL.v == index)
          indentStrings(Seq(v))
        else
          indentStrings(Seq("[" + visit(k) + "] = " + v))
      case _ =>
        indentStrings(Seq("[" + visit(k) + "] = " + v))
    }
  }

  private def visitLogicalOp(n : LogicalBinop.LogicalBinop) : String = {
    n match {
      case LogicalBinop.AND => "and"
      case LogicalBinop.OR => "or"
    }
  }

  private def visitBitwiseOp(n : BitwiseBinop.BitwiseBinop) : String = {
    n match {
      case BitwiseBinop.AND => "&"
      case BitwiseBinop.OR => "|"
    }
  }

  private def visitRelationalOp(n : RelationalBinop.RelationalBinop) : String = {
    n match {
      case RelationalBinop.EQ => "=="
      case RelationalBinop.NE => "~="
      case RelationalBinop.LT => "<"
      case RelationalBinop.GT => ">"
      case RelationalBinop.LTE => "<="
      case RelationalBinop.GTE => ">="
    }
  }

  private def visitArithmeticOp(n : ArithmeticBinop.ArithmeticBinop) : String = {
    n match {
      case ArithmeticBinop.ADD => "+"
      case ArithmeticBinop.SUBTRACT => "-"
      case ArithmeticBinop.MULTIPLY => "*"
      case ArithmeticBinop.DIVIDE => "/"
      case ArithmeticBinop.MODULO => "%"
      case ArithmeticBinop.POWER => "^"
    }
  }
}