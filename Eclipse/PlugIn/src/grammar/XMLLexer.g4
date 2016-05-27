lexer grammar XMLLexer;

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
		return Arrays.asList(Statement);
	}

	public List<Integer> getDocumentTokens() {
		return Arrays.asList();
	}


	public List<Integer> getCommentTokens() {
		return Arrays.asList(Comment);
	}


	// =========================================================================

}

// =============================================================================

Comment:
	'<!--' .*? '-->'
;

// =============================================================================

Statement:
	~[\r\n'<!--']+
;

// =============================================================================

Whitespace:
	[ \t\r\n]+
		-> skip
;
