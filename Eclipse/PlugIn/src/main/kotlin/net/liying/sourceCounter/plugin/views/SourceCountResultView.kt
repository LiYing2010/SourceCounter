package net.liying.sourceCounter.plugin.views

import java.lang.StringBuilder

import org.eclipse.ui.PlatformUI
import org.eclipse.swt.*
import org.eclipse.swt.widgets.*
import org.eclipse.swt.dnd.Clipboard
import org.eclipse.swt.dnd.TextTransfer
import org.eclipse.jface.dialogs.MessageDialog

import org.eclipse.core.resources.*

import net.liying.sourceCounter.*
import net.liying.sourceCounter.plugin.views.base.BaseSourceCountResultView
import net.liying.sourceCounter.plugin.FileCountResult

class SourceCountResultView: BaseSourceCountResultView() {
	companion object {
		/**
		 * The ID of the view as specified by the extension.
		 */
		private const val ID = "net.liying.sourceCounter.plugin.views.SourceCountResultView"

		fun showView(): SourceCountResultView? {
			val activePage = PlatformUI.getWorkbench().activeWorkbenchWindow.activePage
			activePage.showView(ID)

			activePage.viewReferences.forEach {
				viewRef ->
					val view = viewRef.getView(false)
					if (view is SourceCountResultView) {
						return view
					}
			}

			return null
		}
	}

	fun showResult(resultList: List<FileCountResult>) {
		(this.sourceCountResultTable as SourceCountResultTable).showResult(resultList)

		this.resultList = resultList.toMutableList()

		this.displayResultTree()
	}

	// =========================================================================
	private var resultList = mutableListOf<FileCountResult>()


	// =========================================================================

	override fun createResultTableCompsite(parent: Composite, style: Int)
		= SourceCountResultTable(parent, style)

	// =========================================================================

	private val treeItemMap = mutableMapOf<IResource, TreeItem>()

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

		this.treeItemMap.put(resource, treeItem)

		return treeItem
	}
}
