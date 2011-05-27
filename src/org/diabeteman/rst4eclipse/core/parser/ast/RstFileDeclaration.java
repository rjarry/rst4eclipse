package org.diabeteman.rst4eclipse.core.parser.ast;

import org.eclipse.dltk.ast.declarations.ModuleDeclaration;

public class RstFileDeclaration extends ModuleDeclaration {

    public RstFileDeclaration(int sourceLength) {
        super(sourceLength);
    }

    public RstFileDeclaration(int sourceLength, boolean rebuildEnabled) {
        super(sourceLength, rebuildEnabled);
    }

}
