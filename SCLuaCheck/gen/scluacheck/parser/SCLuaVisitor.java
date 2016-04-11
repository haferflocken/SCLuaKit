// Generated from C:/Users/John/IdeaProjects/SCLuaCheck/src/scluacheck/parser\SCLua.g4 by ANTLR 4.5.1
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
	 * Visit a parse tree produced by {@link SCLuaParser#funcName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncName(SCLuaParser.FuncNameContext ctx);
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
	 * Visit a parse tree produced by {@link SCLuaParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(SCLuaParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(SCLuaParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#funcBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncBody(SCLuaParser.FuncBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#tableConstructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableConstructor(SCLuaParser.TableConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#fField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFField(SCLuaParser.FFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link SCLuaParser#upValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpValue(SCLuaParser.UpValueContext ctx);
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
}