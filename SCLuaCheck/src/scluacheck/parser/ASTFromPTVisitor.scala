package scluacheck.parser

import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor

import scluacheck.ast._
import scluacheck.parser.SCLuaParser._

/**
  * Visits a parse tree and spits out an abstract syntax tree.
  * This file is laid out to match SCLua.g4
  */
object ASTFromPTVisitor extends AbstractParseTreeVisitor[ASTNode] with SCLuaVisitor[ASTNode] {

  override def visitStart(ctx : StartContext) : ASTNode = new FileNode(visitChunk(ctx.chunk()).asInstanceOf[StatementList])

  override def visitIdList(ctx : IdListContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    var s = Seq[Expression]()
    for (i <- Range(0, ctx.ID.size)) {
      val e = ctx.ID.get(i).getSymbol
      s = s :+ new IdentifierExpression(e.getLine, e.getCharPositionInLine, e.getText)
    }
    new ExprList(line, column, s)
  }

  override def visitParamList(ctx : ParamListContext) : ASTNode = {
    if (ctx.idList != null) {
      val idList = visitIdList(ctx.idList).asInstanceOf[ExprList]
      if (ctx.varArgsExpression != null) {
        val finalParam = visitVarArgsExpression(ctx.varArgsExpression).asInstanceOf[Expression]
        return new ExprList(idList.line, idList.column, idList.elements :+ finalParam)
      }
      return idList
    }
    visitVarArgsExpression(ctx.varArgsExpression)
  }

  override def visitVarList(ctx : VarListContext) : ASTNode = visitChildren(ctx)

  override def visitExpressionList(ctx : ExpressionListContext) : ASTNode = visitChildren(ctx)

  // START OF MAIN AST NODES
  // vvvvvvvvvvvvvvvvvvvvvvv

  override def visitChunk(ctx : ChunkContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    val stats = visitChildren(ctx)
    stats match {
      case l : StatementList => l
      case DefRes => null
    }
  }

  override def visitStatement(ctx : StatementContext) : ASTNode = visitChildren(ctx)

  override def visitAssignmentStatement(ctx : AssignmentStatementContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    val varList = visitVarList(ctx.varList).asInstanceOf[ExprList]
    val exprList = visitExpressionList(ctx.expressionList).asInstanceOf[ExprList]
    new AssignmentStatement(line, column, varList, exprList)
  }

  override def visitFunctionCallStatement(ctx : FunctionCallStatementContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    new FunctionCallStatement(line, column, visitFunctionCall(ctx.prefixExp, ctx.args))
  }

  override def visitMethodCallStatement(ctx : MethodCallStatementContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    new FunctionCallStatement(line, column, visitMethodCall(ctx.prefixExp, ctx.ID.getSymbol, ctx.args))
  }

  override def visitExplicitBlockStatement(ctx : ExplicitBlockStatementContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    new ExplicitBlockStatement(line, column, visitChunk(ctx.chunk).asInstanceOf[StatementList])
  }

  override def visitWhileStatement(ctx : WhileStatementContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    val condition = visitExpression(ctx.expression()).asInstanceOf[Expression]
    val body = visitChunk(ctx.chunk()).asInstanceOf[StatementList]
    new WhileStatement(line, column, condition, body)
  }

  override def visitRepeatUntilStatement(ctx : RepeatUntilStatementContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    val body = visitChunk(ctx.chunk).asInstanceOf[StatementList]
    val condition = visitExpression(ctx.expression).asInstanceOf[Expression]
    new RepeatUntilStatement(line, column, body, condition)
  }

  override def visitIfStatement(ctx : IfStatementContext) : ASTNode = {
    // Visit the parts of the if statement.
    val first = visitIfPartIf(ctx.ifPartIf).asInstanceOf[IfStatement]
    val elseifs = for (i <- Range(0, ctx.ifPartElseif.size)) yield visitIfPartElseif(ctx.ifPartElseif(i)).asInstanceOf[IfStatement]

    // Chain the parts of the if statement together.
    var prev : Statement = null
    var start = elseifs.size - 1
    if (ctx.ifPartElse != null)
      prev = visitIfPartElse(ctx.ifPartElse).asInstanceOf[Statement]
    else if (elseifs.nonEmpty) {
      prev = elseifs.last
      start = elseifs.size - 2
    }

    for (i <- Range(start, -1, -1)) {
      val e = elseifs(i)
      prev = new IfStatement(e.line, e.column, e.condition, e.thn, prev)
    }
    new IfStatement(first.line, first.column, first.condition, first.thn, prev)
  }

