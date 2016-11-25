lexer grammar PythonLexer;

@header {
package net.liying.sourceCounter.parser;

import java.util.Arrays;
import java.util.List;

import net.liying.sourceCounter.parser.base.BaseLexer;
}

options {
	superClass=BaseLexer;
}

@members {

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

}

// =============================================================================

SingleLineComment:
	'#' ~[\r\n]*
;

// =============================================================================

SingleLineString_SingleQuotation:
	'\'' ('\\\'' | ~[\r\n'\''])* '\''
;

SingleLineString_DoubleQuotation:
	'"' ('\"' | ~[\r\n'"'])* '"'
;

MultiLineString:
	'"""' .*? '"""'
;

// =============================================================================

Statement:
	~[\r\n'"'''']+
;

// =============================================================================

Whitespace:
	[ \t\r\n]+
		-> skip
;
