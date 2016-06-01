package net.liying.sourceCounter.plugin.views

import org.eclipse.swt.*
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.widgets.*

import org.eclipse.core.resources.*

import org.eclipse.wb.swt.ResourceManager

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

class SourceCountResultChart(parent: Composite, style: Int): BaseSourceCountResultChart(parent, style) {
	private var resultList = mutableListOf<FileCountResult>()

	private val treeItemMap = mutableMapOf<IContainer, TreeItem>()

	private val imageProject = ResourceManager.getPluginImageDescriptor(
			"SourceCounter", "images/icons/project.gif").createImage()

	private val imageFolder = ResourceManager.getPluginImageDescriptor(
			"SourceCounter", "images/icons/folder.gif").createImage()

	// =========================================================================

	fun showResult(resultList: List<FileCountResult>) {
		this.resultList = resultList.toMutableList()

		this.resultList.sortBy {
			result -> result.file.fullPath.toString()
		}

		this.displayResultTree()
	}

	// =========================================================================

	private fun displayResultTree() {
		this.treeItemMap.clear()

		this.clearChart()

		this.tree.removeAll()

		this.resultList.forEach {
			result -> this.createTreeItem(result.file.getParent())
		}
	}

	private fun createTreeItem(container: IContainer): TreeItem {
		var treeItem = this.treeItemMap.get(container)
		if (treeItem != null) {
			return treeItem
		}

		val parent = container.parent
		treeItem =
			if (parent != null && !(parent is IWorkspaceRoot)) {
				val parentItem = this.createTreeItem(parent)
				TreeItem(parentItem, SWT.NONE)
			} else {
				TreeItem(this.tree, SWT.NONE)
			}

		treeItem.data = container

		treeItem.setText(container.name)

		when (container) {
			is IProject -> treeItem.setImage(0, this.imageProject)
			is IFolder -> treeItem.setImage(0, this.imageFolder)
		}

		this.treeItemMap.put(container, treeItem)

		return treeItem
	}

	override fun showChart() {
		this.clearChart()

		val treeItem = this.tree.selection.getOrNull(0)

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
		}
		else {
			title = "Count by Type"
			categoryName = "Type"
			dataSet = this.countByType(treeItem)
		}

		var chart = if (this.radioBtnPieChart.selection) {
						this.createPieChart(title, dataSet)
					}
					else {
						this.createBarChart(title, categoryName, dataSet)
					}
		this.displayChartWidget(chart)
	}

	// =========================================================================

	private fun countByPath(treeItem: TreeItem): Map<String, Int> {
		val dataSet = linkedMapOf<String, Int>()

		treeItem.items.forEach {
			childItem ->
				val childResource = childItem.data as IContainer
				val descendantResultList = this.allDescendantResultList(childResource)
				val statementSum = this.statementSum(descendantResultList)

				dataSet.put(childResource.name, statementSum)
		}

		val resource = treeItem.data as IContainer
		val descendantResultList = this.directDescendantResultList(resource)
		if (descendantResultList.isNotEmpty()) {
			val statementSum = this.statementSum(descendantResultList)
			dataSet.put("[${resource.name}]", statementSum)
		}

		return dataSet
	}

	private fun countByType(treeItem: TreeItem): Map<String, Int> {
		val resource = treeItem.data as IContainer
		val descendantResultList = this.allDescendantResultList(resource)

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


	private fun isAncestor(descendant: IResource, ancestor: IContainer): Boolean
		= when (descendant.parent) {
				null -> false
				ancestor -> true
				else -> this.isAncestor(descendant.parent, ancestor)
			}

	private fun allDescendantResultList(ancestor: IContainer): List<FileCountResult>
		= this.resultList.filter {
				result -> this.isAncestor(result.file, ancestor)
			}

	private fun directDescendantResultList(ancestor: IContainer): List<FileCountResult>
		= this.resultList.filter {
				result -> result.file.parent == ancestor
			}

	private fun statementSum(resultList: List<FileCountResult>): Int
		= resultList.sumBy { result -> result.countResult.statement }

	// =========================================================================

	private fun createPieChart(title: String, dataSet: Map<String, Int>): JFreeChart {
		val pieDataSet = DefaultPieDataset();

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
		val categoryDataset = DefaultCategoryDataset();

		dataSet.forEach {
			entry -> categoryDataset.addValue(entry.value, entry.key, "Statement")
		}

		val chart = ChartFactory.createBarChart(title, categoryName, "Line Count",
				categoryDataset)

		return chart
	}

	private fun displayChartWidget(chart: JFreeChart) {
		val chartComposite = ChartComposite(this.chartDisplayComposite, SWT.NONE, chart, true)
		val gridData = GridData(SWT.FILL, SWT.FILL, true, true);
		chartComposite.setLayoutData(gridData);

		this.chartDisplayComposite.layout(true)
	}
}