  override def visitReturnStatement(ctx : ReturnStatementContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    val exprList = if (ctx.expressionList == null) null else visitExpressionList(ctx.expressionList).asInstanceOf[ExprList]
    new ReturnStatement(line, column, exprList)
  }

  override def visitBreakStatement(ctx : BreakStatementContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    new BreakStatement(line, column)
  }

  override def visitContinueStatement(ctx : ContinueStatementContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    new ContinueStatement(line, column)
  }

  override def visitForNumericStatement(ctx : ForNumericStatementContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine

    val index = new IdentifierExpression(ctx.ID.getSymbol.getLine, ctx.ID.getSymbol.getCharPositionInLine, ctx.ID.getText)
    val start = visitExpression(ctx.expression(0)).asInstanceOf[Expression]
    val end = visitExpression(ctx.expression(1)).asInstanceOf[Expression]
    val inc = if (ctx.expression.size > 2) visitExpression(ctx.expression(2)).asInstanceOf[Expression]
              else new NumericLiteral(line, column, 1)
    val body = visitChunk(ctx.chunk).asInstanceOf[StatementList]
    new ForNumericStatement(line, column, index, start, end, inc, body)
  }

  override def visitForEachStatement(ctx : ForEachStatementContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine

    val index1Symbol = ctx.ID(0).getSymbol
    val index1 = new IdentifierExpression(index1Symbol.getLine, index1Symbol.getCharPositionInLine, index1Symbol.getText)
    val index2 = if (ctx.ID.size == 1) null else {
      val index2Symbol = ctx.ID(1).getSymbol
      new IdentifierExpression(index2Symbol.getLine, index2Symbol.getCharPositionInLine, index2Symbol.getText)
    }
    val collection = visitExpression(ctx.expression).asInstanceOf[Expression]
    val body = visitChunk(ctx.chunk).asInstanceOf[StatementList]
    new ForEachStatement(line, column, index1, index2, collection, body)
  }

  // Sugar for an assignment statement with a function declaration expression.
  override def visitFunctionDeclarationStatement(ctx : FunctionDeclarationStatementContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine

    val (rawParams, hasVarArgs, body) = visitFuncDecl(ctx.funcBody)
    val binding = visitFuncName(ctx.funcName).asInstanceOf[Expression]

    // Add the implicit parameter if this is a method call.
    val params = if (ctx.funcName.methodName != null) {
      if (rawParams != null)
        new IdentifierExpression(line, column, "self") +: rawParams
      else
        Seq(new IdentifierExpression(line, column, "self"))
    } else
      rawParams

    val funcDeclExpr = new FunctionDeclarationExpression(line, column, params, hasVarArgs, body)
    new AssignmentStatement(line, column, new ExprList(line, column, Seq(binding)), new ExprList(line, column, Seq(funcDeclExpr)))
  }

  // Sugar for a local declaration followed by an assignment statement with a function declaration expression.
  override def visitLocalFunctionDeclarationStatement(ctx : LocalFunctionDeclarationStatementContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine

    val (params, hasVarArgs, body) = visitFuncDecl(ctx.funcBody)
    val binding = new IdentifierExpression(ctx.ID.getSymbol.getLine, ctx.ID.getSymbol.getCharPositionInLine, ctx.ID.getText)

    val funcDeclExpr = new FunctionDeclarationExpression(line, column, params, hasVarArgs, body)
    val localDecl = new LocalVariableDeclarationStatement(line, column, Seq[IdentifierExpression](binding), null)
    val assignment = new AssignmentStatement(line, column, new ExprList(line, column, Seq(binding)), new ExprList(line, column, Seq(funcDeclExpr)))

    // The sugar expands into a local declaration statement followed by an assignment statement.
    new StatementList(line, column, Seq(localDecl, assignment))
  }

