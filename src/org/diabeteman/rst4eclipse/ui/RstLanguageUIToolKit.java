package org.diabeteman.rst4eclipse.ui;

import org.diabeteman.rst4eclipse.RstActivator;
import org.diabeteman.rst4eclipse.core.RstLanguageToolKit;
import org.eclipse.dltk.core.IDLTKLanguageToolkit;
import org.eclipse.dltk.ui.AbstractDLTKUILanguageToolkit;
import org.eclipse.jface.preference.IPreferenceStore;

public class RstLanguageUIToolKit extends AbstractDLTKUILanguageToolkit {

	@Override
	public IDLTKLanguageToolkit getCoreToolkit() {
		return RstLanguageToolKit.getDefault();
	}

	@Override
	public IPreferenceStore getPreferenceStore() {
		return RstActivator.getDefault().getPreferenceStore();
	}

}
