package net.liying.sourceCounter.plugin.views

import org.eclipse.ui.IWorkbenchPartSite
import org.eclipse.swt.widgets.Composite

import net.liying.sourceCounter.plugin.views.base.*
import net.liying.sourceCounter.plugin.FileCountResult

class SourceCountResultView: BaseSourceCountResultView() {
	companion object {
		/**
		 * The ID of the view as specified by the extension.
		 */
		private const val ID = "net.liying.sourceCounter.plugin.views.SourceCountResultView"

		fun showView(site: IWorkbenchPartSite): SourceCountResultView? {
			val page = site.page
			page.showView(ID)

			page.viewReferences.forEach {
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
		this.resultTable.showResult(resultList)

		this.resultChart.showResult(resultList)
	}
}
