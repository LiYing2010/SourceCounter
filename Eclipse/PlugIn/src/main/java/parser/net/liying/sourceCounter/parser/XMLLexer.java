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
		Comment=1, TagStart=2, TagEnd=3, Statement=4, Whitespace=5;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Comment", "TagStart", "TagEnd", "Statement", "Whitespace"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Comment", "TagStart", "TagEnd", "Statement", "Whitespace"
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
			return Arrays.asList(TagStart, TagEnd, Statement);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\7>\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\7\2\24\n\2\f\2"+
		"\16\2\27\13\2\3\2\3\2\3\2\3\2\3\3\3\3\7\3\37\n\3\f\3\16\3\"\13\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\6\4*\n\4\r\4\16\4+\3\4\3\4\3\4\5\4\61\n\4\3\5\6\5\64"+
		"\n\5\r\5\16\5\65\3\6\6\69\n\6\r\6\16\6:\3\6\3\6\5\25 +\2\7\3\3\5\4\7\5"+
		"\t\6\13\7\3\2\4\6\2\f\f\17\17#/>>\5\2\13\f\17\17\"\"C\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\3\r\3\2\2\2\5\34\3\2\2\2"+
		"\7\60\3\2\2\2\t\63\3\2\2\2\138\3\2\2\2\r\16\7>\2\2\16\17\7#\2\2\17\20"+
		"\7/\2\2\20\21\7/\2\2\21\25\3\2\2\2\22\24\13\2\2\2\23\22\3\2\2\2\24\27"+
		"\3\2\2\2\25\26\3\2\2\2\25\23\3\2\2\2\26\30\3\2\2\2\27\25\3\2\2\2\30\31"+
		"\7/\2\2\31\32\7/\2\2\32\33\7@\2\2\33\4\3\2\2\2\34 \7>\2\2\35\37\13\2\2"+
		"\2\36\35\3\2\2\2\37\"\3\2\2\2 !\3\2\2\2 \36\3\2\2\2!#\3\2\2\2\" \3\2\2"+
		"\2#$\7@\2\2$\6\3\2\2\2%&\7>\2\2&\'\7\61\2\2\')\3\2\2\2(*\13\2\2\2)(\3"+
		"\2\2\2*+\3\2\2\2+,\3\2\2\2+)\3\2\2\2,-\3\2\2\2-\61\7@\2\2./\7\61\2\2/"+
		"\61\7@\2\2\60%\3\2\2\2\60.\3\2\2\2\61\b\3\2\2\2\62\64\n\2\2\2\63\62\3"+
		"\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\n\3\2\2\2\679\t\3"+
		"\2\28\67\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\b\6\2\2=\f"+
		"\3\2\2\2\t\2\25 +\60\65:\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}