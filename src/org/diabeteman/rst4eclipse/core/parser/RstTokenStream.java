package org.diabeteman.rst4eclipse.core.parser;

import java.util.List;
import java.util.Vector;

import org.antlr.runtime.ClassicToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.diabeteman.rst4eclipse.core.parser.grammar.RstLexer;
import org.diabeteman.rst4eclipse.core.parser.grammar.RstParser;

public class RstTokenStream implements TokenSource {
	public static final int MAX_INDENTS = 100;
	public static final int FIRST_CHAR_POSITION = 0;

	private int[] identation = new int[MAX_INDENTS];
	private int tabposition = -1;
	private Vector tokenBuffer = new Vector();
	private CommonTokenStream stream;
	private int lastIndex = -1;

	public RstTokenStream(CommonTokenStream stream) {
		this.stream = stream;

		push(FIRST_CHAR_POSITION);
	}

	public Token nextToken() {
		if (tokenBuffer.size() > 0) {
			Token t = (Token) tokenBuffer.firstElement();
			tokenBuffer.removeElementAt(0);
			return t;
		}

		insertFakeTokens();

		return nextToken();
	}

	protected void insertFakeTokens() {
		Token tok = stream.LT(1);
		stream.consume();
		if (tok.getType() != RstLexer.NEWLINE) {
			List hiddenTokens = stream.getTokens(lastIndex + 1, tok
					.getTokenIndex() - 1);
			if (hiddenTokens != null) {
				tokenBuffer.addAll(hiddenTokens);
			}
			lastIndex = tok.getTokenIndex();
			tokenBuffer.addElement(tok);
			return;
		}

		List hiddenTokens = stream.getTokens(lastIndex + 1,
				tok.getTokenIndex() - 1);
		if (hiddenTokens != null) {
			tokenBuffer.addAll(hiddenTokens);
		}
		lastIndex = tok.getTokenIndex();
		tokenBuffer.addElement(tok);

		tok = stream.LT(1);
		stream.consume();

		hiddenTokens = stream.getTokens(lastIndex + 1, tok.getTokenIndex() - 1);
		if (hiddenTokens != null) {
			tokenBuffer.addAll(hiddenTokens);
		}
		lastIndex = tok.getTokenIndex();

		int cpos = tok.getCharPositionInLine();
		if (tok.getType() == Token.EOF) {
			cpos = -1;
		} else if (tok.getType() == RstLexer.LEADING_WS) {
			cpos = tok.getText().length();
		}

		int lastIndent = peek();
		if (cpos > lastIndent) {
			push(cpos);
			createAddToken(RstParser.INDENT, tok);
		} else if (cpos < lastIndent) {
			int prevIndex = findPreviousIndent(cpos);
			for (int d = tabposition - 1; d >= prevIndex; d--) {
				createAddToken(RstParser.DEDENT, tok);
			}
			tabposition = prevIndex;
		}
		if (tok.getType() != RstLexer.LEADING_WS) {
			tokenBuffer.addElement(tok);
		}
	}

	private void createAddToken(int type, Token tok) {
		Token token = new ClassicToken(type, "");
		token.setCharPositionInLine(tok.getCharPositionInLine());
		token.setLine(tok.getLine());
		tokenBuffer.addElement(token);
	}

	protected void push(int i) {
		if (tabposition >= MAX_INDENTS) {
			throw new IllegalStateException("stack overflow");
		}
		tabposition++;
		identation[tabposition] = i;
	}

	protected int pop() {
		if (tabposition < 0) {
			throw new IllegalStateException("stack underflow");
		}
		int top = identation[tabposition];
		tabposition--;
		return top;
	}

	protected int peek() {
		return identation[tabposition];
	}

	protected int findPreviousIndent(int i) {
		for (int j = tabposition - 1; j >= 0; j--) {
			if (identation[j] == i) {
				return j;
			}
		}
		return FIRST_CHAR_POSITION;
	}

	@Override
	public String getSourceName() {
		return "Rst";
	}
}
