lexer grammar KotlinLexer;

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

	public List<Integer> getStatementTokens() {
		return Arrays.asList(Statement, SingleLineString, MultiLineString);
	}

	public List<Integer> getDocumentTokens() {
		return Arrays.asList(Document);
	}


	public List<Integer> getCommentTokens() {
		return Arrays.asList(SingleLineComment, MultiLineComment);
	}


	// =========================================================================

}

// =============================================================================
Document:
	'/**' .*? '*/'
;

// =============================================================================

SingleLineComment:
	'//' ~[\r\n]*
;

MultiLineComment:
	'/*' .*? '*/'
;

// =============================================================================

SingleLineString:
	'"' ('\"' | ~[\r\n'"'])* '"'
;

MultiLineString:
	'"""' .*? '"""'
;

// =============================================================================

Statement:
	~[\r\n'"']+
;

// =============================================================================

Whitespace:
	[ \t\r\n]+
		-> skip
;
