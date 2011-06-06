package org.diabeteman.rst4eclipse;

import java.util.Vector;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;

import antlr.TokenStreamException;

/*
 [The "BSD licence"]
 Copyright (c) 2004 Terence Parr and Loring Craymer
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
 notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
 notice, this list of conditions and the following disclaimer in the
 documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
 derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * Python does not explicitly provide begin and end nesting signals. Rather, the
 * indentation level indicates when you begin and end. This is an interesting
 * lexical problem because multiple DEDENT tokens should be sent to the parser
 * sometimes without a corresponding input symbol! Consider the following
 * example:
 * 
 * a=1 if a>1: print a b=3
 * 
 * Here the "b" token on the left edge signals that a DEDENT is needed after the
 * "print a \n" and before the "b". The sequence should be
 * 
 * ... 1 COLON LineBreak INDENT PRINT a LineBreak DEDENT b ASSIGN 3 ...
 * 
 * For more examples, see the big comment at the bottom of this file.
 * 
 * This TokenStream normally just passes tokens through to the parser. Upon
 * LineBreak token from the lexer, however, an INDENT or DEDENT token may need
 * to be sent to the parser. The LineBreak is the trigger for this class to do
 * it's job. LineBreak is saved and then the first token of the next line is
 * examined. If non-leading-whitespace token, then check against stack for
 * indent vs dedent. If LeadingWs, then the column of the next non-whitespace
 * token will dictate indent vs dedent. The column of the next real token is
 * number of spaces in the LeadingWs token + 1 (to move past the whitespace).
 * The lexer grammar must set the text of the LeadingWs token to be the proper
 * number of spaces (and do tab conversion etc...).
 * 
 * A stack of column numbers is tracked and used to detect changes in indent
 * level from one token to the next.
 * 
 * A queue of tokens is built up to hold multiple DEDENT tokens that are
 * generated. Before asking the lexer for another token via nextToken(), the
 * queue is flushed first one token at a time.
 * 
 * Terence Parr and Loring Craymer February 2004
 */
public class RstTokenStream extends CommonTokenStream {
    public static final int MAX_INDENTS = 100;
    public static final int FIRST_COLUMN = 1;

    /** The stack of indent levels (column numbers) */
    int[] indentStack = new int[MAX_INDENTS];
    /** stack pointer */
    int sp = -1; // grow upwards

    /** The queue of tokens */
    Vector<Token> tokens = new Vector<Token>();

    /** We pull real tokens from this lexer */
    RstLexer lexer;

    public RstTokenStream(RstLexer lexer) {
        this.lexer = lexer;
        push(FIRST_COLUMN); // "state" of indent level is FIRST_COLUMN
    }

    /**
     * From http://www.python.org/doc/2.2.3/ref/indentation.html
     * 
     * "Before the first line of the file is read, a single zero is pushed on
     * the stack; this will never be popped off again. The numbers pushed on the
     * stack will always be strictly increasing from bottom to top. At the
     * beginning of each logical line, the line's indentation level is compared
     * to the top of the stack. If it is equal, nothing happens. If it is
     * larger, it is pushed on the stack, and one INDENT token is generated. If
     * it is smaller, it must be one of the numbers occurring on the stack; all
     * numbers on the stack that are larger are popped off, and for each number
     * popped off a DEDENT token is generated. At the end of the file, a DEDENT
     * token is generated for each number remaining on the stack that is larger
     * than zero."
     * 
     * I use columns 1..n instead.
     * 
     * The DEDENTS possibly needed at EOF are gracefully handled by forcing EOF
     * to have column 1 even though with UNIX it's hard to get EOF at a non left
     * edge.
     */
    public Token nextToken() throws TokenStreamException {
        // if something in queue, just remove and return it
        if (tokens.size() > 0) {
            Token t = tokens.firstElement();
            tokens.removeElementAt(0);
            // System.out.println(t);
            return t;
        }

        insertImaginaryIndentDedentTokens();

        return nextToken();
    }

    protected void insertImaginaryIndentDedentTokens() throws TokenStreamException {
        Token t = lexer.nextToken();

        // if not a LineBreak, doesn't signal indent/dedent work; just enqueue
        if (t.getType() != RstLexer.LINE_BREAK) {
            tokens.addElement(t);
            return;
        }
        // save LineBreak in the queue
        tokens.addElement(t);
        // grab first token of next line
        t = lexer.nextToken();

        // compute col as the column number of next non-WS token in line
        int col = t.getCharPositionInLine(); // column dictates indent/dedent
        if (t.getType() == RstLexer.EOF) {
            col = 1; // pretend EOF always happens at left edge
        } else if (t.getType() == RstLexer.LEADING_WS) {
            col = t.getText().length() + 1; // col is 1 spot after size
        }

        // compare to last indent level
        int lastIndent = peek();
        if (col > lastIndent) { // they indented; track and gen INDENT
            push(col);
            Token indent = new CommonToken(RstParser.Indent, "");
            indent.setCharPositionInLine(t.getCharPositionInLine());
            indent.setLine(t.getLine());
            tokens.addElement(indent);
        } else if (col < lastIndent) { // they dedented
            // how far back did we dedent?
            int prevIndex = findPreviousIndent(col);
            // generate DEDENTs for each indent level we backed up over
            for (int d = sp - 1; d >= prevIndex; d--) {
                Token dedent = new CommonToken(RstParser.Dedent, "");
                dedent.setCharPositionInLine(t.getCharPositionInLine());
                dedent.setLine(t.getLine());
                tokens.addElement(dedent);
            }
            sp = prevIndex; // pop those off indent level
        }
        if (t.getType() != RstLexer.LEADING_WS) { // discard WS
            tokens.addElement(t);
        }
    }

    // TOKEN STACK METHODS

    protected void push(int i) {
        if (sp >= MAX_INDENTS) {
            throw new IllegalStateException("Indent Token stack overflow");
        }
        sp++;
        indentStack[sp] = i;
    }

    protected int pop() {
        if (sp < 0) {
            throw new IllegalStateException("Indent Token stack underflow");
        }
        int top = indentStack[sp];
        sp--;
        return top;
    }

    protected int peek() {
        return indentStack[sp];
    }

    /** Return the index on stack of previous indent level == i else -1 */
    protected int findPreviousIndent(int i) {
        for (int j = sp - 1; j >= 0; j--) {
            if (indentStack[j] == i) {
                return j;
            }
        }
        return -1;
    }
}
