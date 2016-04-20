package scluacheck.ast

/**
  * Prints the AST as pseudo-Lua. Methods should not have dangling newlines.
  * The convention is that visiting an expression will not return a string with indentation on the first line,
  * but visiting a statement will.
  */
object ASTPrettyPrintVisitor extends ASTVisitor[String] {

  private def join(strs : Seq[String], separator : String) : String = {
    var out = ""
    if (strs.nonEmpty) {
      out += strs.head
      for (s <- strs.slice(1, strs.size))
        out += separator + s
    }
    out
  }

  private def indentStrings(inStrs : Seq[String]) : String = {
    val s = (for (i <- inStrs) yield i.split("\n")).flatten
    "  " + join(s, "\n  ")
  }

  private def indentVisitList(l : StatementList) : String = indentStrings(visitList(l))

  private def commaSeparate(s : Seq[String]) : String = join(s, ", ")

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
    var out = "if " + visit(n.condition) + " then\n" + indentVisitList(n.thn)
    if (n.els != null)
      out += "\n" + "else " + visit(n.els).trim()
    out + "\n" + "end"
  }

  override def visit(n : ReturnStatement) : String = "return " + commaSeparate(visitList(n.returnValues))

  override def visit(n : BreakStatement) : String = "break"

  override def visit(n : ContinueStatement) : String = "continue"

  override def visit(n : ForNumericStatement) : String = {
    val out = "for " + visit(n.index) + " <- Range(" + visit(n.start) + ", "
    out + visit(n.end) + ", " + visit(n.inc) + ") do\n" + indentVisitList(n.body) + "\n" + "end"
  }

  override def visit(n : ForEachStatement) : String = {
    var out = "for " + visit(n.i1)
    if (n.i2 != null)
      out += visit(n.i2)
    out + " in " + visit(n.collection) + " do\n" + indentVisitList(n.body) + "\n" + "end"
  }

  override def visit(n : LocalVariableDeclarationStatement) : String = {
    var out = "local " + commaSeparate(n.names.map((e : IdentifierExpression) => visit(e)))
    if (n.values != null)
      out += " = " + commaSeparate(visitList(n.values))
    out
  }

  override def visit(n : LogicalBinopExpression) : String = visit(n.lhs) + " " + n.op + " " + visit(n.rhs)
  override def visit(n : BitwiseBinopExpression) : String = visit(n.lhs) + " " + n.op + " " + visit(n.rhs)
  override def visit(n : RelationalBinopExpression) : String = visit(n.lhs) + " " + n.op + " " + visit(n.rhs)
  override def visit(n : ConcatenationExpression) : String = visit(n.lhs) + " .. " + visit(n.rhs)
  override def visit(n : ArithmeticBinopExpression) : String = visit(n.lhs) + " " + n.op + " " + visit(n.rhs)
  override def visit(n : NotExpression) : String = "!" + visit(n.e)
  override def visit(n : NegationExpression) : String = "-" + visit(n.e)
  override def visit(n : FunctionCallExpression) : String = visit(n.func) + "(" + commaSeparate(visitList(n.args)) + ")"
  override def visit(n : TableAccessExpression) : String = visit(n.table) + "[" + visit(n.field) + "]"
  override def visit(n : ParentheticalExpression) : String = "(" + visit(n.e) + ")"
  override def visit(n : IdentifierExpression) : String = n.id
  override def visit(n : BooleanLiteral) : String = n.v.toString
  override def visit(n : NumericLiteral) : String = n.v.toString
  override def visit(n : StringLiteral) : String =  "\"" + n.v + "\""
  override def visit(n : NilLiteral) : String = "nil"

  // TODO varargs
  override def visit(n : FunctionDeclarationExpression) : String =
    "function(" + commaSeparate(n.params.map((e : IdentifierExpression) => visit(e))) + ")\n" + indentVisitList(n.body) + "\n" + "end"

  override def visit(n : TableConstructorExpression) : String = {
    if (n.keys.elements.isEmpty)
      return "{}"

    val keys = visitList(n.keys)
    val values = visitList(n.values)

    var out = ""
    if (keys.nonEmpty) {
      out += indentStrings(Seq(keys.head + " = " + values.head))
      for (i <- Range(1, keys.size)) {
        out += ",\n" + indentStrings(Seq(keys(i) + " = " + values(i)))
      }
    }

    "{\n" + out + "\n" + "}"
  }

  override def visit(n : UpValueExpression) : String = "upValue(" + visit(n.id) + ")"
  override def visit(n : VarArgsExpression) : String = "..."
}
