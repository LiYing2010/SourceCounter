// Generated from XMLLexer.g4 by ANTLR 4.5.3

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
public class XMLLexer extends BaseLexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Comment=1, Statement=2, Whitespace=3;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Comment", "Statement", "Whitespace"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Comment", "Statement", "Whitespace"
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
			return Arrays.asList(Statement);
		}

		public List<Integer> getDocumentTokens() {
			return Arrays.asList();
		}


		public List<Integer> getCommentTokens() {
			return Arrays.asList(Comment);
		}


		// =========================================================================



	public XMLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XMLLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\5$\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\3\2\3\2\3\2\3\2\3\2\3\2\7\2\20\n\2\f\2\16\2\23\13\2\3\2"+
		"\3\2\3\2\3\2\3\3\6\3\32\n\3\r\3\16\3\33\3\4\6\4\37\n\4\r\4\16\4 \3\4\3"+
		"\4\3\21\2\5\3\3\5\4\7\5\3\2\4\6\2\f\f\17\17#/>>\5\2\13\f\17\17\"\"&\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\3\t\3\2\2\2\5\31\3\2\2\2\7\36\3\2\2"+
		"\2\t\n\7>\2\2\n\13\7#\2\2\13\f\7/\2\2\f\r\7/\2\2\r\21\3\2\2\2\16\20\13"+
		"\2\2\2\17\16\3\2\2\2\20\23\3\2\2\2\21\22\3\2\2\2\21\17\3\2\2\2\22\24\3"+
		"\2\2\2\23\21\3\2\2\2\24\25\7/\2\2\25\26\7/\2\2\26\27\7@\2\2\27\4\3\2\2"+
		"\2\30\32\n\2\2\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2"+
		"\2\34\6\3\2\2\2\35\37\t\3\2\2\36\35\3\2\2\2\37 \3\2\2\2 \36\3\2\2\2 !"+
		"\3\2\2\2!\"\3\2\2\2\"#\b\4\2\2#\b\3\2\2\2\6\2\21\33 \3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}