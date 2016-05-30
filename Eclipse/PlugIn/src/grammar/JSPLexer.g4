lexer grammar JSPLexer;

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

}

// =============================================================================

SingleLineCommentForJava:
	'//' ~[\r\n]*
;

MultiLineCommentForJava:
	'/*' .*? '*/'
;

CommentForXML:
	'<!--' .*? '-->'
;

CommentForScript:
	'<%--' .*? '--%>'
;

// =============================================================================
ScriptStart:
	'<%'
;

ScriptEnd:
	'%>'
;


XMLTagStart:
	'<' ~[%] .*? '>'
;

XMLTagEnd:
	('</' .+? '>')
		|
	('/>')
;

Statement:
	~[\r\n<]+
;

// =============================================================================

Whitespace:
	[ \t\r\n]+
		-> skip
;
