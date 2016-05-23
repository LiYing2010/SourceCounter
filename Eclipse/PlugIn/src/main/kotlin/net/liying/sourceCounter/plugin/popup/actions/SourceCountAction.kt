package net.liying.sourceCounter.plugin.popup.actions

import org.eclipse.jface.action.IAction
import org.eclipse.jface.viewers.ISelection
import org.eclipse.swt.widgets.Shell
import org.eclipse.ui.IActionDelegate
import org.eclipse.ui.IObjectActionDelegate
import org.eclipse.ui.IWorkbenchPart

import net.liying.sourceCounter.plugin.SourceCounterRunner

class SourceCountAction: IObjectActionDelegate {
	private var shell: Shell? = null

	private var selection: ISelection? = null

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	override fun setActivePart(action: IAction, targetPart: IWorkbenchPart) {
		this.shell = targetPart.site.shell
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	override fun selectionChanged(action: IAction, selection: ISelection) {
		this.selection = selection
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	override fun run(action: IAction) {
		SourceCounterRunner.Runner.count(this.selection)
	}
}
