// Generated from FefoLang.g4 by ANTLR 4.13.0
package fefolanguage.parser;

import java.util.Stack;
	import java.util.ArrayList;
	import fefolanguage.dataStructures.*;
	import fefolanguage.exceptions.FefoExceptions;
	import fefolanguage.ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class FefoLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, ASPAS=23, DECIMAL=24, 
		INTEIRO=25, BOOLEANO=26, TEXTO=27, ID=28, VIR=29, ACH=30, FCH=31, AP=32, 
		FP=33, PF=34, WS=35;
	public static final int
		RULE_prog = 0, RULE_bloco = 1, RULE_cmd = 2, RULE_cmdDeclaracao = 3, RULE_tipo = 4, 
		RULE_cmdLeitura = 5, RULE_cmdEscrita = 6, RULE_cmdCondicao = 7, RULE_cmdAtribuicao = 8, 
		RULE_opAtr = 9, RULE_opRel = 10, RULE_expr = 11, RULE_exprLinha = 12, 
		RULE_opExpr = 13, RULE_termo = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "bloco", "cmd", "cmdDeclaracao", "tipo", "cmdLeitura", "cmdEscrita", 
			"cmdCondicao", "cmdAtribuicao", "opAtr", "opRel", "expr", "exprLinha", 
			"opExpr", "termo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'inteiro'", "'decimal'", "'texto'", 
			"'booleano'", "'leia'", "'escreva'", "'se'", "'entao'", "'senao'", "':='", 
			"'<'", "'>'", "'<='", "'>='", "'!='", "'=='", "'+'", "'-'", "'*'", "'/'", 
			"'\"'", null, null, null, null, null, "','", "'{'", "'}'", "'('", "')'", 
			"'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "ASPAS", 
			"DECIMAL", "INTEIRO", "BOOLEANO", "TEXTO", "ID", "VIR", "ACH", "FCH", 
			"AP", "FP", "PF", "WS"
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
	public String getGrammarFileName() { return "FefoLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		private ArrayList<String> listaDeTokens = new ArrayList<String>();
		private ArrayList<String> listaDeVariaveis = new ArrayList<String>();
		
		private int _tipo;
		private String _varName;
		private boolean _varValue;
		private FefoSymbolTable _symbolTable = new FefoSymbolTable();
		private FefoSymbol _symbol;
		private int _tipoExprEsquerda;
		private int _tipoExprDireita;
		private FefoBinaryExpression _expressao = new FefoBinaryExpression();
		
		private FefoProgram _program = new FefoProgram();
		private ArrayList<AbstractCommand> _curThread;
		private String _readId;
		private String _writeId;
		private String _exprID;
		private String _exprContent;
		private Stack<ArrayList<AbstractCommand>> _stack = new Stack<ArrayList<AbstractCommand>>();
		private String _exprDecision;
		private ArrayList<AbstractCommand> _listaTrue;
		private ArrayList<AbstractCommand> _listaFalse;
			
		private void inicializaID(){
			_varName = ((TokenStream) _input).LT(-1).getText();
			_varValue = false;
			_symbol = new FefoSymbol(_varName, _tipo, _varValue);
			if (!_symbolTable.exists(_varName)){
				_symbolTable.add(_symbol);
				listaDeVariaveis.add(_varName);
			}
			else{
				throw new FefoExceptions("Variável " + _varName + " já inicializada anteriormente!");
			}
		}
		
		
		private void utilizaID(){
			_varName = ((TokenStream) _input).LT(-1).getText();
			if(!_symbolTable.exists(_varName))
				throw new FefoExceptions("Variável \"" + _varName + "\" nunca declarada.");	
			else{
				_symbolTable.get(_varName).setUsado(true);
			}	
		}
		
		private void finalizaPrograma(){
			//vou passar por todas as variáveis declaradas para ver se elas são usadas.
			for (int i = 0; i < listaDeVariaveis.size(); i++){
				_symbol = _symbolTable.get(listaDeVariaveis.get(i));
				//gero um aviso, mas não um erro de compilação
				if(!_symbol.getUsado())
					System.out.println("Aviso! Variável \"" + _symbol.getName() + "\" declarada, mas nunca usada");
			}
			_program.setComandos(_stack.pop());
			_program.setVartable(_symbolTable);
			exibeComandos();
		}
		
		public void exibeComandos(){
			_program.generateTarget();
		}

	public FefoLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(T__0);
			setState(31);
			bloco();
			setState(32);
			match(T__1);
			finalizaPrograma();
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
	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			_curThread = new ArrayList<AbstractCommand>();
						_stack.push(_curThread);
						
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				cmd();
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 268436472L) != 0) );
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
	public static class CmdContext extends ParserRuleContext {
		public CmdDeclaracaoContext cmdDeclaracao() {
			return getRuleContext(CmdDeclaracaoContext.class,0);
		}
		public CmdLeituraContext cmdLeitura() {
			return getRuleContext(CmdLeituraContext.class,0);
		}
		public CmdEscritaContext cmdEscrita() {
			return getRuleContext(CmdEscritaContext.class,0);
		}
		public CmdCondicaoContext cmdCondicao() {
			return getRuleContext(CmdCondicaoContext.class,0);
		}
		public CmdAtribuicaoContext cmdAtribuicao() {
			return getRuleContext(CmdAtribuicaoContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cmd);
		try {
			setState(46);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
			case T__4:
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				cmdDeclaracao();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				cmdLeitura();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				cmdEscrita();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(44);
				cmdCondicao();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(45);
				cmdAtribuicao();
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
	public static class CmdDeclaracaoContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(FefoLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FefoLangParser.ID, i);
		}
		public TerminalNode PF() { return getToken(FefoLangParser.PF, 0); }
		public List<TerminalNode> VIR() { return getTokens(FefoLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(FefoLangParser.VIR, i);
		}
		public CmdDeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdDeclaracao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).enterCmdDeclaracao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).exitCmdDeclaracao(this);
		}
	}

	public final CmdDeclaracaoContext cmdDeclaracao() throws RecognitionException {
		CmdDeclaracaoContext _localctx = new CmdDeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cmdDeclaracao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			tipo();
			setState(49);
			match(ID);
			inicializaID();
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(51);
				match(VIR);
				setState(52);
				match(ID);
				inicializaID();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			match(PF);
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
	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tipo);
		try {
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(T__2);
				 _tipo = FefoSymbol.INTEGER;
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				match(T__3);
				_tipo = FefoSymbol.DOUBLE;
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				match(T__4);
				_tipo = FefoSymbol.TEXT;
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				match(T__5);
				_tipo = FefoSymbol.BOOLEAN;
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
	public static class CmdLeituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(FefoLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(FefoLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(FefoLangParser.FP, 0); }
		public TerminalNode PF() { return getToken(FefoLangParser.PF, 0); }
		public CmdLeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).enterCmdLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).exitCmdLeitura(this);
		}
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__6);
			setState(72);
			match(AP);
			setState(73);
			match(ID);
			utilizaID();
											_symbolTable.get(_varName).setValue(true);
											_readId = ((TokenStream) _input).LT(-1).getText();
											
			setState(75);
			match(FP);
			setState(76);
			match(PF);
			FefoSymbol var =  _symbolTable.get(_readId);
												CommandLeitura cmd = new CommandLeitura(_readId, var);
												_stack.peek().add(cmd);
											
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
	public static class CmdEscritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(FefoLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(FefoLangParser.FP, 0); }
		public TerminalNode PF() { return getToken(FefoLangParser.PF, 0); }
		public TerminalNode TEXTO() { return getToken(FefoLangParser.TEXTO, 0); }
		public TerminalNode ID() { return getToken(FefoLangParser.ID, 0); }
		public CmdEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).enterCmdEscrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).exitCmdEscrita(this);
		}
	}

	public final CmdEscritaContext cmdEscrita() throws RecognitionException {
		CmdEscritaContext _localctx = new CmdEscritaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__7);
			setState(80);
			match(AP);
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXTO:
				{
				setState(81);
				match(TEXTO);
				_writeId = ((TokenStream) _input).LT(-1).getText();
				}
				break;
			case ID:
				{
				setState(83);
				match(ID);
				utilizaID();
												if(!_symbolTable.get(_varName).getValue())
													throw new FefoExceptions("Variável " + _varName + " utilizada antes de seu valor ter sido atribuído.");
												_writeId = ((TokenStream) _input).LT(-1).getText();
												
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(87);
			match(FP);
			setState(88);
			match(PF);
			CommandEscrita cmd = new CommandEscrita(_writeId);
											 _stack.peek().add(cmd);
											 
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
	public static class CmdCondicaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(FefoLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(FefoLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(FefoLangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(FefoLangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(FefoLangParser.ACH, i);
		}
		public List<BlocoContext> bloco() {
			return getRuleContexts(BlocoContext.class);
		}
		public BlocoContext bloco(int i) {
			return getRuleContext(BlocoContext.class,i);
		}
		public List<TerminalNode> FCH() { return getTokens(FefoLangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(FefoLangParser.FCH, i);
		}
		public CmdCondicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdCondicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).enterCmdCondicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).exitCmdCondicao(this);
		}
	}

	public final CmdCondicaoContext cmdCondicao() throws RecognitionException {
		CmdCondicaoContext _localctx = new CmdCondicaoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdCondicao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__8);
			setState(92);
			match(AP);
			setState(93);
			match(ID);
			utilizaID();
										if(!_symbolTable.get(_varName).getValue())
											throw new FefoExceptions("Valor da variável " +_varName + " utilizado antes de ser atribuído.");
										if(_symbolTable.get(_varName).getType() != 3)
											throw new FefoExceptions("Variável não booleana " +_varName + " utilizado em um comando \"se\"");
										_exprDecision = ((TokenStream) _input).LT(-1).getText();
								
			setState(95);
			match(FP);
			setState(96);
			match(T__9);
			 _listaTrue = null;
											_listaFalse = null;
			setState(98);
			match(ACH);
			setState(99);
			bloco();
			setState(100);
			match(FCH);
			_listaTrue = _stack.pop();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(102);
				match(T__10);
				setState(103);
				match(ACH);
				setState(104);
				bloco();
				setState(105);
				match(FCH);
				_listaFalse = _stack.pop();
									 CommandDecisao cmd = new CommandDecisao(_exprDecision, _listaTrue, _listaFalse);
									 _stack.peek().add(cmd);
									 
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdAtribuicaoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(FefoLangParser.ID, 0); }
		public OpAtrContext opAtr() {
			return getRuleContext(OpAtrContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PF() { return getToken(FefoLangParser.PF, 0); }
		public CmdAtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAtribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).enterCmdAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).exitCmdAtribuicao(this);
		}
	}

	public final CmdAtribuicaoContext cmdAtribuicao() throws RecognitionException {
		CmdAtribuicaoContext _localctx = new CmdAtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdAtribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(ID);
			utilizaID();
									_tipoExprEsquerda = _symbolTable.get(_varName).getType();
									_exprID = ((TokenStream) _input).LT(-1).getText();
									
			setState(112);
			opAtr();
			 _exprContent = "";
			setState(114);
			expr();
			if(_tipoExprEsquerda != _tipoExprDireita && _tipoExprEsquerda <= 1 && _tipoExprDireita <= 1)
												System.out.println("Alerta! Atribuição com possível perda de informação entre um decimal e um inteiro.");
											else if(_tipoExprEsquerda != _tipoExprDireita)
												throw new FefoExceptions("Atribuição com tipos incompatíveis!");
											_symbolTable.get(_varName).setValue(true);
											
			setState(116);
			match(PF);
			CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
												_stack.peek().add(cmd);
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
	public static class OpAtrContext extends ParserRuleContext {
		public OpAtrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opAtr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).enterOpAtr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).exitOpAtr(this);
		}
	}

	public final OpAtrContext opAtr() throws RecognitionException {
		OpAtrContext _localctx = new OpAtrContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_opAtr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
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

	@SuppressWarnings("CheckReturnValue")
	public static class OpRelContext extends ParserRuleContext {
		public OpRelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opRel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).enterOpRel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).exitOpRel(this);
		}
	}

	public final OpRelContext opRel() throws RecognitionException {
		OpRelContext _localctx = new OpRelContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_opRel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 516096L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public List<ExprLinhaContext> exprLinha() {
			return getRuleContexts(ExprLinhaContext.class);
		}
		public ExprLinhaContext exprLinha(int i) {
			return getRuleContext(ExprLinhaContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			termo();
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8380416L) != 0)) {
				{
				{
				setState(124);
				exprLinha();
				}
				}
				setState(129);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprLinhaContext extends ParserRuleContext {
		public OpExprContext opExpr() {
			return getRuleContext(OpExprContext.class,0);
		}
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public ExprLinhaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprLinha; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).enterExprLinha(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).exitExprLinha(this);
		}
	}

	public final ExprLinhaContext exprLinha() throws RecognitionException {
		ExprLinhaContext _localctx = new ExprLinhaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_exprLinha);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			opExpr();
			_expressao.setTipoEsquerda(_tipoExprDireita);
										 _expressao.setOperador(_input.LT(-1).getText());
										 _exprContent += ((TokenStream) _input).LT(-1).getText();
										 
			setState(132);
			termo();
			_expressao.setTipoDireita(_tipoExprDireita);
										_tipoExprDireita = _expressao.eval();
										
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
	public static class OpExprContext extends ParserRuleContext {
		public OpRelContext opRel() {
			return getRuleContext(OpRelContext.class,0);
		}
		public OpExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).enterOpExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).exitOpExpr(this);
		}
	}

	public final OpExprContext opExpr() throws RecognitionException {
		OpExprContext _localctx = new OpExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_opExpr);
		try {
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				match(T__18);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				match(T__19);
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 3);
				{
				setState(137);
				match(T__20);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 4);
				{
				setState(138);
				match(T__21);
				}
				break;
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
				enterOuterAlt(_localctx, 5);
				{
				setState(139);
				opRel();
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
	public static class TermoContext extends ParserRuleContext {
		public TerminalNode INTEIRO() { return getToken(FefoLangParser.INTEIRO, 0); }
		public TerminalNode DECIMAL() { return getToken(FefoLangParser.DECIMAL, 0); }
		public TerminalNode BOOLEANO() { return getToken(FefoLangParser.BOOLEANO, 0); }
		public TerminalNode TEXTO() { return getToken(FefoLangParser.TEXTO, 0); }
		public TerminalNode ID() { return getToken(FefoLangParser.ID, 0); }
		public TerminalNode AP() { return getToken(FefoLangParser.AP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(FefoLangParser.FP, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_termo);
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEIRO:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				match(INTEIRO);
				 _tipoExprDireita = FefoSymbol.INTEGER;
											_exprContent += ((TokenStream) _input).LT(-1).getText();
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				match(DECIMAL);
				_tipoExprDireita = FefoSymbol.DOUBLE;
											_exprContent += ((TokenStream) _input).LT(-1).getText();
				}
				break;
			case BOOLEANO:
				enterOuterAlt(_localctx, 3);
				{
				setState(146);
				match(BOOLEANO);
				_tipoExprDireita = FefoSymbol.BOOLEAN;
											_exprContent += ((TokenStream) _input).LT(-1).getText();
				}
				break;
			case TEXTO:
				enterOuterAlt(_localctx, 4);
				{
				setState(148);
				match(TEXTO);
				_tipoExprDireita = FefoSymbol.TEXT;
										_exprContent += ((TokenStream) _input).LT(-1).getText();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(150);
				match(ID);
				utilizaID();
										_exprContent += ((TokenStream) _input).LT(-1).getText();
										if(!_symbolTable.get(_varName).getValue())
											throw new FefoExceptions("Variável " + _varName + " utilizada antes de seu valor ter sido atribuído.");
										_tipoExprDireita = _symbolTable.get(_varName).getType();
										
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 6);
				{
				setState(152);
				match(AP);
				setState(153);
				expr();
				setState(154);
				match(FP);
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

	public static final String _serializedATN =
		"\u0004\u0001#\u009f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0004\u0001"+
		"&\b\u0001\u000b\u0001\f\u0001\'\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002/\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u00037\b\u0003\n\u0003"+
		"\f\u0003:\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004F\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006V\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007m\b\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0005\u000b~\b\u000b\n\u000b\f\u000b"+
		"\u0081\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0003\r\u008d\b\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u009d\b\u000e\u0001\u000e\u0000\u0000\u000f\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0001\u0001"+
		"\u0000\r\u0012\u00a4\u0000\u001e\u0001\u0000\u0000\u0000\u0002#\u0001"+
		"\u0000\u0000\u0000\u0004.\u0001\u0000\u0000\u0000\u00060\u0001\u0000\u0000"+
		"\u0000\bE\u0001\u0000\u0000\u0000\nG\u0001\u0000\u0000\u0000\fO\u0001"+
		"\u0000\u0000\u0000\u000e[\u0001\u0000\u0000\u0000\u0010n\u0001\u0000\u0000"+
		"\u0000\u0012w\u0001\u0000\u0000\u0000\u0014y\u0001\u0000\u0000\u0000\u0016"+
		"{\u0001\u0000\u0000\u0000\u0018\u0082\u0001\u0000\u0000\u0000\u001a\u008c"+
		"\u0001\u0000\u0000\u0000\u001c\u009c\u0001\u0000\u0000\u0000\u001e\u001f"+
		"\u0005\u0001\u0000\u0000\u001f \u0003\u0002\u0001\u0000 !\u0005\u0002"+
		"\u0000\u0000!\"\u0006\u0000\uffff\uffff\u0000\"\u0001\u0001\u0000\u0000"+
		"\u0000#%\u0006\u0001\uffff\uffff\u0000$&\u0003\u0004\u0002\u0000%$\u0001"+
		"\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000"+
		"\'(\u0001\u0000\u0000\u0000(\u0003\u0001\u0000\u0000\u0000)/\u0003\u0006"+
		"\u0003\u0000*/\u0003\n\u0005\u0000+/\u0003\f\u0006\u0000,/\u0003\u000e"+
		"\u0007\u0000-/\u0003\u0010\b\u0000.)\u0001\u0000\u0000\u0000.*\u0001\u0000"+
		"\u0000\u0000.+\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000.-\u0001"+
		"\u0000\u0000\u0000/\u0005\u0001\u0000\u0000\u000001\u0003\b\u0004\u0000"+
		"12\u0005\u001c\u0000\u000028\u0006\u0003\uffff\uffff\u000034\u0005\u001d"+
		"\u0000\u000045\u0005\u001c\u0000\u000057\u0006\u0003\uffff\uffff\u0000"+
		"63\u0001\u0000\u0000\u00007:\u0001\u0000\u0000\u000086\u0001\u0000\u0000"+
		"\u000089\u0001\u0000\u0000\u00009;\u0001\u0000\u0000\u0000:8\u0001\u0000"+
		"\u0000\u0000;<\u0005\"\u0000\u0000<\u0007\u0001\u0000\u0000\u0000=>\u0005"+
		"\u0003\u0000\u0000>F\u0006\u0004\uffff\uffff\u0000?@\u0005\u0004\u0000"+
		"\u0000@F\u0006\u0004\uffff\uffff\u0000AB\u0005\u0005\u0000\u0000BF\u0006"+
		"\u0004\uffff\uffff\u0000CD\u0005\u0006\u0000\u0000DF\u0006\u0004\uffff"+
		"\uffff\u0000E=\u0001\u0000\u0000\u0000E?\u0001\u0000\u0000\u0000EA\u0001"+
		"\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000F\t\u0001\u0000\u0000\u0000"+
		"GH\u0005\u0007\u0000\u0000HI\u0005 \u0000\u0000IJ\u0005\u001c\u0000\u0000"+
		"JK\u0006\u0005\uffff\uffff\u0000KL\u0005!\u0000\u0000LM\u0005\"\u0000"+
		"\u0000MN\u0006\u0005\uffff\uffff\u0000N\u000b\u0001\u0000\u0000\u0000"+
		"OP\u0005\b\u0000\u0000PU\u0005 \u0000\u0000QR\u0005\u001b\u0000\u0000"+
		"RV\u0006\u0006\uffff\uffff\u0000ST\u0005\u001c\u0000\u0000TV\u0006\u0006"+
		"\uffff\uffff\u0000UQ\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000"+
		"VW\u0001\u0000\u0000\u0000WX\u0005!\u0000\u0000XY\u0005\"\u0000\u0000"+
		"YZ\u0006\u0006\uffff\uffff\u0000Z\r\u0001\u0000\u0000\u0000[\\\u0005\t"+
		"\u0000\u0000\\]\u0005 \u0000\u0000]^\u0005\u001c\u0000\u0000^_\u0006\u0007"+
		"\uffff\uffff\u0000_`\u0005!\u0000\u0000`a\u0005\n\u0000\u0000ab\u0006"+
		"\u0007\uffff\uffff\u0000bc\u0005\u001e\u0000\u0000cd\u0003\u0002\u0001"+
		"\u0000de\u0005\u001f\u0000\u0000el\u0006\u0007\uffff\uffff\u0000fg\u0005"+
		"\u000b\u0000\u0000gh\u0005\u001e\u0000\u0000hi\u0003\u0002\u0001\u0000"+
		"ij\u0005\u001f\u0000\u0000jk\u0006\u0007\uffff\uffff\u0000km\u0001\u0000"+
		"\u0000\u0000lf\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000m\u000f"+
		"\u0001\u0000\u0000\u0000no\u0005\u001c\u0000\u0000op\u0006\b\uffff\uffff"+
		"\u0000pq\u0003\u0012\t\u0000qr\u0006\b\uffff\uffff\u0000rs\u0003\u0016"+
		"\u000b\u0000st\u0006\b\uffff\uffff\u0000tu\u0005\"\u0000\u0000uv\u0006"+
		"\b\uffff\uffff\u0000v\u0011\u0001\u0000\u0000\u0000wx\u0005\f\u0000\u0000"+
		"x\u0013\u0001\u0000\u0000\u0000yz\u0007\u0000\u0000\u0000z\u0015\u0001"+
		"\u0000\u0000\u0000{\u007f\u0003\u001c\u000e\u0000|~\u0003\u0018\f\u0000"+
		"}|\u0001\u0000\u0000\u0000~\u0081\u0001\u0000\u0000\u0000\u007f}\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0017\u0001"+
		"\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0082\u0083\u0003"+
		"\u001a\r\u0000\u0083\u0084\u0006\f\uffff\uffff\u0000\u0084\u0085\u0003"+
		"\u001c\u000e\u0000\u0085\u0086\u0006\f\uffff\uffff\u0000\u0086\u0019\u0001"+
		"\u0000\u0000\u0000\u0087\u008d\u0005\u0013\u0000\u0000\u0088\u008d\u0005"+
		"\u0014\u0000\u0000\u0089\u008d\u0005\u0015\u0000\u0000\u008a\u008d\u0005"+
		"\u0016\u0000\u0000\u008b\u008d\u0003\u0014\n\u0000\u008c\u0087\u0001\u0000"+
		"\u0000\u0000\u008c\u0088\u0001\u0000\u0000\u0000\u008c\u0089\u0001\u0000"+
		"\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008b\u0001\u0000"+
		"\u0000\u0000\u008d\u001b\u0001\u0000\u0000\u0000\u008e\u008f\u0005\u0019"+
		"\u0000\u0000\u008f\u009d\u0006\u000e\uffff\uffff\u0000\u0090\u0091\u0005"+
		"\u0018\u0000\u0000\u0091\u009d\u0006\u000e\uffff\uffff\u0000\u0092\u0093"+
		"\u0005\u001a\u0000\u0000\u0093\u009d\u0006\u000e\uffff\uffff\u0000\u0094"+
		"\u0095\u0005\u001b\u0000\u0000\u0095\u009d\u0006\u000e\uffff\uffff\u0000"+
		"\u0096\u0097\u0005\u001c\u0000\u0000\u0097\u009d\u0006\u000e\uffff\uffff"+
		"\u0000\u0098\u0099\u0005 \u0000\u0000\u0099\u009a\u0003\u0016\u000b\u0000"+
		"\u009a\u009b\u0005!\u0000\u0000\u009b\u009d\u0001\u0000\u0000\u0000\u009c"+
		"\u008e\u0001\u0000\u0000\u0000\u009c\u0090\u0001\u0000\u0000\u0000\u009c"+
		"\u0092\u0001\u0000\u0000\u0000\u009c\u0094\u0001\u0000\u0000\u0000\u009c"+
		"\u0096\u0001\u0000\u0000\u0000\u009c\u0098\u0001\u0000\u0000\u0000\u009d"+
		"\u001d\u0001\u0000\u0000\u0000\t\'.8EUl\u007f\u008c\u009c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}