  override def visitLocalVariableDeclarationStatement(ctx : LocalVariableDeclarationStatementContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    val idExprs = visitIdList(ctx.idList).asInstanceOf[ExprList]
    val ids = for (e <- idExprs.elements) yield e.asInstanceOf[IdentifierExpression]

    // Local definitions may have assignments.
    if (ctx.expressionList == null)
      return new LocalVariableDeclarationStatement(line, column, ids, null)
    val values = visitExpressionList(ctx.expressionList).asInstanceOf[ExprList]
    new LocalVariableDeclarationStatement(line, column, ids, values)
  }

  override def visitExpression(ctx : ExpressionContext) : ASTNode = {
    val l = visitChildren(ctx).asInstanceOf[ExprList]
    assert(l.elements.size == 1)
    l.elements.head
  }

  override def visitOrExpression(ctx : OrExpressionContext) : ASTNode =
    visitCompositeExpression(ctx.getStart, ctx.andExpression, visitAndExpression,
      (line : Int, column : Int, _ : Null, lhs : Expression, rhs : Expression) =>
        new LogicalBinopExpression(line, column, LogicalBinop.OR, lhs, rhs))

  override def visitAndExpression(ctx : AndExpressionContext) : ASTNode =
    visitCompositeExpression(ctx.getStart, ctx.bitwiseOrExpression, visitBitwiseOrExpression,
      (line : Int, column : Int, _ : Null, lhs : Expression, rhs : Expression) =>
        new LogicalBinopExpression(line, column, LogicalBinop.AND, lhs, rhs))

  override def visitBitwiseOrExpression(ctx : BitwiseOrExpressionContext) : ASTNode =
    visitCompositeExpression(ctx.getStart, ctx.bitwiseAndExpression, visitBitwiseAndExpression,
      (line : Int, column : Int, _ : Null, lhs : Expression, rhs : Expression) =>
        new BitwiseBinopExpression(line, column, BitwiseBinop.OR, lhs, rhs))

  override def visitBitwiseAndExpression(ctx : BitwiseAndExpressionContext) : ASTNode =
    visitCompositeExpression(ctx.getStart, ctx.equalityExpression, visitEqualityExpression,
      (line : Int, column : Int, _ : Null, lhs : Expression, rhs : Expression) =>
        new BitwiseBinopExpression(line, column, BitwiseBinop.AND, lhs, rhs))

  override def visitEqualityExpression(ctx : EqualityExpressionContext) : ASTNode =
    visitCompositeExpression(ctx.getStart, ctx.relationalExpression, ctx.equalityOp, visitRelationalExpression,
      (line : Int, column : Int, op : EqualityOpContext, lhs : Expression, rhs : Expression) => {
        val o = relationalOpFromString(op.getText)
        new RelationalBinopExpression(line, column, o, lhs, rhs)
      })

  override def visitRelationalExpression(ctx : RelationalExpressionContext) : ASTNode =
    visitCompositeExpression(ctx.getStart, ctx.concatExpression, ctx.relationalOp, visitConcatExpression,
      (line : Int, column : Int, op : RelationalOpContext, lhs : Expression, rhs : Expression) => {
        val o = relationalOpFromString(op.getText)
        new RelationalBinopExpression(line, column, o, lhs, rhs)
      })

  override def visitConcatExpression(ctx : ConcatExpressionContext) : ASTNode =
    visitCompositeExpression(ctx.getStart, ctx.addExpression, visitAddExpression,
      (line : Int, column : Int, _ : Null, lhs : Expression, rhs : Expression) =>
        new ConcatenationExpression(line, column, lhs, rhs))

  override def visitAddExpression(ctx : AddExpressionContext) : ASTNode =
    visitCompositeExpression(ctx.getStart, ctx.multExpression, ctx.addOp, visitMultExpression,
      (line : Int, column : Int, op : AddOpContext, lhs : Expression, rhs : Expression) => {
        val o = arithmeticOpFromString(op.getText)
        new ArithmeticBinopExpression(line, column, o, lhs, rhs)
      })

  override def visitMultExpression(ctx : MultExpressionContext) : ASTNode =
    visitCompositeExpression(ctx.getStart, ctx.negationExpression, ctx.multOp, visitNegationExpression,
      (line : Int, column : Int, op : MultOpContext, lhs : Expression, rhs : Expression) => {
        val o = arithmeticOpFromString(op.getText)
        new ArithmeticBinopExpression(line, column, o, lhs, rhs)
      })

