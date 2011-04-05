package org.eclipse.rst4eclipse.core;

import org.eclipse.dltk.core.AbstractSourceElementParser;

public class RstSourceElementParser extends AbstractSourceElementParser {

	@Override
	protected String getNatureId() {
		return RstNature.RST_NATURE;
	}

}
