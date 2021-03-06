// Generated from JavaScriptLexer.g4 by ANTLR 4.5.3

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
public class JavaScriptLexer extends BaseLexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Document=1, SingleLineComment=2, MultiLineComment=3, SingleQuotationString=4, 
		DoubleQuotationString=5, Statement=6, Whitespace=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Document", "SingleLineComment", "MultiLineComment", "SingleQuotationString", 
		"DoubleQuotationString", "Statement", "Whitespace"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Document", "SingleLineComment", "MultiLineComment", "SingleQuotationString", 
		"DoubleQuotationString", "Statement", "Whitespace"
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
			return Arrays.asList(Statement, SingleQuotationString, DoubleQuotationString);
		}

		public List<Integer> getDocumentTokens() {
			return Arrays.asList(Document);
		}


		public List<Integer> getCommentTokens() {
			return Arrays.asList(SingleLineComment, MultiLineComment);
		}


		// =========================================================================



	public JavaScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JavaScriptLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\tU\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\7\2"+
		"\27\n\2\f\2\16\2\32\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3#\n\3\f\3\16\3"+
		"&\13\3\3\4\3\4\3\4\3\4\7\4,\n\4\f\4\16\4/\13\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\7\58\n\5\f\5\16\5;\13\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6C\n\6\f\6\16\6"+
		"F\13\6\3\6\3\6\3\7\6\7K\n\7\r\7\16\7L\3\b\6\bP\n\b\r\b\16\bQ\3\b\3\b\6"+
		"\30-9D\2\t\3\3\5\4\7\5\t\6\13\7\r\b\17\t\3\2\6\4\2\f\f\17\17\5\2\f\f\17"+
		"\17))\6\2\f\f\17\17$$))\5\2\13\f\17\17\"\"]\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\21\3\2"+
		"\2\2\5\36\3\2\2\2\7\'\3\2\2\2\t\63\3\2\2\2\13>\3\2\2\2\rJ\3\2\2\2\17O"+
		"\3\2\2\2\21\22\7\61\2\2\22\23\7,\2\2\23\24\7,\2\2\24\30\3\2\2\2\25\27"+
		"\13\2\2\2\26\25\3\2\2\2\27\32\3\2\2\2\30\31\3\2\2\2\30\26\3\2\2\2\31\33"+
		"\3\2\2\2\32\30\3\2\2\2\33\34\7,\2\2\34\35\7\61\2\2\35\4\3\2\2\2\36\37"+
		"\7\61\2\2\37 \7\61\2\2 $\3\2\2\2!#\n\2\2\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2"+
		"\2\2$%\3\2\2\2%\6\3\2\2\2&$\3\2\2\2\'(\7\61\2\2()\7,\2\2)-\3\2\2\2*,\13"+
		"\2\2\2+*\3\2\2\2,/\3\2\2\2-.\3\2\2\2-+\3\2\2\2.\60\3\2\2\2/-\3\2\2\2\60"+
		"\61\7,\2\2\61\62\7\61\2\2\62\b\3\2\2\2\639\7)\2\2\64\65\7^\2\2\658\7)"+
		"\2\2\668\n\3\2\2\67\64\3\2\2\2\67\66\3\2\2\28;\3\2\2\29:\3\2\2\29\67\3"+
		"\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7)\2\2=\n\3\2\2\2>D\7$\2\2?@\7^\2\2@C\7$"+
		"\2\2AC\n\4\2\2B?\3\2\2\2BA\3\2\2\2CF\3\2\2\2DE\3\2\2\2DB\3\2\2\2EG\3\2"+
		"\2\2FD\3\2\2\2GH\7$\2\2H\f\3\2\2\2IK\n\4\2\2JI\3\2\2\2KL\3\2\2\2LJ\3\2"+
		"\2\2LM\3\2\2\2M\16\3\2\2\2NP\t\5\2\2ON\3\2\2\2PQ\3\2\2\2QO\3\2\2\2QR\3"+
		"\2\2\2RS\3\2\2\2ST\b\b\2\2T\20\3\2\2\2\f\2\30$-\679BDLQ\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}