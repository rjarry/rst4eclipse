package org.eclipse.rst4eclipse.ui;

import org.eclipse.dltk.core.IDLTKLanguageToolkit;
import org.eclipse.dltk.ui.AbstractDLTKUILanguageToolkit;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.rst4eclipse.RstActivator;
import org.eclipse.rst4eclipse.core.RstLanguageToolKit;

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
