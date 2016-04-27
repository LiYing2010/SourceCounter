package net.liying.sourceCounter.plugin

import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource

import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection

import net.liying.sourceCounter.*

class SourceCounterRunner(val selection: IStructuredSelection) {
	companion object Runner {
		fun count(selection: ISelection) {
			if (selection is IStructuredSelection) {
				SourceCounterRunner(selection).count()
			}
		}
	}

	private val processedResourceSet = mutableSetOf<IResource>()

	private fun count() {
		this.selection.toList().forEach {
			item ->
				if (item is IResource) {
					this.countResource(item)
				}
		}
	}

	private fun countResource(resource: IResource) {
		if (processedResourceSet.contains(resource)) {
			return
		}

		processedResourceSet.add(resource)

		when (resource) {
			is IContainer ->
				resource.members().forEach {
					subResource ->
						this.countResource(subResource)
				}

			is IFile ->
				this.countFile(resource)
		}
	}

	private fun countFile(file: IFile) {
		val charSet = file.getCharset(true)

		val osFile = file.location.toFile().normalize()

		val counter = buildSourceCounter(osFile, charSet)
		counter.count()

		println("CharSet: ${charSet}; File: ${osFile}")
		counter.countResult.print()
	}
}
