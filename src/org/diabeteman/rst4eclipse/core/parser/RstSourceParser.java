/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.diabeteman.rst4eclipse.core.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.diabeteman.rst4eclipse.core.parser.ast.RstFileDeclaration;
import org.diabeteman.rst4eclipse.core.parser.grammar.RstLexer;
import org.diabeteman.rst4eclipse.core.parser.grammar.RstParser;
import org.eclipse.dltk.ast.parser.AbstractSourceParser;
import org.eclipse.dltk.ast.parser.IModuleDeclaration;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.dltk.core.DLTKCore;

public class RstSourceParser extends AbstractSourceParser {
	private TokenStream fTokenStream;
	private IProblemReporter problemReporter = null;

	public RstSourceParser(/* IProblemReporter reporter */) {
		// this.problemReporter = reporter;
	}

	public static class MyLexer extends RstLexer {
		public MyLexer(CharStream lexer) {
			super(lexer);
		}

		public Token nextToken() {
			startPos = getCharPositionInLine();
			return super.nextToken();
		}
	}

	/**
	 * Parses selected context to module declaration using python parser.
	 * 
	 */
	public IModuleDeclaration parse(IModuleSource input,
			IProblemReporter reporter) {// throws
		this.problemReporter = reporter;
		char[] content0 = input.getContentsAsCharArray();

		RstFileDeclaration moduleDeclaration = new RstFileDeclaration(
				content0.length, true);

		CharStream st = new ANTLRStringStream(content0, content0.length);
		RstLexer pythonLexer = new MyLexer(st);

		CommonTokenStream tokens = new CommonTokenStream(pythonLexer);
		RstTokenStream indentedSource = new RstTokenStream(tokens);
		tokens = new CommonTokenStream(indentedSource);
		this.fTokenStream = tokens;

		RstParser rstParser = new RstParser(this.fTokenStream);
		rstParser.decl = moduleDeclaration;
		rstParser.length = content0.length;
		rstParser.converter = new DLTKRstTokenConverter(content0);
		rstParser.reporter = new DLTKRstErrorReporter(
				rstParser.converter, problemReporter, rstParser);

		try {
			rstParser.document();
		} catch (Throwable e) {
			if (DLTKCore.DEBUG_PARSER) {
				e.printStackTrace();
			}
		}
		moduleDeclaration.rebuild();

		return moduleDeclaration;
	}
}
