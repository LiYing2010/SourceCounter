// Generated from PythonLexer.g4 by ANTLR 4.5.3

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
public class PythonLexer extends BaseLexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SingleLineComment=1, SingleLineString_SingleQuotation=2, SingleLineString_DoubleQuotation=3, 
		MultiLineString=4, Statement=5, Whitespace=6;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SingleLineComment", "SingleLineString_SingleQuotation", "SingleLineString_DoubleQuotation", 
		"MultiLineString", "Statement", "Whitespace"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SingleLineComment", "SingleLineString_SingleQuotation", "SingleLineString_DoubleQuotation", 
		"MultiLineString", "Statement", "Whitespace"
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
		private static final int DOCString = 9999;


		public List<Integer> getStatementTokens() {
			return Arrays.asList(Statement, SingleLineString_SingleQuotation,
								SingleLineString_DoubleQuotation, MultiLineString);
		}

		public List<Integer> getDocumentTokens() {
			return Arrays.asList(DOCString);
		}

		public List<Integer> getCommentTokens() {
			return Arrays.asList(SingleLineComment);
		}

		@Override
		public void fixToken(final WritableToken currentToken, final WritableToken preToken) {
			if (currentToken == null) {
				return;
			}

			if (currentToken.getType() == MultiLineString) {
				if (preToken == null) {
					currentToken.setType(DOCString);
				} else if (preToken.getType() == Statement) {
					String tokenText = preToken.getText();
					String[] lines = tokenText.split("\\r\\n|\\n|\\r");
					int preTokenEndLine = preToken.getLine() + lines.length - 1;

					if (currentToken.getLine() > preTokenEndLine) {
						currentToken.setType(DOCString);
					}
				}
			}
		}

		// =========================================================================



	public PythonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PythonLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\bE\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\7\2\22\n\2\f\2\16\2\25"+
		"\13\2\3\3\3\3\3\3\3\3\7\3\33\n\3\f\3\16\3\36\13\3\3\3\3\3\3\4\3\4\3\4"+
		"\7\4%\n\4\f\4\16\4(\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\7\5\61\n\5\f\5\16"+
		"\5\64\13\5\3\5\3\5\3\5\3\5\3\6\6\6;\n\6\r\6\16\6<\3\7\6\7@\n\7\r\7\16"+
		"\7A\3\7\3\7\3\62\2\b\3\3\5\4\7\5\t\6\13\7\r\b\3\2\6\4\2\f\f\17\17\5\2"+
		"\f\f\17\17))\6\2\f\f\17\17$$))\5\2\13\f\17\17\"\"L\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3\17\3\2\2\2\5\26"+
		"\3\2\2\2\7!\3\2\2\2\t+\3\2\2\2\13:\3\2\2\2\r?\3\2\2\2\17\23\7%\2\2\20"+
		"\22\n\2\2\2\21\20\3\2\2\2\22\25\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24"+
		"\4\3\2\2\2\25\23\3\2\2\2\26\34\7)\2\2\27\30\7^\2\2\30\33\7)\2\2\31\33"+
		"\n\3\2\2\32\27\3\2\2\2\32\31\3\2\2\2\33\36\3\2\2\2\34\32\3\2\2\2\34\35"+
		"\3\2\2\2\35\37\3\2\2\2\36\34\3\2\2\2\37 \7)\2\2 \6\3\2\2\2!&\7$\2\2\""+
		"%\7$\2\2#%\n\4\2\2$\"\3\2\2\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2"+
		"\')\3\2\2\2(&\3\2\2\2)*\7$\2\2*\b\3\2\2\2+,\7$\2\2,-\7$\2\2-.\7$\2\2."+
		"\62\3\2\2\2/\61\13\2\2\2\60/\3\2\2\2\61\64\3\2\2\2\62\63\3\2\2\2\62\60"+
		"\3\2\2\2\63\65\3\2\2\2\64\62\3\2\2\2\65\66\7$\2\2\66\67\7$\2\2\678\7$"+
		"\2\28\n\3\2\2\29;\n\4\2\2:9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\f\3"+
		"\2\2\2>@\t\5\2\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\b"+
		"\7\2\2D\16\3\2\2\2\13\2\23\32\34$&\62<A\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}