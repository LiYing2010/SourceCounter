package net.liying.sourceCounter.plugin

import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.SubMonitor
import org.eclipse.ui.IWorkbenchPartSite
import org.eclipse.swt.widgets.Display

import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection

import net.liying.sourceCounter.*
import net.liying.sourceCounter.plugin.views.SourceCountResultView

data class FileCountResult(val file: IFile, val countResult: CountResult)

class SourceCounterRunner(val selection: IStructuredSelection) {
	companion object Runner {
		fun count(selection: ISelection?, site: IWorkbenchPartSite,
				monitor: IProgressMonitor) {
			if (selection is IStructuredSelection) {
				SourceCounterRunner(selection).count(site, monitor)
			}
		}
	}

	private val processedResourceSet = mutableSetOf<IResource>()

	private val countResultList = mutableListOf<FileCountResult>()

	private fun count(site: IWorkbenchPartSite, monitor: IProgressMonitor) {
		val workCount = this.selection.toList().sumBy {
			item -> this.getWorkCount(item)
		}

		val subMonitor = SubMonitor.convert(monitor, workCount)

		this.selection.toList().forEach {
			item -> if (item is IResource) {
						this.countResource(item, subMonitor)
					}
		}

		subMonitor.done()

		Display.getDefault().asyncExec {
			val resultView = SourceCountResultView.showView(site)
			resultView?.showResult(this.countResultList)
		}
	}

	private fun getWorkCount(item: Any?): Int
		= when (item) {
			is IContainer -> item.members().sumBy {
								subResource -> this.getWorkCount(subResource)
							}
			is IFile -> 1
			else -> 0
		}

	private fun countResource(resource: IResource, subMonitor: SubMonitor) {
		if (this.processedResourceSet.contains(resource)) {
			return
		}

		this.processedResourceSet.add(resource)

		when (resource) {
			is IContainer ->
				resource.members().forEach {
					subResource ->
						this.countResource(subResource, subMonitor)
				}

			is IFile -> {
						this.countFile(resource)
						subMonitor.internalWorked(1.0)
					}
		}
	}

	private fun countFile(file: IFile) {
		val charSet = file.getCharset(true)

		val osFile = file.location.toFile().normalize()

		val counter = buildSourceCounter(osFile, charSet)
		counter.count()

		this.countResultList.add(FileCountResult(file, counter.countResult))
	}
}
