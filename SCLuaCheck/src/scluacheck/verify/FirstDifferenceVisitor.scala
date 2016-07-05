package scluacheck.verify

import scluacheck.ast._

/**
  * Finds the first difference between two ASTs. Returns a node from the AST being visited.
  */
object FirstDifferenceVisitor extends ASTVisitor[ASTNode] {
  var baseAST : ASTNode = null

  def visit(n : StatementList) : ASTNode = {
    val baseList = baseAST match {
      case l : StatementList => l
      case _ => return n
    }

    if (baseList.elements.size != n.elements.size)
      return n.elements(Math.min(baseList.elements.size, n.elements.size) - 1)

    for (i <- n.elements.indices) {
      baseAST = baseList.elements(i)
      val r = visit(n.elements(i))
      if (r != null)
        return r
    }
    baseAST = baseList
    null
  }

  def visit(n : ExprList) : ASTNode = {
    val baseList = baseAST match {
      case l : ExprList => l
      case _ => return n
    }

    if (baseList.elements.size != n.elements.size)
      return n.elements(Math.min(baseList.elements.size, n.elements.size) - 1)

    for (i <- n.elements.indices) {
      baseAST = baseList.elements(i)
      val r = visit(n.elements(i))
      if (r != null)
        return r
    }
    baseAST = baseList
    null
  }

  // Visiting a file node is the typical entry point for a visitor.
  def visit(n : FileNode) : ASTNode = {
    val baseFile = baseAST match {
      case f : FileNode => f
      case _ => return n
    }

    baseAST = baseFile.statements
    val r = visit(n.statements)
    if (r != null)
      return r

    baseAST = baseFile
    null
  }

  // Visit statements.
  def visit(n : AssignmentStatement) : ASTNode = {
    val baseAssign = baseAST match {
      case a : AssignmentStatement => a
      case _ => return n
    }

    baseAST = baseAssign.vars
    val varsResult = visit(n.vars)
    if (varsResult != null)
      return varsResult

    baseAST = baseAssign.values
    val valuesResult = visit(n.values)
    if (valuesResult != null)
      return valuesResult

    baseAST = baseAssign
    null
  }

  def visit(n : FunctionCallStatement) : ASTNode = {
    val baseCall = baseAST match {
      case c : FunctionCallStatement => c
      case _ => return n
    }

    baseAST = baseCall.call
    val r = visit(n.call)
    if (r != null)
      return r

    baseAST = baseCall
    null
  }

  def visit(n : ExplicitBlockStatement) : ASTNode = {
    val baseBlock = baseAST match {
      case b : ExplicitBlockStatement => b
      case _ => return n
    }

    baseAST = baseBlock.statements
    val r = visit(n.statements)
    if (r != null)
      return r

    baseAST = baseBlock
    null
  }

  def visit(n : WhileStatement) : ASTNode = {
    val baseLoop = baseAST match {
      case l : WhileStatement => l
      case _ => return n
    }

    baseAST = baseLoop.condition
    val condResult = visit(n.condition)
    if (condResult != null)
      return condResult

    baseAST = baseLoop.body
    val bodyResult = visit(n.body)
    if (bodyResult != null)
      return bodyResult

    baseAST = baseLoop
    null
  }

  def visit(n : RepeatUntilStatement) : ASTNode = {
    val baseLoop = baseAST match {
      case l : RepeatUntilStatement => l
      case _ => return n
    }

    baseAST = baseLoop.body
    val bodyResult = visit(n.body)
    if (bodyResult != null)
      return bodyResult

    baseAST = baseLoop.condition
    val condResult = visit(n.condition)
    if (condResult != null)
      return condResult

    baseAST = baseLoop
    null
  }

  def visit(n : IfStatement) : ASTNode = {
    val baseIf = baseAST match {
      case iF : IfStatement => iF
      case _ => return n
    }

    if (baseIf.conditions.size != n.conditions.size)
      return n.conditions(Math.min(baseIf.conditions.size, n.conditions.size) - 1)

    if (baseIf.bodies.size != n.bodies.size)
      return n.bodies(Math.min(baseIf.bodies.size, n.bodies.size) - 1)

    for (i <- n.conditions.indices) {
      baseAST = baseIf.conditions(i)
      val condResult = visit(n.conditions(i))
      if (condResult != null)
        return condResult

      baseAST = baseIf.bodies(i)
      val bodyResult = visit(n.bodies(i))
      if (bodyResult != null)
        return bodyResult
    }

    if (n.conditions.size < n.bodies.size) {
      baseAST = baseIf.bodies.last
      val elseResult = visit(n.bodies.last)
      if (elseResult != null)
        return elseResult
    }

    baseAST = baseIf
    null
  }

  def visit(n : ReturnStatement) : ASTNode = {
    val baseRet = baseAST match {
      case r : ReturnStatement => r
      case _ => return n
    }

    baseAST = baseRet.returnValues
    val r = visit(n.returnValues)
    if (r != null)
      return r

    baseAST = baseRet
    null
  }

