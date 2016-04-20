package scluacheck.ast

import scala.collection.Seq

/**
  * A node in the abstract syntax tree.
  */
abstract class ASTNode(val line : Int, val column : Int) {
  def accept[T](visitor : ASTVisitor[T]) : T
}

class StatementList(line : Int, column : Int, val elements : Seq[Statement]) extends ASTNode(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class ExprList(line : Int, column : Int, val elements : Seq[Expression]) extends ASTNode(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

abstract class Statement(line : Int, column : Int) extends ASTNode(line, column)
abstract class Expression(line : Int, column : Int) extends ASTNode(line, column)

object LogicalBinop extends Enumeration {
  type LogicalBinop = Value
  val AND, OR = Value
}

object BitwiseBinop extends Enumeration {
  type BitwiseBinop = Value
  val AND, OR = Value
}

object RelationalBinop extends Enumeration {
  type RelationalBinop = Value
  val EQ, NE, LT, GT, LTE, GTE = Value
}

object ArithmeticBinop extends Enumeration {
  type ArithmeticBinop = Value
  val ADD, SUBTRACT, MULTIPLY, DIVIDE, MODULO, POWER = Value
}

class FileNode(val statements : StatementList) extends ASTNode(0, 0) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

/*
 * STATEMENTS
 */

class AssignmentStatement(line : Int, column : Int, val vars : ExprList, val values : ExprList) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class FunctionCallStatement(line : Int, column : Int, val call : FunctionCallExpression) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class ExplicitBlockStatement(line : Int, column : Int, val statements : StatementList) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class WhileStatement(line : Int, column : Int, val condition : Expression, val body : StatementList) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class RepeatUntilStatement(line : Int, column : Int, val body : StatementList, val condition : Expression) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

// For if/elseif/else, do IfStatement(..., ..., IfStatement(..., ..., Chunk(...)))
class IfStatement(line : Int, column : Int, val condition : Expression, val thn : StatementList, val els : Statement) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class ReturnStatement(line : Int, column : Int, val returnValues : ExprList) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class BreakStatement(line : Int, column : Int) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class ContinueStatement(line : Int, column : Int) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class ForNumericStatement(line : Int, column : Int, val index : IdentifierExpression, val start : Expression, val end : Expression, val inc : Expression, val body : StatementList) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class ForEachStatement(line : Int, column : Int, val i1 : IdentifierExpression, val i2 : IdentifierExpression, val collection : Expression, val body : StatementList) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class LocalVariableDeclarationStatement(line : Int, column : Int, val names : Seq[IdentifierExpression], val values : ExprList) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

/*
 * EXPRESSIONS
 */

class LogicalBinopExpression(line : Int, column : Int, val op : LogicalBinop.LogicalBinop, val lhs : Expression, val rhs : Expression) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class BitwiseBinopExpression(line : Int, column : Int, val op : BitwiseBinop.BitwiseBinop, val lhs : Expression, val rhs : Expression) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class RelationalBinopExpression(line : Int, column : Int, val op : RelationalBinop.RelationalBinop, val lhs : Expression, val rhs : Expression) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class ConcatenationExpression(line : Int, column : Int, val lhs : Expression, val rhs : Expression) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class ArithmeticBinopExpression(line : Int, column : Int, val op : ArithmeticBinop.ArithmeticBinop, val lhs : Expression, val rhs : Expression) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class NotExpression(line : Int, column : Int, val e : Expression) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class NegationExpression(line : Int, column : Int, val e : Expression) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class FunctionCallExpression(line : Int, column : Int, val func : Expression, val args : ExprList) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class TableAccessExpression(line : Int, column : Int, val table : Expression, val field : Expression) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class ParentheticalExpression(line : Int, column : Int, val e : Expression) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class IdentifierExpression(line : Int, column : Int, val id : String) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class BooleanLiteral(line : Int, column : Int, val v : Boolean) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class NumericLiteral(line : Int, column : Int, val v : Double) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class StringLiteral(line : Int, column : Int, val v : String) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class NilLiteral(line : Int, column : Int) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class FunctionDeclarationExpression(line : Int, column : Int, val params : Seq[IdentifierExpression], val hasVarArgs : Boolean, val body : StatementList) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class TableConstructorExpression(line : Int, column : Int, val keys : ExprList, val values : ExprList) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class UpValueExpression(line : Int, column : Int, val id : IdentifierExpression) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}

class VarArgsExpression(line : Int, column : Int) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)
}
