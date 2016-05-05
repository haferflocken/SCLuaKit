package scluacheck.verify

import scluacheck.ast._

/**
  * Created by John on 5/3/2016.
  */
object TypedPrettyPrintVisitor extends BasePrettyPrintVisitor {
  var globalTable : SymbolTable = null
  var localTable : SymbolTable = null

  override def visit(n : ExplicitBlockStatement) : String = {
    localTable = localTable.subTables(n)
    val out = super.visit(n)
    localTable = localTable.parentTable
    out
  }

  override def visit(n : WhileStatement) : String = {
    var out = "while " + visit(n.condition) + " do\n"
    localTable = localTable.subTables(n)
    out += indentVisitList(n.body) + "\n" + "end"
    localTable = localTable.parentTable
    out
  }

  override def visit(n : RepeatUntilStatement) : String = {
    localTable = localTable.subTables(n)
    val out = super.visit(n)
    localTable = localTable.parentTable
    out
  }

  override def visit(n : IfStatement) : String = {
    var out = "if " + visit(n.condition) + " then\n"

    localTable = localTable.subTables(n)
    out += indentVisitList(n.thn)
    localTable = localTable.parentTable

    if (n.els != null)
      out += "\n" + "else " + visit(n.els).trim()
    out + "\n" + "end"
  }

  override def visit(n : ForNumericStatement) : String = {
    var out = "for " + visit(n.index) + " <- Range(" + visit(n.start) + ", "
    out += visit(n.end) + ", " + visit(n.inc) + ") do\n"

    localTable = localTable.subTables(n)
    out += indentVisitList(n.body) + "\n" + "end"
    localTable = localTable.parentTable
    out
  }

  override def visit(n : ForEachStatement) : String = {
    var out = "for " + visit(n.i1)
    if (n.i2 != null)
      out += visit(n.i2)
    out += " in " + visit(n.collection) + " do\n"

    localTable = localTable.subTables(n)
    out += indentVisitList(n.body) + "\n" + "end"
    localTable = localTable.parentTable
    out
  }

  override def visit(n : LocalVariableDeclarationStatement) : String = {
    var out = "local " + commaSeparate(n.names.map((e : IdentifierExpression) =>
      visit(e) + " : " + localTable.lookup(e.id).t
    ))
    if (n.values != null)
      out += " = " + commaSeparate(visitList(n.values))
    out
  }

  override def visit(n : FunctionDeclarationExpression) : String = {
    var out = "function("
    if (n.params != null) {
      out += commaSeparate(n.params.map((e : IdentifierExpression) => visit(e)))
      if (n.hasVarArgs)
        out += ", ..."
    } else if (n.hasVarArgs) {
      out += "..."
    }

    localTable = localTable.subTables(n)
    out += ")\n" + indentVisitList(n.body) + "\n" + "end"
    localTable = localTable.parentTable
    out
  }
}