  override def visitNegationExpression(ctx : NegationExpressionContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine

    if (ctx.negationOp != null) {
      val opString = ctx.negationOp.getText
      val e = visitNegationExpression(ctx.negationExpression).asInstanceOf[Expression]
      if (opString.equals("-"))
        return new NegationExpression(line, column, e)
      return new NotExpression(line, column, e)
    }
    visitPowerExpression(ctx.powerExpression)
  }


  override def visitPowerExpression(ctx : PowerExpressionContext) : ASTNode =
    visitCompositeExpression(ctx.getStart, ctx.primaryExpression, visitPrimaryExpression,
      (line : Int, column : Int, _ : Null, lhs : Expression, rhs : Expression) =>
        new ArithmeticBinopExpression(line, column, ArithmeticBinop.POWER, lhs, rhs))

  override def visitPrimaryExpression(ctx : PrimaryExpressionContext) : ASTNode = {
    val l = visitChildren(ctx).asInstanceOf[ExprList]
    assert(l.elements.size == 1)
    l.elements.head
  }

  override def visitPrefixExp(ctx : PrefixExpContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine

    if (ctx.prefixExp != null) {
      val prefix = visitPrefixExp(ctx.prefixExp).asInstanceOf[Expression]

      if (ctx.prefixPartFunctionCall != null) {
        return visitFunctionCall(ctx.prefixExp, ctx.prefixPartFunctionCall.args)
      }
      if (ctx.prefixPartMethodCall != null) {
        return visitMethodCall(ctx.prefixExp, ctx.prefixPartMethodCall.ID.getSymbol, ctx.prefixPartMethodCall.args)
      }
      if (ctx.prefixPartTableAccess != null) {
        val key = visitExpression(ctx.prefixPartTableAccess.expression).asInstanceOf[Expression]
        return new TableAccessExpression(line, column, prefix, key)
      }
      if (ctx.prefixPartDotAccess != null) {
        val keySymbol = ctx.prefixPartDotAccess.ID.getSymbol
        val key = new StringLiteral(keySymbol.getLine, keySymbol.getCharPositionInLine, keySymbol.getText)
        return new TableAccessExpression(line, column, prefix, key)
      }
    }
    if (ctx.parentheticalExpression != null)
      return visitParentheticalExpression(ctx.parentheticalExpression)
    new IdentifierExpression(line, column, ctx.ID.getText)
  }

  override def visitParentheticalExpression(ctx : ParentheticalExpressionContext) : ASTNode = {
    val l = visitChildren(ctx).asInstanceOf[ExprList]
    assert(l.elements.size == 1)
    l.elements.head
  }

  override def visitFunctionDeclExpression(ctx : FunctionDeclExpressionContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    val (params, hasVarArgs, body) = visitFuncDecl(ctx.funcBody)
    new FunctionDeclarationExpression(line, column, params, hasVarArgs, body)
  }

  override def visitTableConstructor(ctx : TableConstructorContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine

    val entries = ctx.tableEntry
    var keyExprs = Seq[Expression]()
    var valExprs = Seq[Expression]()
    for (i <- Range(0, entries.size)) {
      val e = entries.get(i)
      // Determine the type of entry. There are three:
      // - Type 1 has two expressions.
      // - Type 2 has an ID and one expression.
      // - Type 3 has just one expression.
      var key : Expression = null
      var value : Expression = null
      if (e.expression.size == 2) {
        key = visitExpression(e.expression(0)).asInstanceOf[Expression]
        value = visitExpression(e.expression(1)).asInstanceOf[Expression]
      } else if (e.ID != null) {
        key = new IdentifierExpression(e.ID.getSymbol.getLine, e.ID.getSymbol.getCharPositionInLine, e.ID.getText)
        value = visitExpression(e.expression(0)).asInstanceOf[Expression]
      } else {
        key = new NumericLiteral(e.getStart.getLine, e.getStart.getCharPositionInLine, i)
        value = visitExpression(e.expression(0)).asInstanceOf[Expression]
      }
      keyExprs = keyExprs :+ key
      valExprs = valExprs :+ value
    }

    new TableConstructorExpression(line, column, new ExprList(line, column, keyExprs), new ExprList(line, column, valExprs))
  }

