// Generated from FefoLang.g4 by ANTLR 4.7.1
package fefolanguage.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FefoLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, OP=3, ID=4, NUM=5, WS=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "OP", "ID", "NUM", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "OP", "ID", "NUM", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\b:\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\7\5%\n\5\f\5\16\5"+
		"(\13\5\3\6\6\6+\n\6\r\6\16\6,\3\6\3\6\6\6\61\n\6\r\6\16\6\62\5\6\65\n"+
		"\6\3\7\3\7\3\7\3\7\2\2\b\3\3\5\4\7\5\t\6\13\7\r\b\3\2\7\5\2,-//\61\61"+
		"\3\2c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2=\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3\17\3\2\2\2\5\30"+
		"\3\2\2\2\7 \3\2\2\2\t\"\3\2\2\2\13*\3\2\2\2\r\66\3\2\2\2\17\20\7r\2\2"+
		"\20\21\7t\2\2\21\22\7q\2\2\22\23\7i\2\2\23\24\7t\2\2\24\25\7c\2\2\25\26"+
		"\7o\2\2\26\27\7c\2\2\27\4\3\2\2\2\30\31\7h\2\2\31\32\7k\2\2\32\33\7o\2"+
		"\2\33\34\7r\2\2\34\35\7t\2\2\35\36\7q\2\2\36\37\7i\2\2\37\6\3\2\2\2 !"+
		"\t\2\2\2!\b\3\2\2\2\"&\t\3\2\2#%\t\4\2\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2"+
		"&\'\3\2\2\2\'\n\3\2\2\2(&\3\2\2\2)+\t\5\2\2*)\3\2\2\2+,\3\2\2\2,*\3\2"+
		"\2\2,-\3\2\2\2-\64\3\2\2\2.\60\7\60\2\2/\61\t\5\2\2\60/\3\2\2\2\61\62"+
		"\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64.\3\2\2\2\64\65\3"+
		"\2\2\2\65\f\3\2\2\2\66\67\t\6\2\2\678\3\2\2\289\b\7\2\29\16\3\2\2\2\b"+
		"\2$&,\62\64\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}