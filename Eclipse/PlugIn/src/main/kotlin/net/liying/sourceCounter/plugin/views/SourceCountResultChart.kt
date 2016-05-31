package net.liying.sourceCounter.plugin.views

import org.eclipse.swt.*
import org.eclipse.swt.widgets.*

import org.eclipse.core.resources.*

import org.eclipse.wb.swt.ResourceManager

import net.liying.sourceCounter.plugin.views.base.BaseSourceCountResultChart
import net.liying.sourceCounter.plugin.FileCountResult

class SourceCountResultChart(parent: Composite, style: Int): BaseSourceCountResultChart(parent, style) {
	private var resultList = mutableListOf<FileCountResult>()

	private val treeItemMap = mutableMapOf<IResource, TreeItem>()

	val imageProject = ResourceManager.getPluginImageDescriptor(
			"SourceCounter", "images/icons/project.gif").createImage()

	val imageFolder = ResourceManager.getPluginImageDescriptor(
			"SourceCounter", "images/icons/folder.gif").createImage()

	// =========================================================================

	fun showResult(resultList: List<FileCountResult>) {
		this.resultList = resultList.toMutableList()

		this.displayResultTree()
	}

	private fun displayResultTree() {
		this.treeItemMap.clear()

		this.tree.removeAll()

		this.resultList.forEach {
			result ->
				val treeItem = this.createTreeItem(result.file.getParent())

				treeItem.data = result
		}
	}

	private fun createTreeItem(resource: IResource): TreeItem {
		var treeItem = this.treeItemMap.get(resource)
		if (treeItem != null) {
			return treeItem
		}

		val parent = resource.parent
		treeItem =
			if (parent != null && !(parent is IWorkspaceRoot)) {
				val parentItem = this.createTreeItem(parent)
				TreeItem(parentItem, SWT.NONE)
			} else {
				TreeItem(this.tree, SWT.NONE)
			}

		treeItem.setText(resource.name)

		when (resource) {
			is IProject -> treeItem.setImage(0, this.imageProject)
			is IFolder -> treeItem.setImage(0, this.imageFolder)
		}

		this.treeItemMap.put(resource, treeItem)

		return treeItem
	}
}
