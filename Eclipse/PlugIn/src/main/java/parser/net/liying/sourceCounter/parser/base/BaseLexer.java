package net.liying.sourceCounter.parser.base;

import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.WritableToken;

public abstract class BaseLexer extends Lexer {
	public BaseLexer(CharStream input) {
		super(input);
	}

	public abstract List<Integer> getStatementTokens();

	public abstract List<Integer> getDocumentTokens();

	public abstract List<Integer> getCommentTokens();

	public void fixToken(final WritableToken currentToken, final WritableToken preToken) {
		// TODO
	}
}
