// Generated from C:/Users/John/IdeaProjects/SCLuaCheck/src/scluacheck/parser\SCLua.g4 by ANTLR 4.5.1
package scluacheck.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SCLuaParser}.
 */
public interface SCLuaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(SCLuaParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(SCLuaParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#idList}.
	 * @param ctx the parse tree
	 */
	void enterIdList(SCLuaParser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#idList}.
	 * @param ctx the parse tree
	 */
	void exitIdList(SCLuaParser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(SCLuaParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(SCLuaParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#varList}.
	 * @param ctx the parse tree
	 */
	void enterVarList(SCLuaParser.VarListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#varList}.
	 * @param ctx the parse tree
	 */
	void exitVarList(SCLuaParser.VarListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(SCLuaParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(SCLuaParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#chunk}.
	 * @param ctx the parse tree
	 */
	void enterChunk(SCLuaParser.ChunkContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#chunk}.
	 * @param ctx the parse tree
	 */
	void exitChunk(SCLuaParser.ChunkContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SCLuaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SCLuaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#funcName}.
	 * @param ctx the parse tree
	 */
	void enterFuncName(SCLuaParser.FuncNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#funcName}.
	 * @param ctx the parse tree
	 */
	void exitFuncName(SCLuaParser.FuncNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SCLuaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SCLuaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(SCLuaParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(SCLuaParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(SCLuaParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(SCLuaParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#bitwiseOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseOrExpression(SCLuaParser.BitwiseOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#bitwiseOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseOrExpression(SCLuaParser.BitwiseOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#bitwiseAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseAndExpression(SCLuaParser.BitwiseAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#bitwiseAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseAndExpression(SCLuaParser.BitwiseAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(SCLuaParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(SCLuaParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(SCLuaParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(SCLuaParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#concatExpression}.
	 * @param ctx the parse tree
	 */
	void enterConcatExpression(SCLuaParser.ConcatExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#concatExpression}.
	 * @param ctx the parse tree
	 */
	void exitConcatExpression(SCLuaParser.ConcatExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#addExpression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpression(SCLuaParser.AddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#addExpression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpression(SCLuaParser.AddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#multExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultExpression(SCLuaParser.MultExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#multExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultExpression(SCLuaParser.MultExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#negationExpression}.
	 * @param ctx the parse tree
	 */
	void enterNegationExpression(SCLuaParser.NegationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#negationExpression}.
	 * @param ctx the parse tree
	 */
	void exitNegationExpression(SCLuaParser.NegationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#powerExpression}.
	 * @param ctx the parse tree
	 */
	void enterPowerExpression(SCLuaParser.PowerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#powerExpression}.
	 * @param ctx the parse tree
	 */
	void exitPowerExpression(SCLuaParser.PowerExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(SCLuaParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(SCLuaParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#prefixExp}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExp(SCLuaParser.PrefixExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#prefixExp}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExp(SCLuaParser.PrefixExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(SCLuaParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(SCLuaParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(SCLuaParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(SCLuaParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#funcBody}.
	 * @param ctx the parse tree
	 */
	void enterFuncBody(SCLuaParser.FuncBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#funcBody}.
	 * @param ctx the parse tree
	 */
	void exitFuncBody(SCLuaParser.FuncBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#tableConstructor}.
	 * @param ctx the parse tree
	 */
	void enterTableConstructor(SCLuaParser.TableConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#tableConstructor}.
	 * @param ctx the parse tree
	 */
	void exitTableConstructor(SCLuaParser.TableConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#fField}.
	 * @param ctx the parse tree
	 */
	void enterFField(SCLuaParser.FFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#fField}.
	 * @param ctx the parse tree
	 */
	void exitFField(SCLuaParser.FFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#upValue}.
	 * @param ctx the parse tree
	 */
	void enterUpValue(SCLuaParser.UpValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#upValue}.
	 * @param ctx the parse tree
	 */
	void exitUpValue(SCLuaParser.UpValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(SCLuaParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(SCLuaParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(SCLuaParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(SCLuaParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(SCLuaParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(SCLuaParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#numericLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumericLiteral(SCLuaParser.NumericLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#numericLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumericLiteral(SCLuaParser.NumericLiteralContext ctx);
}