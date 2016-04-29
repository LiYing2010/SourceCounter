package net.liying.sourceCounter.plugin.views

import org.eclipse.ui.PlatformUI
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.TableItem

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
		this.table.removeAll()

		var total = CountResult(null, "")
		resultList.forEach {
			result ->
				val file = result.file
				val countResult = result.countResult
				total += countResult

				val item = TableItem(this.table, SWT.NONE)

				var textArray = arrayOf(
						// Name
						file.name,
						// Resource Path
						file.fullPath.toString(),
						// File Path
						countResult.file?.absolutePath,
						// Extension
						file.fullPath.getFileExtension(),
						// Type
						countResult.type)
				if (countResult.type != Type.Unknown) {
					textArray += arrayOf(
						// Statement
						countResult.statement.toString(),
						// Document
						countResult.document.toString(),
						// Comment
						countResult.comment.toString(),
						// Empty
						countResult.empty.toString(),
						// Total
						countResult.total.toString()
					)
				}

				item.setText(textArray)
		}

		val item = TableItem(this.table, SWT.NONE)
		item.setText(arrayOf(
				// Name
				"Total",
				// Resource Path
				"",
				// File Path
				"",
				// Extension
				"",
				// Type
				total.type,
				// Statement
				total.statement.toString(),
				// Document
				total.document.toString(),
				// Comment
				total.comment.toString(),
				// Empty
				total.empty.toString(),
				// Total
				total.total.toString()
			))
	}
}