  override def visitUpValue(ctx : UpValueContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    val id = new IdentifierExpression(ctx.ID.getSymbol.getLine, ctx.ID.getSymbol.getCharPositionInLine, ctx.ID.getText)
    new UpValueExpression(line, column, id)
  }

  override def visitVarArgsExpression(ctx : VarArgsExpressionContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    new VarArgsExpression(line, column)
  }

  // ^^^^^^^^^^^^^^^^^^^^^
  // END OF MAIN AST NODES

  // Returns a partially constructed if statement which has not considered any elseif or else clauses.
  override def visitIfPartIf(ctx : IfPartIfContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    val condition = visitExpression(ctx.expression).asInstanceOf[Expression]
    val body = visitChunk(ctx.chunk).asInstanceOf[StatementList]
    new IfStatement(line, column, condition, body, null)
  }

  // Returns a partially constructed if statement which is an elseif clause of an if statement.
  override def visitIfPartElseif(ctx : IfPartElseifContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    val condition = visitExpression(ctx.expression).asInstanceOf[Expression]
    val body = visitChunk(ctx.chunk).asInstanceOf[StatementList]
    new IfStatement(line, column, condition, body, null)
  }

  // Returns a chunk which represents the else clause of an if statement.
  override def visitIfPartElse(ctx : IfPartElseContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    new ExplicitBlockStatement(line, column, visitChunk(ctx.chunk).asInstanceOf[StatementList])
  }

  override def visitFuncName(ctx : FuncNameContext) : ASTNode = {
    if (ctx.methodName != null)
      return visitMethodName(ctx.methodName)

    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine

    val leftID = new IdentifierExpression(line, column, ctx.ID(0).getText)
    if (ctx.ID.size == 1)
      return leftID
    val rightID = new StringLiteral(line, column, ctx.ID(1).getText)
    new TableAccessExpression(line, column, leftID, rightID)
  }

  override def visitMethodName(ctx : MethodNameContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    val leftID = new IdentifierExpression(line, column, ctx.ID(0).getText)
    val rightID = new StringLiteral(line, column, ctx.ID(1).getText)
    new TableAccessExpression(line, column, leftID, rightID)
  }

  override def visitArgs(ctx : ArgsContext) : ASTNode = {
    if (ctx.STRING_LITERAL != null) {
      val line = ctx.getStart.getLine
      val column = ctx.getStart.getCharPositionInLine
      return new StringLiteral(line, column, unquote(ctx.STRING_LITERAL.getText))
    }
    visitChildren(ctx)
  }

  override def visitFuncBody(ctx : FuncBodyContext) : ASTNode = throw new java.lang.Error("Not a valid node to visit.")

  override def visitEqualityOp(ctx : EqualityOpContext) : ASTNode = throw new java.lang.Error("Not a valid node to visit.")

  override def visitRelationalOp(ctx : RelationalOpContext) : ASTNode = throw new java.lang.Error("Not a valid node to visit.")

  override def visitAddOp(ctx : AddOpContext) : ASTNode = throw new java.lang.Error("Not a valid node to visit.")

  override def visitMultOp(ctx : MultOpContext) : ASTNode = throw new java.lang.Error("Not a valid node to visit.")

  override def visitNegationOp(ctx : NegationOpContext) : ASTNode = throw new java.lang.Error("Not a valid node to visit.")

  override def visitTableEntry(ctx : TableEntryContext) : ASTNode = throw new java.lang.Error("Not a valid node to visit.")

  override def visitVar(ctx : VarContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine

    if (ctx.prefixExp != null) {
      val table = visitPrefixExp(ctx.prefixExp).asInstanceOf[Expression]
      if (ctx.expression != null) {
        val key = visitExpression(ctx.expression).asInstanceOf[Expression]
        return new TableAccessExpression(line, column, table, key)
      } else {
        val key = ctx.ID.getSymbol
        return new TableAccessExpression(line, column, table, new StringLiteral(key.getLine, key.getCharPositionInLine, key.getText))
      }
    }
    new IdentifierExpression(line, column, ctx.ID.getSymbol.getText)
  }

