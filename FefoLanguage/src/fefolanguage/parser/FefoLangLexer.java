// Generated from FefoLang.g4 by ANTLR 4.13.0
package fefolanguage.parser;

import java.util.Stack;
	import java.util.ArrayList;
	import fefolanguage.dataStructures.*;
	import fefolanguage.exceptions.FefoExceptions;
	import fefolanguage.ast.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class FefoLangLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "ASPAS", "DECIMAL", "INTEIRO", 
			"BOOLEANO", "TEXTO", "ID", "VIR", "ACH", "FCH", "AP", "FP", "PF", "WS"
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


	public FefoLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FefoLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000#\u00f0\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0003"+
		"\u0017\u00b2\b\u0017\u0001\u0017\u0004\u0017\u00b5\b\u0017\u000b\u0017"+
		"\f\u0017\u00b6\u0001\u0017\u0001\u0017\u0004\u0017\u00bb\b\u0017\u000b"+
		"\u0017\f\u0017\u00bc\u0001\u0018\u0003\u0018\u00c0\b\u0018\u0001\u0018"+
		"\u0004\u0018\u00c3\b\u0018\u000b\u0018\f\u0018\u00c4\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0003\u0019\u00d0\b\u0019\u0001\u001a\u0001\u001a\u0004"+
		"\u001a\u00d4\b\u001a\u000b\u001a\f\u001a\u00d5\u0001\u001a\u0001\u001a"+
		"\u0001\u001b\u0001\u001b\u0005\u001b\u00dc\b\u001b\n\u001b\f\u001b\u00df"+
		"\t\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001"+
		"\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0000\u0000#\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013"+
		"\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d"+
		";\u001e=\u001f? A!C\"E#\u0001\u0000\u0005\u0001\u000009\u0001\u0000\""+
		"\"\u0001\u0000az\u0003\u000009AZaz\u0003\u0000\t\n\r\r  \u00f7\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000"+
		"\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001"+
		"\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000"+
		"\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u0000"+
		"5\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001"+
		"\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000"+
		"\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000"+
		"C\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0001G\u0001"+
		"\u0000\u0000\u0000\u0003P\u0001\u0000\u0000\u0000\u0005X\u0001\u0000\u0000"+
		"\u0000\u0007`\u0001\u0000\u0000\u0000\th\u0001\u0000\u0000\u0000\u000b"+
		"n\u0001\u0000\u0000\u0000\rw\u0001\u0000\u0000\u0000\u000f|\u0001\u0000"+
		"\u0000\u0000\u0011\u0084\u0001\u0000\u0000\u0000\u0013\u0087\u0001\u0000"+
		"\u0000\u0000\u0015\u008d\u0001\u0000\u0000\u0000\u0017\u0093\u0001\u0000"+
		"\u0000\u0000\u0019\u0096\u0001\u0000\u0000\u0000\u001b\u0098\u0001\u0000"+
		"\u0000\u0000\u001d\u009a\u0001\u0000\u0000\u0000\u001f\u009d\u0001\u0000"+
		"\u0000\u0000!\u00a0\u0001\u0000\u0000\u0000#\u00a3\u0001\u0000\u0000\u0000"+
		"%\u00a6\u0001\u0000\u0000\u0000\'\u00a8\u0001\u0000\u0000\u0000)\u00aa"+
		"\u0001\u0000\u0000\u0000+\u00ac\u0001\u0000\u0000\u0000-\u00ae\u0001\u0000"+
		"\u0000\u0000/\u00b1\u0001\u0000\u0000\u00001\u00bf\u0001\u0000\u0000\u0000"+
		"3\u00cf\u0001\u0000\u0000\u00005\u00d1\u0001\u0000\u0000\u00007\u00d9"+
		"\u0001\u0000\u0000\u00009\u00e0\u0001\u0000\u0000\u0000;\u00e2\u0001\u0000"+
		"\u0000\u0000=\u00e4\u0001\u0000\u0000\u0000?\u00e6\u0001\u0000\u0000\u0000"+
		"A\u00e8\u0001\u0000\u0000\u0000C\u00ea\u0001\u0000\u0000\u0000E\u00ec"+
		"\u0001\u0000\u0000\u0000GH\u0005p\u0000\u0000HI\u0005r\u0000\u0000IJ\u0005"+
		"o\u0000\u0000JK\u0005g\u0000\u0000KL\u0005r\u0000\u0000LM\u0005a\u0000"+
		"\u0000MN\u0005m\u0000\u0000NO\u0005a\u0000\u0000O\u0002\u0001\u0000\u0000"+
		"\u0000PQ\u0005f\u0000\u0000QR\u0005i\u0000\u0000RS\u0005m\u0000\u0000"+
		"ST\u0005p\u0000\u0000TU\u0005r\u0000\u0000UV\u0005o\u0000\u0000VW\u0005"+
		"g\u0000\u0000W\u0004\u0001\u0000\u0000\u0000XY\u0005i\u0000\u0000YZ\u0005"+
		"n\u0000\u0000Z[\u0005t\u0000\u0000[\\\u0005e\u0000\u0000\\]\u0005i\u0000"+
		"\u0000]^\u0005r\u0000\u0000^_\u0005o\u0000\u0000_\u0006\u0001\u0000\u0000"+
		"\u0000`a\u0005d\u0000\u0000ab\u0005e\u0000\u0000bc\u0005c\u0000\u0000"+
		"cd\u0005i\u0000\u0000de\u0005m\u0000\u0000ef\u0005a\u0000\u0000fg\u0005"+
		"l\u0000\u0000g\b\u0001\u0000\u0000\u0000hi\u0005t\u0000\u0000ij\u0005"+
		"e\u0000\u0000jk\u0005x\u0000\u0000kl\u0005t\u0000\u0000lm\u0005o\u0000"+
		"\u0000m\n\u0001\u0000\u0000\u0000no\u0005b\u0000\u0000op\u0005o\u0000"+
		"\u0000pq\u0005o\u0000\u0000qr\u0005l\u0000\u0000rs\u0005e\u0000\u0000"+
		"st\u0005a\u0000\u0000tu\u0005n\u0000\u0000uv\u0005o\u0000\u0000v\f\u0001"+
		"\u0000\u0000\u0000wx\u0005l\u0000\u0000xy\u0005e\u0000\u0000yz\u0005i"+
		"\u0000\u0000z{\u0005a\u0000\u0000{\u000e\u0001\u0000\u0000\u0000|}\u0005"+
		"e\u0000\u0000}~\u0005s\u0000\u0000~\u007f\u0005c\u0000\u0000\u007f\u0080"+
		"\u0005r\u0000\u0000\u0080\u0081\u0005e\u0000\u0000\u0081\u0082\u0005v"+
		"\u0000\u0000\u0082\u0083\u0005a\u0000\u0000\u0083\u0010\u0001\u0000\u0000"+
		"\u0000\u0084\u0085\u0005s\u0000\u0000\u0085\u0086\u0005e\u0000\u0000\u0086"+
		"\u0012\u0001\u0000\u0000\u0000\u0087\u0088\u0005e\u0000\u0000\u0088\u0089"+
		"\u0005n\u0000\u0000\u0089\u008a\u0005t\u0000\u0000\u008a\u008b\u0005a"+
		"\u0000\u0000\u008b\u008c\u0005o\u0000\u0000\u008c\u0014\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0005s\u0000\u0000\u008e\u008f\u0005e\u0000\u0000\u008f"+
		"\u0090\u0005n\u0000\u0000\u0090\u0091\u0005a\u0000\u0000\u0091\u0092\u0005"+
		"o\u0000\u0000\u0092\u0016\u0001\u0000\u0000\u0000\u0093\u0094\u0005:\u0000"+
		"\u0000\u0094\u0095\u0005=\u0000\u0000\u0095\u0018\u0001\u0000\u0000\u0000"+
		"\u0096\u0097\u0005<\u0000\u0000\u0097\u001a\u0001\u0000\u0000\u0000\u0098"+
		"\u0099\u0005>\u0000\u0000\u0099\u001c\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0005<\u0000\u0000\u009b\u009c\u0005=\u0000\u0000\u009c\u001e\u0001\u0000"+
		"\u0000\u0000\u009d\u009e\u0005>\u0000\u0000\u009e\u009f\u0005=\u0000\u0000"+
		"\u009f \u0001\u0000\u0000\u0000\u00a0\u00a1\u0005!\u0000\u0000\u00a1\u00a2"+
		"\u0005=\u0000\u0000\u00a2\"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005"+
		"=\u0000\u0000\u00a4\u00a5\u0005=\u0000\u0000\u00a5$\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a7\u0005+\u0000\u0000\u00a7&\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a9\u0005-\u0000\u0000\u00a9(\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005"+
		"*\u0000\u0000\u00ab*\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005/\u0000"+
		"\u0000\u00ad,\u0001\u0000\u0000\u0000\u00ae\u00af\u0005\"\u0000\u0000"+
		"\u00af.\u0001\u0000\u0000\u0000\u00b0\u00b2\u0005-\u0000\u0000\u00b1\u00b0"+
		"\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b5\u0007\u0000\u0000\u0000\u00b4\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b8"+
		"\u0001\u0000\u0000\u0000\u00b8\u00ba\u0005.\u0000\u0000\u00b9\u00bb\u0007"+
		"\u0000\u0000\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001"+
		"\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001"+
		"\u0000\u0000\u0000\u00bd0\u0001\u0000\u0000\u0000\u00be\u00c0\u0005-\u0000"+
		"\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000"+
		"\u0000\u00c0\u00c2\u0001\u0000\u0000\u0000\u00c1\u00c3\u0007\u0000\u0000"+
		"\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000"+
		"\u0000\u00c52\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005t\u0000\u0000\u00c7"+
		"\u00c8\u0005r\u0000\u0000\u00c8\u00c9\u0005u\u0000\u0000\u00c9\u00d0\u0005"+
		"e\u0000\u0000\u00ca\u00cb\u0005f\u0000\u0000\u00cb\u00cc\u0005a\u0000"+
		"\u0000\u00cc\u00cd\u0005l\u0000\u0000\u00cd\u00ce\u0005s\u0000\u0000\u00ce"+
		"\u00d0\u0005e\u0000\u0000\u00cf\u00c6\u0001\u0000\u0000\u0000\u00cf\u00ca"+
		"\u0001\u0000\u0000\u0000\u00d04\u0001\u0000\u0000\u0000\u00d1\u00d3\u0005"+
		"\"\u0000\u0000\u00d2\u00d4\b\u0001\u0000\u0000\u00d3\u00d2\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d8\u0005\"\u0000\u0000\u00d86\u0001\u0000\u0000"+
		"\u0000\u00d9\u00dd\u0007\u0002\u0000\u0000\u00da\u00dc\u0007\u0003\u0000"+
		"\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00dc\u00df\u0001\u0000\u0000"+
		"\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000"+
		"\u0000\u00de8\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000"+
		"\u00e0\u00e1\u0005,\u0000\u0000\u00e1:\u0001\u0000\u0000\u0000\u00e2\u00e3"+
		"\u0005{\u0000\u0000\u00e3<\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005}"+
		"\u0000\u0000\u00e5>\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005(\u0000\u0000"+
		"\u00e7@\u0001\u0000\u0000\u0000\u00e8\u00e9\u0005)\u0000\u0000\u00e9B"+
		"\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005.\u0000\u0000\u00ebD\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ed\u0007\u0004\u0000\u0000\u00ed\u00ee\u0001\u0000"+
		"\u0000\u0000\u00ee\u00ef\u0006\"\u0000\u0000\u00efF\u0001\u0000\u0000"+
		"\u0000\n\u0000\u00b1\u00b6\u00bc\u00bf\u00c4\u00cf\u00d5\u00db\u00dd\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}