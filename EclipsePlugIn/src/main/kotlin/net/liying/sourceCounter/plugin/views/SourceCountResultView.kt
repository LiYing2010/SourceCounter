package net.liying.sourceCounter.plugin.views

import java.lang.StringBuilder

import org.eclipse.ui.PlatformUI
import org.eclipse.swt.*
import org.eclipse.swt.widgets.*
import org.eclipse.swt.dnd.Clipboard
import org.eclipse.swt.dnd.TextTransfer
import org.eclipse.jface.dialogs.MessageDialog

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
		this.resultList = resultList.toMutableList()

		this.total = CountResult(null, "")
		resultList.forEach {
			result ->
				total += result.countResult
		}

		this.table.sortColumn = this.resPathColumn
		this.table.sortDirection = SWT.UP

		this.sortResultList()
		this.displayResult(true)
	}

	// =========================================================================
	private var parent: Composite? = null

	private var clipboard: Clipboard? = null

	// =========================================================================
	override fun createPartControl(parent: Composite) {
		super.createPartControl(parent)

		this.parent = parent
		this.clipboard = Clipboard(parent.display)

		this.table.columns.forEach {
			column -> column.addListener(SWT.Selection) {
							event -> this.sortActionListener(event)
						}
		}
	}

	// =========================================================================

	private var resultList = mutableListOf<FileCountResult>()

	private var total = CountResult(null, "")

	// =========================================================================

	/**
	 * Listener for sort action
	 */
	private fun sortActionListener(event: Event) {
		val clickedColumn = event.widget as TableColumn

		if (this.table.sortColumn === clickedColumn) {
			this.table.sortDirection = when (this.table.sortDirection) {
											SWT.UP -> SWT.DOWN
											else -> SWT.UP
										}
		} else {
			this.table.sortColumn = clickedColumn
			this.table.sortDirection = SWT.UP
		}

		this.sortResultList()
		this.displayResult(false)
	}

	private fun sortResultList() {
		val sortColumn = this.table.sortColumn

		val selector = { result: FileCountResult ->
				when (sortColumn) {
					this.nameColumn -> result.file.name

					this.resPathColumn -> result.file.fullPath.toString()

					this.filePathColumn -> result.countResult.file?.absolutePath

					this.extensionColumn -> result.file.fullPath.fileExtension

					this.typeColumn -> result.countResult.type

					this.statementColumn -> this.getLineIntForSort(result.countResult.type, result.countResult.statement)

					this.documentColumn -> this.getLineIntForSort(result.countResult.type, result.countResult.document)

					this.commentColumn -> this.getLineIntForSort(result.countResult.type, result.countResult.comment)

					this.emptyColumn -> this.getLineIntForSort(result.countResult.type, result.countResult.empty)

					this.totalColumn -> this.getLineIntForSort(result.countResult.type, result.countResult.total)

					else -> null
				} as Comparable<Any>
		}

		if (this.table.sortDirection == SWT.UP)
			this.resultList.sortBy(selector)
		else
			this.resultList.sortByDescending (selector)
	}

	private fun getLineIntForSort(type: String?, lineInt: Int): Int {
		return if (type == Type.Unknown) -1 else lineInt
	}

	private fun displayResult(createFlag: Boolean) {
		if (createFlag)
			this.table.removeAll()
		else
			this.table.clearAll()

		// =====================================================================
		// show rows for all the count results
		this.resultList.forEachIndexed {
			idx, result ->
				val file = result.file
				val countResult = result.countResult

				val item = if (createFlag)
							TableItem(this.table, SWT.NONE)
						else
							this.table.getItem(idx)

				var textArray = arrayOf(
						// Name
						file.name,
						// Resource Path
						file.fullPath.toString(),
						// File Path
						countResult.file?.absolutePath,
						// Extension
						file.fullPath.fileExtension,
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

		// =====================================================================
		// show row for the summation
		val item = if (createFlag)
					TableItem(this.table, SWT.NONE)
				else
					this.table.getItem(this.resultList.size)

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

	// =========================================================================

	/**
	 * Handler for Select All action
	 */
	override fun runSelectAllAction() {
		this.table.selectAll()
	}

	/**
	 * Handler for Copy action
	 */
	override fun runCopyAction() {
		val columnCount = this.table.columnCount

		var content = StringBuilder()

		val columnArray = Array(columnCount) {
			idx -> this.table.columns[idx].text
		}
		columnArray.joinTo(content, "\t")
		content.append("\n")

		this.table.selection.forEach {
			tableItem ->
				val textArray = Array(columnCount) {
					idx -> tableItem.getText(idx)
				}
				textArray.joinTo(content, "\t")
				content.append("\n")
		}

		val transfer = TextTransfer.getInstance()
		this.clipboard?.setContents(arrayOf(content.toString()), arrayOf(transfer))
	}

	/**
	 * Handler for Clear action
	 */
	override fun runClearAction() {
		val confirmResult = MessageDialog.openConfirm(this.parent?.shell,
				"Confirm", "Clear the count result?")
		if (confirmResult) {
			this.resultList.clear()
			this.table.removeAll()
		}
	}
}
