// Generated from C:/Users/John/Documents/GitHub/SCLuaKit/SCLuaCheck/src/scluacheck/parser\SCLua.g4 by ANTLR 4.5.1
package scluacheck.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SCLuaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SCLuaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(SCLuaParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#idList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdList(SCLuaParser.IdListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(SCLuaParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#varList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarList(SCLuaParser.VarListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(SCLuaParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#chunk}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChunk(SCLuaParser.ChunkContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SCLuaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(SCLuaParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#functionCallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallStatement(SCLuaParser.FunctionCallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#methodCallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCallStatement(SCLuaParser.MethodCallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#explicitBlockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitBlockStatement(SCLuaParser.ExplicitBlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(SCLuaParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#repeatUntilStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatUntilStatement(SCLuaParser.RepeatUntilStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(SCLuaParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(SCLuaParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(SCLuaParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(SCLuaParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#forNumericStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForNumericStatement(SCLuaParser.ForNumericStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#forEachStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForEachStatement(SCLuaParser.ForEachStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#functionDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclarationStatement(SCLuaParser.FunctionDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#localFunctionDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalFunctionDeclarationStatement(SCLuaParser.LocalFunctionDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(SCLuaParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SCLuaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#orExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(SCLuaParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(SCLuaParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#bitwiseOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseOrExpression(SCLuaParser.BitwiseOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#bitwiseAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseAndExpression(SCLuaParser.BitwiseAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(SCLuaParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(SCLuaParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#concatExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatExpression(SCLuaParser.ConcatExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#addExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpression(SCLuaParser.AddExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#multExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpression(SCLuaParser.MultExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#negationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegationExpression(SCLuaParser.NegationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#powerExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowerExpression(SCLuaParser.PowerExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(SCLuaParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#prefixExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExp(SCLuaParser.PrefixExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#parentheticalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheticalExpression(SCLuaParser.ParentheticalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#functionDeclExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclExpression(SCLuaParser.FunctionDeclExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#tableConstructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableConstructor(SCLuaParser.TableConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#upValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpValue(SCLuaParser.UpValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#varArgsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarArgsExpression(SCLuaParser.VarArgsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#ifPartIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfPartIf(SCLuaParser.IfPartIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#ifPartElseif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfPartElseif(SCLuaParser.IfPartElseifContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#ifPartElse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfPartElse(SCLuaParser.IfPartElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#funcName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncName(SCLuaParser.FuncNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(SCLuaParser.MethodNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(SCLuaParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#funcBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncBody(SCLuaParser.FuncBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#equalityOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityOp(SCLuaParser.EqualityOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalOp(SCLuaParser.RelationalOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#addOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOp(SCLuaParser.AddOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#multOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultOp(SCLuaParser.MultOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#negationOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegationOp(SCLuaParser.NegationOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#tableEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableEntry(SCLuaParser.TableEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(SCLuaParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(SCLuaParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(SCLuaParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#numericLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericLiteral(SCLuaParser.NumericLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#prefixPartFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixPartFunctionCall(SCLuaParser.PrefixPartFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#prefixPartMethodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixPartMethodCall(SCLuaParser.PrefixPartMethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#prefixPartTableAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixPartTableAccess(SCLuaParser.PrefixPartTableAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#prefixPartDotAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixPartDotAccess(SCLuaParser.PrefixPartDotAccessContext ctx);
}