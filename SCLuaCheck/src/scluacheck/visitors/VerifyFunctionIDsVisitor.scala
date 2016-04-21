package scluacheck.visitors

import scluacheck.ast.{VarArgsExpression, _}

/**
  * Verify that functions are always given names which can be determined statically.
  * Returns any functions which have names which cannot be determined statically.
  *
  * This verification relies on verification of the assumption that functions aren't declared anywhere
  * except globally or in tables, which is also verified by this visitor.
  *
  * For example, these are legal:
  *   g = function(t) return t end
  *   local l = { Foo = function(self) return self.bar end }
  * But these are not:
  *   l[self.a] = { F = function(x) return x * x end }
  *   l[x .. y] = function(self) return self.bar end
  */
object VerifyFunctionIDsVisitor extends ASTVisitor[Seq[ASTNode]] {

  override def visit(n : StatementList) : Seq[ASTNode] = visitList(n).flatten
  override def visit(n : ExprList) : Seq[ASTNode] = Seq()

  override def visit(n : FileNode) : Seq[ASTNode] = visit(n.statements)

  // Assignment statements are the most obvious type of assignment.
  override def visit(n : AssignmentStatement) : Seq[ASTNode] = verifyAssignments(n.vars, n.values)

  // Local declarations can't assign to a non-literal.
  override def visit(n : LocalVariableDeclarationStatement) : Seq[ASTNode] = Seq()

  // Table constructor expressions are a special type of assignment.
  override def visit(n : TableConstructorExpression) : Seq[ASTNode] = verifyAssignments(n.keys, n.values)

  // Function declaration expressions are special. If one is visited, it means it was encountered outside of
  // an assignment statement or table constructor, which is not allowed.
  override def visit(n : FunctionDeclarationExpression) : Seq[ASTNode] = Seq(n)

  // Literal and identifier expressions are special in that we don't add them to the list.
  override def visit(n : BooleanLiteral) : Seq[ASTNode] = Seq()
  override def visit(n : NumericLiteral) : Seq[ASTNode] = Seq()
  override def visit(n : StringLiteral) : Seq[ASTNode] = Seq()
  override def visit(n : IdentifierExpression) : Seq[ASTNode] = Seq(n)

  // Most statements don't do anything special.
  override def visit(n : FunctionCallStatement) : Seq[ASTNode] = Seq()
  override def visit(n : ExplicitBlockStatement) : Seq[ASTNode] = visit(n.statements)
  override def visit(n : WhileStatement) : Seq[ASTNode] = visit(n.condition) ++ visit(n.body)
  override def visit(n : RepeatUntilStatement) : Seq[ASTNode] = visit(n.body) ++ visit(n.condition)
  override def visit(n : IfStatement) : Seq[ASTNode] = {
    val out = visit(n.condition) ++ visit(n.thn)
    if (n.els != null) out ++ visit(n.els) else out
  }
  override def visit(n : ReturnStatement) : Seq[ASTNode] = visit(n.returnValues)
  override def visit(n : BreakStatement) : Seq[ASTNode] = Seq()
  override def visit(n : ContinueStatement) : Seq[ASTNode] = Seq()
  override def visit(n : ForNumericStatement) : Seq[ASTNode] = visit(n.start) ++ visit(n.end) ++ visit(n.inc) ++ visit(n.body)
  override def visit(n : ForEachStatement) : Seq[ASTNode] = visit(n.collection) ++ visit(n.body)

  // Most expressions don't do anything special.
  override def visit(n : LogicalBinopExpression) : Seq[ASTNode] = visit(n.lhs) ++ visit(n.rhs)
  override def visit(n : BitwiseBinopExpression) : Seq[ASTNode] = visit(n.lhs) ++ visit(n.rhs)
  override def visit(n : RelationalBinopExpression) : Seq[ASTNode] = visit(n.lhs) ++ visit(n.rhs)
  override def visit(n : ConcatenationExpression) : Seq[ASTNode] = visit(n.lhs) ++ visit(n.rhs)
  override def visit(n : ArithmeticBinopExpression) : Seq[ASTNode] = visit(n.lhs) ++ visit(n.rhs)
  override def visit(n : NotExpression) : Seq[ASTNode] = visit(n.e)
  override def visit(n : NegationExpression) : Seq[ASTNode] = visit(n.e)
  override def visit(n : FunctionCallExpression) : Seq[ASTNode] = visit(n.func) ++ visit(n.args)
  override def visit(n : TableAccessExpression) : Seq[ASTNode] = visit(n.table) ++ visit(n.field)
  override def visit(n : ParentheticalExpression) : Seq[ASTNode] = visit(n.e)
  override def visit(n : NilLiteral) : Seq[ASTNode] = Seq(n)
  override def visit(n : UpValueExpression) : Seq[ASTNode] = Seq(n)
  override def visit(n : VarArgsExpression) : Seq[ASTNode] = Seq(n)

  // Helper functions.
  private def verifyAssignments(vars : ExprList, values : ExprList) : Seq[ASTNode] = {
    var out = Seq[Seq[ASTNode]]()
    for (i <- vars.elements.indices) {
      // See if the value is a function or contains a function.
      val v = visit(values.elements(i))
      if (anyFunctions(v)) {
        // If the value is or contains a function, verify its key is a literal.
        val k = visit(vars.elements(i))
        if (k.nonEmpty) {
          // If visiting keys returns a non-empty list, we are not assigning to a literal
          // and must produce the functions inside of v.
          out = out :+ onlyFunctions(v)
        }
      }
    }
    out.flatten
  }

  private def anyFunctions(l : Seq[ASTNode]) : Boolean = {
    for (e <- l) {
      e match {
        case _ : FunctionDeclarationExpression => return true
        case _ =>
      }
    }
    false
  }

  private def onlyFunctions(l : Seq[ASTNode]) : Seq[FunctionDeclarationExpression] =
    l.filter((e : ASTNode) => e.isInstanceOf[FunctionDeclarationExpression]).map((e : ASTNode) => e.asInstanceOf[FunctionDeclarationExpression])
}
