// Generated from C:/Users/John/IdeaProjects/SCLuaCheck/src/scluacheck/parser\SCLua.g4 by ANTLR 4.5.1
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
		RULE_expressionList = 4, RULE_chunk = 5, RULE_statement = 6, RULE_funcName = 7, 
		RULE_expression = 8, RULE_orExpression = 9, RULE_andExpression = 10, RULE_bitwiseOrExpression = 11, 
		RULE_bitwiseAndExpression = 12, RULE_equalityExpression = 13, RULE_relationalExpression = 14, 
		RULE_concatExpression = 15, RULE_addExpression = 16, RULE_multExpression = 17, 
		RULE_negationExpression = 18, RULE_powerExpression = 19, RULE_primaryExpression = 20, 
		RULE_prefixExp = 21, RULE_args = 22, RULE_functionDecl = 23, RULE_funcBody = 24, 
		RULE_tableConstructor = 25, RULE_fField = 26, RULE_upValue = 27, RULE_var = 28, 
		RULE_literal = 29, RULE_booleanLiteral = 30, RULE_numericLiteral = 31;
	public static final String[] ruleNames = {
		"start", "idList", "paramList", "varList", "expressionList", "chunk", 
		"statement", "funcName", "expression", "orExpression", "andExpression", 
		"bitwiseOrExpression", "bitwiseAndExpression", "equalityExpression", "relationalExpression", 
		"concatExpression", "addExpression", "multExpression", "negationExpression", 
		"powerExpression", "primaryExpression", "prefixExp", "args", "functionDecl", 
		"funcBody", "tableConstructor", "fField", "upValue", "var", "literal", 
		"booleanLiteral", "numericLiteral"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'...'", "';'", "'='", "':'", "'do'", "'end'", "'while'", 
		"'repeat'", "'until'", "'if'", "'then'", "'elseif'", "'else'", "'return'", 
		"'break'", "'continue'", "'for'", "'in'", "'function'", "'local'", "'.'", 
		"'or'", "'and'", "'|'", "'&'", "'=='", "'~='", "'!='", "'<'", "'>'", "'<='", 
		"'>='", "'..'", "'+'", "'-'", "'*'", "'/'", "'%'", "'not'", "'^'", "'['", 
		"']'", "'('", "')'", "'{'", "'}'", "'nil'", "'true'", "'false'"
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
			setState(64);
			chunk();
			setState(65);
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
			setState(67);
			match(ID);
			setState(72);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(68);
					match(T__0);
					setState(69);
					match(ID);
					}
					} 
				}
				setState(74);
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
			setState(81);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				idList();
				setState(78);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(76);
					match(T__0);
					setState(77);
					match(T__1);
					}
				}

				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(T__1);
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
			setState(83);
			var();
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(84);
				match(T__0);
				setState(85);
				var();
				}
				}
				setState(90);
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
			setState(91);
			expression();
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(92);
				match(T__0);
				setState(93);
				expression();
				}
				}
				setState(98);
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
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__20) | (1L << T__43) | (1L << ID))) != 0)) {
				{
				{
				setState(99);
				statement();
				setState(101);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(100);
					match(T__2);
					}
				}

				}
				}
				setState(107);
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
		public VarListContext varList() {
			return getRuleContext(VarListContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public PrefixExpContext prefixExp() {
			return getRuleContext(PrefixExpContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(SCLuaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SCLuaParser.ID, i);
		}
		public List<ChunkContext> chunk() {
			return getRuleContexts(ChunkContext.class);
		}
		public ChunkContext chunk(int i) {
			return getRuleContext(ChunkContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FuncNameContext funcName() {
			return getRuleContext(FuncNameContext.class,0);
		}
		public FuncBodyContext funcBody() {
			return getRuleContext(FuncBodyContext.class,0);
		}
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
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
		int _la;
		try {
			setState(201);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				varList();
				setState(109);
				match(T__3);
				setState(110);
				expressionList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				prefixExp(0);
				setState(113);
				args();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(115);
				prefixExp(0);
				setState(116);
				match(T__4);
				setState(117);
				match(ID);
				setState(118);
				args();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(120);
				match(T__5);
				setState(121);
				chunk();
				setState(122);
				match(T__6);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(124);
				match(T__7);
				setState(125);
				expression();
				setState(126);
				match(T__5);
				setState(127);
				chunk();
				setState(128);
				match(T__6);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(130);
				match(T__8);
				setState(131);
				chunk();
				setState(132);
				match(T__9);
				setState(133);
				expression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(135);
				match(T__10);
				setState(136);
				expression();
				setState(137);
				match(T__11);
				setState(138);
				chunk();
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(139);
					match(T__12);
					setState(140);
					expression();
					setState(141);
					match(T__11);
					setState(142);
					chunk();
					}
					}
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(151);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(149);
					match(T__13);
					setState(150);
					chunk();
					}
				}

				setState(153);
				match(T__6);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(155);
				match(T__14);
				setState(157);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(156);
					expressionList();
					}
					break;
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(159);
				match(T__15);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(160);
				match(T__16);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(161);
				match(T__17);
				setState(162);
				match(ID);
				setState(163);
				match(T__3);
				setState(164);
				expression();
				setState(165);
				match(T__0);
				setState(166);
				expression();
				setState(169);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(167);
					match(T__0);
					setState(168);
					expression();
					}
				}

				setState(171);
				match(T__5);
				setState(172);
				chunk();
				setState(173);
				match(T__6);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(175);
				match(T__17);
				setState(176);
				match(ID);
				setState(179);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(177);
					match(T__0);
					setState(178);
					match(ID);
					}
				}

				setState(181);
				match(T__18);
				setState(182);
				expression();
				setState(183);
				match(T__5);
				setState(184);
				chunk();
				setState(185);
				match(T__6);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(187);
				match(T__19);
				setState(188);
				funcName();
				setState(189);
				funcBody();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(191);
				match(T__20);
				setState(192);
				match(T__19);
				setState(193);
				match(ID);
				setState(194);
				funcBody();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(195);
				match(T__20);
				setState(196);
				idList();
				setState(199);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(197);
					match(T__3);
					setState(198);
					expressionList();
					}
				}

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

	public static class FuncNameContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SCLuaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SCLuaParser.ID, i);
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
		enterRule(_localctx, 14, RULE_funcName);
		try {
			setState(210);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				match(ID);
				setState(205);
				match(T__21);
				setState(206);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(207);
				match(ID);
				setState(208);
				match(T__4);
				setState(209);
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
		enterRule(_localctx, 16, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
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
		enterRule(_localctx, 18, RULE_orExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			andExpression();
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22) {
				{
				{
				setState(215);
				match(T__22);
				setState(216);
				andExpression();
				}
				}
				setState(221);
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
		enterRule(_localctx, 20, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			bitwiseOrExpression();
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(223);
				match(T__23);
				setState(224);
				bitwiseOrExpression();
				}
				}
				setState(229);
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
		enterRule(_localctx, 22, RULE_bitwiseOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			bitwiseAndExpression();
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(231);
				match(T__24);
				setState(232);
				bitwiseAndExpression();
				}
				}
				setState(237);
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
		enterRule(_localctx, 24, RULE_bitwiseAndExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			equalityExpression();
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__25) {
				{
				{
				setState(239);
				match(T__25);
				setState(240);
				equalityExpression();
				}
				}
				setState(245);
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
		enterRule(_localctx, 26, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			relationalExpression();
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) {
				{
				{
				setState(247);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(248);
				relationalExpression();
				}
				}
				setState(253);
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
		enterRule(_localctx, 28, RULE_relationalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			concatExpression();
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) {
				{
				{
				setState(255);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(256);
				concatExpression();
				}
				}
				setState(261);
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
		enterRule(_localctx, 30, RULE_concatExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			addExpression();
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__33) {
				{
				{
				setState(263);
				match(T__33);
				setState(264);
				addExpression();
				}
				}
				setState(269);
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
		enterRule(_localctx, 32, RULE_addExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			multExpression();
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__34 || _la==T__35) {
				{
				{
				setState(271);
				_la = _input.LA(1);
				if ( !(_la==T__34 || _la==T__35) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(272);
				multExpression();
				}
				}
				setState(277);
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
		enterRule(_localctx, 34, RULE_multExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			negationExpression();
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) {
				{
				{
				setState(279);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(280);
				negationExpression();
				}
				}
				setState(285);
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
		enterRule(_localctx, 36, RULE_negationExpression);
		int _la;
		try {
			setState(289);
			switch (_input.LA(1)) {
			case T__35:
			case T__39:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				_la = _input.LA(1);
				if ( !(_la==T__35 || _la==T__39) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(287);
				negationExpression();
				}
				break;
			case T__1:
			case T__19:
			case T__38:
			case T__43:
			case T__45:
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
				setState(288);
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
		enterRule(_localctx, 38, RULE_powerExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			primaryExpression();
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__40) {
				{
				{
				setState(292);
				match(T__40);
				setState(293);
				primaryExpression();
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

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public PrefixExpContext prefixExp() {
			return getRuleContext(PrefixExpContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public FunctionDeclContext functionDecl() {
			return getRuleContext(FunctionDeclContext.class,0);
		}
		public TableConstructorContext tableConstructor() {
			return getRuleContext(TableConstructorContext.class,0);
		}
		public UpValueContext upValue() {
			return getRuleContext(UpValueContext.class,0);
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
		enterRule(_localctx, 40, RULE_primaryExpression);
		try {
			setState(305);
			switch (_input.LA(1)) {
			case T__43:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
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
				setState(300);
				literal();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 3);
				{
				setState(301);
				functionDecl();
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 4);
				{
				setState(302);
				tableConstructor();
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 5);
				{
				setState(303);
				upValue();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 6);
				{
				setState(304);
				match(T__1);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ID() { return getToken(SCLuaParser.ID, 0); }
		public PrefixExpContext prefixExp() {
			return getRuleContext(PrefixExpContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_prefixExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			switch (_input.LA(1)) {
			case T__43:
				{
				setState(308);
				match(T__43);
				setState(309);
				expression();
				setState(310);
				match(T__44);
				}
				break;
			case ID:
				{
				setState(312);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(331);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(329);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new PrefixExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_prefixExp);
						setState(315);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(316);
						args();
						}
						break;
					case 2:
						{
						_localctx = new PrefixExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_prefixExp);
						setState(317);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(318);
						match(T__4);
						setState(319);
						match(ID);
						setState(320);
						args();
						}
						break;
					case 3:
						{
						_localctx = new PrefixExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_prefixExp);
						setState(321);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(322);
						match(T__41);
						setState(323);
						expression();
						setState(324);
						match(T__42);
						}
						break;
					case 4:
						{
						_localctx = new PrefixExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_prefixExp);
						setState(326);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(327);
						match(T__21);
						setState(328);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(333);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
		enterRule(_localctx, 44, RULE_args);
		int _la;
		try {
			setState(341);
			switch (_input.LA(1)) {
			case T__43:
				enterOuterAlt(_localctx, 1);
				{
				setState(334);
				match(T__43);
				setState(336);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__19) | (1L << T__35) | (1L << T__38) | (1L << T__39) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << HEX_LITERAL) | (1L << INT_LITERAL) | (1L << FLOAT_LITERAL) | (1L << STRING_LITERAL) | (1L << ID))) != 0)) {
					{
					setState(335);
					expressionList();
					}
				}

				setState(338);
				match(T__44);
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 2);
				{
				setState(339);
				tableConstructor();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(340);
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

	public static class FunctionDeclContext extends ParserRuleContext {
		public FuncBodyContext funcBody() {
			return getRuleContext(FuncBodyContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_functionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(T__19);
			setState(344);
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
		enterRule(_localctx, 48, RULE_funcBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			match(T__43);
			setState(348);
			_la = _input.LA(1);
			if (_la==T__1 || _la==ID) {
				{
				setState(347);
				paramList();
				}
			}

			setState(350);
			match(T__44);
			setState(351);
			chunk();
			setState(352);
			match(T__6);
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
		public List<FFieldContext> fField() {
			return getRuleContexts(FFieldContext.class);
		}
		public FFieldContext fField(int i) {
			return getRuleContext(FFieldContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		enterRule(_localctx, 50, RULE_tableConstructor);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(T__45);
			setState(372);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__19) | (1L << T__35) | (1L << T__38) | (1L << T__39) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << HEX_LITERAL) | (1L << INT_LITERAL) | (1L << FLOAT_LITERAL) | (1L << STRING_LITERAL) | (1L << ID))) != 0)) {
				{
				setState(357);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(355);
					fField();
					}
					break;
				case 2:
					{
					setState(356);
					expression();
					}
					break;
				}
				setState(366);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(359);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==T__2) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(362);
						switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
						case 1:
							{
							setState(360);
							fField();
							}
							break;
						case 2:
							{
							setState(361);
							expression();
							}
							break;
						}
						}
						} 
					}
					setState(368);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				}
				setState(370);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(369);
					match(T__0);
					}
				}

				}
			}

			setState(374);
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

	public static class FFieldContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ID() { return getToken(SCLuaParser.ID, 0); }
		public FFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).enterFField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SCLuaListener ) ((SCLuaListener)listener).exitFField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SCLuaVisitor ) return ((SCLuaVisitor<? extends T>)visitor).visitFField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FFieldContext fField() throws RecognitionException {
		FFieldContext _localctx = new FFieldContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_fField);
		try {
			setState(385);
			switch (_input.LA(1)) {
			case T__41:
				enterOuterAlt(_localctx, 1);
				{
				setState(376);
				match(T__41);
				setState(377);
				expression();
				setState(378);
				match(T__42);
				setState(379);
				match(T__3);
				setState(380);
				expression();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(382);
				match(ID);
				setState(383);
				match(T__3);
				setState(384);
				expression();
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
		enterRule(_localctx, 54, RULE_upValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			match(T__38);
			setState(388);
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
		enterRule(_localctx, 56, RULE_var);
		try {
			setState(400);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(390);
				prefixExp(0);
				setState(391);
				match(T__41);
				setState(392);
				expression();
				setState(393);
				match(T__42);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(395);
				prefixExp(0);
				setState(396);
				match(T__21);
				setState(397);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(399);
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
		enterRule(_localctx, 58, RULE_literal);
		try {
			setState(406);
			switch (_input.LA(1)) {
			case T__48:
			case T__49:
				enterOuterAlt(_localctx, 1);
				{
				setState(402);
				booleanLiteral();
				}
				break;
			case HEX_LITERAL:
			case INT_LITERAL:
			case FLOAT_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(403);
				numericLiteral();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(404);
				match(STRING_LITERAL);
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 4);
				{
				setState(405);
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
		enterRule(_localctx, 60, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
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
		enterRule(_localctx, 62, RULE_numericLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21:
			return prefixExp_sempred((PrefixExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean prefixExp_sempred(PrefixExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3=\u019f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\3\3\3\3\3\7\3I\n\3\f\3\16\3L\13\3\3\4\3\4\3\4\5\4Q\n"+
		"\4\3\4\5\4T\n\4\3\5\3\5\3\5\7\5Y\n\5\f\5\16\5\\\13\5\3\6\3\6\3\6\7\6a"+
		"\n\6\f\6\16\6d\13\6\3\7\3\7\5\7h\n\7\7\7j\n\7\f\7\16\7m\13\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0093"+
		"\n\b\f\b\16\b\u0096\13\b\3\b\3\b\5\b\u009a\n\b\3\b\3\b\3\b\3\b\5\b\u00a0"+
		"\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00ac\n\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\5\b\u00b6\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00ca\n\b\5\b\u00cc\n\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\5\t\u00d5\n\t\3\n\3\n\3\13\3\13\3\13\7\13\u00dc"+
		"\n\13\f\13\16\13\u00df\13\13\3\f\3\f\3\f\7\f\u00e4\n\f\f\f\16\f\u00e7"+
		"\13\f\3\r\3\r\3\r\7\r\u00ec\n\r\f\r\16\r\u00ef\13\r\3\16\3\16\3\16\7\16"+
		"\u00f4\n\16\f\16\16\16\u00f7\13\16\3\17\3\17\3\17\7\17\u00fc\n\17\f\17"+
		"\16\17\u00ff\13\17\3\20\3\20\3\20\7\20\u0104\n\20\f\20\16\20\u0107\13"+
		"\20\3\21\3\21\3\21\7\21\u010c\n\21\f\21\16\21\u010f\13\21\3\22\3\22\3"+
		"\22\7\22\u0114\n\22\f\22\16\22\u0117\13\22\3\23\3\23\3\23\7\23\u011c\n"+
		"\23\f\23\16\23\u011f\13\23\3\24\3\24\3\24\5\24\u0124\n\24\3\25\3\25\3"+
		"\25\7\25\u0129\n\25\f\25\16\25\u012c\13\25\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\5\26\u0134\n\26\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u013c\n\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27"+
		"\u014c\n\27\f\27\16\27\u014f\13\27\3\30\3\30\5\30\u0153\n\30\3\30\3\30"+
		"\3\30\5\30\u0158\n\30\3\31\3\31\3\31\3\32\3\32\5\32\u015f\n\32\3\32\3"+
		"\32\3\32\3\32\3\33\3\33\3\33\5\33\u0168\n\33\3\33\3\33\3\33\5\33\u016d"+
		"\n\33\7\33\u016f\n\33\f\33\16\33\u0172\13\33\3\33\5\33\u0175\n\33\5\33"+
		"\u0177\n\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34"+
		"\u0184\n\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\5\36\u0193\n\36\3\37\3\37\3\37\3\37\5\37\u0199\n\37\3 \3 \3!\3!"+
		"\3!\2\3,\"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@\2\n\3\2\35\37\3\2 #\3\2%&\3\2\')\4\2&&**\4\2\3\3\5\5\3\2\63\64\3"+
		"\2\65\67\u01bf\2B\3\2\2\2\4E\3\2\2\2\6S\3\2\2\2\bU\3\2\2\2\n]\3\2\2\2"+
		"\fk\3\2\2\2\16\u00cb\3\2\2\2\20\u00d4\3\2\2\2\22\u00d6\3\2\2\2\24\u00d8"+
		"\3\2\2\2\26\u00e0\3\2\2\2\30\u00e8\3\2\2\2\32\u00f0\3\2\2\2\34\u00f8\3"+
		"\2\2\2\36\u0100\3\2\2\2 \u0108\3\2\2\2\"\u0110\3\2\2\2$\u0118\3\2\2\2"+
		"&\u0123\3\2\2\2(\u0125\3\2\2\2*\u0133\3\2\2\2,\u013b\3\2\2\2.\u0157\3"+
		"\2\2\2\60\u0159\3\2\2\2\62\u015c\3\2\2\2\64\u0164\3\2\2\2\66\u0183\3\2"+
		"\2\28\u0185\3\2\2\2:\u0192\3\2\2\2<\u0198\3\2\2\2>\u019a\3\2\2\2@\u019c"+
		"\3\2\2\2BC\5\f\7\2CD\7\2\2\3D\3\3\2\2\2EJ\7:\2\2FG\7\3\2\2GI\7:\2\2HF"+
		"\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\5\3\2\2\2LJ\3\2\2\2MP\5\4\3\2"+
		"NO\7\3\2\2OQ\7\4\2\2PN\3\2\2\2PQ\3\2\2\2QT\3\2\2\2RT\7\4\2\2SM\3\2\2\2"+
		"SR\3\2\2\2T\7\3\2\2\2UZ\5:\36\2VW\7\3\2\2WY\5:\36\2XV\3\2\2\2Y\\\3\2\2"+
		"\2ZX\3\2\2\2Z[\3\2\2\2[\t\3\2\2\2\\Z\3\2\2\2]b\5\22\n\2^_\7\3\2\2_a\5"+
		"\22\n\2`^\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\13\3\2\2\2db\3\2\2\2"+
		"eg\5\16\b\2fh\7\5\2\2gf\3\2\2\2gh\3\2\2\2hj\3\2\2\2ie\3\2\2\2jm\3\2\2"+
		"\2ki\3\2\2\2kl\3\2\2\2l\r\3\2\2\2mk\3\2\2\2no\5\b\5\2op\7\6\2\2pq\5\n"+
		"\6\2q\u00cc\3\2\2\2rs\5,\27\2st\5.\30\2t\u00cc\3\2\2\2uv\5,\27\2vw\7\7"+
		"\2\2wx\7:\2\2xy\5.\30\2y\u00cc\3\2\2\2z{\7\b\2\2{|\5\f\7\2|}\7\t\2\2}"+
		"\u00cc\3\2\2\2~\177\7\n\2\2\177\u0080\5\22\n\2\u0080\u0081\7\b\2\2\u0081"+
		"\u0082\5\f\7\2\u0082\u0083\7\t\2\2\u0083\u00cc\3\2\2\2\u0084\u0085\7\13"+
		"\2\2\u0085\u0086\5\f\7\2\u0086\u0087\7\f\2\2\u0087\u0088\5\22\n\2\u0088"+
		"\u00cc\3\2\2\2\u0089\u008a\7\r\2\2\u008a\u008b\5\22\n\2\u008b\u008c\7"+
		"\16\2\2\u008c\u0094\5\f\7\2\u008d\u008e\7\17\2\2\u008e\u008f\5\22\n\2"+
		"\u008f\u0090\7\16\2\2\u0090\u0091\5\f\7\2\u0091\u0093\3\2\2\2\u0092\u008d"+
		"\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0099\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0098\7\20\2\2\u0098\u009a\5"+
		"\f\7\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u009c\7\t\2\2\u009c\u00cc\3\2\2\2\u009d\u009f\7\21\2\2\u009e\u00a0\5"+
		"\n\6\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00cc\3\2\2\2\u00a1"+
		"\u00cc\7\22\2\2\u00a2\u00cc\7\23\2\2\u00a3\u00a4\7\24\2\2\u00a4\u00a5"+
		"\7:\2\2\u00a5\u00a6\7\6\2\2\u00a6\u00a7\5\22\n\2\u00a7\u00a8\7\3\2\2\u00a8"+
		"\u00ab\5\22\n\2\u00a9\u00aa\7\3\2\2\u00aa\u00ac\5\22\n\2\u00ab\u00a9\3"+
		"\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7\b\2\2\u00ae"+
		"\u00af\5\f\7\2\u00af\u00b0\7\t\2\2\u00b0\u00cc\3\2\2\2\u00b1\u00b2\7\24"+
		"\2\2\u00b2\u00b5\7:\2\2\u00b3\u00b4\7\3\2\2\u00b4\u00b6\7:\2\2\u00b5\u00b3"+
		"\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\7\25\2\2"+
		"\u00b8\u00b9\5\22\n\2\u00b9\u00ba\7\b\2\2\u00ba\u00bb\5\f\7\2\u00bb\u00bc"+
		"\7\t\2\2\u00bc\u00cc\3\2\2\2\u00bd\u00be\7\26\2\2\u00be\u00bf\5\20\t\2"+
		"\u00bf\u00c0\5\62\32\2\u00c0\u00cc\3\2\2\2\u00c1\u00c2\7\27\2\2\u00c2"+
		"\u00c3\7\26\2\2\u00c3\u00c4\7:\2\2\u00c4\u00cc\5\62\32\2\u00c5\u00c6\7"+
		"\27\2\2\u00c6\u00c9\5\4\3\2\u00c7\u00c8\7\6\2\2\u00c8\u00ca\5\n\6\2\u00c9"+
		"\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cbn\3\2\2\2"+
		"\u00cbr\3\2\2\2\u00cbu\3\2\2\2\u00cbz\3\2\2\2\u00cb~\3\2\2\2\u00cb\u0084"+
		"\3\2\2\2\u00cb\u0089\3\2\2\2\u00cb\u009d\3\2\2\2\u00cb\u00a1\3\2\2\2\u00cb"+
		"\u00a2\3\2\2\2\u00cb\u00a3\3\2\2\2\u00cb\u00b1\3\2\2\2\u00cb\u00bd\3\2"+
		"\2\2\u00cb\u00c1\3\2\2\2\u00cb\u00c5\3\2\2\2\u00cc\17\3\2\2\2\u00cd\u00d5"+
		"\7:\2\2\u00ce\u00cf\7:\2\2\u00cf\u00d0\7\30\2\2\u00d0\u00d5\7:\2\2\u00d1"+
		"\u00d2\7:\2\2\u00d2\u00d3\7\7\2\2\u00d3\u00d5\7:\2\2\u00d4\u00cd\3\2\2"+
		"\2\u00d4\u00ce\3\2\2\2\u00d4\u00d1\3\2\2\2\u00d5\21\3\2\2\2\u00d6\u00d7"+
		"\5\24\13\2\u00d7\23\3\2\2\2\u00d8\u00dd\5\26\f\2\u00d9\u00da\7\31\2\2"+
		"\u00da\u00dc\5\26\f\2\u00db\u00d9\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db"+
		"\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\25\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0"+
		"\u00e5\5\30\r\2\u00e1\u00e2\7\32\2\2\u00e2\u00e4\5\30\r\2\u00e3\u00e1"+
		"\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\27\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00ed\5\32\16\2\u00e9\u00ea\7\33"+
		"\2\2\u00ea\u00ec\5\32\16\2\u00eb\u00e9\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed"+
		"\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\31\3\2\2\2\u00ef\u00ed\3\2\2"+
		"\2\u00f0\u00f5\5\34\17\2\u00f1\u00f2\7\34\2\2\u00f2\u00f4\5\34\17\2\u00f3"+
		"\u00f1\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2"+
		"\2\2\u00f6\33\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00fd\5\36\20\2\u00f9"+
		"\u00fa\t\2\2\2\u00fa\u00fc\5\36\20\2\u00fb\u00f9\3\2\2\2\u00fc\u00ff\3"+
		"\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\35\3\2\2\2\u00ff"+
		"\u00fd\3\2\2\2\u0100\u0105\5 \21\2\u0101\u0102\t\3\2\2\u0102\u0104\5 "+
		"\21\2\u0103\u0101\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\37\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u010d\5\"\22"+
		"\2\u0109\u010a\7$\2\2\u010a\u010c\5\"\22\2\u010b\u0109\3\2\2\2\u010c\u010f"+
		"\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e!\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u0110\u0115\5$\23\2\u0111\u0112\t\4\2\2\u0112\u0114\5$"+
		"\23\2\u0113\u0111\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115"+
		"\u0116\3\2\2\2\u0116#\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u011d\5&\24\2"+
		"\u0119\u011a\t\5\2\2\u011a\u011c\5&\24\2\u011b\u0119\3\2\2\2\u011c\u011f"+
		"\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e%\3\2\2\2\u011f"+
		"\u011d\3\2\2\2\u0120\u0121\t\6\2\2\u0121\u0124\5&\24\2\u0122\u0124\5("+
		"\25\2\u0123\u0120\3\2\2\2\u0123\u0122\3\2\2\2\u0124\'\3\2\2\2\u0125\u012a"+
		"\5*\26\2\u0126\u0127\7+\2\2\u0127\u0129\5*\26\2\u0128\u0126\3\2\2\2\u0129"+
		"\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b)\3\2\2\2"+
		"\u012c\u012a\3\2\2\2\u012d\u0134\5,\27\2\u012e\u0134\5<\37\2\u012f\u0134"+
		"\5\60\31\2\u0130\u0134\5\64\33\2\u0131\u0134\58\35\2\u0132\u0134\7\4\2"+
		"\2\u0133\u012d\3\2\2\2\u0133\u012e\3\2\2\2\u0133\u012f\3\2\2\2\u0133\u0130"+
		"\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0132\3\2\2\2\u0134+\3\2\2\2\u0135"+
		"\u0136\b\27\1\2\u0136\u0137\7.\2\2\u0137\u0138\5\22\n\2\u0138\u0139\7"+
		"/\2\2\u0139\u013c\3\2\2\2\u013a\u013c\7:\2\2\u013b\u0135\3\2\2\2\u013b"+
		"\u013a\3\2\2\2\u013c\u014d\3\2\2\2\u013d\u013e\f\b\2\2\u013e\u014c\5."+
		"\30\2\u013f\u0140\f\7\2\2\u0140\u0141\7\7\2\2\u0141\u0142\7:\2\2\u0142"+
		"\u014c\5.\30\2\u0143\u0144\f\6\2\2\u0144\u0145\7,\2\2\u0145\u0146\5\22"+
		"\n\2\u0146\u0147\7-\2\2\u0147\u014c\3\2\2\2\u0148\u0149\f\5\2\2\u0149"+
		"\u014a\7\30\2\2\u014a\u014c\7:\2\2\u014b\u013d\3\2\2\2\u014b\u013f\3\2"+
		"\2\2\u014b\u0143\3\2\2\2\u014b\u0148\3\2\2\2\u014c\u014f\3\2\2\2\u014d"+
		"\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e-\3\2\2\2\u014f\u014d\3\2\2\2"+
		"\u0150\u0152\7.\2\2\u0151\u0153\5\n\6\2\u0152\u0151\3\2\2\2\u0152\u0153"+
		"\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0158\7/\2\2\u0155\u0158\5\64\33\2"+
		"\u0156\u0158\78\2\2\u0157\u0150\3\2\2\2\u0157\u0155\3\2\2\2\u0157\u0156"+
		"\3\2\2\2\u0158/\3\2\2\2\u0159\u015a\7\26\2\2\u015a\u015b\5\62\32\2\u015b"+
		"\61\3\2\2\2\u015c\u015e\7.\2\2\u015d\u015f\5\6\4\2\u015e\u015d\3\2\2\2"+
		"\u015e\u015f\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161\7/\2\2\u0161\u0162"+
		"\5\f\7\2\u0162\u0163\7\t\2\2\u0163\63\3\2\2\2\u0164\u0176\7\60\2\2\u0165"+
		"\u0168\5\66\34\2\u0166\u0168\5\22\n\2\u0167\u0165\3\2\2\2\u0167\u0166"+
		"\3\2\2\2\u0168\u0170\3\2\2\2\u0169\u016c\t\7\2\2\u016a\u016d\5\66\34\2"+
		"\u016b\u016d\5\22\n\2\u016c\u016a\3\2\2\2\u016c\u016b\3\2\2\2\u016d\u016f"+
		"\3\2\2\2\u016e\u0169\3\2\2\2\u016f\u0172\3\2\2\2\u0170\u016e\3\2\2\2\u0170"+
		"\u0171\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0173\u0175\7\3"+
		"\2\2\u0174\u0173\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0177\3\2\2\2\u0176"+
		"\u0167\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\7\61"+
		"\2\2\u0179\65\3\2\2\2\u017a\u017b\7,\2\2\u017b\u017c\5\22\n\2\u017c\u017d"+
		"\7-\2\2\u017d\u017e\7\6\2\2\u017e\u017f\5\22\n\2\u017f\u0184\3\2\2\2\u0180"+
		"\u0181\7:\2\2\u0181\u0182\7\6\2\2\u0182\u0184\5\22\n\2\u0183\u017a\3\2"+
		"\2\2\u0183\u0180\3\2\2\2\u0184\67\3\2\2\2\u0185\u0186\7)\2\2\u0186\u0187"+
		"\7:\2\2\u01879\3\2\2\2\u0188\u0189\5,\27\2\u0189\u018a\7,\2\2\u018a\u018b"+
		"\5\22\n\2\u018b\u018c\7-\2\2\u018c\u0193\3\2\2\2\u018d\u018e\5,\27\2\u018e"+
		"\u018f\7\30\2\2\u018f\u0190\7:\2\2\u0190\u0193\3\2\2\2\u0191\u0193\7:"+
		"\2\2\u0192\u0188\3\2\2\2\u0192\u018d\3\2\2\2\u0192\u0191\3\2\2\2\u0193"+
		";\3\2\2\2\u0194\u0199\5> \2\u0195\u0199\5@!\2\u0196\u0199\78\2\2\u0197"+
		"\u0199\7\62\2\2\u0198\u0194\3\2\2\2\u0198\u0195\3\2\2\2\u0198\u0196\3"+
		"\2\2\2\u0198\u0197\3\2\2\2\u0199=\3\2\2\2\u019a\u019b\t\b\2\2\u019b?\3"+
		"\2\2\2\u019c\u019d\t\t\2\2\u019dA\3\2\2\2+JPSZbgk\u0094\u0099\u009f\u00ab"+
		"\u00b5\u00c9\u00cb\u00d4\u00dd\u00e5\u00ed\u00f5\u00fd\u0105\u010d\u0115"+
		"\u011d\u0123\u012a\u0133\u013b\u014b\u014d\u0152\u0157\u015e\u0167\u016c"+
		"\u0170\u0174\u0176\u0183\u0192\u0198";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}