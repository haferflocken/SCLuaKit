// Generated from C:/Users/John/Documents/GitHub/SCLuaKit/SCLuaCheck/src/scluacheck/parser\SCLua.g4 by ANTLR 4.5.1
package scluacheck.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SCLuaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, HEX_LITERAL=51, INT_LITERAL=52, 
		FLOAT_LITERAL=53, STRING_LITERAL=54, ESCAPE_LITERAL=55, ID=56, LINE_COMMENT=57, 
		LONG_COMMENT=58, WS=59;
	public static final int
		RULE_start = 0, RULE_idList = 1, RULE_paramList = 2, RULE_varList = 3, 
		RULE_expressionList = 4, RULE_chunk = 5, RULE_statement = 6, RULE_assignmentStatement = 7, 
		RULE_functionCallStatement = 8, RULE_methodCallStatement = 9, RULE_explicitBlockStatement = 10, 
		RULE_whileStatement = 11, RULE_repeatUntilStatement = 12, RULE_ifStatement = 13, 
		RULE_returnStatement = 14, RULE_breakStatement = 15, RULE_continueStatement = 16, 
		RULE_forNumericStatement = 17, RULE_forEachStatement = 18, RULE_functionDeclarationStatement = 19, 
		RULE_localFunctionDeclarationStatement = 20, RULE_localVariableDeclarationStatement = 21, 
		RULE_expression = 22, RULE_orExpression = 23, RULE_andExpression = 24, 
		RULE_bitwiseOrExpression = 25, RULE_bitwiseAndExpression = 26, RULE_equalityExpression = 27, 
		RULE_relationalExpression = 28, RULE_concatExpression = 29, RULE_addExpression = 30, 
		RULE_multExpression = 31, RULE_negationExpression = 32, RULE_powerExpression = 33, 
		RULE_primaryExpression = 34, RULE_prefixExp = 35, RULE_parentheticalExpression = 36, 
		RULE_functionDeclExpression = 37, RULE_tableConstructor = 38, RULE_upValue = 39, 
		RULE_varArgsExpression = 40, RULE_ifPartIf = 41, RULE_ifPartElseif = 42, 
		RULE_ifPartElse = 43, RULE_funcName = 44, RULE_methodName = 45, RULE_args = 46, 
		RULE_funcBody = 47, RULE_equalityOp = 48, RULE_relationalOp = 49, RULE_addOp = 50, 
		RULE_multOp = 51, RULE_negationOp = 52, RULE_tableEntry = 53, RULE_var = 54, 
		RULE_literal = 55, RULE_booleanLiteral = 56, RULE_numericLiteral = 57, 
		RULE_prefixPartFunctionCall = 58, RULE_prefixPartMethodCall = 59, RULE_prefixPartTableAccess = 60, 
		RULE_prefixPartDotAccess = 61;
	public static final String[] ruleNames = {
		"start", "idList", "paramList", "varList", "expressionList", "chunk", 
		"statement", "assignmentStatement", "functionCallStatement", "methodCallStatement", 
		"explicitBlockStatement", "whileStatement", "repeatUntilStatement", "ifStatement", 
		"returnStatement", "breakStatement", "continueStatement", "forNumericStatement", 
		"forEachStatement", "functionDeclarationStatement", "localFunctionDeclarationStatement", 
		"localVariableDeclarationStatement", "expression", "orExpression", "andExpression", 
		"bitwiseOrExpression", "bitwiseAndExpression", "equalityExpression", "relationalExpression", 
		"concatExpression", "addExpression", "multExpression", "negationExpression", 
		"powerExpression", "primaryExpression", "prefixExp", "parentheticalExpression", 
		"functionDeclExpression", "tableConstructor", "upValue", "varArgsExpression", 
		"ifPartIf", "ifPartElseif", "ifPartElse", "funcName", "methodName", "args", 
		"funcBody", "equalityOp", "relationalOp", "addOp", "multOp", "negationOp", 
		"tableEntry", "var", "literal", "booleanLiteral", "numericLiteral", "prefixPartFunctionCall", 
		"prefixPartMethodCall", "prefixPartTableAccess", "prefixPartDotAccess"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "';'", "'='", "':'", "'do'", "'end'", "'while'", "'repeat'", 
		"'until'", "'return'", "'break'", "'continue'", "'for'", "'in'", "'function'", 
		"'local'", "'or'", "'and'", "'|'", "'&'", "'..'", "'^'", "'('", "')'", 
		"'{'", "'}'", "'%'", "'...'", "'if'", "'then'", "'elseif'", "'else'", 
		"'.'", "'=='", "'~='", "'!='", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", 
		"'*'", "'/'", "'not'", "'['", "']'", "'nil'", "'true'", "'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "HEX_LITERAL", "INT_LITERAL", "FLOAT_LITERAL", "STRING_LITERAL", 
		"ESCAPE_LITERAL", "ID", "LINE_COMMENT", "LONG_COMMENT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SCLua.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SCLuaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public ChunkContext chunk() {
			return getRuleContext(ChunkContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SCLuaParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			chunk();
			setState(125);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SCLuaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SCLuaParser.ID, i);
		}
		public IdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterIdList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitIdList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitIdList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdListContext idList() throws RecognitionException {
		IdListContext _localctx = new IdListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_idList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(ID);
			setState(132);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(128);
					match(T__0);
					setState(129);
					match(ID);
					}
					} 
				}
				setState(134);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamListContext extends ParserRuleContext {
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public VarArgsExpressionContext varArgsExpression() {
			return getRuleContext(VarArgsExpressionContext.class,0);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_paramList);
		int _la;
		try {
			setState(141);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				idList();
				setState(138);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(136);
					match(T__0);
					setState(137);
					varArgsExpression();
					}
				}

				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				varArgsExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarListContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public VarListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterVarList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitVarList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitVarList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarListContext varList() throws RecognitionException {
		VarListContext _localctx = new VarListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			var();
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(144);
				match(T__0);
				setState(145);
				var();
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			expression();
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(152);
				match(T__0);
				setState(153);
				expression();
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChunkContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ChunkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chunk; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterChunk(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitChunk(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitChunk(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChunkContext chunk() throws RecognitionException {
		ChunkContext _localctx = new ChunkContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_chunk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__14) | (1L << T__15) | (1L << T__22) | (1L << T__28) | (1L << ID))) != 0)) {
				{
				{
				setState(159);
				statement();
				setState(161);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(160);
					match(T__1);
					}
				}

				}
				}
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public FunctionCallStatementContext functionCallStatement() {
			return getRuleContext(FunctionCallStatementContext.class,0);
		}
		public MethodCallStatementContext methodCallStatement() {
			return getRuleContext(MethodCallStatementContext.class,0);
		}
		public ExplicitBlockStatementContext explicitBlockStatement() {
			return getRuleContext(ExplicitBlockStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public RepeatUntilStatementContext repeatUntilStatement() {
			return getRuleContext(RepeatUntilStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public ForNumericStatementContext forNumericStatement() {
			return getRuleContext(ForNumericStatementContext.class,0);
		}
		public ForEachStatementContext forEachStatement() {
			return getRuleContext(ForEachStatementContext.class,0);
		}
		public FunctionDeclarationStatementContext functionDeclarationStatement() {
			return getRuleContext(FunctionDeclarationStatementContext.class,0);
		}
		public LocalFunctionDeclarationStatementContext localFunctionDeclarationStatement() {
			return getRuleContext(LocalFunctionDeclarationStatementContext.class,0);
		}
		public LocalVariableDeclarationStatementContext localVariableDeclarationStatement() {
			return getRuleContext(LocalVariableDeclarationStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		try {
			setState(183);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				assignmentStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				functionCallStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				methodCallStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(171);
				explicitBlockStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(172);
				whileStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(173);
				repeatUntilStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(174);
				ifStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(175);
				returnStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(176);
				breakStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(177);
				continueStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(178);
				forNumericStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(179);
				forEachStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(180);
				functionDeclarationStatement();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(181);
				localFunctionDeclarationStatement();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(182);
				localVariableDeclarationStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentStatementContext extends ParserRuleContext {
		public VarListContext varList() {
			return getRuleContext(VarListContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			varList();
			setState(186);
			match(T__2);
			setState(187);
			expressionList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallStatementContext extends ParserRuleContext {
		public PrefixExpContext prefixExp() {
			return getRuleContext(PrefixExpContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public FunctionCallStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterFunctionCallStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitFunctionCallStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitFunctionCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallStatementContext functionCallStatement() throws RecognitionException {
		FunctionCallStatementContext _localctx = new FunctionCallStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionCallStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			prefixExp(0);
			setState(190);
			args();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodCallStatementContext extends ParserRuleContext {
		public PrefixExpContext prefixExp() {
			return getRuleContext(PrefixExpContext.class,0);
		}
		public TerminalNode ID() { return getToken(SCLuaParser.ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public MethodCallStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCallStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterMethodCallStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitMethodCallStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitMethodCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallStatementContext methodCallStatement() throws RecognitionException {
		MethodCallStatementContext _localctx = new MethodCallStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_methodCallStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			prefixExp(0);
			setState(193);
			match(T__3);
			setState(194);
			match(ID);
			setState(195);
			args();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExplicitBlockStatementContext extends ParserRuleContext {
		public ChunkContext chunk() {
			return getRuleContext(ChunkContext.class,0);
		}
		public ExplicitBlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitBlockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterExplicitBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitExplicitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitExplicitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExplicitBlockStatementContext explicitBlockStatement() throws RecognitionException {
		ExplicitBlockStatementContext _localctx = new ExplicitBlockStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_explicitBlockStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(T__4);
			setState(198);
			chunk();
			setState(199);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ChunkContext chunk() {
			return getRuleContext(ChunkContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(T__6);
			setState(202);
			expression();
			setState(203);
			match(T__4);
			setState(204);
			chunk();
			setState(205);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepeatUntilStatementContext extends ParserRuleContext {
		public ChunkContext chunk() {
			return getRuleContext(ChunkContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RepeatUntilStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatUntilStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterRepeatUntilStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitRepeatUntilStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitRepeatUntilStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatUntilStatementContext repeatUntilStatement() throws RecognitionException {
		RepeatUntilStatementContext _localctx = new RepeatUntilStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_repeatUntilStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(T__7);
			setState(208);
			chunk();
			setState(209);
			match(T__8);
			setState(210);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public IfPartIfContext ifPartIf() {
			return getRuleContext(IfPartIfContext.class,0);
		}
		public List<IfPartElseifContext> ifPartElseif() {
			return getRuleContexts(IfPartElseifContext.class);
		}
		public IfPartElseifContext ifPartElseif(int i) {
			return getRuleContext(IfPartElseifContext.class,i);
		}
		public IfPartElseContext ifPartElse() {
			return getRuleContext(IfPartElseContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			ifPartIf();
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__30) {
				{
				{
				setState(213);
				ifPartElseif();
				}
				}
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(220);
			_la = _input.LA(1);
			if (_la==T__31) {
				{
				setState(219);
				ifPartElse();
				}
			}

			setState(222);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(T__9);
			setState(226);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(225);
				expressionList();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BreakStatementContext extends ParserRuleContext {
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContinueStatementContext extends ParserRuleContext {
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitContinueStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitContinueStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForNumericStatementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SCLuaParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ChunkContext chunk() {
			return getRuleContext(ChunkContext.class,0);
		}
		public ForNumericStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forNumericStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterForNumericStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitForNumericStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitForNumericStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForNumericStatementContext forNumericStatement() throws RecognitionException {
		ForNumericStatementContext _localctx = new ForNumericStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_forNumericStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(T__12);
			setState(233);
			match(ID);
			setState(234);
			match(T__2);
			setState(235);
			expression();
			setState(236);
			match(T__0);
			setState(237);
			expression();
			setState(240);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(238);
				match(T__0);
				setState(239);
				expression();
				}
			}

			setState(242);
			match(T__4);
			setState(243);
			chunk();
			setState(244);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForEachStatementContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SCLuaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SCLuaParser.ID, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ChunkContext chunk() {
			return getRuleContext(ChunkContext.class,0);
		}
		public ForEachStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forEachStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterForEachStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitForEachStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitForEachStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForEachStatementContext forEachStatement() throws RecognitionException {
		ForEachStatementContext _localctx = new ForEachStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_forEachStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(T__12);
			setState(247);
			match(ID);
			setState(250);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(248);
				match(T__0);
				setState(249);
				match(ID);
				}
			}

			setState(252);
			match(T__13);
			setState(253);
			expression();
			setState(254);
			match(T__4);
			setState(255);
			chunk();
			setState(256);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclarationStatementContext extends ParserRuleContext {
		public FuncNameContext funcName() {
			return getRuleContext(FuncNameContext.class,0);
		}
		public FuncBodyContext funcBody() {
			return getRuleContext(FuncBodyContext.class,0);
		}
		public FunctionDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterFunctionDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitFunctionDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitFunctionDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationStatementContext functionDeclarationStatement() throws RecognitionException {
		FunctionDeclarationStatementContext _localctx = new FunctionDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_functionDeclarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(T__14);
			setState(259);
			funcName();
			setState(260);
			funcBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalFunctionDeclarationStatementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SCLuaParser.ID, 0); }
		public FuncBodyContext funcBody() {
			return getRuleContext(FuncBodyContext.class,0);
		}
		public LocalFunctionDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localFunctionDeclarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterLocalFunctionDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitLocalFunctionDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitLocalFunctionDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalFunctionDeclarationStatementContext localFunctionDeclarationStatement() throws RecognitionException {
		LocalFunctionDeclarationStatementContext _localctx = new LocalFunctionDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_localFunctionDeclarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(T__15);
			setState(263);
			match(T__14);
			setState(264);
			match(ID);
			setState(265);
			funcBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVariableDeclarationStatementContext extends ParserRuleContext {
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public LocalVariableDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterLocalVariableDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitLocalVariableDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitLocalVariableDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationStatementContext localVariableDeclarationStatement() throws RecognitionException {
		LocalVariableDeclarationStatementContext _localctx = new LocalVariableDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_localVariableDeclarationStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(T__15);
			setState(268);
			idList();
			setState(271);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(269);
				match(T__2);
				setState(270);
				expressionList();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			orExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrExpressionContext extends ParserRuleContext {
		public List<AndExpressionContext> andExpression() {
			return getRuleContexts(AndExpressionContext.class);
		}
		public AndExpressionContext andExpression(int i) {
			return getRuleContext(AndExpressionContext.class,i);
		}
		public OrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExpressionContext orExpression() throws RecognitionException {
		OrExpressionContext _localctx = new OrExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_orExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			andExpression();
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16) {
				{
				{
				setState(276);
				match(T__16);
				setState(277);
				andExpression();
				}
				}
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndExpressionContext extends ParserRuleContext {
		public List<BitwiseOrExpressionContext> bitwiseOrExpression() {
			return getRuleContexts(BitwiseOrExpressionContext.class);
		}
		public BitwiseOrExpressionContext bitwiseOrExpression(int i) {
			return getRuleContext(BitwiseOrExpressionContext.class,i);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			bitwiseOrExpression();
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(284);
				match(T__17);
				setState(285);
				bitwiseOrExpression();
				}
				}
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BitwiseOrExpressionContext extends ParserRuleContext {
		public List<BitwiseAndExpressionContext> bitwiseAndExpression() {
			return getRuleContexts(BitwiseAndExpressionContext.class);
		}
		public BitwiseAndExpressionContext bitwiseAndExpression(int i) {
			return getRuleContext(BitwiseAndExpressionContext.class,i);
		}
		public BitwiseOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwiseOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterBitwiseOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitBitwiseOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitBitwiseOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BitwiseOrExpressionContext bitwiseOrExpression() throws RecognitionException {
		BitwiseOrExpressionContext _localctx = new BitwiseOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_bitwiseOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			bitwiseAndExpression();
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(292);
				match(T__18);
				setState(293);
				bitwiseAndExpression();
				}
				}
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BitwiseAndExpressionContext extends ParserRuleContext {
		public List<EqualityExpressionContext> equalityExpression() {
			return getRuleContexts(EqualityExpressionContext.class);
		}
		public EqualityExpressionContext equalityExpression(int i) {
			return getRuleContext(EqualityExpressionContext.class,i);
		}
		public BitwiseAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwiseAndExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterBitwiseAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitBitwiseAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitBitwiseAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BitwiseAndExpressionContext bitwiseAndExpression() throws RecognitionException {
		BitwiseAndExpressionContext _localctx = new BitwiseAndExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_bitwiseAndExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			equalityExpression();
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(300);
				match(T__19);
				setState(301);
				equalityExpression();
				}
				}
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualityExpressionContext extends ParserRuleContext {
		public List<RelationalExpressionContext> relationalExpression() {
			return getRuleContexts(RelationalExpressionContext.class);
		}
		public RelationalExpressionContext relationalExpression(int i) {
			return getRuleContext(RelationalExpressionContext.class,i);
		}
		public List<EqualityOpContext> equalityOp() {
			return getRuleContexts(EqualityOpContext.class);
		}
		public EqualityOpContext equalityOp(int i) {
			return getRuleContext(EqualityOpContext.class,i);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			relationalExpression();
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) {
				{
				{
				setState(308);
				equalityOp();
				setState(309);
				relationalExpression();
				}
				}
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalExpressionContext extends ParserRuleContext {
		public List<ConcatExpressionContext> concatExpression() {
			return getRuleContexts(ConcatExpressionContext.class);
		}
		public ConcatExpressionContext concatExpression(int i) {
			return getRuleContext(ConcatExpressionContext.class,i);
		}
		public List<RelationalOpContext> relationalOp() {
			return getRuleContexts(RelationalOpContext.class);
		}
		public RelationalOpContext relationalOp(int i) {
			return getRuleContext(RelationalOpContext.class,i);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitRelationalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitRelationalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_relationalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			concatExpression();
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) {
				{
				{
				setState(317);
				relationalOp();
				setState(318);
				concatExpression();
				}
				}
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConcatExpressionContext extends ParserRuleContext {
		public List<AddExpressionContext> addExpression() {
			return getRuleContexts(AddExpressionContext.class);
		}
		public AddExpressionContext addExpression(int i) {
			return getRuleContext(AddExpressionContext.class,i);
		}
		public ConcatExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concatExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterConcatExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitConcatExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitConcatExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConcatExpressionContext concatExpression() throws RecognitionException {
		ConcatExpressionContext _localctx = new ConcatExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_concatExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			addExpression();
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(326);
				match(T__20);
				setState(327);
				addExpression();
				}
				}
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddExpressionContext extends ParserRuleContext {
		public List<MultExpressionContext> multExpression() {
			return getRuleContexts(MultExpressionContext.class);
		}
		public MultExpressionContext multExpression(int i) {
			return getRuleContext(MultExpressionContext.class,i);
		}
		public List<AddOpContext> addOp() {
			return getRuleContexts(AddOpContext.class);
		}
		public AddOpContext addOp(int i) {
			return getRuleContext(AddOpContext.class,i);
		}
		public AddExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterAddExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitAddExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitAddExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddExpressionContext addExpression() throws RecognitionException {
		AddExpressionContext _localctx = new AddExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_addExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			multExpression();
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__40 || _la==T__41) {
				{
				{
				setState(334);
				addOp();
				setState(335);
				multExpression();
				}
				}
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultExpressionContext extends ParserRuleContext {
		public List<NegationExpressionContext> negationExpression() {
			return getRuleContexts(NegationExpressionContext.class);
		}
		public NegationExpressionContext negationExpression(int i) {
			return getRuleContext(NegationExpressionContext.class,i);
		}
		public List<MultOpContext> multOp() {
			return getRuleContexts(MultOpContext.class);
		}
		public MultOpContext multOp(int i) {
			return getRuleContext(MultOpContext.class,i);
		}
		public MultExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterMultExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitMultExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitMultExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultExpressionContext multExpression() throws RecognitionException {
		MultExpressionContext _localctx = new MultExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_multExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			negationExpression();
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__42) | (1L << T__43))) != 0)) {
				{
				{
				setState(343);
				multOp();
				setState(344);
				negationExpression();
				}
				}
				setState(350);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NegationExpressionContext extends ParserRuleContext {
		public NegationOpContext negationOp() {
			return getRuleContext(NegationOpContext.class,0);
		}
		public NegationExpressionContext negationExpression() {
			return getRuleContext(NegationExpressionContext.class,0);
		}
		public PowerExpressionContext powerExpression() {
			return getRuleContext(PowerExpressionContext.class,0);
		}
		public NegationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negationExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterNegationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitNegationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitNegationExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegationExpressionContext negationExpression() throws RecognitionException {
		NegationExpressionContext _localctx = new NegationExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_negationExpression);
		try {
			setState(355);
			switch (_input.LA(1)) {
			case T__41:
			case T__44:
				enterOuterAlt(_localctx, 1);
				{
				setState(351);
				negationOp();
				setState(352);
				negationExpression();
				}
				break;
			case T__14:
			case T__22:
			case T__24:
			case T__26:
			case T__27:
			case T__47:
			case T__48:
			case T__49:
			case HEX_LITERAL:
			case INT_LITERAL:
			case FLOAT_LITERAL:
			case STRING_LITERAL:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(354);
				powerExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PowerExpressionContext extends ParserRuleContext {
		public List<PrimaryExpressionContext> primaryExpression() {
			return getRuleContexts(PrimaryExpressionContext.class);
		}
		public PrimaryExpressionContext primaryExpression(int i) {
			return getRuleContext(PrimaryExpressionContext.class,i);
		}
		public PowerExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_powerExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterPowerExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitPowerExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitPowerExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PowerExpressionContext powerExpression() throws RecognitionException {
		PowerExpressionContext _localctx = new PowerExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_powerExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			primaryExpression();
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(358);
				match(T__21);
				setState(359);
				primaryExpression();
				}
				}
				setState(364);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public PrefixExpContext prefixExp() {
			return getRuleContext(PrefixExpContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public FunctionDeclExpressionContext functionDeclExpression() {
			return getRuleContext(FunctionDeclExpressionContext.class,0);
		}
		public TableConstructorContext tableConstructor() {
			return getRuleContext(TableConstructorContext.class,0);
		}
		public UpValueContext upValue() {
			return getRuleContext(UpValueContext.class,0);
		}
		public VarArgsExpressionContext varArgsExpression() {
			return getRuleContext(VarArgsExpressionContext.class,0);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitPrimaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitPrimaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_primaryExpression);
		try {
			setState(371);
			switch (_input.LA(1)) {
			case T__22:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(365);
				prefixExp(0);
				}
				break;
			case T__47:
			case T__48:
			case T__49:
			case HEX_LITERAL:
			case INT_LITERAL:
			case FLOAT_LITERAL:
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(366);
				literal();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(367);
				functionDeclExpression();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 4);
				{
				setState(368);
				tableConstructor();
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 5);
				{
				setState(369);
				upValue();
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 6);
				{
				setState(370);
				varArgsExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixExpContext extends ParserRuleContext {
		public ParentheticalExpressionContext parentheticalExpression() {
			return getRuleContext(ParentheticalExpressionContext.class,0);
		}
		public TerminalNode ID() { return getToken(SCLuaParser.ID, 0); }
		public PrefixExpContext prefixExp() {
			return getRuleContext(PrefixExpContext.class,0);
		}
		public PrefixPartFunctionCallContext prefixPartFunctionCall() {
			return getRuleContext(PrefixPartFunctionCallContext.class,0);
		}
		public PrefixPartMethodCallContext prefixPartMethodCall() {
			return getRuleContext(PrefixPartMethodCallContext.class,0);
		}
		public PrefixPartTableAccessContext prefixPartTableAccess() {
			return getRuleContext(PrefixPartTableAccessContext.class,0);
		}
		public PrefixPartDotAccessContext prefixPartDotAccess() {
			return getRuleContext(PrefixPartDotAccessContext.class,0);
		}
		public PrefixExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterPrefixExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitPrefixExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitPrefixExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixExpContext prefixExp() throws RecognitionException {
		return prefixExp(0);
	}

	private PrefixExpContext prefixExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrefixExpContext _localctx = new PrefixExpContext(_ctx, _parentState);
		PrefixExpContext _prevctx = _localctx;
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_prefixExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			switch (_input.LA(1)) {
			case T__22:
				{
				setState(374);
				parentheticalExpression();
				}
				break;
			case ID:
				{
				setState(375);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(387);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PrefixExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_prefixExp);
					setState(378);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(383);
					switch (_input.LA(1)) {
					case T__22:
					case T__24:
					case STRING_LITERAL:
						{
						setState(379);
						prefixPartFunctionCall();
						}
						break;
					case T__3:
						{
						setState(380);
						prefixPartMethodCall();
						}
						break;
					case T__45:
						{
						setState(381);
						prefixPartTableAccess();
						}
						break;
					case T__32:
						{
						setState(382);
						prefixPartDotAccess();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(389);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParentheticalExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParentheticalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parentheticalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterParentheticalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitParentheticalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitParentheticalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParentheticalExpressionContext parentheticalExpression() throws RecognitionException {
		ParentheticalExpressionContext _localctx = new ParentheticalExpressionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_parentheticalExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			match(T__22);
			setState(391);
			expression();
			setState(392);
			match(T__23);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclExpressionContext extends ParserRuleContext {
		public FuncBodyContext funcBody() {
			return getRuleContext(FuncBodyContext.class,0);
		}
		public FunctionDeclExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterFunctionDeclExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitFunctionDeclExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitFunctionDeclExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclExpressionContext functionDeclExpression() throws RecognitionException {
		FunctionDeclExpressionContext _localctx = new FunctionDeclExpressionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_functionDeclExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			match(T__14);
			setState(395);
			funcBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableConstructorContext extends ParserRuleContext {
		public List<TableEntryContext> tableEntry() {
			return getRuleContexts(TableEntryContext.class);
		}
		public TableEntryContext tableEntry(int i) {
			return getRuleContext(TableEntryContext.class,i);
		}
		public TableConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableConstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterTableConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitTableConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitTableConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableConstructorContext tableConstructor() throws RecognitionException {
		TableConstructorContext _localctx = new TableConstructorContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_tableConstructor);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			match(T__24);
			setState(409);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__22) | (1L << T__24) | (1L << T__26) | (1L << T__27) | (1L << T__41) | (1L << T__44) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << HEX_LITERAL) | (1L << INT_LITERAL) | (1L << FLOAT_LITERAL) | (1L << STRING_LITERAL) | (1L << ID))) != 0)) {
				{
				setState(398);
				tableEntry();
				setState(403);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(399);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==T__1) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(400);
						tableEntry();
						}
						} 
					}
					setState(405);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				}
				setState(407);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(406);
					match(T__0);
					}
				}

				}
			}

			setState(411);
			match(T__25);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpValueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SCLuaParser.ID, 0); }
		public UpValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_upValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterUpValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitUpValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitUpValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpValueContext upValue() throws RecognitionException {
		UpValueContext _localctx = new UpValueContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_upValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			match(T__26);
			setState(414);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarArgsExpressionContext extends ParserRuleContext {
		public VarArgsExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varArgsExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterVarArgsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitVarArgsExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitVarArgsExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarArgsExpressionContext varArgsExpression() throws RecognitionException {
		VarArgsExpressionContext _localctx = new VarArgsExpressionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_varArgsExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			match(T__27);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfPartIfContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ChunkContext chunk() {
			return getRuleContext(ChunkContext.class,0);
		}
		public IfPartIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifPartIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterIfPartIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitIfPartIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitIfPartIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfPartIfContext ifPartIf() throws RecognitionException {
		IfPartIfContext _localctx = new IfPartIfContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_ifPartIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			match(T__28);
			setState(419);
			expression();
			setState(420);
			match(T__29);
			setState(421);
			chunk();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfPartElseifContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ChunkContext chunk() {
			return getRuleContext(ChunkContext.class,0);
		}
		public IfPartElseifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifPartElseif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterIfPartElseif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitIfPartElseif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitIfPartElseif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfPartElseifContext ifPartElseif() throws RecognitionException {
		IfPartElseifContext _localctx = new IfPartElseifContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_ifPartElseif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			match(T__30);
			setState(424);
			expression();
			setState(425);
			match(T__29);
			setState(426);
			chunk();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfPartElseContext extends ParserRuleContext {
		public ChunkContext chunk() {
			return getRuleContext(ChunkContext.class,0);
		}
		public IfPartElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifPartElse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterIfPartElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitIfPartElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitIfPartElse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfPartElseContext ifPartElse() throws RecognitionException {
		IfPartElseContext _localctx = new IfPartElseContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_ifPartElse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			match(T__31);
			setState(429);
			chunk();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncNameContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SCLuaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SCLuaParser.ID, i);
		}
		public MethodNameContext methodName() {
			return getRuleContext(MethodNameContext.class,0);
		}
		public FuncNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterFuncName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitFuncName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitFuncName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncNameContext funcName() throws RecognitionException {
		FuncNameContext _localctx = new FuncNameContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_funcName);
		try {
			setState(436);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(431);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(432);
				match(ID);
				setState(433);
				match(T__32);
				setState(434);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(435);
				methodName();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodNameContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SCLuaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SCLuaParser.ID, i);
		}
		public MethodNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterMethodName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitMethodName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitMethodName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodNameContext methodName() throws RecognitionException {
		MethodNameContext _localctx = new MethodNameContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_methodName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			match(ID);
			setState(439);
			match(T__3);
			setState(440);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TableConstructorContext tableConstructor() {
			return getRuleContext(TableConstructorContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(SCLuaParser.STRING_LITERAL, 0); }
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_args);
		int _la;
		try {
			setState(449);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(442);
				match(T__22);
				setState(444);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__22) | (1L << T__24) | (1L << T__26) | (1L << T__27) | (1L << T__41) | (1L << T__44) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << HEX_LITERAL) | (1L << INT_LITERAL) | (1L << FLOAT_LITERAL) | (1L << STRING_LITERAL) | (1L << ID))) != 0)) {
					{
					setState(443);
					expressionList();
					}
				}

				setState(446);
				match(T__23);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(447);
				tableConstructor();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(448);
				match(STRING_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncBodyContext extends ParserRuleContext {
		public ChunkContext chunk() {
			return getRuleContext(ChunkContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public FuncBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterFuncBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitFuncBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitFuncBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncBodyContext funcBody() throws RecognitionException {
		FuncBodyContext _localctx = new FuncBodyContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_funcBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			match(T__22);
			setState(453);
			_la = _input.LA(1);
			if (_la==T__27 || _la==ID) {
				{
				setState(452);
				paramList();
				}
			}

			setState(455);
			match(T__23);
			setState(456);
			chunk();
			setState(457);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualityOpContext extends ParserRuleContext {
		public EqualityOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterEqualityOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitEqualityOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitEqualityOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityOpContext equalityOp() throws RecognitionException {
		EqualityOpContext _localctx = new EqualityOpContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_equalityOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalOpContext extends ParserRuleContext {
		public RelationalOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterRelationalOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitRelationalOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitRelationalOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalOpContext relationalOp() throws RecognitionException {
		RelationalOpContext _localctx = new RelationalOpContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_relationalOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddOpContext extends ParserRuleContext {
		public AddOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterAddOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitAddOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitAddOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			_la = _input.LA(1);
			if ( !(_la==T__40 || _la==T__41) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultOpContext extends ParserRuleContext {
		public MultOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterMultOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitMultOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitMultOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultOpContext multOp() throws RecognitionException {
		MultOpContext _localctx = new MultOpContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_multOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__42) | (1L << T__43))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NegationOpContext extends ParserRuleContext {
		public NegationOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negationOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterNegationOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitNegationOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitNegationOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegationOpContext negationOp() throws RecognitionException {
		NegationOpContext _localctx = new NegationOpContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_negationOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			_la = _input.LA(1);
			if ( !(_la==T__41 || _la==T__44) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableEntryContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ID() { return getToken(SCLuaParser.ID, 0); }
		public TableEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableEntry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterTableEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitTableEntry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitTableEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableEntryContext tableEntry() throws RecognitionException {
		TableEntryContext _localctx = new TableEntryContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_tableEntry);
		try {
			setState(479);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(469);
				match(T__45);
				setState(470);
				expression();
				setState(471);
				match(T__46);
				setState(472);
				match(T__2);
				setState(473);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(475);
				match(ID);
				setState(476);
				match(T__2);
				setState(477);
				expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(478);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public PrefixExpContext prefixExp() {
			return getRuleContext(PrefixExpContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ID() { return getToken(SCLuaParser.ID, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_var);
		try {
			setState(491);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(481);
				prefixExp(0);
				setState(482);
				match(T__45);
				setState(483);
				expression();
				setState(484);
				match(T__46);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(486);
				prefixExp(0);
				setState(487);
				match(T__32);
				setState(488);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(490);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public NumericLiteralContext numericLiteral() {
			return getRuleContext(NumericLiteralContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(SCLuaParser.STRING_LITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_literal);
		try {
			setState(497);
			switch (_input.LA(1)) {
			case T__48:
			case T__49:
				enterOuterAlt(_localctx, 1);
				{
				setState(493);
				booleanLiteral();
				}
				break;
			case HEX_LITERAL:
			case INT_LITERAL:
			case FLOAT_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(494);
				numericLiteral();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(495);
				match(STRING_LITERAL);
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 4);
				{
				setState(496);
				match(T__47);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanLiteralContext extends ParserRuleContext {
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			_la = _input.LA(1);
			if ( !(_la==T__48 || _la==T__49) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericLiteralContext extends ParserRuleContext {
		public TerminalNode HEX_LITERAL() { return getToken(SCLuaParser.HEX_LITERAL, 0); }
		public TerminalNode INT_LITERAL() { return getToken(SCLuaParser.INT_LITERAL, 0); }
		public TerminalNode FLOAT_LITERAL() { return getToken(SCLuaParser.FLOAT_LITERAL, 0); }
		public NumericLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterNumericLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitNumericLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitNumericLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericLiteralContext numericLiteral() throws RecognitionException {
		NumericLiteralContext _localctx = new NumericLiteralContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_numericLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HEX_LITERAL) | (1L << INT_LITERAL) | (1L << FLOAT_LITERAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixPartFunctionCallContext extends ParserRuleContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public PrefixPartFunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixPartFunctionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterPrefixPartFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitPrefixPartFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitPrefixPartFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixPartFunctionCallContext prefixPartFunctionCall() throws RecognitionException {
		PrefixPartFunctionCallContext _localctx = new PrefixPartFunctionCallContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_prefixPartFunctionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			args();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixPartMethodCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SCLuaParser.ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public PrefixPartMethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixPartMethodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterPrefixPartMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitPrefixPartMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitPrefixPartMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixPartMethodCallContext prefixPartMethodCall() throws RecognitionException {
		PrefixPartMethodCallContext _localctx = new PrefixPartMethodCallContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_prefixPartMethodCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			match(T__3);
			setState(506);
			match(ID);
			setState(507);
			args();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixPartTableAccessContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrefixPartTableAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixPartTableAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterPrefixPartTableAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitPrefixPartTableAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitPrefixPartTableAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixPartTableAccessContext prefixPartTableAccess() throws RecognitionException {
		PrefixPartTableAccessContext _localctx = new PrefixPartTableAccessContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_prefixPartTableAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			match(T__45);
			setState(510);
			expression();
			setState(511);
			match(T__46);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixPartDotAccessContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SCLuaParser.ID, 0); }
		public PrefixPartDotAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixPartDotAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterPrefixPartDotAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitPrefixPartDotAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitPrefixPartDotAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixPartDotAccessContext prefixPartDotAccess() throws RecognitionException {
		PrefixPartDotAccessContext _localctx = new PrefixPartDotAccessContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_prefixPartDotAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			match(T__32);
			setState(514);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 35:
			return prefixExp_sempred((PrefixExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean prefixExp_sempred(PrefixExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3=\u0207\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\3\2\3\2\3\2\3\3\3\3\3\3\7\3\u0085\n\3\f\3\16\3\u0088\13\3"+
		"\3\4\3\4\3\4\5\4\u008d\n\4\3\4\5\4\u0090\n\4\3\5\3\5\3\5\7\5\u0095\n\5"+
		"\f\5\16\5\u0098\13\5\3\6\3\6\3\6\7\6\u009d\n\6\f\6\16\6\u00a0\13\6\3\7"+
		"\3\7\5\7\u00a4\n\7\7\7\u00a6\n\7\f\7\16\7\u00a9\13\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00ba\n\b\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\7\17\u00d9\n\17\f\17\16"+
		"\17\u00dc\13\17\3\17\5\17\u00df\n\17\3\17\3\17\3\20\3\20\5\20\u00e5\n"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00f3"+
		"\n\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u00fd\n\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\5\27\u0112\n\27\3\30\3\30\3\31\3\31\3\31\7\31\u0119\n"+
		"\31\f\31\16\31\u011c\13\31\3\32\3\32\3\32\7\32\u0121\n\32\f\32\16\32\u0124"+
		"\13\32\3\33\3\33\3\33\7\33\u0129\n\33\f\33\16\33\u012c\13\33\3\34\3\34"+
		"\3\34\7\34\u0131\n\34\f\34\16\34\u0134\13\34\3\35\3\35\3\35\3\35\7\35"+
		"\u013a\n\35\f\35\16\35\u013d\13\35\3\36\3\36\3\36\3\36\7\36\u0143\n\36"+
		"\f\36\16\36\u0146\13\36\3\37\3\37\3\37\7\37\u014b\n\37\f\37\16\37\u014e"+
		"\13\37\3 \3 \3 \3 \7 \u0154\n \f \16 \u0157\13 \3!\3!\3!\3!\7!\u015d\n"+
		"!\f!\16!\u0160\13!\3\"\3\"\3\"\3\"\5\"\u0166\n\"\3#\3#\3#\7#\u016b\n#"+
		"\f#\16#\u016e\13#\3$\3$\3$\3$\3$\3$\5$\u0176\n$\3%\3%\3%\5%\u017b\n%\3"+
		"%\3%\3%\3%\3%\5%\u0182\n%\7%\u0184\n%\f%\16%\u0187\13%\3&\3&\3&\3&\3\'"+
		"\3\'\3\'\3(\3(\3(\3(\7(\u0194\n(\f(\16(\u0197\13(\3(\5(\u019a\n(\5(\u019c"+
		"\n(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3.\3."+
		"\3.\3.\3.\5.\u01b7\n.\3/\3/\3/\3/\3\60\3\60\5\60\u01bf\n\60\3\60\3\60"+
		"\3\60\5\60\u01c4\n\60\3\61\3\61\5\61\u01c8\n\61\3\61\3\61\3\61\3\61\3"+
		"\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\3\67\3\67\3"+
		"\67\3\67\3\67\3\67\3\67\3\67\5\67\u01e2\n\67\38\38\38\38\38\38\38\38\3"+
		"8\38\58\u01ee\n8\39\39\39\39\59\u01f4\n9\3:\3:\3;\3;\3<\3<\3=\3=\3=\3"+
		"=\3>\3>\3>\3>\3?\3?\3?\3?\2\3H@\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|\2\n\3\2\3\4"+
		"\3\2$&\3\2\'*\3\2+,\4\2\35\35-.\4\2,,//\3\2\63\64\3\2\65\67\u0208\2~\3"+
		"\2\2\2\4\u0081\3\2\2\2\6\u008f\3\2\2\2\b\u0091\3\2\2\2\n\u0099\3\2\2\2"+
		"\f\u00a7\3\2\2\2\16\u00b9\3\2\2\2\20\u00bb\3\2\2\2\22\u00bf\3\2\2\2\24"+
		"\u00c2\3\2\2\2\26\u00c7\3\2\2\2\30\u00cb\3\2\2\2\32\u00d1\3\2\2\2\34\u00d6"+
		"\3\2\2\2\36\u00e2\3\2\2\2 \u00e6\3\2\2\2\"\u00e8\3\2\2\2$\u00ea\3\2\2"+
		"\2&\u00f8\3\2\2\2(\u0104\3\2\2\2*\u0108\3\2\2\2,\u010d\3\2\2\2.\u0113"+
		"\3\2\2\2\60\u0115\3\2\2\2\62\u011d\3\2\2\2\64\u0125\3\2\2\2\66\u012d\3"+
		"\2\2\28\u0135\3\2\2\2:\u013e\3\2\2\2<\u0147\3\2\2\2>\u014f\3\2\2\2@\u0158"+
		"\3\2\2\2B\u0165\3\2\2\2D\u0167\3\2\2\2F\u0175\3\2\2\2H\u017a\3\2\2\2J"+
		"\u0188\3\2\2\2L\u018c\3\2\2\2N\u018f\3\2\2\2P\u019f\3\2\2\2R\u01a2\3\2"+
		"\2\2T\u01a4\3\2\2\2V\u01a9\3\2\2\2X\u01ae\3\2\2\2Z\u01b6\3\2\2\2\\\u01b8"+
		"\3\2\2\2^\u01c3\3\2\2\2`\u01c5\3\2\2\2b\u01cd\3\2\2\2d\u01cf\3\2\2\2f"+
		"\u01d1\3\2\2\2h\u01d3\3\2\2\2j\u01d5\3\2\2\2l\u01e1\3\2\2\2n\u01ed\3\2"+
		"\2\2p\u01f3\3\2\2\2r\u01f5\3\2\2\2t\u01f7\3\2\2\2v\u01f9\3\2\2\2x\u01fb"+
		"\3\2\2\2z\u01ff\3\2\2\2|\u0203\3\2\2\2~\177\5\f\7\2\177\u0080\7\2\2\3"+
		"\u0080\3\3\2\2\2\u0081\u0086\7:\2\2\u0082\u0083\7\3\2\2\u0083\u0085\7"+
		":\2\2\u0084\u0082\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\5\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008c\5\4\3\2"+
		"\u008a\u008b\7\3\2\2\u008b\u008d\5R*\2\u008c\u008a\3\2\2\2\u008c\u008d"+
		"\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u0090\5R*\2\u008f\u0089\3\2\2\2\u008f"+
		"\u008e\3\2\2\2\u0090\7\3\2\2\2\u0091\u0096\5n8\2\u0092\u0093\7\3\2\2\u0093"+
		"\u0095\5n8\2\u0094\u0092\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2"+
		"\2\u0096\u0097\3\2\2\2\u0097\t\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009e"+
		"\5.\30\2\u009a\u009b\7\3\2\2\u009b\u009d\5.\30\2\u009c\u009a\3\2\2\2\u009d"+
		"\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\13\3\2\2"+
		"\2\u00a0\u009e\3\2\2\2\u00a1\u00a3\5\16\b\2\u00a2\u00a4\7\4\2\2\u00a3"+
		"\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a1\3\2"+
		"\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\r\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ba\5\20\t\2\u00ab\u00ba\5\22\n"+
		"\2\u00ac\u00ba\5\24\13\2\u00ad\u00ba\5\26\f\2\u00ae\u00ba\5\30\r\2\u00af"+
		"\u00ba\5\32\16\2\u00b0\u00ba\5\34\17\2\u00b1\u00ba\5\36\20\2\u00b2\u00ba"+
		"\5 \21\2\u00b3\u00ba\5\"\22\2\u00b4\u00ba\5$\23\2\u00b5\u00ba\5&\24\2"+
		"\u00b6\u00ba\5(\25\2\u00b7\u00ba\5*\26\2\u00b8\u00ba\5,\27\2\u00b9\u00aa"+
		"\3\2\2\2\u00b9\u00ab\3\2\2\2\u00b9\u00ac\3\2\2\2\u00b9\u00ad\3\2\2\2\u00b9"+
		"\u00ae\3\2\2\2\u00b9\u00af\3\2\2\2\u00b9\u00b0\3\2\2\2\u00b9\u00b1\3\2"+
		"\2\2\u00b9\u00b2\3\2\2\2\u00b9\u00b3\3\2\2\2\u00b9\u00b4\3\2\2\2\u00b9"+
		"\u00b5\3\2\2\2\u00b9\u00b6\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00b8\3\2"+
		"\2\2\u00ba\17\3\2\2\2\u00bb\u00bc\5\b\5\2\u00bc\u00bd\7\5\2\2\u00bd\u00be"+
		"\5\n\6\2\u00be\21\3\2\2\2\u00bf\u00c0\5H%\2\u00c0\u00c1\5^\60\2\u00c1"+
		"\23\3\2\2\2\u00c2\u00c3\5H%\2\u00c3\u00c4\7\6\2\2\u00c4\u00c5\7:\2\2\u00c5"+
		"\u00c6\5^\60\2\u00c6\25\3\2\2\2\u00c7\u00c8\7\7\2\2\u00c8\u00c9\5\f\7"+
		"\2\u00c9\u00ca\7\b\2\2\u00ca\27\3\2\2\2\u00cb\u00cc\7\t\2\2\u00cc\u00cd"+
		"\5.\30\2\u00cd\u00ce\7\7\2\2\u00ce\u00cf\5\f\7\2\u00cf\u00d0\7\b\2\2\u00d0"+
		"\31\3\2\2\2\u00d1\u00d2\7\n\2\2\u00d2\u00d3\5\f\7\2\u00d3\u00d4\7\13\2"+
		"\2\u00d4\u00d5\5.\30\2\u00d5\33\3\2\2\2\u00d6\u00da\5T+\2\u00d7\u00d9"+
		"\5V,\2\u00d8\u00d7\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00df\5X"+
		"-\2\u00de\u00dd\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\u00e1\7\b\2\2\u00e1\35\3\2\2\2\u00e2\u00e4\7\f\2\2\u00e3\u00e5\5\n\6"+
		"\2\u00e4\u00e3\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\37\3\2\2\2\u00e6\u00e7"+
		"\7\r\2\2\u00e7!\3\2\2\2\u00e8\u00e9\7\16\2\2\u00e9#\3\2\2\2\u00ea\u00eb"+
		"\7\17\2\2\u00eb\u00ec\7:\2\2\u00ec\u00ed\7\5\2\2\u00ed\u00ee\5.\30\2\u00ee"+
		"\u00ef\7\3\2\2\u00ef\u00f2\5.\30\2\u00f0\u00f1\7\3\2\2\u00f1\u00f3\5."+
		"\30\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00f5\7\7\2\2\u00f5\u00f6\5\f\7\2\u00f6\u00f7\7\b\2\2\u00f7%\3\2\2\2"+
		"\u00f8\u00f9\7\17\2\2\u00f9\u00fc\7:\2\2\u00fa\u00fb\7\3\2\2\u00fb\u00fd"+
		"\7:\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe"+
		"\u00ff\7\20\2\2\u00ff\u0100\5.\30\2\u0100\u0101\7\7\2\2\u0101\u0102\5"+
		"\f\7\2\u0102\u0103\7\b\2\2\u0103\'\3\2\2\2\u0104\u0105\7\21\2\2\u0105"+
		"\u0106\5Z.\2\u0106\u0107\5`\61\2\u0107)\3\2\2\2\u0108\u0109\7\22\2\2\u0109"+
		"\u010a\7\21\2\2\u010a\u010b\7:\2\2\u010b\u010c\5`\61\2\u010c+\3\2\2\2"+
		"\u010d\u010e\7\22\2\2\u010e\u0111\5\4\3\2\u010f\u0110\7\5\2\2\u0110\u0112"+
		"\5\n\6\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112-\3\2\2\2\u0113"+
		"\u0114\5\60\31\2\u0114/\3\2\2\2\u0115\u011a\5\62\32\2\u0116\u0117\7\23"+
		"\2\2\u0117\u0119\5\62\32\2\u0118\u0116\3\2\2\2\u0119\u011c\3\2\2\2\u011a"+
		"\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\61\3\2\2\2\u011c\u011a\3\2\2"+
		"\2\u011d\u0122\5\64\33\2\u011e\u011f\7\24\2\2\u011f\u0121\5\64\33\2\u0120"+
		"\u011e\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2"+
		"\2\2\u0123\63\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u012a\5\66\34\2\u0126"+
		"\u0127\7\25\2\2\u0127\u0129\5\66\34\2\u0128\u0126\3\2\2\2\u0129\u012c"+
		"\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\65\3\2\2\2\u012c"+
		"\u012a\3\2\2\2\u012d\u0132\58\35\2\u012e\u012f\7\26\2\2\u012f\u0131\5"+
		"8\35\2\u0130\u012e\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132"+
		"\u0133\3\2\2\2\u0133\67\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u013b\5:\36"+
		"\2\u0136\u0137\5b\62\2\u0137\u0138\5:\36\2\u0138\u013a\3\2\2\2\u0139\u0136"+
		"\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c"+
		"9\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u0144\5<\37\2\u013f\u0140\5d\63\2"+
		"\u0140\u0141\5<\37\2\u0141\u0143\3\2\2\2\u0142\u013f\3\2\2\2\u0143\u0146"+
		"\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145;\3\2\2\2\u0146"+
		"\u0144\3\2\2\2\u0147\u014c\5> \2\u0148\u0149\7\27\2\2\u0149\u014b\5> "+
		"\2\u014a\u0148\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d"+
		"\3\2\2\2\u014d=\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0155\5@!\2\u0150\u0151"+
		"\5f\64\2\u0151\u0152\5@!\2\u0152\u0154\3\2\2\2\u0153\u0150\3\2\2\2\u0154"+
		"\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156?\3\2\2\2"+
		"\u0157\u0155\3\2\2\2\u0158\u015e\5B\"\2\u0159\u015a\5h\65\2\u015a\u015b"+
		"\5B\"\2\u015b\u015d\3\2\2\2\u015c\u0159\3\2\2\2\u015d\u0160\3\2\2\2\u015e"+
		"\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015fA\3\2\2\2\u0160\u015e\3\2\2\2"+
		"\u0161\u0162\5j\66\2\u0162\u0163\5B\"\2\u0163\u0166\3\2\2\2\u0164\u0166"+
		"\5D#\2\u0165\u0161\3\2\2\2\u0165\u0164\3\2\2\2\u0166C\3\2\2\2\u0167\u016c"+
		"\5F$\2\u0168\u0169\7\30\2\2\u0169\u016b\5F$\2\u016a\u0168\3\2\2\2\u016b"+
		"\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016dE\3\2\2\2"+
		"\u016e\u016c\3\2\2\2\u016f\u0176\5H%\2\u0170\u0176\5p9\2\u0171\u0176\5"+
		"L\'\2\u0172\u0176\5N(\2\u0173\u0176\5P)\2\u0174\u0176\5R*\2\u0175\u016f"+
		"\3\2\2\2\u0175\u0170\3\2\2\2\u0175\u0171\3\2\2\2\u0175\u0172\3\2\2\2\u0175"+
		"\u0173\3\2\2\2\u0175\u0174\3\2\2\2\u0176G\3\2\2\2\u0177\u0178\b%\1\2\u0178"+
		"\u017b\5J&\2\u0179\u017b\7:\2\2\u017a\u0177\3\2\2\2\u017a\u0179\3\2\2"+
		"\2\u017b\u0185\3\2\2\2\u017c\u0181\f\5\2\2\u017d\u0182\5v<\2\u017e\u0182"+
		"\5x=\2\u017f\u0182\5z>\2\u0180\u0182\5|?\2\u0181\u017d\3\2\2\2\u0181\u017e"+
		"\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0180\3\2\2\2\u0182\u0184\3\2\2\2\u0183"+
		"\u017c\3\2\2\2\u0184\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2"+
		"\2\2\u0186I\3\2\2\2\u0187\u0185\3\2\2\2\u0188\u0189\7\31\2\2\u0189\u018a"+
		"\5.\30\2\u018a\u018b\7\32\2\2\u018bK\3\2\2\2\u018c\u018d\7\21\2\2\u018d"+
		"\u018e\5`\61\2\u018eM\3\2\2\2\u018f\u019b\7\33\2\2\u0190\u0195\5l\67\2"+
		"\u0191\u0192\t\2\2\2\u0192\u0194\5l\67\2\u0193\u0191\3\2\2\2\u0194\u0197"+
		"\3\2\2\2\u0195\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0199\3\2\2\2\u0197"+
		"\u0195\3\2\2\2\u0198\u019a\7\3\2\2\u0199\u0198\3\2\2\2\u0199\u019a\3\2"+
		"\2\2\u019a\u019c\3\2\2\2\u019b\u0190\3\2\2\2\u019b\u019c\3\2\2\2\u019c"+
		"\u019d\3\2\2\2\u019d\u019e\7\34\2\2\u019eO\3\2\2\2\u019f\u01a0\7\35\2"+
		"\2\u01a0\u01a1\7:\2\2\u01a1Q\3\2\2\2\u01a2\u01a3\7\36\2\2\u01a3S\3\2\2"+
		"\2\u01a4\u01a5\7\37\2\2\u01a5\u01a6\5.\30\2\u01a6\u01a7\7 \2\2\u01a7\u01a8"+
		"\5\f\7\2\u01a8U\3\2\2\2\u01a9\u01aa\7!\2\2\u01aa\u01ab\5.\30\2\u01ab\u01ac"+
		"\7 \2\2\u01ac\u01ad\5\f\7\2\u01adW\3\2\2\2\u01ae\u01af\7\"\2\2\u01af\u01b0"+
		"\5\f\7\2\u01b0Y\3\2\2\2\u01b1\u01b7\7:\2\2\u01b2\u01b3\7:\2\2\u01b3\u01b4"+
		"\7#\2\2\u01b4\u01b7\7:\2\2\u01b5\u01b7\5\\/\2\u01b6\u01b1\3\2\2\2\u01b6"+
		"\u01b2\3\2\2\2\u01b6\u01b5\3\2\2\2\u01b7[\3\2\2\2\u01b8\u01b9\7:\2\2\u01b9"+
		"\u01ba\7\6\2\2\u01ba\u01bb\7:\2\2\u01bb]\3\2\2\2\u01bc\u01be\7\31\2\2"+
		"\u01bd\u01bf\5\n\6\2\u01be\u01bd\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c0"+
		"\3\2\2\2\u01c0\u01c4\7\32\2\2\u01c1\u01c4\5N(\2\u01c2\u01c4\78\2\2\u01c3"+
		"\u01bc\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c2\3\2\2\2\u01c4_\3\2\2\2"+
		"\u01c5\u01c7\7\31\2\2\u01c6\u01c8\5\6\4\2\u01c7\u01c6\3\2\2\2\u01c7\u01c8"+
		"\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01ca\7\32\2\2\u01ca\u01cb\5\f\7\2"+
		"\u01cb\u01cc\7\b\2\2\u01cca\3\2\2\2\u01cd\u01ce\t\3\2\2\u01cec\3\2\2\2"+
		"\u01cf\u01d0\t\4\2\2\u01d0e\3\2\2\2\u01d1\u01d2\t\5\2\2\u01d2g\3\2\2\2"+
		"\u01d3\u01d4\t\6\2\2\u01d4i\3\2\2\2\u01d5\u01d6\t\7\2\2\u01d6k\3\2\2\2"+
		"\u01d7\u01d8\7\60\2\2\u01d8\u01d9\5.\30\2\u01d9\u01da\7\61\2\2\u01da\u01db"+
		"\7\5\2\2\u01db\u01dc\5.\30\2\u01dc\u01e2\3\2\2\2\u01dd\u01de\7:\2\2\u01de"+
		"\u01df\7\5\2\2\u01df\u01e2\5.\30\2\u01e0\u01e2\5.\30\2\u01e1\u01d7\3\2"+
		"\2\2\u01e1\u01dd\3\2\2\2\u01e1\u01e0\3\2\2\2\u01e2m\3\2\2\2\u01e3\u01e4"+
		"\5H%\2\u01e4\u01e5\7\60\2\2\u01e5\u01e6\5.\30\2\u01e6\u01e7\7\61\2\2\u01e7"+
		"\u01ee\3\2\2\2\u01e8\u01e9\5H%\2\u01e9\u01ea\7#\2\2\u01ea\u01eb\7:\2\2"+
		"\u01eb\u01ee\3\2\2\2\u01ec\u01ee\7:\2\2\u01ed\u01e3\3\2\2\2\u01ed\u01e8"+
		"\3\2\2\2\u01ed\u01ec\3\2\2\2\u01eeo\3\2\2\2\u01ef\u01f4\5r:\2\u01f0\u01f4"+
		"\5t;\2\u01f1\u01f4\78\2\2\u01f2\u01f4\7\62\2\2\u01f3\u01ef\3\2\2\2\u01f3"+
		"\u01f0\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f3\u01f2\3\2\2\2\u01f4q\3\2\2\2"+
		"\u01f5\u01f6\t\b\2\2\u01f6s\3\2\2\2\u01f7\u01f8\t\t\2\2\u01f8u\3\2\2\2"+
		"\u01f9\u01fa\5^\60\2\u01faw\3\2\2\2\u01fb\u01fc\7\6\2\2\u01fc\u01fd\7"+
		":\2\2\u01fd\u01fe\5^\60\2\u01fey\3\2\2\2\u01ff\u0200\7\60\2\2\u0200\u0201"+
		"\5.\30\2\u0201\u0202\7\61\2\2\u0202{\3\2\2\2\u0203\u0204\7#\2\2\u0204"+
		"\u0205\7:\2\2\u0205}\3\2\2\2)\u0086\u008c\u008f\u0096\u009e\u00a3\u00a7"+
		"\u00b9\u00da\u00de\u00e4\u00f2\u00fc\u0111\u011a\u0122\u012a\u0132\u013b"+
		"\u0144\u014c\u0155\u015e\u0165\u016c\u0175\u017a\u0181\u0185\u0195\u0199"+
		"\u019b\u01b6\u01be\u01c3\u01c7\u01e1\u01ed\u01f3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}