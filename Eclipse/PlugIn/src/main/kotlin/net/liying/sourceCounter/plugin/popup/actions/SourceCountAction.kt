package net.liying.sourceCounter.plugin.popup.actions

import org.eclipse.jface.action.IAction
import org.eclipse.jface.viewers.ISelection
import org.eclipse.ui.IActionDelegate
import org.eclipse.ui.IObjectActionDelegate
import org.eclipse.ui.IWorkbenchPart
import org.eclipse.ui.IWorkbenchPartSite

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.Job

import net.liying.sourceCounter.plugin.SourceCounterRunner

class SourceCountAction: IObjectActionDelegate {
	private var site: IWorkbenchPartSite? = null

	private var selection: ISelection? = null

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	override fun setActivePart(action: IAction, targetPart: IWorkbenchPart) {
		this.site = targetPart.site
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
		val job = object: Job("Source Conter") {
			override fun run(monitor: IProgressMonitor): IStatus {
				SourceCounterRunner.Runner.count(this@SourceCountAction.selection,
						this@SourceCountAction.site as IWorkbenchPartSite,
						monitor)

				return Status.OK_STATUS;
			}
		}

		job.setUser(true)
		job.schedule()
	}
}