  def visit(n : BreakStatement) : ASTNode = if (baseAST.isInstanceOf[BreakStatement]) null else n

  def visit(n : ContinueStatement) : ASTNode = if (baseAST.isInstanceOf[ContinueStatement]) null else n

  def visit(n : ForNumericStatement) : ASTNode = {
    val baseLoop = baseAST match {
      case f : ForNumericStatement => f
      case _ => return n
    }

    baseAST = baseLoop.index
    val indexResult = visit(n.index)
    if (indexResult != null)
      return indexResult

    baseAST = baseLoop.start
    val startResult = visit(n.start)
    if (startResult != null)
      return startResult

    baseAST = baseLoop.end
    val endResult = visit(n.end)
    if (endResult != null)
      return endResult

    baseAST = baseLoop.inc
    val incResult = visit(n.inc)
    if (incResult != null)
      return incResult

    baseAST = baseLoop.body
    val bodyResult = visit(n.body)
    if (bodyResult != null)
      return bodyResult

    baseAST = baseLoop
    null
  }

  def visit(n : ForEachStatement) : ASTNode = {
    val baseLoop = baseAST match {
      case f : ForEachStatement => f
      case _ => return n
    }

    baseAST = baseLoop.i1
    val i1Result = visit(n.i1)
    if (i1Result != null)
      return i1Result

    if (baseLoop.i2 == null && n.i2 != null)
      return n.i2
    if (baseLoop.i2 != null && n.i2 == null)
      return n
    if (baseLoop.i2 != null && n.i2 != null) {
      baseAST = baseLoop.i2
      val i2Result = visit(n.i2)
      if (i2Result != null)
        return i2Result
    }

    baseAST = baseLoop.collection
    val collectionResult = visit(n.collection)
    if (collectionResult != null)
      return collectionResult

    baseAST = baseLoop.body
    val bodyResult = visit(n.body)
    if (bodyResult != null)
      return bodyResult

    baseAST = baseLoop
    null
  }

  def visit(n : LocalVariableDeclarationStatement) : ASTNode = {
    val baseDecl = baseAST match {
      case d : LocalVariableDeclarationStatement => d
      case _ => return n
    }

    if (baseDecl.names.size != n.names.size)
      return n.names(Math.min(baseDecl.names.size, n.names.size) - 1)

    for (i <- n.names.indices) {
      baseAST = baseDecl.names(i)
      val r = visit(n.names(i))
      if (r != null)
        return r
    }

    baseAST = baseDecl.values
    val valuesResult = visit(n.values)
    if (valuesResult != null)
      return valuesResult

    baseAST = baseDecl
    null
  }

  // Visit expressions.
  def visit(n : LogicalBinopExpression) : ASTNode = {
    val baseBinop = baseAST match {
      case b : LogicalBinopExpression => b
      case _ => return n
    }

    baseAST = baseBinop.lhs
    val lhsResult = visit(n.lhs)
    if (lhsResult != null)
      return lhsResult

    if (baseBinop.op != n.op)
      return n

    baseAST = baseBinop.rhs
    val rhsResult = visit(n.rhs)
    if (rhsResult != null)
      return rhsResult

    baseAST = baseBinop
    null
  }

  def visit(n : BitwiseBinopExpression) : ASTNode = {
    val baseBinop = baseAST match {
      case b : BitwiseBinopExpression => b
      case _ => return n
    }

    baseAST = baseBinop.lhs
    val lhsResult = visit(n.lhs)
    if (lhsResult != null)
      return lhsResult

    if (baseBinop.op != n.op)
      return n

    baseAST = baseBinop.rhs
    val rhsResult = visit(n.rhs)
    if (rhsResult != null)
      return rhsResult

    baseAST = baseBinop
    null
  }

  def visit(n : RelationalBinopExpression) : ASTNode = {
    val baseBinop = baseAST match {
      case b : RelationalBinopExpression => b
      case _ => return n
    }

    baseAST = baseBinop.lhs
    val lhsResult = visit(n.lhs)
    if (lhsResult != null)
      return lhsResult

    if (baseBinop.op != n.op)
      return n

    baseAST = baseBinop.rhs
    val rhsResult = visit(n.rhs)
    if (rhsResult != null)
      return rhsResult

    baseAST = baseBinop
    null
  }

  def visit(n : ConcatenationExpression) : ASTNode = {
    val baseBinop = baseAST match {
      case b : ConcatenationExpression => b
      case _ => return n
    }

    baseAST = baseBinop.lhs
    val lhsResult = visit(n.lhs)
    if (lhsResult != null)
      return lhsResult

    baseAST = baseBinop.rhs
    val rhsResult = visit(n.rhs)
    if (rhsResult != null)
      return rhsResult

    baseAST = baseBinop
    null

  }
  def visit(n : ArithmeticBinopExpression) : ASTNode = {
    val baseBinop = baseAST match {
      case b : ArithmeticBinopExpression => b
      case _ => return n
    }

    baseAST = baseBinop.lhs
    val lhsResult = visit(n.lhs)
    if (lhsResult != null)
      return lhsResult

    if (baseBinop.op != n.op)
      return n

    baseAST = baseBinop.rhs
    val rhsResult = visit(n.rhs)
    if (rhsResult != null)
      return rhsResult

    baseAST = baseBinop
    null
  }

