package net.liying.sourceCounter.parser.base;

import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;

public abstract class BaseLexer extends Lexer {
	public abstract List<Integer> getStatementTokens();

	public abstract List<Integer> getDocumentTokens();

	public abstract List<Integer> getCommentTokens();

	public BaseLexer(CharStream input) {
		super(input);
	}
}
