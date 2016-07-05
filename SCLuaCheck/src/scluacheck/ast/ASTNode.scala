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

  override def equals(o : Any) : Boolean = {
    o match {
      case sL : StatementList => elements.equals(sL.elements)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(elements)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class ExprList(line : Int, column : Int, val elements : Seq[Expression]) extends ASTNode(line, column) {
  def this(e : Expression) = this(e.line, e.column, Seq(e))

  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case eL : ExprList => elements.equals(eL.elements)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(elements)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
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

  override def equals(o : Any) : Boolean = {
    o match {
      case fN : FileNode => statements.equals(fN.statements)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(statements)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

/*
 * STATEMENTS
 */

class AssignmentStatement(line : Int, column : Int, val vars : ExprList, val values : ExprList) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case aS : AssignmentStatement => vars.equals(aS.vars) && values.equals(aS.values)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(vars, values)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class FunctionCallStatement(line : Int, column : Int, val call : FunctionCallExpression) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case fCS : FunctionCallStatement => call.equals(fCS.call)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(call)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class ExplicitBlockStatement(line : Int, column : Int, val statements : StatementList) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case eBS : ExplicitBlockStatement => statements.equals(eBS.statements)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(statements)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class WhileStatement(line : Int, column : Int, val condition : Expression, val body : StatementList) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case wS : WhileStatement => condition.equals(wS.condition) && body.equals(wS.body)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(condition, body)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class RepeatUntilStatement(line : Int, column : Int, val body : StatementList, val condition : Expression) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case rUS : RepeatUntilStatement => body.equals(rUS.body) && condition.equals(rUS.condition)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(body, condition)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

// Each condition is followed by a body. There may be one more body than condition, which is the else case.
class IfStatement(line : Int, column : Int, val conditions : Seq[Expression], val bodies : Seq[StatementList]) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case iF : IfStatement => conditions.equals(iF.conditions) && bodies.equals(iF.bodies)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(conditions, bodies)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class ReturnStatement(line : Int, column : Int, val returnValues : ExprList) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case rS : ReturnStatement =>
        if (returnValues == null)
          rS.returnValues == null
        else if (rS.returnValues == null)
          false
        else
          returnValues.equals(rS.returnValues)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    if (returnValues == null)
      return 52073233 // Random prime number.

    val state = Seq(returnValues)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class BreakStatement(line : Int, column : Int) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case _ : BreakStatement => true
      case _ => false
    }
  }

  override def hashCode() : Int = 1668524633 // Random prime number.
}

class ContinueStatement(line : Int, column : Int) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case _ : ContinueStatement => true
      case _ => false
    }
  }

  override def hashCode() : Int = 8846683 // Random prime number.
}

