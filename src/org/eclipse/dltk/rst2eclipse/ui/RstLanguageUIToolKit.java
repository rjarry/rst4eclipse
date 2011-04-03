package org.eclipse.dltk.rst2eclipse.ui;

import org.eclipse.dltk.core.IDLTKLanguageToolkit;
import org.eclipse.dltk.rst2eclipse.RstActivator;
import org.eclipse.dltk.rst2eclipse.core.RstLanguageToolKit;
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
