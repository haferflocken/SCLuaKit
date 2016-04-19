package scluacheck.ast

/**
  * Prints the AST as pseudo-Lua. Methods should not have dangling newlines.
  * The convention is that visiting an expression will not return a string with indentation on the first line,
  * but visiting a statement will.
  */
object ASTPrettyPrintVisitor extends ASTVisitor[String] {
  private var indent : Int = 0

  private def indentString(s : String) : String = {
    val parts = s.split("\n")
    indentStrings(parts)
  }

  private def indentStrings(s : Seq[String], extra : Int = 0) : String = {
    var in = ""
    for (i <- Range(0, indent + extra))
      in += "  "
    var out = ""
    if (s.nonEmpty) {
      out += in + s.head
      for (i <- s.slice(1, s.size))
        out += "\n" + in + i
    }
    out
  }

  private def commaSeparate(s : Seq[String]) : String = {
    var out = ""
    if (s.nonEmpty) {
      out += s.head
      for (i <- s.slice(1, s.size))
        out += ", " + i
    }
    out
  }

  override def visit(n : StatementList) : String = throw new java.lang.Error("Not implemented")
  override def visit(n : ExprList) : String = throw new java.lang.Error("Not implemented")

  override def visit(n : Chunk) : String = {
    indentString("do") + "\n" + indentStrings(visitList(n.statements), 1) + "\n" + indentString("end")
  }

  override def visit(n : AssignmentStatement) : String = {
    val oldIndent = indent
    indent = 0
    val vars = visitList(n.vars)
    val values = visitList(n.values)
    indent = oldIndent

    indentString(commaSeparate(vars) + " = " + commaSeparate(values))
  }

  override def visit(n : FunctionCallStatement) : String = visit(n.call)

  override def visit(n : WhileStatement) : String =
    indentString("while ") + visit(n.condition) + "\n" + visit(n.body)

  override def visit(n : RepeatUntilStatement) : String =
    indentString("repeat") + "\n" + visit(n.body) + "\n" + indentString("until ") + visit(n.condition)

  override def visit(n : IfStatement) : String = {
    var out = indentString("if ")
    out += visit(n.condition) + " then\n" + visit(n.thn)
    if (n.els != null)
      out += "\n" + indentString("else ") + visit(n.els).trim() + "\n" + indentString("end")
    out
  }

  override def visit(n : ReturnStatement) : String = {
    val oldIndent = indent
    indent = 0
    val values = visitList(n.returnValues)
    indent = oldIndent

    indentString("return " + commaSeparate(values))
  }

  override def visit(n : BreakStatement) : String = indentString("break")

  override def visit(n : ContinueStatement) : String = indentString("continue")

  override def visit(n : ForNumericStatement) : String = {
    val out = indentString("for ") + visit(n.index) + " <- Range(" + visit(n.start) + ", "
    out + visit(n.end) + ", " + visit(n.inc) + ")\n" + visit(n.body)
  }

  override def visit(n : ForEachStatement) : String = {
    var out = indentString("for ") + visit(n.i1)
    if (n.i2 != null)
      out += visit(n.i2)
    out + " in " + visit(n.collection) + "\n" + visit(n.body)
  }

  override def visit(n : LocalVariableDeclarationStatement) : String =
    indentString("local ") + commaSeparate(n.names.map((e : IdentifierExpression) => visit(e)))

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
    "function(" + commaSeparate(n.params.map((e : IdentifierExpression) => visit(e))) + ")\n" + visit(n.body) + "\n" + indentString("end")

  override def visit(n : TableConstructorExpression) : String = {
    val keys = visitList(n.keys)
    val values = visitList(n.values)

    indent += 1
    var out = ""
    if (keys.nonEmpty) {
      out += indentString(keys.head + " = " + values.head)
      for (i <- Range(1, keys.size)) {
        out += ",\n" + indentString(keys(i) + " = " + values(i))
      }
    }
    indent -= 1

    "{\n" + out + "\n}"
  }

  override def visit(n : UpValueExpression) : String = "upValue(" + visit(n.id) + ")"
  override def visit(n : VarArgsExpression) : String = "..."
}
