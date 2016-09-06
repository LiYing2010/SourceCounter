package net.liying.sourceCounter.plugin.views

import org.eclipse.swt.*
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.widgets.*

import org.eclipse.core.resources.*

import org.jfree.chart.ChartFactory
import org.jfree.chart.JFreeChart
import org.jfree.chart.plot.PiePlot3D
import org.jfree.data.general.DefaultPieDataset
import org.jfree.data.general.PieDataset
import org.jfree.data.category.DefaultCategoryDataset
import org.jfree.experimental.chart.swt.ChartComposite
import org.jfree.util.Rotation

import net.liying.sourceCounter.plugin.views.base.BaseSourceCountResultChart
import net.liying.sourceCounter.plugin.FileCountResult

class SourceCountResultChart(parent: Composite, style: Int) : BaseSourceCountResultChart(parent, style) {
	public fun showResult(resultList: List<FileCountResult>) {
		this.clearChart()

		this.resultTree.showResult(resultList)
	}

	override fun showChart() {
		this.clearChart()

		val treeItem = this.resultTree.tree.selection.getOrNull(0)

		if (treeItem == null) {
			return
		}

		this.countByTreeItem(treeItem)
	}

	private fun clearChart() {
		this.removeAllWidgets(this.chartDisplayComposite)
	}

	private fun removeAllWidgets(parentComposite: Composite) {
		parentComposite.children.forEach {
			control -> control.dispose()
		}
	}

	private fun countByTreeItem(treeItem: TreeItem) {
		var title: String
		val categoryName: String
		var dataSet: Map<String, Int>

		if (this.radioBtnCountByPath.selection) {
			title = "Count by Path"
			categoryName = "Path"
			dataSet = this.countByPath(treeItem)
		} else {
			title = "Count by Type"
			categoryName = "Type"
			dataSet = this.countByType(treeItem)
		}

		var chart = if (this.radioBtnPieChart.selection) {
						this.createPieChart(title, dataSet)
					} else {
						this.createBarChart(title, categoryName, dataSet)
					}
		this.displayChartWidget(chart)
	}

	// =========================================================================

	private fun countByPath(treeItem: TreeItem): Map<String, Int> {
		val dataSet = linkedMapOf<String, Int>()

		treeItem.items.forEach {
			childItem ->
				val childResource = this.resultTree.getResource(childItem)

				val descendantResultList = this.resultTree.getAllDescendantResultList(childItem)
				val statementSum = this.statementSum(descendantResultList)

				dataSet.put(childResource.name, statementSum)
		}

		val descendantResultList = this.resultTree.getDirectDescendantResultList(treeItem)
		if (descendantResultList.isNotEmpty()) {
			val resource = this.resultTree.getResource(treeItem)
			val statementSum = this.statementSum(descendantResultList)

			dataSet.put("[${resource.name}]", statementSum)
		}

		return dataSet
	}

	private fun countByType(treeItem: TreeItem): Map<String, Int> {
		val descendantResultList = this.resultTree.getAllDescendantResultList(treeItem)

		val keySelector = {
			result: FileCountResult -> result.countResult.type
		}
		val valueTransform = {
			result: FileCountResult -> result.countResult.statement
		}
		// group by type
		val groupedList = descendantResultList.groupBy(keySelector, valueTransform)

		// sort by type
		val sortedList = groupedList.toList().sortedBy {
			pair -> pair.first
		}

		val dataSet = linkedMapOf<String, Int>()
		sortedList.forEach {
			pair -> dataSet.put(pair.first ?: "", pair.second.sum())
		}

		return dataSet
	}

	private fun statementSum(resultList: List<FileCountResult>): Int
		= resultList.sumBy { result -> result.countResult.statement }

	// =========================================================================

	private fun createPieChart(title: String, dataSet: Map<String, Int>): JFreeChart {
		val pieDataSet = DefaultPieDataset()

		dataSet.forEach {
			entry -> pieDataSet.setValue(entry.key, entry.value)
		}

		val chart = ChartFactory.createPieChart3D(title, pieDataSet)

		val plot = chart.plot as PiePlot3D
		plot.startAngle = 290.0
		plot.direction = Rotation.CLOCKWISE
		plot.foregroundAlpha = 0.5f

		return chart
	}

	private fun createBarChart(title: String, categoryName: String,
			dataSet: Map<String, Int>): JFreeChart {
		val categoryDataset = DefaultCategoryDataset()

		dataSet.forEach {
			entry -> categoryDataset.addValue(entry.value, entry.key, "Statement")
		}

		val chart = ChartFactory.createBarChart(title, categoryName, "Line Count",
				categoryDataset)

		return chart
	}

	private fun displayChartWidget(chart: JFreeChart) {
		val chartComposite = ChartComposite(this.chartDisplayComposite, SWT.NONE, chart, true)
		val gridData = GridData(SWT.FILL, SWT.FILL, true, true)
		chartComposite.setLayoutData(gridData)

		this.chartDisplayComposite.layout(true)
	}
}
