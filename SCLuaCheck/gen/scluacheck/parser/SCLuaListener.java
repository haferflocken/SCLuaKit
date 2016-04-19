// Generated from C:/Users/John/Documents/GitHub/SCLuaKit/SCLuaCheck/src/scluacheck/parser\SCLua.g4 by ANTLR 4.5.1
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
	 * Enter a parse tree produced by {@link SCLuaParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(SCLuaParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(SCLuaParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#functionCallStatement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallStatement(SCLuaParser.FunctionCallStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#functionCallStatement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallStatement(SCLuaParser.FunctionCallStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#methodCallStatement}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallStatement(SCLuaParser.MethodCallStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#methodCallStatement}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallStatement(SCLuaParser.MethodCallStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#explicitBlockStatement}.
	 * @param ctx the parse tree
	 */
	void enterExplicitBlockStatement(SCLuaParser.ExplicitBlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#explicitBlockStatement}.
	 * @param ctx the parse tree
	 */
	void exitExplicitBlockStatement(SCLuaParser.ExplicitBlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(SCLuaParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(SCLuaParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#repeatUntilStatement}.
	 * @param ctx the parse tree
	 */
	void enterRepeatUntilStatement(SCLuaParser.RepeatUntilStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#repeatUntilStatement}.
	 * @param ctx the parse tree
	 */
	void exitRepeatUntilStatement(SCLuaParser.RepeatUntilStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SCLuaParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SCLuaParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(SCLuaParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(SCLuaParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(SCLuaParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(SCLuaParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(SCLuaParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(SCLuaParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#forNumericStatement}.
	 * @param ctx the parse tree
	 */
	void enterForNumericStatement(SCLuaParser.ForNumericStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#forNumericStatement}.
	 * @param ctx the parse tree
	 */
	void exitForNumericStatement(SCLuaParser.ForNumericStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#forEachStatement}.
	 * @param ctx the parse tree
	 */
	void enterForEachStatement(SCLuaParser.ForEachStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#forEachStatement}.
	 * @param ctx the parse tree
	 */
	void exitForEachStatement(SCLuaParser.ForEachStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#functionDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclarationStatement(SCLuaParser.FunctionDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#functionDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclarationStatement(SCLuaParser.FunctionDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#localFunctionDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalFunctionDeclarationStatement(SCLuaParser.LocalFunctionDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#localFunctionDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalFunctionDeclarationStatement(SCLuaParser.LocalFunctionDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(SCLuaParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(SCLuaParser.LocalVariableDeclarationStatementContext ctx);
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
	 * Enter a parse tree produced by {@link SCLuaParser#parentheticalExpression}.
	 * @param ctx the parse tree
	 */
	void enterParentheticalExpression(SCLuaParser.ParentheticalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#parentheticalExpression}.
	 * @param ctx the parse tree
	 */
	void exitParentheticalExpression(SCLuaParser.ParentheticalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#functionDeclExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclExpression(SCLuaParser.FunctionDeclExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#functionDeclExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclExpression(SCLuaParser.FunctionDeclExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link SCLuaParser#varArgsExpression}.
	 * @param ctx the parse tree
	 */
	void enterVarArgsExpression(SCLuaParser.VarArgsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#varArgsExpression}.
	 * @param ctx the parse tree
	 */
	void exitVarArgsExpression(SCLuaParser.VarArgsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#ifPartIf}.
	 * @param ctx the parse tree
	 */
	void enterIfPartIf(SCLuaParser.IfPartIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#ifPartIf}.
	 * @param ctx the parse tree
	 */
	void exitIfPartIf(SCLuaParser.IfPartIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#ifPartElseif}.
	 * @param ctx the parse tree
	 */
	void enterIfPartElseif(SCLuaParser.IfPartElseifContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#ifPartElseif}.
	 * @param ctx the parse tree
	 */
	void exitIfPartElseif(SCLuaParser.IfPartElseifContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#ifPartElse}.
	 * @param ctx the parse tree
	 */
	void enterIfPartElse(SCLuaParser.IfPartElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#ifPartElse}.
	 * @param ctx the parse tree
	 */
	void exitIfPartElse(SCLuaParser.IfPartElseContext ctx);
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
	 * Enter a parse tree produced by {@link SCLuaParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(SCLuaParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(SCLuaParser.MethodNameContext ctx);
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
	 * Enter a parse tree produced by {@link SCLuaParser#equalityOp}.
	 * @param ctx the parse tree
	 */
	void enterEqualityOp(SCLuaParser.EqualityOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#equalityOp}.
	 * @param ctx the parse tree
	 */
	void exitEqualityOp(SCLuaParser.EqualityOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void enterRelationalOp(SCLuaParser.RelationalOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void exitRelationalOp(SCLuaParser.RelationalOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#addOp}.
	 * @param ctx the parse tree
	 */
	void enterAddOp(SCLuaParser.AddOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#addOp}.
	 * @param ctx the parse tree
	 */
	void exitAddOp(SCLuaParser.AddOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#multOp}.
	 * @param ctx the parse tree
	 */
	void enterMultOp(SCLuaParser.MultOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#multOp}.
	 * @param ctx the parse tree
	 */
	void exitMultOp(SCLuaParser.MultOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#negationOp}.
	 * @param ctx the parse tree
	 */
	void enterNegationOp(SCLuaParser.NegationOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#negationOp}.
	 * @param ctx the parse tree
	 */
	void exitNegationOp(SCLuaParser.NegationOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#tableEntry}.
	 * @param ctx the parse tree
	 */
	void enterTableEntry(SCLuaParser.TableEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#tableEntry}.
	 * @param ctx the parse tree
	 */
	void exitTableEntry(SCLuaParser.TableEntryContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#prefixPartFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterPrefixPartFunctionCall(SCLuaParser.PrefixPartFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#prefixPartFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitPrefixPartFunctionCall(SCLuaParser.PrefixPartFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#prefixPartMethodCall}.
	 * @param ctx the parse tree
	 */
	void enterPrefixPartMethodCall(SCLuaParser.PrefixPartMethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#prefixPartMethodCall}.
	 * @param ctx the parse tree
	 */
	void exitPrefixPartMethodCall(SCLuaParser.PrefixPartMethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#prefixPartTableAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrefixPartTableAccess(SCLuaParser.PrefixPartTableAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#prefixPartTableAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrefixPartTableAccess(SCLuaParser.PrefixPartTableAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCLuaParser#prefixPartDotAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrefixPartDotAccess(SCLuaParser.PrefixPartDotAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCLuaParser#prefixPartDotAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrefixPartDotAccess(SCLuaParser.PrefixPartDotAccessContext ctx);
}