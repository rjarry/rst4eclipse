package org.diabeteman.rst4eclipse.core;

import org.diabeteman.rst4eclipse.core.parser.RstSourceParser;
import org.eclipse.dltk.ast.parser.ISourceParser;
import org.eclipse.dltk.ast.parser.ISourceParserFactory;

public class RstSourceParserFactory implements ISourceParserFactory {

    @Override
    public ISourceParser createSourceParser() {
        return new RstSourceParser();
    }

}