  override def visitLiteral(ctx : LiteralContext) : ASTNode = {
    if (ctx.booleanLiteral != null)
      return visitBooleanLiteral(ctx.booleanLiteral)
    if (ctx.numericLiteral != null)
      return visitNumericLiteral(ctx.numericLiteral)

    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    if (ctx.STRING_LITERAL != null)
      return new StringLiteral(line, column, unquote(ctx.STRING_LITERAL.getText))
    new NilLiteral(line, column)
  }

  override def visitBooleanLiteral(ctx : BooleanLiteralContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine
    new BooleanLiteral(line, column, ctx.getText.equals("true"))
  }

  override def visitNumericLiteral(ctx : NumericLiteralContext) : ASTNode = {
    val line = ctx.getStart.getLine
    val column = ctx.getStart.getCharPositionInLine

    if (ctx.HEX_LITERAL != null) {
      val i = java.lang.Long.decode(ctx.HEX_LITERAL.getText)
      return new NumericLiteral(line, column, i.toDouble)
    }
    if (ctx.INT_LITERAL != null)
      return new NumericLiteral(line, column, ctx.INT_LITERAL.getText.toDouble)
    new NumericLiteral(line, column, ctx.FLOAT_LITERAL.getText.toDouble)
  }

  override def visitPrefixPartFunctionCall(ctx : PrefixPartFunctionCallContext) : ASTNode = throw new java.lang.Error("Not a valid node to visit.")

  override def visitPrefixPartMethodCall(ctx : PrefixPartMethodCallContext) : ASTNode = throw new java.lang.Error("Not a valid node to visit.")

  override def visitPrefixPartTableAccess(ctx : PrefixPartTableAccessContext) : ASTNode = throw new java.lang.Error("Not a valid node to visit.")

  override def visitPrefixPartDotAccess(ctx : PrefixPartDotAccessContext) : ASTNode = throw new java.lang.Error("Not a valid node to visit.")

  private def visitCompositeExpression[T](start : Token, subExps : java.util.List[T], subFn : (T) => ASTNode,
                                          aggregator : (Int, Int, _ >: Null, Expression, Expression) => Expression) : ASTNode =
    visitCompositeExpression(start, subExps, null, subFn, aggregator)

  private def visitCompositeExpression[T, O >: Null](start : Token, subExps : java.util.List[T], ops : java.util.List[O],
                                             subFn : (T) => ASTNode, aggregator : (Int, Int, O, Expression, Expression) => Expression) : ASTNode = {
    val line = start.getLine
    val column = start.getCharPositionInLine
    var out : Expression = null
    for (i <- Range(0, subExps.size)) {
      val e = subFn(subExps.get(i)).asInstanceOf[Expression]
      val o : O = if (i == 0 || ops == null) null else ops.get(i - 1)
      if (out == null)
        out = e
      else
        out = aggregator(line, column, o, out, e)
    }
    out
  }

  private def relationalOpFromString(s : String) : RelationalBinop.RelationalBinop =
    if (s.equals("=="))
      RelationalBinop.EQ
    else if (s.equals("~=") || s.equals("!="))
      RelationalBinop.NE
    else if (s.equals("<"))
      RelationalBinop. LT
    else if (s.equals(">"))
      RelationalBinop.GT
    else if (s.equals("<="))
      RelationalBinop.LTE
    else // if (s.equals(">=")
      RelationalBinop.GTE

  private def arithmeticOpFromString(s : String) : ArithmeticBinop.ArithmeticBinop =
    if (s.equals("+"))
      ArithmeticBinop.ADD
    else if (s.equals("-"))
      ArithmeticBinop.SUBTRACT
    else if (s.equals("*"))
      ArithmeticBinop.MULTIPLY
    else if (s.equals("/"))
      ArithmeticBinop.DIVIDE
    else if (s.equals("%"))
      ArithmeticBinop.MODULO
    else // if (s.equals("^"))
      ArithmeticBinop.POWER

