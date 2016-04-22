package scluacheck.verify

import scluacheck.ast.{VarArgsExpression, _}

/**
  * Verify that functions are always given names which can be determined statically.
  * Returns any functions which have names which cannot be determined statically.
  *
  * This verification is intended to make type checking easier.
  *
  * For example, these are legal:
  *   g = function(t) return t end
  *   local l = { Foo = function(self) return self.bar end }
  *   x["a"]["b"] = function(q) return q + 3 end
  * But these are not:
  *   l[self.a] = { F = function(x) return x * x end }
  *   l[x .. y] = function(self) return self.bar end
  */
object VerifyFunctionIDsVisitor extends ASTVisitor[Seq[ASTNode]] {

  override def visit(n : StatementList) : Seq[ASTNode] = visitList(n).flatten
  override def visit(n : ExprList) : Seq[ASTNode] = Seq()

  override def visit(n : FileNode) : Seq[ASTNode] = visit(n.statements)

  // Assignment statements are the most obvious type of assignment.
  override def visit(n : AssignmentStatement) : Seq[ASTNode] =
    verifyAssignments(n.vars, n.values, allowLiterals = false, allowTableAccesses = true)

  // Local declarations can only assign directly to an identifier, which is always OK.
  override def visit(n : LocalVariableDeclarationStatement) : Seq[ASTNode] = Seq()

  // Table constructor expressions are a special type of assignment.
  override def visit(n : TableConstructorExpression) : Seq[ASTNode] =
    verifyAssignments(n.keys, n.values, allowLiterals = true, allowTableAccesses = false)

  // Function declaration expressions are special. If one is visited, it means it was encountered outside of
  // an assignment statement or table constructor, which is not allowed.
  override def visit(n : FunctionDeclarationExpression) : Seq[ASTNode] = Seq(n)

  // Literal expressions are special in that we don't add them to the list.
  override def visit(n : BooleanLiteral) : Seq[ASTNode] = Seq()
  override def visit(n : NumericLiteral) : Seq[ASTNode] = Seq()
  override def visit(n : StringLiteral) : Seq[ASTNode] = Seq()

  // Most statements don't do anything special. They generally only go into their sub-statements, and not sub-expressions,
  // as an assignment cannot take place in an expression.
  override def visit(n : FunctionCallStatement) : Seq[ASTNode] = Seq()
  override def visit(n : ExplicitBlockStatement) : Seq[ASTNode] = visit(n.statements)
  override def visit(n : WhileStatement) : Seq[ASTNode] = visit(n.body)
  override def visit(n : RepeatUntilStatement) : Seq[ASTNode] = visit(n.body)
  override def visit(n : IfStatement) : Seq[ASTNode] = {
    val out = visit(n.thn)
    if (n.els != null) out ++ visit(n.els) else out
  }
  override def visit(n : ReturnStatement) : Seq[ASTNode] = Seq()
  override def visit(n : BreakStatement) : Seq[ASTNode] = Seq()
  override def visit(n : ContinueStatement) : Seq[ASTNode] = Seq()
  override def visit(n : ForNumericStatement) : Seq[ASTNode] = visit(n.body)
  override def visit(n : ForEachStatement) : Seq[ASTNode] = visit(n.body)

  // Most expressions don't do anything special.
  override def visit(n : LogicalBinopExpression) : Seq[ASTNode] = visit(n.lhs) ++ visit(n.rhs) :+ n
  override def visit(n : BitwiseBinopExpression) : Seq[ASTNode] = visit(n.lhs) ++ visit(n.rhs) :+ n
  override def visit(n : RelationalBinopExpression) : Seq[ASTNode] = visit(n.lhs) ++ visit(n.rhs) :+ n
  override def visit(n : ConcatenationExpression) : Seq[ASTNode] = visit(n.lhs) ++ visit(n.rhs) :+ n
  override def visit(n : ArithmeticBinopExpression) : Seq[ASTNode] = visit(n.lhs) ++ visit(n.rhs) :+ n
  override def visit(n : NotExpression) : Seq[ASTNode] = visit(n.e) :+ n
  override def visit(n : NegationExpression) : Seq[ASTNode] = visit(n.e) :+ n
  override def visit(n : FunctionCallExpression) : Seq[ASTNode] = visit(n.func) ++ visit(n.args) :+ n
  override def visit(n : TableAccessExpression) : Seq[ASTNode] = visit(n.table) ++ visit(n.field)
  override def visit(n : IdentifierExpression) : Seq[ASTNode] = Seq(n)
  override def visit(n : ParentheticalExpression) : Seq[ASTNode] = visit(n.e)
  override def visit(n : NilLiteral) : Seq[ASTNode] = Seq(n)
  override def visit(n : UpValueExpression) : Seq[ASTNode] = Seq(n)
  override def visit(n : VarArgsExpression) : Seq[ASTNode] = Seq(n)

  // Helper functions.
  private def verifyAssignments(vars : ExprList, values : ExprList, allowLiterals : Boolean, allowTableAccesses : Boolean) : Seq[ASTNode] = {
    var out = Seq[Seq[ASTNode]]()
    for (i <- vars.elements.indices) {
      // See if the value is a function or contains a function.
      val vSub = visit(values.elements(i))
      if (anyFunctions(vSub)) {
        // If the value is or contains a function, verify its key is a literal.
        val k = vars.elements(i)
        if (!allowKey(k, allowLiterals, allowTableAccesses))
          out = out :+ onlyFunctions(vSub)
      }
    }
    out.flatten
  }

  private def allowKey(k : Expression, allowLiterals : Boolean, allowTableAccesses : Boolean) : Boolean = {
    k match {
      case _ : IdentifierExpression => true // It is always OK to assign directly to an identifier.
      case _ : BooleanLiteral => allowLiterals
      case _ : NumericLiteral => allowLiterals
      case _ : StringLiteral => allowLiterals
      case t : TableAccessExpression =>
        if (allowTableAccesses)
          // Make sure the table is allowed (to allow for chained table accesses) and that
          // the field is a literal.
          allowKey(t.table, allowLiterals, allowTableAccesses) && (t.field match {
            case _ : BooleanLiteral => true
            case _ : NumericLiteral => true
            case _ : StringLiteral => true
            case _ => false
          })
        else
          false
      case _ => visit(k).nonEmpty
    }
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
