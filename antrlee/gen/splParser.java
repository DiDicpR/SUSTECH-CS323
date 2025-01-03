// Generated from C:/Users/aoxiangxueyuan/PycharmProjects/git/SUSTECH-CS323/antrlee/src/main/spl.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class splParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TYPE=1, STRUCT=2, IF=3, ELSE=4, WHILE=5, RETURN=6, DOT=7, SEMI=8, COMMA=9, 
		ASSIGN=10, LT=11, LE=12, GT=13, GE=14, NE=15, EQ=16, PLUS=17, MINUS=18, 
		MUL=19, DIV=20, AND=21, OR=22, NOT=23, LP=24, RP=25, LB=26, RB=27, LC=28, 
		RC=29, INT=30, WRITE=31, ID=32, FLOAT=33, CHAR=34, CHATTOKEN=35, INVALID_CHAR=36, 
		LINE_COMMENT=37, BLOCK_COMMENT=38, WS=39, INVALID_ID=40, INVALID_EXP=41;
	public static final int
		RULE_program = 0, RULE_extDefList = 1, RULE_extDef = 2, RULE_extDecList = 3, 
		RULE_specifier = 4, RULE_structSpecifier = 5, RULE_varDec = 6, RULE_funDec = 7, 
		RULE_varList = 8, RULE_paramDec = 9, RULE_compSt = 10, RULE_stmtList = 11, 
		RULE_stmt = 12, RULE_defList = 13, RULE_def = 14, RULE_decList = 15, RULE_dec = 16, 
		RULE_exp = 17, RULE_args = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "extDefList", "extDef", "extDecList", "specifier", "structSpecifier", 
			"varDec", "funDec", "varList", "paramDec", "compSt", "stmtList", "stmt", 
			"defList", "def", "decList", "dec", "exp", "args"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'struct'", "'if'", "'else'", "'while'", "'return'", "'.'", 
			"';'", "','", "'='", "'<'", "'<='", "'>'", "'>='", "'!='", "'=='", "'+'", 
			"'-'", "'*'", "'/'", "'&&'", "'||'", "'!'", "'('", "')'", "'['", "']'", 
			"'{'", "'}'", null, "'write'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TYPE", "STRUCT", "IF", "ELSE", "WHILE", "RETURN", "DOT", "SEMI", 
			"COMMA", "ASSIGN", "LT", "LE", "GT", "GE", "NE", "EQ", "PLUS", "MINUS", 
			"MUL", "DIV", "AND", "OR", "NOT", "LP", "RP", "LB", "RB", "LC", "RC", 
			"INT", "WRITE", "ID", "FLOAT", "CHAR", "CHATTOKEN", "INVALID_CHAR", "LINE_COMMENT", 
			"BLOCK_COMMENT", "WS", "INVALID_ID", "INVALID_EXP"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "spl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public splParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public ExtDefListContext extDefList() {
			return getRuleContext(ExtDefListContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof splVisitor ) return ((splVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			extDefList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExtDefListContext extends ParserRuleContext {
		public ExtDefContext extDef() {
			return getRuleContext(ExtDefContext.class,0);
		}
		public ExtDefListContext extDefList() {
			return getRuleContext(ExtDefListContext.class,0);
		}
		public ExtDefListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extDefList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).enterExtDefList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).exitExtDefList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof splVisitor ) return ((splVisitor<? extends T>)visitor).visitExtDefList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtDefListContext extDefList() throws RecognitionException {
		ExtDefListContext _localctx = new ExtDefListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_extDefList);
		try {
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
			case STRUCT:
			case ID:
			case INVALID_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				extDef();
				setState(41);
				extDefList();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExtDefContext extends ParserRuleContext {
		public SpecifierContext specifier;
		public ExtDecListContext extDecList;
		public SpecifierContext specifier() {
			return getRuleContext(SpecifierContext.class,0);
		}
		public ExtDecListContext extDecList() {
			return getRuleContext(ExtDecListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(splParser.SEMI, 0); }
		public FunDecContext funDec() {
			return getRuleContext(FunDecContext.class,0);
		}
		public CompStContext compSt() {
			return getRuleContext(CompStContext.class,0);
		}
		public ExtDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).enterExtDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).exitExtDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof splVisitor ) return ((splVisitor<? extends T>)visitor).visitExtDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtDefContext extDef() throws RecognitionException {
		ExtDefContext _localctx = new ExtDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_extDef);
		try {
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				specifier();
				setState(47);
				extDecList();
				setState(48);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				specifier();
				setState(51);
				match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				specifier();
				setState(54);
				funDec();
				setState(55);
				compSt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(57);
				((ExtDefContext)_localctx).specifier = specifier();
				setState(58);
				extDecList();

				                System.err.println("Error type B at Line " + (((ExtDefContext)_localctx).specifier!=null?(((ExtDefContext)_localctx).specifier.start):null).getLine() + ": Missing semicolon \';\'");
				            
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(61);
				((ExtDefContext)_localctx).specifier = specifier();

				                System.err.println("Error type B at Line " + (((ExtDefContext)_localctx).specifier!=null?(((ExtDefContext)_localctx).specifier.start):null).getLine() + ": Missing semicolon \';\'");
				            
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(64);
				((ExtDefContext)_localctx).extDecList = extDecList();
				setState(65);
				match(SEMI);

				              System.err.println("Error type B at Line " + (((ExtDefContext)_localctx).extDecList!=null?(((ExtDefContext)_localctx).extDecList.start):null).getLine() + ": Missing specifier");
				            
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExtDecListContext extends ParserRuleContext {
		public Token COMMA;
		public VarDecContext varDec() {
			return getRuleContext(VarDecContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(splParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(splParser.COMMA, i);
		}
		public ExtDecListContext extDecList() {
			return getRuleContext(ExtDecListContext.class,0);
		}
		public ExtDecListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extDecList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).enterExtDecList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).exitExtDecList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof splVisitor ) return ((splVisitor<? extends T>)visitor).visitExtDecList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtDecListContext extDecList() throws RecognitionException {
		ExtDecListContext _localctx = new ExtDecListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_extDecList);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				varDec(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				varDec(0);
				setState(72);
				match(COMMA);
				setState(73);
				extDecList();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				varDec(0);
				setState(76);
				((ExtDecListContext)_localctx).COMMA = match(COMMA);

				             System.err.println("Error type B at Line " + ((ExtDecListContext)_localctx).COMMA .getLine() + ": Missing variable name");
				            
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				varDec(0);
				setState(80);
				((ExtDecListContext)_localctx).COMMA = match(COMMA);
				setState(81);
				((ExtDecListContext)_localctx).COMMA = match(COMMA);
				setState(82);
				extDecList();
				  System.err.println("Error type B at Line " + ((ExtDecListContext)_localctx).COMMA .getLine() + ": Unexpected ','");
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

	@SuppressWarnings("CheckReturnValue")
	public static class SpecifierContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(splParser.TYPE, 0); }
		public StructSpecifierContext structSpecifier() {
			return getRuleContext(StructSpecifierContext.class,0);
		}
		public SpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).enterSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).exitSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof splVisitor ) return ((splVisitor<? extends T>)visitor).visitSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecifierContext specifier() throws RecognitionException {
		SpecifierContext _localctx = new SpecifierContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_specifier);
		try {
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				match(TYPE);
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				structSpecifier();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructSpecifierContext extends ParserRuleContext {
		public Token STRUCT;
		public TerminalNode STRUCT() { return getToken(splParser.STRUCT, 0); }
		public TerminalNode ID() { return getToken(splParser.ID, 0); }
		public TerminalNode LC() { return getToken(splParser.LC, 0); }
		public DefListContext defList() {
			return getRuleContext(DefListContext.class,0);
		}
		public TerminalNode RC() { return getToken(splParser.RC, 0); }
		public StructSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).enterStructSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).exitStructSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof splVisitor ) return ((splVisitor<? extends T>)visitor).visitStructSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructSpecifierContext structSpecifier() throws RecognitionException {
		StructSpecifierContext _localctx = new StructSpecifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_structSpecifier);
		try {
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				match(STRUCT);
				setState(92);
				match(ID);
				setState(93);
				match(LC);
				setState(94);
				defList();
				setState(95);
				match(RC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				match(STRUCT);
				setState(98);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				((StructSpecifierContext)_localctx).STRUCT = match(STRUCT);
				setState(100);
				match(ID);
				setState(101);
				match(LC);
				setState(102);
				defList();

				                   System.err.println("Error type B at Line " + (((StructSpecifierContext)_localctx).STRUCT!=null?((StructSpecifierContext)_localctx).STRUCT.getLine():0) + ": Missing closing curly brace");
				               
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarDecContext extends ParserRuleContext {
		public Token LB;
		public TerminalNode ID() { return getToken(splParser.ID, 0); }
		public TerminalNode INVALID_ID() { return getToken(splParser.INVALID_ID, 0); }
		public VarDecContext varDec() {
			return getRuleContext(VarDecContext.class,0);
		}
		public TerminalNode LB() { return getToken(splParser.LB, 0); }
		public TerminalNode INT() { return getToken(splParser.INT, 0); }
		public TerminalNode RB() { return getToken(splParser.RB, 0); }
		public VarDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).enterVarDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).exitVarDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof splVisitor ) return ((splVisitor<? extends T>)visitor).visitVarDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDecContext varDec() throws RecognitionException {
		return varDec(0);
	}

	private VarDecContext varDec(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VarDecContext _localctx = new VarDecContext(_ctx, _parentState);
		VarDecContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_varDec, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(108);
				match(ID);
				}
				break;
			case INVALID_ID:
				{
				setState(109);
				match(INVALID_ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(122);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(120);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new VarDecContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_varDec);
						setState(112);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(113);
						((VarDecContext)_localctx).LB = match(LB);
						setState(114);
						match(INT);
						setState(115);
						match(RB);
						}
						break;
					case 2:
						{
						_localctx = new VarDecContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_varDec);
						setState(116);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(117);
						((VarDecContext)_localctx).LB = match(LB);
						setState(118);
						match(INT);

						                          System.err.println("Error type B at Line " + (((VarDecContext)_localctx).LB!=null?((VarDecContext)_localctx).LB.getLine():0) + ": Missing closing bracket \']\'");
						                      
						}
						break;
					}
					} 
				}
				setState(124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunDecContext extends ParserRuleContext {
		public Token LP;
		public TerminalNode ID() { return getToken(splParser.ID, 0); }
		public TerminalNode LP() { return getToken(splParser.LP, 0); }
		public VarListContext varList() {
			return getRuleContext(VarListContext.class,0);
		}
		public TerminalNode RP() { return getToken(splParser.RP, 0); }
		public FunDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).enterFunDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).exitFunDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof splVisitor ) return ((splVisitor<? extends T>)visitor).visitFunDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunDecContext funDec() throws RecognitionException {
		FunDecContext _localctx = new FunDecContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funDec);
		try {
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				match(ID);
				setState(126);
				match(LP);
				setState(127);
				varList();
				setState(128);
				match(RP);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				match(ID);
				setState(131);
				match(LP);
				setState(132);
				match(RP);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				match(ID);
				setState(134);
				((FunDecContext)_localctx).LP = match(LP);
				setState(135);
				varList();

				                System.err.println("Error type B at Line " + (((FunDecContext)_localctx).LP!=null?((FunDecContext)_localctx).LP.getLine():0) + ": Missing closing parenthesis \')\'");
				            
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(138);
				match(ID);
				setState(139);
				((FunDecContext)_localctx).LP = match(LP);

				                System.err.println("Error type B at Line " + (((FunDecContext)_localctx).LP!=null?((FunDecContext)_localctx).LP.getLine():0) + ": Missing closing parenthesis \')\'");
				            
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarListContext extends ParserRuleContext {
		public Token COMMA;
		public ParamDecContext paramDec() {
			return getRuleContext(ParamDecContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(splParser.COMMA, 0); }
		public VarListContext varList() {
			return getRuleContext(VarListContext.class,0);
		}
		public VarListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).enterVarList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).exitVarList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof splVisitor ) return ((splVisitor<? extends T>)visitor).visitVarList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarListContext varList() throws RecognitionException {
		VarListContext _localctx = new VarListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varList);
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				paramDec();
				setState(144);
				match(COMMA);
				setState(145);
				varList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				paramDec();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				paramDec();
				setState(149);
				((VarListContext)_localctx).COMMA = match(COMMA);
				System.err.println("Error type B at Line " + ((VarListContext)_localctx).COMMA.getLine() + ": Missing variable");
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamDecContext extends ParserRuleContext {
		public VarDecContext varDec;
		public SpecifierContext specifier;
		public SpecifierContext specifier() {
			return getRuleContext(SpecifierContext.class,0);
		}
		public VarDecContext varDec() {
			return getRuleContext(VarDecContext.class,0);
		}
		public ParamDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).enterParamDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).exitParamDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof splVisitor ) return ((splVisitor<? extends T>)visitor).visitParamDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamDecContext paramDec() throws RecognitionException {
		ParamDecContext _localctx = new ParamDecContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_paramDec);
		try {
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				specifier();
				setState(155);
				varDec(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				((ParamDecContext)_localctx).varDec = varDec(0);

				    System.err.println("Error type B at Line " + (((ParamDecContext)_localctx).varDec!=null?(((ParamDecContext)_localctx).varDec.start):null).getLine() + ": Missing specifier");
				            
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				((ParamDecContext)_localctx).specifier = specifier();
				 System.err.println("Error type B at Line " + (((ParamDecContext)_localctx).specifier!=null?(((ParamDecContext)_localctx).specifier.start):null).getLine() + ": Missing variable name");
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

	@SuppressWarnings("CheckReturnValue")
	public static class CompStContext extends ParserRuleContext {
		public Token LC;
		public Token RC;
		public TerminalNode LC() { return getToken(splParser.LC, 0); }
		public DefListContext defList() {
			return getRuleContext(DefListContext.class,0);
		}
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public TerminalNode RC() { return getToken(splParser.RC, 0); }
		public CompStContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compSt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).enterCompSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).exitCompSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof splVisitor ) return ((splVisitor<? extends T>)visitor).visitCompSt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompStContext compSt() throws RecognitionException {
		CompStContext _localctx = new CompStContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_compSt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			((CompStContext)_localctx).LC = match(LC);
			setState(166);
			defList();
			setState(167);
			stmtList();
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(168);
				((CompStContext)_localctx).RC = match(RC);
				}
				break;
			}

			                if (((CompStContext)_localctx).RC == null) {
			                    System.err.println("Error type B at Line " + (((CompStContext)_localctx).LC!=null?((CompStContext)_localctx).LC.getLine():0) + ": Missing closing curly bracket '}'");
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

	@SuppressWarnings("CheckReturnValue")
	public static class StmtListContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public StmtListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).enterStmtList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).exitStmtList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof splVisitor ) return ((splVisitor<? extends T>)visitor).visitStmtList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtListContext stmtList() throws RecognitionException {
		StmtListContext _localctx = new StmtListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stmtList);
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				stmt();
				setState(174);
				stmtList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
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

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public Token ELSE;
		public ExpContext exp;
		public Token RETURN;
		public Token LP;
		public Token RP;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(splParser.SEMI, 0); }
		public CompStContext compSt() {
			return getRuleContext(CompStContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(splParser.RETURN, 0); }
		public TerminalNode IF() { return getToken(splParser.IF, 0); }
		public TerminalNode LP() { return getToken(splParser.LP, 0); }
		public TerminalNode RP() { return getToken(splParser.RP, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(splParser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(splParser.WHILE, 0); }
		public TerminalNode WRITE() { return getToken(splParser.WRITE, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof splVisitor ) return ((splVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stmt);
		try {
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				exp(0);
				setState(180);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				compSt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(183);
				match(RETURN);
				setState(184);
				exp(0);
				setState(185);
				match(SEMI);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(187);
				match(IF);
				setState(188);
				match(LP);
				setState(189);
				exp(0);
				setState(190);
				match(RP);
				setState(191);
				stmt();
				setState(192);
				match(ELSE);
				setState(193);
				stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(195);
				match(IF);
				setState(196);
				match(LP);
				setState(197);
				exp(0);
				setState(198);
				match(RP);
				setState(199);
				stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(201);
				((StmtContext)_localctx).ELSE = match(ELSE);
				setState(202);
				stmt();
				System.err.println("Error type B at Line " + ((StmtContext)_localctx).ELSE.getLine() + ": no 'if' before 'else'");
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(205);
				match(WHILE);
				setState(206);
				match(LP);
				setState(207);
				exp(0);
				setState(208);
				match(RP);
				setState(209);
				stmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(211);
				match(WRITE);
				setState(212);
				match(LP);
				setState(213);
				exp(0);
				setState(214);
				match(RP);
				setState(215);
				match(SEMI);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(217);
				((StmtContext)_localctx).exp = exp(0);

				                System.err.println("Error type B at Line " + (((StmtContext)_localctx).exp!=null?(((StmtContext)_localctx).exp.start):null).getLine() + ": Missing semicolon \';\'");
				            
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(220);
				((StmtContext)_localctx).RETURN = match(RETURN);
				setState(221);
				exp(0);

				                System.err.println("Error type B at Line " + (((StmtContext)_localctx).RETURN!=null?((StmtContext)_localctx).RETURN.getLine():0) + ": Missing semicolon \';\'");
				            
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(224);
				match(IF);
				setState(225);
				((StmtContext)_localctx).LP = match(LP);
				setState(226);
				exp(0);
				setState(227);
				stmt();

				                System.err.println("Error type B at Line " + (((StmtContext)_localctx).LP!=null?((StmtContext)_localctx).LP.getLine():0) + ": Missing closing parenthesis \')\'");
				            
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(230);
				match(IF);
				setState(231);
				exp(0);
				setState(232);
				((StmtContext)_localctx).RP = match(RP);
				setState(233);
				stmt();

				                System.err.println("Error type B at Line " + (((StmtContext)_localctx).RP!=null?((StmtContext)_localctx).RP.getLine():0) + ": Missing opening parenthesis \'(\'");
				            
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(236);
				match(WHILE);
				setState(237);
				((StmtContext)_localctx).LP = match(LP);
				setState(238);
				exp(0);
				setState(239);
				stmt();

				                System.err.println("Error type B at Line " + (((StmtContext)_localctx).LP!=null?((StmtContext)_localctx).LP.getLine():0) + ": Missing closing parenthesis \')\'");
				            
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(242);
				match(WHILE);
				setState(243);
				exp(0);
				setState(244);
				((StmtContext)_localctx).RP = match(RP);
				setState(245);
				stmt();

				                System.err.println("Error type B at Line " + (((StmtContext)_localctx).RP!=null?((StmtContext)_localctx).RP.getLine():0) + ": Missing opening parenthesis \'(\'");
				            
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefListContext extends ParserRuleContext {
		public DefContext def() {
			return getRuleContext(DefContext.class,0);
		}
		public DefListContext defList() {
			return getRuleContext(DefListContext.class,0);
		}
		public DefListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).enterDefList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).exitDefList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof splVisitor ) return ((splVisitor<? extends T>)visitor).visitDefList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefListContext defList() throws RecognitionException {
		DefListContext _localctx = new DefListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_defList);
		try {
			setState(255);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(252);
				def();
				setState(253);
				defList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefContext extends ParserRuleContext {
		public SpecifierContext specifier;
		public DecListContext decList;
		public Token LP;
		public SpecifierContext specifier() {
			return getRuleContext(SpecifierContext.class,0);
		}
		public DecListContext decList() {
			return getRuleContext(DecListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(splParser.SEMI, 0); }
		public TerminalNode IF() { return getToken(splParser.IF, 0); }
		public TerminalNode LP() { return getToken(splParser.LP, 0); }
		public TerminalNode RP() { return getToken(splParser.RP, 0); }
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).enterDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).exitDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof splVisitor ) return ((splVisitor<? extends T>)visitor).visitDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_def);
		try {
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(257);
				specifier();
				setState(258);
				decList();
				setState(259);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
				((DefContext)_localctx).specifier = specifier();
				setState(262);
				decList();

				                System.err.println("Error type B at Line " + (((DefContext)_localctx).specifier!=null?(((DefContext)_localctx).specifier.start):null).getLine() + ": Missing semicolon \';\'");
				            
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(265);
				((DefContext)_localctx).decList = decList();
				setState(266);
				match(SEMI);

				                                           System.err.println("Error type B at Line " + (((DefContext)_localctx).decList!=null?(((DefContext)_localctx).decList.start):null).getLine() + ": Missing specifier");
				                                       
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(269);
				match(IF);
				setState(270);
				((DefContext)_localctx).LP = match(LP);
				setState(271);
				match(RP);

				 System.err.println("Error type B at Line " + ((DefContext)_localctx).LP.getLine() + ": Missing specifier");
				                                                                                           
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

	@SuppressWarnings("CheckReturnValue")
	public static class DecListContext extends ParserRuleContext {
		public DecContext dec() {
			return getRuleContext(DecContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(splParser.COMMA, 0); }
		public DecListContext decList() {
			return getRuleContext(DecListContext.class,0);
		}
		public DecListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).enterDecList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).exitDecList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof splVisitor ) return ((splVisitor<? extends T>)visitor).visitDecList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecListContext decList() throws RecognitionException {
		DecListContext _localctx = new DecListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_decList);
		try {
			setState(280);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(275);
				dec();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(276);
				dec();
				setState(277);
				match(COMMA);
				setState(278);
				decList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DecContext extends ParserRuleContext {
		public VarDecContext varDec() {
			return getRuleContext(VarDecContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(splParser.ASSIGN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).enterDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).exitDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof splVisitor ) return ((splVisitor<? extends T>)visitor).visitDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_dec);
		try {
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(282);
				varDec(0);
				setState(283);
				match(ASSIGN);
				setState(284);
				exp(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				varDec(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpContext extends ParserRuleContext {
		public Token LP;
		public Token RP;
		public Token MINUS;
		public Token ASSIGN;
		public Token MUL;
		public Token DIV;
		public Token PLUS;
		public Token LB;
		public Token DOT;
		public TerminalNode LP() { return getToken(splParser.LP, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode RP() { return getToken(splParser.RP, 0); }
		public TerminalNode MINUS() { return getToken(splParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(splParser.NOT, 0); }
		public TerminalNode ID() { return getToken(splParser.ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode INT() { return getToken(splParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(splParser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(splParser.CHAR, 0); }
		public TerminalNode INVALID_ID() { return getToken(splParser.INVALID_ID, 0); }
		public TerminalNode INVALID_EXP() { return getToken(splParser.INVALID_EXP, 0); }
		public TerminalNode INVALID_CHAR() { return getToken(splParser.INVALID_CHAR, 0); }
		public TerminalNode ASSIGN() { return getToken(splParser.ASSIGN, 0); }
		public TerminalNode MUL() { return getToken(splParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(splParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(splParser.PLUS, 0); }
		public TerminalNode NE() { return getToken(splParser.NE, 0); }
		public TerminalNode EQ() { return getToken(splParser.EQ, 0); }
		public TerminalNode LT() { return getToken(splParser.LT, 0); }
		public TerminalNode LE() { return getToken(splParser.LE, 0); }
		public TerminalNode GT() { return getToken(splParser.GT, 0); }
		public TerminalNode GE() { return getToken(splParser.GE, 0); }
		public TerminalNode AND() { return getToken(splParser.AND, 0); }
		public TerminalNode OR() { return getToken(splParser.OR, 0); }
		public TerminalNode LB() { return getToken(splParser.LB, 0); }
		public TerminalNode RB() { return getToken(splParser.RB, 0); }
		public TerminalNode DOT() { return getToken(splParser.DOT, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof splVisitor ) return ((splVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_exp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(290);
				((ExpContext)_localctx).LP = match(LP);
				setState(291);
				exp(0);
				setState(292);
				((ExpContext)_localctx).RP = match(RP);
				}
				break;
			case 2:
				{
				setState(294);
				((ExpContext)_localctx).MINUS = match(MINUS);
				setState(295);
				exp(23);
				}
				break;
			case 3:
				{
				setState(296);
				match(NOT);
				setState(297);
				exp(22);
				}
				break;
			case 4:
				{
				setState(298);
				match(ID);
				setState(299);
				((ExpContext)_localctx).LP = match(LP);
				setState(300);
				args();
				setState(302);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(301);
					((ExpContext)_localctx).RP = match(RP);
					}
					break;
				}

				                                          if (((ExpContext)_localctx).RP == null) {
				                                                                            System.err.println("Error type B at Line " + (((ExpContext)_localctx).LP!=null?((ExpContext)_localctx).LP.getLine():0) + ": Missing closing parenthesis ')'");
				                                                                        }
				                                       
				}
				break;
			case 5:
				{
				setState(306);
				match(ID);
				setState(307);
				((ExpContext)_localctx).LP = match(LP);
				setState(308);
				((ExpContext)_localctx).RP = match(RP);
				}
				break;
			case 6:
				{
				setState(309);
				match(INT);
				}
				break;
			case 7:
				{
				setState(310);
				match(FLOAT);
				}
				break;
			case 8:
				{
				setState(311);
				match(CHAR);
				}
				break;
			case 9:
				{
				setState(312);
				match(ID);
				}
				break;
			case 10:
				{
				setState(313);
				((ExpContext)_localctx).LP = match(LP);
				setState(314);
				exp(8);

				                System.err.println("Error type B at Line " + (((ExpContext)_localctx).LP!=null?((ExpContext)_localctx).LP.getLine():0) + ": Missing closing parenthesis \')\'");
				            
				}
				break;
			case 11:
				{
				setState(317);
				match(ID);
				setState(318);
				((ExpContext)_localctx).LP = match(LP);
				setState(319);
				args();

				                System.err.println("Error type B at Line " + (((ExpContext)_localctx).LP!=null?((ExpContext)_localctx).LP.getLine():0) + ": Missing closing parenthesis \')\'");
				            
				}
				break;
			case 12:
				{
				setState(322);
				match(ID);
				setState(323);
				((ExpContext)_localctx).LP = match(LP);

				                System.err.println("Error type B at Line " + (((ExpContext)_localctx).LP!=null?((ExpContext)_localctx).LP.getLine():0) + ": Missing closing parenthesis \')\'");
				            
				}
				break;
			case 13:
				{
				setState(325);
				match(INVALID_ID);
				}
				break;
			case 14:
				{
				setState(326);
				match(INVALID_EXP);
				}
				break;
			case 15:
				{
				setState(327);
				match(INVALID_CHAR);
				}
				break;
			case 16:
				{
				setState(328);
				((ExpContext)_localctx).ASSIGN = match(ASSIGN);
				setState(329);
				exp(1);
				 System.err.println("Error type B at Line " + (((ExpContext)_localctx).ASSIGN!=null?((ExpContext)_localctx).ASSIGN.getLine():0) + ": Unexpected statement");
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(412);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(410);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(334);
						if (!(precpred(_ctx, 40))) throw new FailedPredicateException(this, "precpred(_ctx, 40)");
						setState(335);
						((ExpContext)_localctx).MUL = match(MUL);
						setState(336);
						exp(41);
						}
						break;
					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(337);
						if (!(precpred(_ctx, 39))) throw new FailedPredicateException(this, "precpred(_ctx, 39)");
						setState(338);
						((ExpContext)_localctx).DIV = match(DIV);
						setState(339);
						exp(40);
						}
						break;
					case 3:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(340);
						if (!(precpred(_ctx, 36))) throw new FailedPredicateException(this, "precpred(_ctx, 36)");
						setState(341);
						((ExpContext)_localctx).PLUS = match(PLUS);
						setState(342);
						exp(37);
						}
						break;
					case 4:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(343);
						if (!(precpred(_ctx, 35))) throw new FailedPredicateException(this, "precpred(_ctx, 35)");
						setState(344);
						((ExpContext)_localctx).MINUS = match(MINUS);
						setState(345);
						exp(36);
						}
						break;
					case 5:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(346);
						if (!(precpred(_ctx, 32))) throw new FailedPredicateException(this, "precpred(_ctx, 32)");
						setState(347);
						match(NE);
						setState(348);
						exp(33);
						}
						break;
					case 6:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(349);
						if (!(precpred(_ctx, 31))) throw new FailedPredicateException(this, "precpred(_ctx, 31)");
						setState(350);
						match(EQ);
						setState(351);
						exp(32);
						}
						break;
					case 7:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(352);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(353);
						match(LT);
						setState(354);
						exp(31);
						}
						break;
					case 8:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(355);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(356);
						match(LE);
						setState(357);
						exp(30);
						}
						break;
					case 9:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(358);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(359);
						match(GT);
						setState(360);
						exp(29);
						}
						break;
					case 10:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(361);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(362);
						match(GE);
						setState(363);
						exp(28);
						}
						break;
					case 11:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(364);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(365);
						match(AND);
						setState(366);
						exp(27);
						}
						break;
					case 12:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(367);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(368);
						match(OR);
						setState(369);
						exp(26);
						}
						break;
					case 13:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(370);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(371);
						((ExpContext)_localctx).LB = match(LB);
						setState(372);
						exp(19);

						                                                     System.err.println("Error type B at Line " + (((ExpContext)_localctx).LB!=null?((ExpContext)_localctx).LB.getLine():0) + ": Missing closing bracket \']\'");
						                                                 
						}
						break;
					case 14:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(375);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(376);
						((ExpContext)_localctx).ASSIGN = match(ASSIGN);
						setState(377);
						exp(15);
						}
						break;
					case 15:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(378);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(379);
						match(INVALID_EXP);
						setState(380);
						exp(4);
						}
						break;
					case 16:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(381);
						if (!(precpred(_ctx, 38))) throw new FailedPredicateException(this, "precpred(_ctx, 38)");
						setState(382);
						((ExpContext)_localctx).MUL = match(MUL);
						System.err.println("Error type B at Line " + (((ExpContext)_localctx).MUL!=null?((ExpContext)_localctx).MUL.getLine():0) + ": Missing Exp after *");
						}
						break;
					case 17:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(384);
						if (!(precpred(_ctx, 37))) throw new FailedPredicateException(this, "precpred(_ctx, 37)");
						setState(385);
						((ExpContext)_localctx).DIV = match(DIV);
						System.err.println("Error type B at Line " + (((ExpContext)_localctx).DIV!=null?((ExpContext)_localctx).DIV.getLine():0) + ": Missing Exp after /");
						}
						break;
					case 18:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(387);
						if (!(precpred(_ctx, 34))) throw new FailedPredicateException(this, "precpred(_ctx, 34)");
						setState(388);
						((ExpContext)_localctx).PLUS = match(PLUS);
						System.err.println("Error type B at Line " + (((ExpContext)_localctx).PLUS!=null?((ExpContext)_localctx).PLUS.getLine():0) + ": Missing Exp after +");
						}
						break;
					case 19:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(390);
						if (!(precpred(_ctx, 33))) throw new FailedPredicateException(this, "precpred(_ctx, 33)");
						setState(391);
						((ExpContext)_localctx).MINUS = match(MINUS);
						System.err.println("Error type B at Line " + (((ExpContext)_localctx).MINUS!=null?((ExpContext)_localctx).MINUS.getLine():0) + ": Missing Exp after -");
						}
						break;
					case 20:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(393);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(394);
						((ExpContext)_localctx).LB = match(LB);
						setState(395);
						exp(0);
						setState(396);
						match(RB);
						}
						break;
					case 21:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(398);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(399);
						((ExpContext)_localctx).LB = match(LB);

						                                                     System.err.println("Error type B at Line " + (((ExpContext)_localctx).LB!=null?((ExpContext)_localctx).LB.getLine():0) + ": Missing closing bracket \']\'");
						                                                 
						}
						break;
					case 22:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(401);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(402);
						((ExpContext)_localctx).DOT = match(DOT);
						setState(403);
						match(ID);
						}
						break;
					case 23:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(404);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(405);
						((ExpContext)_localctx).DOT = match(DOT);
						  System.err.println("Error type B at Line " + (((ExpContext)_localctx).DOT!=null?((ExpContext)_localctx).DOT.getLine():0) + ": Missing field name");
						}
						break;
					case 24:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(407);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(408);
						((ExpContext)_localctx).ASSIGN = match(ASSIGN);
						System.err.println("Error type B at Line " + ((ExpContext)_localctx).ASSIGN.getLine() + ": Missing value");
						}
						break;
					}
					} 
				}
				setState(414);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgsContext extends ParserRuleContext {
		public Token COMMA;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(splParser.COMMA, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof splListener ) ((splListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof splVisitor ) return ((splVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_args);
		try {
			setState(424);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(415);
				exp(0);
				setState(416);
				match(COMMA);
				setState(417);
				args();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(419);
				exp(0);
				setState(420);
				((ArgsContext)_localctx).COMMA = match(COMMA);
				System.err.println("Error type B at Line " + (((ArgsContext)_localctx).COMMA!=null?((ArgsContext)_localctx).COMMA.getLine():0) + ": Missing arguments");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(423);
				exp(0);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return varDec_sempred((VarDecContext)_localctx, predIndex);
		case 17:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean varDec_sempred(VarDecContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 40);
		case 3:
			return precpred(_ctx, 39);
		case 4:
			return precpred(_ctx, 36);
		case 5:
			return precpred(_ctx, 35);
		case 6:
			return precpred(_ctx, 32);
		case 7:
			return precpred(_ctx, 31);
		case 8:
			return precpred(_ctx, 30);
		case 9:
			return precpred(_ctx, 29);
		case 10:
			return precpred(_ctx, 28);
		case 11:
			return precpred(_ctx, 27);
		case 12:
			return precpred(_ctx, 26);
		case 13:
			return precpred(_ctx, 25);
		case 14:
			return precpred(_ctx, 18);
		case 15:
			return precpred(_ctx, 14);
		case 16:
			return precpred(_ctx, 3);
		case 17:
			return precpred(_ctx, 38);
		case 18:
			return precpred(_ctx, 37);
		case 19:
			return precpred(_ctx, 34);
		case 20:
			return precpred(_ctx, 33);
		case 21:
			return precpred(_ctx, 19);
		case 22:
			return precpred(_ctx, 17);
		case 23:
			return precpred(_ctx, 16);
		case 24:
			return precpred(_ctx, 15);
		case 25:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001)\u01ab\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001-\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002E\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"V\b\u0003\u0001\u0004\u0001\u0004\u0003\u0004Z\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005j\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006o\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006y\b\u0006\n\u0006"+
		"\f\u0006|\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u008e\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\b\u0099\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00a4\b\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u00aa\b\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u00b2\b\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u00f9\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u0100\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u0112\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u0119\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u0120\b\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u012f"+
		"\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u014d"+
		"\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u019b"+
		"\b\u0011\n\u0011\f\u0011\u019e\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u01a9\b\u0012\u0001\u0012\u0000\u0002\f\"\u0013\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$\u0000\u0000\u01ed\u0000&\u0001\u0000\u0000\u0000\u0002,\u0001\u0000"+
		"\u0000\u0000\u0004D\u0001\u0000\u0000\u0000\u0006U\u0001\u0000\u0000\u0000"+
		"\bY\u0001\u0000\u0000\u0000\ni\u0001\u0000\u0000\u0000\fn\u0001\u0000"+
		"\u0000\u0000\u000e\u008d\u0001\u0000\u0000\u0000\u0010\u0098\u0001\u0000"+
		"\u0000\u0000\u0012\u00a3\u0001\u0000\u0000\u0000\u0014\u00a5\u0001\u0000"+
		"\u0000\u0000\u0016\u00b1\u0001\u0000\u0000\u0000\u0018\u00f8\u0001\u0000"+
		"\u0000\u0000\u001a\u00ff\u0001\u0000\u0000\u0000\u001c\u0111\u0001\u0000"+
		"\u0000\u0000\u001e\u0118\u0001\u0000\u0000\u0000 \u011f\u0001\u0000\u0000"+
		"\u0000\"\u014c\u0001\u0000\u0000\u0000$\u01a8\u0001\u0000\u0000\u0000"+
		"&\'\u0003\u0002\u0001\u0000\'\u0001\u0001\u0000\u0000\u0000()\u0003\u0004"+
		"\u0002\u0000)*\u0003\u0002\u0001\u0000*-\u0001\u0000\u0000\u0000+-\u0001"+
		"\u0000\u0000\u0000,(\u0001\u0000\u0000\u0000,+\u0001\u0000\u0000\u0000"+
		"-\u0003\u0001\u0000\u0000\u0000./\u0003\b\u0004\u0000/0\u0003\u0006\u0003"+
		"\u000001\u0005\b\u0000\u00001E\u0001\u0000\u0000\u000023\u0003\b\u0004"+
		"\u000034\u0005\b\u0000\u00004E\u0001\u0000\u0000\u000056\u0003\b\u0004"+
		"\u000067\u0003\u000e\u0007\u000078\u0003\u0014\n\u00008E\u0001\u0000\u0000"+
		"\u00009:\u0003\b\u0004\u0000:;\u0003\u0006\u0003\u0000;<\u0006\u0002\uffff"+
		"\uffff\u0000<E\u0001\u0000\u0000\u0000=>\u0003\b\u0004\u0000>?\u0006\u0002"+
		"\uffff\uffff\u0000?E\u0001\u0000\u0000\u0000@A\u0003\u0006\u0003\u0000"+
		"AB\u0005\b\u0000\u0000BC\u0006\u0002\uffff\uffff\u0000CE\u0001\u0000\u0000"+
		"\u0000D.\u0001\u0000\u0000\u0000D2\u0001\u0000\u0000\u0000D5\u0001\u0000"+
		"\u0000\u0000D9\u0001\u0000\u0000\u0000D=\u0001\u0000\u0000\u0000D@\u0001"+
		"\u0000\u0000\u0000E\u0005\u0001\u0000\u0000\u0000FV\u0003\f\u0006\u0000"+
		"GH\u0003\f\u0006\u0000HI\u0005\t\u0000\u0000IJ\u0003\u0006\u0003\u0000"+
		"JV\u0001\u0000\u0000\u0000KL\u0003\f\u0006\u0000LM\u0005\t\u0000\u0000"+
		"MN\u0006\u0003\uffff\uffff\u0000NV\u0001\u0000\u0000\u0000OP\u0003\f\u0006"+
		"\u0000PQ\u0005\t\u0000\u0000QR\u0005\t\u0000\u0000RS\u0003\u0006\u0003"+
		"\u0000ST\u0006\u0003\uffff\uffff\u0000TV\u0001\u0000\u0000\u0000UF\u0001"+
		"\u0000\u0000\u0000UG\u0001\u0000\u0000\u0000UK\u0001\u0000\u0000\u0000"+
		"UO\u0001\u0000\u0000\u0000V\u0007\u0001\u0000\u0000\u0000WZ\u0005\u0001"+
		"\u0000\u0000XZ\u0003\n\u0005\u0000YW\u0001\u0000\u0000\u0000YX\u0001\u0000"+
		"\u0000\u0000Z\t\u0001\u0000\u0000\u0000[\\\u0005\u0002\u0000\u0000\\]"+
		"\u0005 \u0000\u0000]^\u0005\u001c\u0000\u0000^_\u0003\u001a\r\u0000_`"+
		"\u0005\u001d\u0000\u0000`j\u0001\u0000\u0000\u0000ab\u0005\u0002\u0000"+
		"\u0000bj\u0005 \u0000\u0000cd\u0005\u0002\u0000\u0000de\u0005 \u0000\u0000"+
		"ef\u0005\u001c\u0000\u0000fg\u0003\u001a\r\u0000gh\u0006\u0005\uffff\uffff"+
		"\u0000hj\u0001\u0000\u0000\u0000i[\u0001\u0000\u0000\u0000ia\u0001\u0000"+
		"\u0000\u0000ic\u0001\u0000\u0000\u0000j\u000b\u0001\u0000\u0000\u0000"+
		"kl\u0006\u0006\uffff\uffff\u0000lo\u0005 \u0000\u0000mo\u0005(\u0000\u0000"+
		"nk\u0001\u0000\u0000\u0000nm\u0001\u0000\u0000\u0000oz\u0001\u0000\u0000"+
		"\u0000pq\n\u0003\u0000\u0000qr\u0005\u001a\u0000\u0000rs\u0005\u001e\u0000"+
		"\u0000sy\u0005\u001b\u0000\u0000tu\n\u0002\u0000\u0000uv\u0005\u001a\u0000"+
		"\u0000vw\u0005\u001e\u0000\u0000wy\u0006\u0006\uffff\uffff\u0000xp\u0001"+
		"\u0000\u0000\u0000xt\u0001\u0000\u0000\u0000y|\u0001\u0000\u0000\u0000"+
		"zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{\r\u0001\u0000\u0000"+
		"\u0000|z\u0001\u0000\u0000\u0000}~\u0005 \u0000\u0000~\u007f\u0005\u0018"+
		"\u0000\u0000\u007f\u0080\u0003\u0010\b\u0000\u0080\u0081\u0005\u0019\u0000"+
		"\u0000\u0081\u008e\u0001\u0000\u0000\u0000\u0082\u0083\u0005 \u0000\u0000"+
		"\u0083\u0084\u0005\u0018\u0000\u0000\u0084\u008e\u0005\u0019\u0000\u0000"+
		"\u0085\u0086\u0005 \u0000\u0000\u0086\u0087\u0005\u0018\u0000\u0000\u0087"+
		"\u0088\u0003\u0010\b\u0000\u0088\u0089\u0006\u0007\uffff\uffff\u0000\u0089"+
		"\u008e\u0001\u0000\u0000\u0000\u008a\u008b\u0005 \u0000\u0000\u008b\u008c"+
		"\u0005\u0018\u0000\u0000\u008c\u008e\u0006\u0007\uffff\uffff\u0000\u008d"+
		"}\u0001\u0000\u0000\u0000\u008d\u0082\u0001\u0000\u0000\u0000\u008d\u0085"+
		"\u0001\u0000\u0000\u0000\u008d\u008a\u0001\u0000\u0000\u0000\u008e\u000f"+
		"\u0001\u0000\u0000\u0000\u008f\u0090\u0003\u0012\t\u0000\u0090\u0091\u0005"+
		"\t\u0000\u0000\u0091\u0092\u0003\u0010\b\u0000\u0092\u0099\u0001\u0000"+
		"\u0000\u0000\u0093\u0099\u0003\u0012\t\u0000\u0094\u0095\u0003\u0012\t"+
		"\u0000\u0095\u0096\u0005\t\u0000\u0000\u0096\u0097\u0006\b\uffff\uffff"+
		"\u0000\u0097\u0099\u0001\u0000\u0000\u0000\u0098\u008f\u0001\u0000\u0000"+
		"\u0000\u0098\u0093\u0001\u0000\u0000\u0000\u0098\u0094\u0001\u0000\u0000"+
		"\u0000\u0099\u0011\u0001\u0000\u0000\u0000\u009a\u009b\u0003\b\u0004\u0000"+
		"\u009b\u009c\u0003\f\u0006\u0000\u009c\u00a4\u0001\u0000\u0000\u0000\u009d"+
		"\u009e\u0003\f\u0006\u0000\u009e\u009f\u0006\t\uffff\uffff\u0000\u009f"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a0\u00a1\u0003\b\u0004\u0000\u00a1\u00a2"+
		"\u0006\t\uffff\uffff\u0000\u00a2\u00a4\u0001\u0000\u0000\u0000\u00a3\u009a"+
		"\u0001\u0000\u0000\u0000\u00a3\u009d\u0001\u0000\u0000\u0000\u00a3\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a4\u0013\u0001\u0000\u0000\u0000\u00a5\u00a6"+
		"\u0005\u001c\u0000\u0000\u00a6\u00a7\u0003\u001a\r\u0000\u00a7\u00a9\u0003"+
		"\u0016\u000b\u0000\u00a8\u00aa\u0005\u001d\u0000\u0000\u00a9\u00a8\u0001"+
		"\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ac\u0006\n\uffff\uffff\u0000\u00ac\u0015\u0001"+
		"\u0000\u0000\u0000\u00ad\u00ae\u0003\u0018\f\u0000\u00ae\u00af\u0003\u0016"+
		"\u000b\u0000\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b1\u00ad\u0001\u0000\u0000\u0000\u00b1\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b2\u0017\u0001\u0000\u0000\u0000\u00b3\u00b4\u0003\"\u0011"+
		"\u0000\u00b4\u00b5\u0005\b\u0000\u0000\u00b5\u00f9\u0001\u0000\u0000\u0000"+
		"\u00b6\u00f9\u0003\u0014\n\u0000\u00b7\u00b8\u0005\u0006\u0000\u0000\u00b8"+
		"\u00b9\u0003\"\u0011\u0000\u00b9\u00ba\u0005\b\u0000\u0000\u00ba\u00f9"+
		"\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005\u0003\u0000\u0000\u00bc\u00bd"+
		"\u0005\u0018\u0000\u0000\u00bd\u00be\u0003\"\u0011\u0000\u00be\u00bf\u0005"+
		"\u0019\u0000\u0000\u00bf\u00c0\u0003\u0018\f\u0000\u00c0\u00c1\u0005\u0004"+
		"\u0000\u0000\u00c1\u00c2\u0003\u0018\f\u0000\u00c2\u00f9\u0001\u0000\u0000"+
		"\u0000\u00c3\u00c4\u0005\u0003\u0000\u0000\u00c4\u00c5\u0005\u0018\u0000"+
		"\u0000\u00c5\u00c6\u0003\"\u0011\u0000\u00c6\u00c7\u0005\u0019\u0000\u0000"+
		"\u00c7\u00c8\u0003\u0018\f\u0000\u00c8\u00f9\u0001\u0000\u0000\u0000\u00c9"+
		"\u00ca\u0005\u0004\u0000\u0000\u00ca\u00cb\u0003\u0018\f\u0000\u00cb\u00cc"+
		"\u0006\f\uffff\uffff\u0000\u00cc\u00f9\u0001\u0000\u0000\u0000\u00cd\u00ce"+
		"\u0005\u0005\u0000\u0000\u00ce\u00cf\u0005\u0018\u0000\u0000\u00cf\u00d0"+
		"\u0003\"\u0011\u0000\u00d0\u00d1\u0005\u0019\u0000\u0000\u00d1\u00d2\u0003"+
		"\u0018\f\u0000\u00d2\u00f9\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005\u001f"+
		"\u0000\u0000\u00d4\u00d5\u0005\u0018\u0000\u0000\u00d5\u00d6\u0003\"\u0011"+
		"\u0000\u00d6\u00d7\u0005\u0019\u0000\u0000\u00d7\u00d8\u0005\b\u0000\u0000"+
		"\u00d8\u00f9\u0001\u0000\u0000\u0000\u00d9\u00da\u0003\"\u0011\u0000\u00da"+
		"\u00db\u0006\f\uffff\uffff\u0000\u00db\u00f9\u0001\u0000\u0000\u0000\u00dc"+
		"\u00dd\u0005\u0006\u0000\u0000\u00dd\u00de\u0003\"\u0011\u0000\u00de\u00df"+
		"\u0006\f\uffff\uffff\u0000\u00df\u00f9\u0001\u0000\u0000\u0000\u00e0\u00e1"+
		"\u0005\u0003\u0000\u0000\u00e1\u00e2\u0005\u0018\u0000\u0000\u00e2\u00e3"+
		"\u0003\"\u0011\u0000\u00e3\u00e4\u0003\u0018\f\u0000\u00e4\u00e5\u0006"+
		"\f\uffff\uffff\u0000\u00e5\u00f9\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005"+
		"\u0003\u0000\u0000\u00e7\u00e8\u0003\"\u0011\u0000\u00e8\u00e9\u0005\u0019"+
		"\u0000\u0000\u00e9\u00ea\u0003\u0018\f\u0000\u00ea\u00eb\u0006\f\uffff"+
		"\uffff\u0000\u00eb\u00f9\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005\u0005"+
		"\u0000\u0000\u00ed\u00ee\u0005\u0018\u0000\u0000\u00ee\u00ef\u0003\"\u0011"+
		"\u0000\u00ef\u00f0\u0003\u0018\f\u0000\u00f0\u00f1\u0006\f\uffff\uffff"+
		"\u0000\u00f1\u00f9\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005\u0005\u0000"+
		"\u0000\u00f3\u00f4\u0003\"\u0011\u0000\u00f4\u00f5\u0005\u0019\u0000\u0000"+
		"\u00f5\u00f6\u0003\u0018\f\u0000\u00f6\u00f7\u0006\f\uffff\uffff\u0000"+
		"\u00f7\u00f9\u0001\u0000\u0000\u0000\u00f8\u00b3\u0001\u0000\u0000\u0000"+
		"\u00f8\u00b6\u0001\u0000\u0000\u0000\u00f8\u00b7\u0001\u0000\u0000\u0000"+
		"\u00f8\u00bb\u0001\u0000\u0000\u0000\u00f8\u00c3\u0001\u0000\u0000\u0000"+
		"\u00f8\u00c9\u0001\u0000\u0000\u0000\u00f8\u00cd\u0001\u0000\u0000\u0000"+
		"\u00f8\u00d3\u0001\u0000\u0000\u0000\u00f8\u00d9\u0001\u0000\u0000\u0000"+
		"\u00f8\u00dc\u0001\u0000\u0000\u0000\u00f8\u00e0\u0001\u0000\u0000\u0000"+
		"\u00f8\u00e6\u0001\u0000\u0000\u0000\u00f8\u00ec\u0001\u0000\u0000\u0000"+
		"\u00f8\u00f2\u0001\u0000\u0000\u0000\u00f9\u0019\u0001\u0000\u0000\u0000"+
		"\u00fa\u0100\u0001\u0000\u0000\u0000\u00fb\u0100\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fd\u0003\u001c\u000e\u0000\u00fd\u00fe\u0003\u001a\r\u0000\u00fe"+
		"\u0100\u0001\u0000\u0000\u0000\u00ff\u00fa\u0001\u0000\u0000\u0000\u00ff"+
		"\u00fb\u0001\u0000\u0000\u0000\u00ff\u00fc\u0001\u0000\u0000\u0000\u0100"+
		"\u001b\u0001\u0000\u0000\u0000\u0101\u0102\u0003\b\u0004\u0000\u0102\u0103"+
		"\u0003\u001e\u000f\u0000\u0103\u0104\u0005\b\u0000\u0000\u0104\u0112\u0001"+
		"\u0000\u0000\u0000\u0105\u0106\u0003\b\u0004\u0000\u0106\u0107\u0003\u001e"+
		"\u000f\u0000\u0107\u0108\u0006\u000e\uffff\uffff\u0000\u0108\u0112\u0001"+
		"\u0000\u0000\u0000\u0109\u010a\u0003\u001e\u000f\u0000\u010a\u010b\u0005"+
		"\b\u0000\u0000\u010b\u010c\u0006\u000e\uffff\uffff\u0000\u010c\u0112\u0001"+
		"\u0000\u0000\u0000\u010d\u010e\u0005\u0003\u0000\u0000\u010e\u010f\u0005"+
		"\u0018\u0000\u0000\u010f\u0110\u0005\u0019\u0000\u0000\u0110\u0112\u0006"+
		"\u000e\uffff\uffff\u0000\u0111\u0101\u0001\u0000\u0000\u0000\u0111\u0105"+
		"\u0001\u0000\u0000\u0000\u0111\u0109\u0001\u0000\u0000\u0000\u0111\u010d"+
		"\u0001\u0000\u0000\u0000\u0112\u001d\u0001\u0000\u0000\u0000\u0113\u0119"+
		"\u0003 \u0010\u0000\u0114\u0115\u0003 \u0010\u0000\u0115\u0116\u0005\t"+
		"\u0000\u0000\u0116\u0117\u0003\u001e\u000f\u0000\u0117\u0119\u0001\u0000"+
		"\u0000\u0000\u0118\u0113\u0001\u0000\u0000\u0000\u0118\u0114\u0001\u0000"+
		"\u0000\u0000\u0119\u001f\u0001\u0000\u0000\u0000\u011a\u011b\u0003\f\u0006"+
		"\u0000\u011b\u011c\u0005\n\u0000\u0000\u011c\u011d\u0003\"\u0011\u0000"+
		"\u011d\u0120\u0001\u0000\u0000\u0000\u011e\u0120\u0003\f\u0006\u0000\u011f"+
		"\u011a\u0001\u0000\u0000\u0000\u011f\u011e\u0001\u0000\u0000\u0000\u0120"+
		"!\u0001\u0000\u0000\u0000\u0121\u0122\u0006\u0011\uffff\uffff\u0000\u0122"+
		"\u0123\u0005\u0018\u0000\u0000\u0123\u0124\u0003\"\u0011\u0000\u0124\u0125"+
		"\u0005\u0019\u0000\u0000\u0125\u014d\u0001\u0000\u0000\u0000\u0126\u0127"+
		"\u0005\u0012\u0000\u0000\u0127\u014d\u0003\"\u0011\u0017\u0128\u0129\u0005"+
		"\u0017\u0000\u0000\u0129\u014d\u0003\"\u0011\u0016\u012a\u012b\u0005 "+
		"\u0000\u0000\u012b\u012c\u0005\u0018\u0000\u0000\u012c\u012e\u0003$\u0012"+
		"\u0000\u012d\u012f\u0005\u0019\u0000\u0000\u012e\u012d\u0001\u0000\u0000"+
		"\u0000\u012e\u012f\u0001\u0000\u0000\u0000\u012f\u0130\u0001\u0000\u0000"+
		"\u0000\u0130\u0131\u0006\u0011\uffff\uffff\u0000\u0131\u014d\u0001\u0000"+
		"\u0000\u0000\u0132\u0133\u0005 \u0000\u0000\u0133\u0134\u0005\u0018\u0000"+
		"\u0000\u0134\u014d\u0005\u0019\u0000\u0000\u0135\u014d\u0005\u001e\u0000"+
		"\u0000\u0136\u014d\u0005!\u0000\u0000\u0137\u014d\u0005\"\u0000\u0000"+
		"\u0138\u014d\u0005 \u0000\u0000\u0139\u013a\u0005\u0018\u0000\u0000\u013a"+
		"\u013b\u0003\"\u0011\b\u013b\u013c\u0006\u0011\uffff\uffff\u0000\u013c"+
		"\u014d\u0001\u0000\u0000\u0000\u013d\u013e\u0005 \u0000\u0000\u013e\u013f"+
		"\u0005\u0018\u0000\u0000\u013f\u0140\u0003$\u0012\u0000\u0140\u0141\u0006"+
		"\u0011\uffff\uffff\u0000\u0141\u014d\u0001\u0000\u0000\u0000\u0142\u0143"+
		"\u0005 \u0000\u0000\u0143\u0144\u0005\u0018\u0000\u0000\u0144\u014d\u0006"+
		"\u0011\uffff\uffff\u0000\u0145\u014d\u0005(\u0000\u0000\u0146\u014d\u0005"+
		")\u0000\u0000\u0147\u014d\u0005$\u0000\u0000\u0148\u0149\u0005\n\u0000"+
		"\u0000\u0149\u014a\u0003\"\u0011\u0001\u014a\u014b\u0006\u0011\uffff\uffff"+
		"\u0000\u014b\u014d\u0001\u0000\u0000\u0000\u014c\u0121\u0001\u0000\u0000"+
		"\u0000\u014c\u0126\u0001\u0000\u0000\u0000\u014c\u0128\u0001\u0000\u0000"+
		"\u0000\u014c\u012a\u0001\u0000\u0000\u0000\u014c\u0132\u0001\u0000\u0000"+
		"\u0000\u014c\u0135\u0001\u0000\u0000\u0000\u014c\u0136\u0001\u0000\u0000"+
		"\u0000\u014c\u0137\u0001\u0000\u0000\u0000\u014c\u0138\u0001\u0000\u0000"+
		"\u0000\u014c\u0139\u0001\u0000\u0000\u0000\u014c\u013d\u0001\u0000\u0000"+
		"\u0000\u014c\u0142\u0001\u0000\u0000\u0000\u014c\u0145\u0001\u0000\u0000"+
		"\u0000\u014c\u0146\u0001\u0000\u0000\u0000\u014c\u0147\u0001\u0000\u0000"+
		"\u0000\u014c\u0148\u0001\u0000\u0000\u0000\u014d\u019c\u0001\u0000\u0000"+
		"\u0000\u014e\u014f\n(\u0000\u0000\u014f\u0150\u0005\u0013\u0000\u0000"+
		"\u0150\u019b\u0003\"\u0011)\u0151\u0152\n\'\u0000\u0000\u0152\u0153\u0005"+
		"\u0014\u0000\u0000\u0153\u019b\u0003\"\u0011(\u0154\u0155\n$\u0000\u0000"+
		"\u0155\u0156\u0005\u0011\u0000\u0000\u0156\u019b\u0003\"\u0011%\u0157"+
		"\u0158\n#\u0000\u0000\u0158\u0159\u0005\u0012\u0000\u0000\u0159\u019b"+
		"\u0003\"\u0011$\u015a\u015b\n \u0000\u0000\u015b\u015c\u0005\u000f\u0000"+
		"\u0000\u015c\u019b\u0003\"\u0011!\u015d\u015e\n\u001f\u0000\u0000\u015e"+
		"\u015f\u0005\u0010\u0000\u0000\u015f\u019b\u0003\"\u0011 \u0160\u0161"+
		"\n\u001e\u0000\u0000\u0161\u0162\u0005\u000b\u0000\u0000\u0162\u019b\u0003"+
		"\"\u0011\u001f\u0163\u0164\n\u001d\u0000\u0000\u0164\u0165\u0005\f\u0000"+
		"\u0000\u0165\u019b\u0003\"\u0011\u001e\u0166\u0167\n\u001c\u0000\u0000"+
		"\u0167\u0168\u0005\r\u0000\u0000\u0168\u019b\u0003\"\u0011\u001d\u0169"+
		"\u016a\n\u001b\u0000\u0000\u016a\u016b\u0005\u000e\u0000\u0000\u016b\u019b"+
		"\u0003\"\u0011\u001c\u016c\u016d\n\u001a\u0000\u0000\u016d\u016e\u0005"+
		"\u0015\u0000\u0000\u016e\u019b\u0003\"\u0011\u001b\u016f\u0170\n\u0019"+
		"\u0000\u0000\u0170\u0171\u0005\u0016\u0000\u0000\u0171\u019b\u0003\"\u0011"+
		"\u001a\u0172\u0173\n\u0012\u0000\u0000\u0173\u0174\u0005\u001a\u0000\u0000"+
		"\u0174\u0175\u0003\"\u0011\u0013\u0175\u0176\u0006\u0011\uffff\uffff\u0000"+
		"\u0176\u019b\u0001\u0000\u0000\u0000\u0177\u0178\n\u000e\u0000\u0000\u0178"+
		"\u0179\u0005\n\u0000\u0000\u0179\u019b\u0003\"\u0011\u000f\u017a\u017b"+
		"\n\u0003\u0000\u0000\u017b\u017c\u0005)\u0000\u0000\u017c\u019b\u0003"+
		"\"\u0011\u0004\u017d\u017e\n&\u0000\u0000\u017e\u017f\u0005\u0013\u0000"+
		"\u0000\u017f\u019b\u0006\u0011\uffff\uffff\u0000\u0180\u0181\n%\u0000"+
		"\u0000\u0181\u0182\u0005\u0014\u0000\u0000\u0182\u019b\u0006\u0011\uffff"+
		"\uffff\u0000\u0183\u0184\n\"\u0000\u0000\u0184\u0185\u0005\u0011\u0000"+
		"\u0000\u0185\u019b\u0006\u0011\uffff\uffff\u0000\u0186\u0187\n!\u0000"+
		"\u0000\u0187\u0188\u0005\u0012\u0000\u0000\u0188\u019b\u0006\u0011\uffff"+
		"\uffff\u0000\u0189\u018a\n\u0013\u0000\u0000\u018a\u018b\u0005\u001a\u0000"+
		"\u0000\u018b\u018c\u0003\"\u0011\u0000\u018c\u018d\u0005\u001b\u0000\u0000"+
		"\u018d\u019b\u0001\u0000\u0000\u0000\u018e\u018f\n\u0011\u0000\u0000\u018f"+
		"\u0190\u0005\u001a\u0000\u0000\u0190\u019b\u0006\u0011\uffff\uffff\u0000"+
		"\u0191\u0192\n\u0010\u0000\u0000\u0192\u0193\u0005\u0007\u0000\u0000\u0193"+
		"\u019b\u0005 \u0000\u0000\u0194\u0195\n\u000f\u0000\u0000\u0195\u0196"+
		"\u0005\u0007\u0000\u0000\u0196\u019b\u0006\u0011\uffff\uffff\u0000\u0197"+
		"\u0198\n\r\u0000\u0000\u0198\u0199\u0005\n\u0000\u0000\u0199\u019b\u0006"+
		"\u0011\uffff\uffff\u0000\u019a\u014e\u0001\u0000\u0000\u0000\u019a\u0151"+
		"\u0001\u0000\u0000\u0000\u019a\u0154\u0001\u0000\u0000\u0000\u019a\u0157"+
		"\u0001\u0000\u0000\u0000\u019a\u015a\u0001\u0000\u0000\u0000\u019a\u015d"+
		"\u0001\u0000\u0000\u0000\u019a\u0160\u0001\u0000\u0000\u0000\u019a\u0163"+
		"\u0001\u0000\u0000\u0000\u019a\u0166\u0001\u0000\u0000\u0000\u019a\u0169"+
		"\u0001\u0000\u0000\u0000\u019a\u016c\u0001\u0000\u0000\u0000\u019a\u016f"+
		"\u0001\u0000\u0000\u0000\u019a\u0172\u0001\u0000\u0000\u0000\u019a\u0177"+
		"\u0001\u0000\u0000\u0000\u019a\u017a\u0001\u0000\u0000\u0000\u019a\u017d"+
		"\u0001\u0000\u0000\u0000\u019a\u0180\u0001\u0000\u0000\u0000\u019a\u0183"+
		"\u0001\u0000\u0000\u0000\u019a\u0186\u0001\u0000\u0000\u0000\u019a\u0189"+
		"\u0001\u0000\u0000\u0000\u019a\u018e\u0001\u0000\u0000\u0000\u019a\u0191"+
		"\u0001\u0000\u0000\u0000\u019a\u0194\u0001\u0000\u0000\u0000\u019a\u0197"+
		"\u0001\u0000\u0000\u0000\u019b\u019e\u0001\u0000\u0000\u0000\u019c\u019a"+
		"\u0001\u0000\u0000\u0000\u019c\u019d\u0001\u0000\u0000\u0000\u019d#\u0001"+
		"\u0000\u0000\u0000\u019e\u019c\u0001\u0000\u0000\u0000\u019f\u01a0\u0003"+
		"\"\u0011\u0000\u01a0\u01a1\u0005\t\u0000\u0000\u01a1\u01a2\u0003$\u0012"+
		"\u0000\u01a2\u01a9\u0001\u0000\u0000\u0000\u01a3\u01a4\u0003\"\u0011\u0000"+
		"\u01a4\u01a5\u0005\t\u0000\u0000\u01a5\u01a6\u0006\u0012\uffff\uffff\u0000"+
		"\u01a6\u01a9\u0001\u0000\u0000\u0000\u01a7\u01a9\u0003\"\u0011\u0000\u01a8"+
		"\u019f\u0001\u0000\u0000\u0000\u01a8\u01a3\u0001\u0000\u0000\u0000\u01a8"+
		"\u01a7\u0001\u0000\u0000\u0000\u01a9%\u0001\u0000\u0000\u0000\u0017,D"+
		"UYinxz\u008d\u0098\u00a3\u00a9\u00b1\u00f8\u00ff\u0111\u0118\u011f\u012e"+
		"\u014c\u019a\u019c\u01a8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}