class ForNumericStatement(line : Int, column : Int, val index : IdentifierExpression, val start : Expression, val end : Expression, val inc : Expression, val body : StatementList) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case fNS : ForNumericStatement =>
        index.equals(fNS.index) && start.equals(fNS.start) && end.equals(fNS.end) && inc.equals(fNS.inc) && body.equals(fNS.body)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(index, start, end, inc, body)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class ForEachStatement(line : Int, column : Int, val i1 : IdentifierExpression, val i2 : IdentifierExpression, val collection : Expression, val body : StatementList) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case fES : ForEachStatement =>
        if (!i1.equals(fES.i1))
          false
        else if ((i2 == null && fES.i2 == null) || (i2 != null && i2.equals(fES.i2))) {
          collection.equals(fES.collection) && body.equals(fES.body)
        } else
          false
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = if (i2 != null) Seq(i1, i2, collection, body) else Seq(i1, collection, body)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class LocalVariableDeclarationStatement(line : Int, column : Int, val names : Seq[IdentifierExpression], val values : ExprList) extends Statement(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case lVDS : LocalVariableDeclarationStatement =>
        if (!names.equals(lVDS.names))
          false
        else
          (values == null && lVDS.values == null) || (values != null && values.equals(lVDS.values))
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = if (values != null) Seq(names, values) else Seq(names)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

/*
 * EXPRESSIONS
 */

class LogicalBinopExpression(line : Int, column : Int, val op : LogicalBinop.LogicalBinop, val lhs : Expression, val rhs : Expression) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case lBE : LogicalBinopExpression => op == lBE.op && lhs.equals(lBE.lhs) && rhs.equals(lBE.rhs)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(op, lhs, rhs)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class BitwiseBinopExpression(line : Int, column : Int, val op : BitwiseBinop.BitwiseBinop, val lhs : Expression, val rhs : Expression) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case bBE : BitwiseBinopExpression => op == bBE.op && lhs.equals(bBE.lhs) && rhs.equals(bBE.rhs)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(op, lhs, rhs)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class RelationalBinopExpression(line : Int, column : Int, val op : RelationalBinop.RelationalBinop, val lhs : Expression, val rhs : Expression) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case rBE : RelationalBinopExpression => op == rBE.op && lhs.equals(rBE.lhs) && rhs.equals(rBE.rhs)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(op, lhs, rhs)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class ConcatenationExpression(line : Int, column : Int, val lhs : Expression, val rhs : Expression) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case cE : ConcatenationExpression => lhs.equals(cE.lhs) && rhs.equals(cE.rhs)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(lhs, rhs)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class ArithmeticBinopExpression(line : Int, column : Int, val op : ArithmeticBinop.ArithmeticBinop, val lhs : Expression, val rhs : Expression) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case aBE : ArithmeticBinopExpression => op == aBE.op && lhs.equals(aBE.lhs) && rhs.equals(aBE.rhs)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(op, lhs, rhs)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class NotExpression(line : Int, column : Int, val e : Expression) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case nE : NotExpression => e.equals(nE.e)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(e)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class NegationExpression(line : Int, column : Int, val e : Expression) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case nE : NegationExpression => e.equals(nE.e)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(e)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class FunctionCallExpression(line : Int, column : Int, val func : Expression, val args : ExprList) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case fCE : FunctionCallExpression =>
        if (!func.equals(fCE.func))
          false
        else if (args == null)
          fCE.args == null
        else if (fCE.args == null)
          false
        else
          args.equals(fCE.args)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = if (args != null) Seq(func, args) else Seq(func)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class TableAccessExpression(line : Int, column : Int, val table : Expression, val field : Expression) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case tAE : TableAccessExpression => table.equals(tAE.table) && field.equals(tAE.field)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(table, field)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class ParentheticalExpression(line : Int, column : Int, val e : Expression) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case pE : ParentheticalExpression => e.equals(pE.e)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(e)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class IdentifierExpression(line : Int, column : Int, val id : String) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case iE : IdentifierExpression => id.equals(iE.id)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(id)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class BooleanLiteral(line : Int, column : Int, val v : Boolean) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case bL : BooleanLiteral => v == bL.v
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(v)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class NumericLiteral(line : Int, column : Int, val v : Double) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case nL : NumericLiteral => v == nL.v
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(v)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class StringLiteral(line : Int, column : Int, val v : String) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case sL : StringLiteral => v.equals(sL.v)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(v)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class NilLiteral(line : Int, column : Int) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case nE : NegationExpression => true
      case _ => false
    }
  }

  override def hashCode() : Int = 43391729 // Random prime number.
}

class FunctionDeclarationExpression(line : Int, column : Int, val params : Seq[IdentifierExpression], val hasVarArgs : Boolean, val body : StatementList) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case fDE : FunctionDeclarationExpression =>
          params.equals(fDE.params) && hasVarArgs == fDE.hasVarArgs && body.equals(fDE.body)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(params, hasVarArgs, body)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class TableConstructorExpression(line : Int, column : Int, val keys : ExprList, val values : ExprList) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case tCE : TableConstructorExpression => keys.equals(tCE.keys) && values.equals(tCE.values)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(keys, values)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class UpValueExpression(line : Int, column : Int, val id : IdentifierExpression) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case uVE : UpValueExpression => id.equals(uVE.id)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val state = Seq(id)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

class VarArgsExpression(line : Int, column : Int) extends Expression(line, column) {
  override def accept[T](visitor : ASTVisitor[T]) : T = visitor.visit(this)

  override def equals(o : Any) : Boolean = {
    o match {
      case vAE : VarArgsExpression => true
      case _ => false
    }
  }

  override def hashCode() : Int = 910351543 // Random prime number.
}
