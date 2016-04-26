// Generated from JavaLexer.g4 by ANTLR 4.5.3

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
public class JavaLexer extends BaseLexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Document=1, SingleLineComment=2, MultiLineComment=3, String=4, Statement=5, 
		Whitespace=6;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Document", "SingleLineComment", "MultiLineComment", "String", "Statement", 
		"Whitespace"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Document", "SingleLineComment", "MultiLineComment", "String", "Statement", 
		"Whitespace"
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
			return Arrays.asList(Statement, String);
		}

		public List<Integer> getDocumentTokens() {
			return Arrays.asList(Document);
		}


		public List<Integer> getCommentTokens() {
			return Arrays.asList(SingleLineComment, MultiLineComment);
		}


		// =========================================================================



	public JavaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JavaLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\bG\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\7\2\25\n\2"+
		"\f\2\16\2\30\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3!\n\3\f\3\16\3$\13\3"+
		"\3\4\3\4\3\4\3\4\7\4*\n\4\f\4\16\4-\13\4\3\4\3\4\3\4\3\5\3\5\3\5\7\5\65"+
		"\n\5\f\5\16\58\13\5\3\5\3\5\3\6\6\6=\n\6\r\6\16\6>\3\7\6\7B\n\7\r\7\16"+
		"\7C\3\7\3\7\4\26+\2\b\3\3\5\4\7\5\t\6\13\7\r\b\3\2\5\4\2\f\f\17\17\6\2"+
		"\f\f\17\17$$))\5\2\13\f\17\17\"\"M\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3\17\3\2\2\2\5\34\3\2\2\2\7%\3\2"+
		"\2\2\t\61\3\2\2\2\13<\3\2\2\2\rA\3\2\2\2\17\20\7\61\2\2\20\21\7,\2\2\21"+
		"\22\7,\2\2\22\26\3\2\2\2\23\25\13\2\2\2\24\23\3\2\2\2\25\30\3\2\2\2\26"+
		"\27\3\2\2\2\26\24\3\2\2\2\27\31\3\2\2\2\30\26\3\2\2\2\31\32\7,\2\2\32"+
		"\33\7\61\2\2\33\4\3\2\2\2\34\35\7\61\2\2\35\36\7\61\2\2\36\"\3\2\2\2\37"+
		"!\n\2\2\2 \37\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#\6\3\2\2\2$\"\3"+
		"\2\2\2%&\7\61\2\2&\'\7,\2\2\'+\3\2\2\2(*\13\2\2\2)(\3\2\2\2*-\3\2\2\2"+
		"+,\3\2\2\2+)\3\2\2\2,.\3\2\2\2-+\3\2\2\2./\7,\2\2/\60\7\61\2\2\60\b\3"+
		"\2\2\2\61\66\7$\2\2\62\65\7$\2\2\63\65\n\3\2\2\64\62\3\2\2\2\64\63\3\2"+
		"\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28\66\3\2\2\29"+
		":\7$\2\2:\n\3\2\2\2;=\n\3\2\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2"+
		"?\f\3\2\2\2@B\t\4\2\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2DE\3\2\2"+
		"\2EF\b\7\2\2F\16\3\2\2\2\n\2\26\"+\64\66>C\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}