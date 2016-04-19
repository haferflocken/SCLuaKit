package scluacheck.ast

/**
  * Visits nodes in the AST.
  */
trait ASTVisitor[T] {
  def visit(n : ASTNode) : T = n.accept(this)
  def visit(n : StatementList) : T
  def visit(n : ExprList) : T

  def visitList(n : StatementList) : Seq[T] = for (e <- n.elements) yield e.accept(this)
  def visitList(n : ExprList) : Seq[T] = for (e <- n.elements) yield e.accept(this)

  // Visit statements.
  def visit(n : Chunk) : T
  def visit(n : AssignmentStatement) : T
  def visit(n : FunctionCallStatement) : T
  def visit(n : WhileStatement) : T
  def visit(n : RepeatUntilStatement) : T
  def visit(n : IfStatement) : T
  def visit(n : ReturnStatement) : T
  def visit(n : BreakStatement) : T
  def visit(n : ContinueStatement) : T
  def visit(n : ForNumericStatement) : T
  def visit(n : ForEachStatement) : T
  def visit(n : LocalVariableDeclarationStatement) : T

  // Visit expressions.
  def visit(n : LogicalBinopExpression) : T
  def visit(n : BitwiseBinopExpression) : T
  def visit(n : RelationalBinopExpression) : T
  def visit(n : ConcatenationExpression) : T
  def visit(n : ArithmeticBinopExpression) : T
  def visit(n : NotExpression) : T
  def visit(n : NegationExpression) : T
  def visit(n : FunctionCallExpression) : T
  def visit(n : TableAccessExpression) : T
  def visit(n : ParentheticalExpression) : T
  def visit(n : IdentifierExpression) : T
  def visit(n : BooleanLiteral) : T
  def visit(n : NumericLiteral) : T
  def visit(n : StringLiteral) : T
  def visit(n : NilLiteral) : T
  def visit(n : FunctionDeclarationExpression) : T
  def visit(n : TableConstructorExpression) : T
  def visit(n : UpValueExpression) : T
  def visit(n : VarArgsExpression) : T
}