  def visit(n : NotExpression) : ASTNode = {
    val baseNot = baseAST match {
      case b : NotExpression => b
      case _ => return n
    }

    baseAST = baseNot.e
    val result = visit(n.e)
    if (result != null)
      return result

    baseAST = baseNot
    null
  }

  def visit(n : NegationExpression) : ASTNode = {
    val baseNegation = baseAST match {
      case b : NegationExpression => b
      case _ => return n
    }

    baseAST = baseNegation.e
    val result = visit(n.e)
    if (result != null)
      return result

    baseAST = baseNegation
    null
  }

  def visit(n : FunctionCallExpression) : ASTNode = {
    val baseCall = baseAST match {
      case c : FunctionCallExpression => c
      case _ => return n
    }

    baseAST = baseCall.func
    val funcResult = visit(n.func)
    if (funcResult != null)
      return funcResult

    baseAST = baseCall.args
    val argsResult = visit(n.args)
    if (argsResult != null)
      return argsResult

    baseAST = baseCall
    null
  }

  def visit(n : TableAccessExpression) : ASTNode = {
    val baseAccess = baseAST match {
      case a : TableAccessExpression => a
      case _ => return n
    }

    baseAST = baseAccess.table
    val tableResult = visit(n.table)
    if (tableResult != null)
      return tableResult

    baseAST = baseAccess.field
    val fieldResult = visit(n.field)
    if (fieldResult != null)
      return fieldResult

    baseAST = baseAccess
    null
  }

  def visit(n : ParentheticalExpression) : ASTNode = {
    val baseParen = baseAST match {
      case b : ParentheticalExpression => b
      case _ => return n
    }

    baseAST = baseParen.e
    val result = visit(n.e)
    if (result != null)
      return result

    baseAST = baseParen
    null
  }

  def visit(n : IdentifierExpression) : ASTNode = {
    val baseID = baseAST match {
      case i : IdentifierExpression => i
      case _ => return n
    }

    if (baseID.id.equals(n.id)) null else n
  }

  def visit(n : BooleanLiteral) : ASTNode = {
    val baseBool = baseAST match {
      case b : BooleanLiteral => b
      case _ => return n
    }

    if (baseBool.v == n.v) null else n
  }

  def visit(n : NumericLiteral) : ASTNode = {
    val baseNum = baseAST match {
      case l : NumericLiteral => l
      case _ => return n
    }

    if (baseNum.v == n.v) null else n
  }

  def visit(n : StringLiteral) : ASTNode = {
    val baseString = baseAST match {
      case s : StringLiteral => s
      case _ => return n
    }

    if (baseString.v.equals(n.v)) null else n
  }

  def visit(n : NilLiteral) : ASTNode = if (baseAST.isInstanceOf[NilLiteral]) null else n

  def visit(n : FunctionDeclarationExpression) : ASTNode = {
    val baseDecl = baseAST match {
      case d : FunctionDeclarationExpression => d
      case _ => return n
    }

    if (baseDecl.params.size != n.params.size)
      return n.params(Math.min(baseDecl.params.size, n.params.size) - 1)

    for (i <- n.params.indices) {
      baseAST = baseDecl.params(i)
      val paramResult = visit(n.params(i))
      if (paramResult != null)
        return paramResult
    }

    if (baseDecl.hasVarArgs != n.hasVarArgs)
      return n

    baseAST = baseDecl.body
    val bodyResult = visit(n.body)
    if (bodyResult != null)
      return bodyResult

    baseAST = baseDecl
    null
  }

  def visit(n : TableConstructorExpression) : ASTNode = {
    val baseConstructor = baseAST match {
      case t : TableConstructorExpression => t
      case _ => return n
    }

    baseAST = baseConstructor.keys
    val keysResult = visit(n.keys)
    if (keysResult != null)
      return keysResult

    baseAST = baseConstructor.values
    val valuesResult = visit(n.values)
    if (valuesResult != null)
      return valuesResult

    baseAST = baseConstructor
    null
  }

  def visit(n : UpValueExpression) : ASTNode = {
    val baseUp = baseAST match {
      case u : UpValueExpression => u
      case _ => return n
    }

    baseAST = baseUp.id
    val r = visit(n.id)
    if (r != null)
      return r

    baseAST = baseUp
    null
  }

  def visit(n : VarArgsExpression) : ASTNode = if (baseAST.isInstanceOf[VarArgsExpression]) null else n
}
