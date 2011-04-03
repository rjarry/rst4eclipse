package org.eclipse.dltk.rst2eclipse.core;

import java.util.regex.Pattern;

import org.eclipse.dltk.core.ScriptContentDescriber;;

public class RstContentDescriber extends ScriptContentDescriber {

	protected static final Pattern[] HEADER_PATTERNS = {};
	
	public RstContentDescriber() {
		super();
	}

	@Override
	protected Pattern[] getHeaderPatterns() {
		return HEADER_PATTERNS;
	}

}
