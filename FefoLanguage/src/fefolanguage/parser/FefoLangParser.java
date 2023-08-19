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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		ASPAS=25, DECIMAL=26, INTEIRO=27, BOOLEANO=28, TEXTO=29, ID=30, VIR=31, 
		ACH=32, FCH=33, AP=34, FP=35, PF=36, WS=37;
	public static final int
		RULE_prog = 0, RULE_bloco = 1, RULE_cmd = 2, RULE_cmdDeclaracao = 3, RULE_tipo = 4, 
		RULE_cmdLeitura = 5, RULE_cmdEscrita = 6, RULE_cmdAtribuicao = 7, RULE_cmdCondicao = 8, 
		RULE_cmdLoop = 9, RULE_opAtr = 10, RULE_opRel = 11, RULE_expr = 12, RULE_exprLinha = 13, 
		RULE_opExpr = 14, RULE_termo = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "bloco", "cmd", "cmdDeclaracao", "tipo", "cmdLeitura", "cmdEscrita", 
			"cmdAtribuicao", "cmdCondicao", "cmdLoop", "opAtr", "opRel", "expr", 
			"exprLinha", "opExpr", "termo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'inteiro'", "'decimal'", "'texto'", 
			"'booleano'", "'leia'", "'escreva'", "'se'", "'entao'", "'senao'", "'enquanto'", 
			"'faca'", "':='", "'<'", "'>'", "'<='", "'>='", "'!='", "'=='", "'+'", 
			"'-'", "'*'", "'/'", "'\"'", null, null, null, null, null, "','", "'{'", 
			"'}'", "'('", "')'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ASPAS", "DECIMAL", "INTEIRO", "BOOLEANO", "TEXTO", "ID", "VIR", 
			"ACH", "FCH", "AP", "FP", "PF", "WS"
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
		private String _exprLoop;
		private ArrayList<AbstractCommand> _listaTrue;
		private ArrayList<AbstractCommand> _listaFalse;
		private ArrayList<AbstractCommand> _listaLoop;
			
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
			setState(32);
			match(T__0);
			setState(33);
			bloco();
			setState(34);
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
						
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38);
				cmd();
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1073755128L) != 0) );
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
		public CmdLoopContext cmdLoop() {
			return getRuleContext(CmdLoopContext.class,0);
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
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
			case T__4:
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				cmdDeclaracao();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				cmdLeitura();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				cmdEscrita();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				cmdCondicao();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(47);
				cmdAtribuicao();
				}
				break;
			case T__11:
			case T__12:
				enterOuterAlt(_localctx, 6);
				{
				setState(48);
				cmdLoop();
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
			setState(51);
			tipo();
			setState(52);
			match(ID);
			inicializaID();
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(54);
				match(VIR);
				setState(55);
				match(ID);
				inicializaID();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
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
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				match(T__2);
				 _tipo = FefoSymbol.INTEGER;
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(T__3);
				_tipo = FefoSymbol.DOUBLE;
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				match(T__4);
				_tipo = FefoSymbol.TEXT;
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
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
			setState(74);
			match(T__6);
			setState(75);
			match(AP);
			setState(76);
			match(ID);
			utilizaID();
											_symbolTable.get(_varName).setValue(true);
											_readId = ((TokenStream) _input).LT(-1).getText();
											
			setState(78);
			match(FP);
			setState(79);
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
			setState(82);
			match(T__7);
			setState(83);
			match(AP);
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXTO:
				{
				setState(84);
				match(TEXTO);
				_writeId = ((TokenStream) _input).LT(-1).getText();
				}
				break;
			case ID:
				{
				setState(86);
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
			setState(90);
			match(FP);
			setState(91);
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
		enterRule(_localctx, 14, RULE_cmdAtribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(ID);
			utilizaID();
									_tipoExprEsquerda = _symbolTable.get(_varName).getType();
									_exprID = ((TokenStream) _input).LT(-1).getText();
									
			setState(96);
			opAtr();
			 _exprContent = "";
			setState(98);
			expr();
			if(_tipoExprEsquerda != _tipoExprDireita)
											throw new FefoExceptions("Atribuição com tipos incompatíveis!");
										_symbolTable.get(_varName).setValue(true);
											
			setState(100);
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
		enterRule(_localctx, 16, RULE_cmdCondicao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__8);
			setState(104);
			match(AP);
			setState(105);
			match(ID);
			utilizaID();
									if(!_symbolTable.get(_varName).getValue())
										throw new FefoExceptions("Valor da variável " +_varName + " utilizado antes de ser atribuído.");
									if(_symbolTable.get(_varName).getType() != 3)
										throw new FefoExceptions("Variável não booleana " +_varName + " utilizado em um comando \"se\"");
									_exprDecision = ((TokenStream) _input).LT(-1).getText();
									
			setState(107);
			match(FP);
			setState(108);
			match(T__9);
			 _listaTrue = null;
										_listaFalse = null;
			setState(110);
			match(ACH);
			setState(111);
			bloco();
			setState(112);
			match(FCH);
			_listaTrue = _stack.pop();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(114);
				match(T__10);
				setState(115);
				match(ACH);
				setState(116);
				bloco();
				setState(117);
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
	public static class CmdLoopContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(FefoLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(FefoLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(FefoLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(FefoLangParser.ACH, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode FCH() { return getToken(FefoLangParser.FCH, 0); }
		public TerminalNode PF() { return getToken(FefoLangParser.PF, 0); }
		public CmdLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).enterCmdLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FefoLangListener ) ((FefoLangListener)listener).exitCmdLoop(this);
		}
	}

	public final CmdLoopContext cmdLoop() throws RecognitionException {
		CmdLoopContext _localctx = new CmdLoopContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdLoop);
		try {
			setState(146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				match(T__11);
				setState(123);
				match(AP);
				setState(124);
				match(ID);
				utilizaID();
													if(!_symbolTable.get(_varName).getValue())
														throw new FefoExceptions("Valor da variável " +_varName + " utilizado antes de ser atribuído.");
													if(_symbolTable.get(_varName).getType() != 3)
														throw new FefoExceptions("Variável não booleana " +_varName + " utilizado em um comando \"enquanto\"");
													_exprLoop = ((TokenStream) _input).LT(-1).getText();
													
				setState(126);
				match(FP);
				setState(127);
				match(ACH);
				_listaLoop = null;
				setState(129);
				bloco();
				setState(130);
				match(FCH);
				_listaLoop = _stack.pop();
									 			CommandLoop cmd = new CommandLoop(_exprLoop, _listaLoop, CommandLoop.WHILE);
									 			_stack.peek().add(cmd);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				match(T__12);
				setState(134);
				match(ACH);
				_listaLoop = null;
				setState(136);
				bloco();
				setState(137);
				match(FCH);
				setState(138);
				match(T__11);
				setState(139);
				match(AP);
				setState(140);
				match(ID);
				utilizaID();
													if(!_symbolTable.get(_varName).getValue())
														throw new FefoExceptions("Valor da variável " +_varName + " utilizado antes de ser atribuído.");
													if(_symbolTable.get(_varName).getType() != 3)
														throw new FefoExceptions("Variável não booleana " +_varName + " utilizado em um comando \"enquanto\"");
													_exprLoop = ((TokenStream) _input).LT(-1).getText();
													
				setState(142);
				match(FP);
				setState(143);
				match(PF);
				_listaLoop = _stack.pop();
									 					CommandLoop cmd = new CommandLoop(_exprLoop, _listaLoop, CommandLoop.DoWHILE);
									 					_stack.peek().add(cmd);
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
		enterRule(_localctx, 20, RULE_opAtr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(T__13);
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
		enterRule(_localctx, 22, RULE_opRel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2064384L) != 0)) ) {
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
		enterRule(_localctx, 24, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			termo();
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33521664L) != 0)) {
				{
				{
				setState(153);
				exprLinha();
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
		enterRule(_localctx, 26, RULE_exprLinha);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			opExpr();
			_expressao.setTipoEsquerda(_tipoExprDireita);
										 _expressao.setOperador(_input.LT(-1).getText());
										 _exprContent += ((TokenStream) _input).LT(-1).getText();
										 
			setState(161);
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
		enterRule(_localctx, 28, RULE_opExpr);
		try {
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				match(T__20);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				match(T__21);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 3);
				{
				setState(166);
				match(T__22);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 4);
				{
				setState(167);
				match(T__23);
				}
				break;
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
				enterOuterAlt(_localctx, 5);
				{
				setState(168);
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
		enterRule(_localctx, 30, RULE_termo);
		try {
			setState(185);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEIRO:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				match(INTEIRO);
				 _tipoExprDireita = FefoSymbol.INTEGER;
											_exprContent += ((TokenStream) _input).LT(-1).getText();
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				match(DECIMAL);
				_tipoExprDireita = FefoSymbol.DOUBLE;
											_exprContent += ((TokenStream) _input).LT(-1).getText();
				}
				break;
			case BOOLEANO:
				enterOuterAlt(_localctx, 3);
				{
				setState(175);
				match(BOOLEANO);
				_tipoExprDireita = FefoSymbol.BOOLEAN;
											_exprContent += ((TokenStream) _input).LT(-1).getText();
				}
				break;
			case TEXTO:
				enterOuterAlt(_localctx, 4);
				{
				setState(177);
				match(TEXTO);
				_tipoExprDireita = FefoSymbol.TEXT;
										_exprContent += ((TokenStream) _input).LT(-1).getText();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(179);
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
				setState(181);
				match(AP);
				setState(182);
				expr();
				setState(183);
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
		"\u0004\u0001%\u00bc\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0004\u0001(\b\u0001\u000b\u0001\f\u0001)\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00022\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u0003:\b\u0003\n\u0003\f\u0003=\t\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004I\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006Y\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\by\b\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\t\u0093\b\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0005\f\u009b\b\f\n\f\f\f\u009e\t\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u00aa\b\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u00ba\b\u000f\u0001\u000f\u0000\u0000\u0010\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e\u0000"+
		"\u0001\u0001\u0000\u000f\u0014\u00c2\u0000 \u0001\u0000\u0000\u0000\u0002"+
		"%\u0001\u0000\u0000\u0000\u00041\u0001\u0000\u0000\u0000\u00063\u0001"+
		"\u0000\u0000\u0000\bH\u0001\u0000\u0000\u0000\nJ\u0001\u0000\u0000\u0000"+
		"\fR\u0001\u0000\u0000\u0000\u000e^\u0001\u0000\u0000\u0000\u0010g\u0001"+
		"\u0000\u0000\u0000\u0012\u0092\u0001\u0000\u0000\u0000\u0014\u0094\u0001"+
		"\u0000\u0000\u0000\u0016\u0096\u0001\u0000\u0000\u0000\u0018\u0098\u0001"+
		"\u0000\u0000\u0000\u001a\u009f\u0001\u0000\u0000\u0000\u001c\u00a9\u0001"+
		"\u0000\u0000\u0000\u001e\u00b9\u0001\u0000\u0000\u0000 !\u0005\u0001\u0000"+
		"\u0000!\"\u0003\u0002\u0001\u0000\"#\u0005\u0002\u0000\u0000#$\u0006\u0000"+
		"\uffff\uffff\u0000$\u0001\u0001\u0000\u0000\u0000%\'\u0006\u0001\uffff"+
		"\uffff\u0000&(\u0003\u0004\u0002\u0000\'&\u0001\u0000\u0000\u0000()\u0001"+
		"\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000"+
		"*\u0003\u0001\u0000\u0000\u0000+2\u0003\u0006\u0003\u0000,2\u0003\n\u0005"+
		"\u0000-2\u0003\f\u0006\u0000.2\u0003\u0010\b\u0000/2\u0003\u000e\u0007"+
		"\u000002\u0003\u0012\t\u00001+\u0001\u0000\u0000\u00001,\u0001\u0000\u0000"+
		"\u00001-\u0001\u0000\u0000\u00001.\u0001\u0000\u0000\u00001/\u0001\u0000"+
		"\u0000\u000010\u0001\u0000\u0000\u00002\u0005\u0001\u0000\u0000\u0000"+
		"34\u0003\b\u0004\u000045\u0005\u001e\u0000\u00005;\u0006\u0003\uffff\uffff"+
		"\u000067\u0005\u001f\u0000\u000078\u0005\u001e\u0000\u00008:\u0006\u0003"+
		"\uffff\uffff\u000096\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000"+
		";9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<>\u0001\u0000\u0000"+
		"\u0000=;\u0001\u0000\u0000\u0000>?\u0005$\u0000\u0000?\u0007\u0001\u0000"+
		"\u0000\u0000@A\u0005\u0003\u0000\u0000AI\u0006\u0004\uffff\uffff\u0000"+
		"BC\u0005\u0004\u0000\u0000CI\u0006\u0004\uffff\uffff\u0000DE\u0005\u0005"+
		"\u0000\u0000EI\u0006\u0004\uffff\uffff\u0000FG\u0005\u0006\u0000\u0000"+
		"GI\u0006\u0004\uffff\uffff\u0000H@\u0001\u0000\u0000\u0000HB\u0001\u0000"+
		"\u0000\u0000HD\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000I\t\u0001"+
		"\u0000\u0000\u0000JK\u0005\u0007\u0000\u0000KL\u0005\"\u0000\u0000LM\u0005"+
		"\u001e\u0000\u0000MN\u0006\u0005\uffff\uffff\u0000NO\u0005#\u0000\u0000"+
		"OP\u0005$\u0000\u0000PQ\u0006\u0005\uffff\uffff\u0000Q\u000b\u0001\u0000"+
		"\u0000\u0000RS\u0005\b\u0000\u0000SX\u0005\"\u0000\u0000TU\u0005\u001d"+
		"\u0000\u0000UY\u0006\u0006\uffff\uffff\u0000VW\u0005\u001e\u0000\u0000"+
		"WY\u0006\u0006\uffff\uffff\u0000XT\u0001\u0000\u0000\u0000XV\u0001\u0000"+
		"\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0005#\u0000\u0000[\\\u0005$"+
		"\u0000\u0000\\]\u0006\u0006\uffff\uffff\u0000]\r\u0001\u0000\u0000\u0000"+
		"^_\u0005\u001e\u0000\u0000_`\u0006\u0007\uffff\uffff\u0000`a\u0003\u0014"+
		"\n\u0000ab\u0006\u0007\uffff\uffff\u0000bc\u0003\u0018\f\u0000cd\u0006"+
		"\u0007\uffff\uffff\u0000de\u0005$\u0000\u0000ef\u0006\u0007\uffff\uffff"+
		"\u0000f\u000f\u0001\u0000\u0000\u0000gh\u0005\t\u0000\u0000hi\u0005\""+
		"\u0000\u0000ij\u0005\u001e\u0000\u0000jk\u0006\b\uffff\uffff\u0000kl\u0005"+
		"#\u0000\u0000lm\u0005\n\u0000\u0000mn\u0006\b\uffff\uffff\u0000no\u0005"+
		" \u0000\u0000op\u0003\u0002\u0001\u0000pq\u0005!\u0000\u0000qx\u0006\b"+
		"\uffff\uffff\u0000rs\u0005\u000b\u0000\u0000st\u0005 \u0000\u0000tu\u0003"+
		"\u0002\u0001\u0000uv\u0005!\u0000\u0000vw\u0006\b\uffff\uffff\u0000wy"+
		"\u0001\u0000\u0000\u0000xr\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000"+
		"\u0000y\u0011\u0001\u0000\u0000\u0000z{\u0005\f\u0000\u0000{|\u0005\""+
		"\u0000\u0000|}\u0005\u001e\u0000\u0000}~\u0006\t\uffff\uffff\u0000~\u007f"+
		"\u0005#\u0000\u0000\u007f\u0080\u0005 \u0000\u0000\u0080\u0081\u0006\t"+
		"\uffff\uffff\u0000\u0081\u0082\u0003\u0002\u0001\u0000\u0082\u0083\u0005"+
		"!\u0000\u0000\u0083\u0084\u0006\t\uffff\uffff\u0000\u0084\u0093\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0005\r\u0000\u0000\u0086\u0087\u0005 "+
		"\u0000\u0000\u0087\u0088\u0006\t\uffff\uffff\u0000\u0088\u0089\u0003\u0002"+
		"\u0001\u0000\u0089\u008a\u0005!\u0000\u0000\u008a\u008b\u0005\f\u0000"+
		"\u0000\u008b\u008c\u0005\"\u0000\u0000\u008c\u008d\u0005\u001e\u0000\u0000"+
		"\u008d\u008e\u0006\t\uffff\uffff\u0000\u008e\u008f\u0005#\u0000\u0000"+
		"\u008f\u0090\u0005$\u0000\u0000\u0090\u0091\u0006\t\uffff\uffff\u0000"+
		"\u0091\u0093\u0001\u0000\u0000\u0000\u0092z\u0001\u0000\u0000\u0000\u0092"+
		"\u0085\u0001\u0000\u0000\u0000\u0093\u0013\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0005\u000e\u0000\u0000\u0095\u0015\u0001\u0000\u0000\u0000\u0096"+
		"\u0097\u0007\u0000\u0000\u0000\u0097\u0017\u0001\u0000\u0000\u0000\u0098"+
		"\u009c\u0003\u001e\u000f\u0000\u0099\u009b\u0003\u001a\r\u0000\u009a\u0099"+
		"\u0001\u0000\u0000\u0000\u009b\u009e\u0001\u0000\u0000\u0000\u009c\u009a"+
		"\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u0019"+
		"\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009f\u00a0"+
		"\u0003\u001c\u000e\u0000\u00a0\u00a1\u0006\r\uffff\uffff\u0000\u00a1\u00a2"+
		"\u0003\u001e\u000f\u0000\u00a2\u00a3\u0006\r\uffff\uffff\u0000\u00a3\u001b"+
		"\u0001\u0000\u0000\u0000\u00a4\u00aa\u0005\u0015\u0000\u0000\u00a5\u00aa"+
		"\u0005\u0016\u0000\u0000\u00a6\u00aa\u0005\u0017\u0000\u0000\u00a7\u00aa"+
		"\u0005\u0018\u0000\u0000\u00a8\u00aa\u0003\u0016\u000b\u0000\u00a9\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a9\u00a5\u0001\u0000\u0000\u0000\u00a9\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00a8"+
		"\u0001\u0000\u0000\u0000\u00aa\u001d\u0001\u0000\u0000\u0000\u00ab\u00ac"+
		"\u0005\u001b\u0000\u0000\u00ac\u00ba\u0006\u000f\uffff\uffff\u0000\u00ad"+
		"\u00ae\u0005\u001a\u0000\u0000\u00ae\u00ba\u0006\u000f\uffff\uffff\u0000"+
		"\u00af\u00b0\u0005\u001c\u0000\u0000\u00b0\u00ba\u0006\u000f\uffff\uffff"+
		"\u0000\u00b1\u00b2\u0005\u001d\u0000\u0000\u00b2\u00ba\u0006\u000f\uffff"+
		"\uffff\u0000\u00b3\u00b4\u0005\u001e\u0000\u0000\u00b4\u00ba\u0006\u000f"+
		"\uffff\uffff\u0000\u00b5\u00b6\u0005\"\u0000\u0000\u00b6\u00b7\u0003\u0018"+
		"\f\u0000\u00b7\u00b8\u0005#\u0000\u0000\u00b8\u00ba\u0001\u0000\u0000"+
		"\u0000\u00b9\u00ab\u0001\u0000\u0000\u0000\u00b9\u00ad\u0001\u0000\u0000"+
		"\u0000\u00b9\u00af\u0001\u0000\u0000\u0000\u00b9\u00b1\u0001\u0000\u0000"+
		"\u0000\u00b9\u00b3\u0001\u0000\u0000\u0000\u00b9\u00b5\u0001\u0000\u0000"+
		"\u0000\u00ba\u001f\u0001\u0000\u0000\u0000\n)1;HXx\u0092\u009c\u00a9\u00b9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}