// Generated from JSPLexer.g4 by ANTLR 4.5.3

package net.liying.sourceCounter.parser;

import java.util.Arrays;
import java.util.List;

import net.liying.sourceCounter.parser.base.BaseLexer;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JSPLexer extends BaseLexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SingleLineCommentForJava=1, MultiLineCommentForJava=2, CommentForXML=3, 
		CommentForScript=4, ScriptStart=5, ScriptEnd=6, XMLTagStart=7, XMLTagEnd=8, 
		Statement=9, Whitespace=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SingleLineCommentForJava", "MultiLineCommentForJava", "CommentForXML", 
		"CommentForScript", "ScriptStart", "ScriptEnd", "XMLTagStart", "XMLTagEnd", 
		"Statement", "Whitespace"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'<%'", "'%>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SingleLineCommentForJava", "MultiLineCommentForJava", "CommentForXML", 
		"CommentForScript", "ScriptStart", "ScriptEnd", "XMLTagStart", "XMLTagEnd", 
		"Statement", "Whitespace"
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



		// =========================================================================

		public List<Integer> getStatementTokens() {
			return Arrays.asList(ScriptStart, ScriptEnd, XMLTagStart, XMLTagEnd,
				Statement);
		}

		public List<Integer> getDocumentTokens() {
			return Arrays.asList();
		}


		public List<Integer> getCommentTokens() {
			return Arrays.asList(SingleLineCommentForJava, MultiLineCommentForJava,
				CommentForXML, CommentForScript);
		}


		// =========================================================================



	public JSPLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JSPLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\ft\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\2\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\3\3\3\3\3\3\3\7\3%\n"+
		"\3\f\3\16\3(\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4\63\n\4\f\4\16"+
		"\4\66\13\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5B\n\5\f\5\16\5E"+
		"\13\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\7\bU\n\b"+
		"\f\b\16\bX\13\b\3\b\3\b\3\t\3\t\3\t\3\t\6\t`\n\t\r\t\16\ta\3\t\3\t\3\t"+
		"\5\tg\n\t\3\n\6\nj\n\n\r\n\16\nk\3\13\6\13o\n\13\r\13\16\13p\3\13\3\13"+
		"\7&\64CVa\2\f\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\3\2\6\4\2"+
		"\f\f\17\17\3\2\'\'\5\2\f\f\17\17>>\5\2\13\f\17\17\"\"|\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2\5 \3\2\2\2\7,\3\2"+
		"\2\2\t;\3\2\2\2\13K\3\2\2\2\rN\3\2\2\2\17Q\3\2\2\2\21f\3\2\2\2\23i\3\2"+
		"\2\2\25n\3\2\2\2\27\30\7\61\2\2\30\31\7\61\2\2\31\35\3\2\2\2\32\34\n\2"+
		"\2\2\33\32\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\4\3\2"+
		"\2\2\37\35\3\2\2\2 !\7\61\2\2!\"\7,\2\2\"&\3\2\2\2#%\13\2\2\2$#\3\2\2"+
		"\2%(\3\2\2\2&\'\3\2\2\2&$\3\2\2\2\')\3\2\2\2(&\3\2\2\2)*\7,\2\2*+\7\61"+
		"\2\2+\6\3\2\2\2,-\7>\2\2-.\7#\2\2./\7/\2\2/\60\7/\2\2\60\64\3\2\2\2\61"+
		"\63\13\2\2\2\62\61\3\2\2\2\63\66\3\2\2\2\64\65\3\2\2\2\64\62\3\2\2\2\65"+
		"\67\3\2\2\2\66\64\3\2\2\2\678\7/\2\289\7/\2\29:\7@\2\2:\b\3\2\2\2;<\7"+
		">\2\2<=\7\'\2\2=>\7/\2\2>?\7/\2\2?C\3\2\2\2@B\13\2\2\2A@\3\2\2\2BE\3\2"+
		"\2\2CD\3\2\2\2CA\3\2\2\2DF\3\2\2\2EC\3\2\2\2FG\7/\2\2GH\7/\2\2HI\7\'\2"+
		"\2IJ\7@\2\2J\n\3\2\2\2KL\7>\2\2LM\7\'\2\2M\f\3\2\2\2NO\7\'\2\2OP\7@\2"+
		"\2P\16\3\2\2\2QR\7>\2\2RV\n\3\2\2SU\13\2\2\2TS\3\2\2\2UX\3\2\2\2VW\3\2"+
		"\2\2VT\3\2\2\2WY\3\2\2\2XV\3\2\2\2YZ\7@\2\2Z\20\3\2\2\2[\\\7>\2\2\\]\7"+
		"\61\2\2]_\3\2\2\2^`\13\2\2\2_^\3\2\2\2`a\3\2\2\2ab\3\2\2\2a_\3\2\2\2b"+
		"c\3\2\2\2cg\7@\2\2de\7\61\2\2eg\7@\2\2f[\3\2\2\2fd\3\2\2\2g\22\3\2\2\2"+
		"hj\n\4\2\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\24\3\2\2\2mo\t\5\2"+
		"\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2qr\3\2\2\2rs\b\13\2\2s\26\3"+
		"\2\2\2\f\2\35&\64CVafkp\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}