  private def visitFuncDecl(ctx : FuncBodyContext) : (Seq[IdentifierExpression], Boolean, StatementList) = {
    val rawParams = if (ctx.paramList == null) null else visitParamList(ctx.paramList)
    var params : Seq[IdentifierExpression] = null
    var hasVarArgs = false
    rawParams match {
      case null => // Do nothing.
      case l : ExprList if l.elements.nonEmpty && l.elements.last.isInstanceOf[VarArgsExpression] => {
        params = for(e <- l.elements.slice(0, l.elements.size - 1)) yield e.asInstanceOf[IdentifierExpression]
        hasVarArgs = true
      }
      case l : ExprList if l.elements.nonEmpty => params = for (e <- l.elements) yield e.asInstanceOf[IdentifierExpression]
      case l : ExprList => params = Seq[IdentifierExpression]()
      case v : VarArgsExpression => hasVarArgs = true
    }
    val body = visitChunk(ctx.chunk).asInstanceOf[StatementList]
    (params, hasVarArgs, body)
  }

  private def visitFunctionCall(funcCtx : PrefixExpContext, argsCtx : ArgsContext) : FunctionCallExpression = {
    val line = funcCtx.getStart.getLine
    val column = funcCtx.getStart.getCharPositionInLine

    val funcExpr = visitPrefixExp(funcCtx).asInstanceOf[Expression]
    val rawArgs = visitArgs(argsCtx)
    val args = rawArgs match {
      case a : Expression => new ExprList(a.line, a.column, Seq(a))
      case l : ExprList => l
      case DefRes => null
    }
    new FunctionCallExpression(line, column, funcExpr, args)
  }

  private def visitMethodCall(calleeCtx : PrefixExpContext, methodSymbol : Token, argsCtx : ArgsContext) : FunctionCallExpression = {
    val line = calleeCtx.getStart.getLine
    val column = calleeCtx.getStart.getCharPositionInLine

    val calleeExpr = visitPrefixExp(calleeCtx).asInstanceOf[Expression]
    val methodID = new StringLiteral(methodSymbol.getLine, methodSymbol.getCharPositionInLine, methodSymbol.getText)
    val func = new TableAccessExpression(line, column, calleeExpr, methodID)

    val implicitArg = new IdentifierExpression(line, column, "self")
    val rawArgs = visitArgs(argsCtx)
    val args = rawArgs match {
      case a : Expression => new ExprList(a.line, a.column, Seq(implicitArg, a))
      case l : ExprList => new ExprList(l.line, l.column, implicitArg +: l.elements)
      case DefRes => null
    }
    new FunctionCallExpression(line, column, func, args)
  }

  private def unquote(s : String) : String = {
    // We can just return from a doublequoted string because they are already escaped correctly.
    if (s.charAt(0) == '"')
      return s.substring(1, s.length() - 1)

    // If the string was singlequoted, we need to unescape single quotes and escape double quotes.
    if (s.charAt(0) == '\'') {
      var inner = s.substring(1, s.length() - 1)
      inner = inner.replaceAll("\\\\'", "'")
      return inner.replaceAll("\"", "\\\\\"")
    }

    // If it doesn't start with a single or double quote, it must start with a [[.
    // TODO I'm not sure if the [[ strings need any escape processing.
    s.substring(2, s.length() - 2)
  }

  // Help AbstractParseTreeVisitor do some of our work.
  private object DefRes extends ASTNode(-1, -1) {
    override def accept[T](visitor : ASTVisitor[T]) : T = throw new java.lang.Error("Do not visit the default result.")
  }
  override def defaultResult() : ASTNode = DefRes

  override def aggregateResult(aggregate : ASTNode, nextResult : ASTNode) : ASTNode = {
    if (nextResult == DefRes && aggregate == DefRes)
      return DefRes
    if (nextResult == DefRes)
      return ensureList(aggregate)
    if (aggregate == DefRes)
      return ensureList(nextResult)

    val line = nextResult.line.max(aggregate.line)
    val column = nextResult.column.max(aggregate.column)

    val ag = ensureList(aggregate)
    val nr = ensureList(nextResult)

    ag match {
      case l : ExprList => {
        val l2 = nr.asInstanceOf[ExprList]
        new ExprList(line, column, l.elements ++ l2.elements)
      }
      case l : StatementList => {
        val l2 = nr.asInstanceOf[StatementList]
        new StatementList(line, column, l.elements ++ l2.elements)
      }
    }
  }

  private def ensureList(n : ASTNode) : ASTNode = n match {
    case l : ExprList => l
    case l : StatementList => l
    case e : Expression => new ExprList(e.line, e.column, Seq(e))
    case s : Statement => new StatementList(s.line, s.column, Seq(s))
  }
}
