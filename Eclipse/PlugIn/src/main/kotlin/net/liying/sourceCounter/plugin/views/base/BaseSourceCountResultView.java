package net.liying.sourceCounter.plugin.views.base;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.part.ViewPart;

public abstract class BaseSourceCountResultView extends ViewPart {
	protected BaseSourceCountResultTable resultTable;
	protected BaseSourceCountResultChart resultChart;

	public BaseSourceCountResultView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		TabFolder tabFolder = new TabFolder(parent, SWT.NONE);

		TabItem tabItemTable = new TabItem(tabFolder, SWT.NONE);
		tabItemTable.setText("Table");

		resultTable = createResultTableCompsite(tabFolder, SWT.NONE);
		tabItemTable.setControl(resultTable);

		TabItem tabItemChart = new TabItem(tabFolder, SWT.NONE);
		tabItemChart.setText("Chart");

		resultChart = createResultChartCompsite(tabFolder, SWT.NONE);
		tabItemChart.setControl(resultChart);
	}

	protected BaseSourceCountResultTable createResultTableCompsite(Composite parent, int style) {
		return new BaseSourceCountResultTable(parent, style);
	}

	protected BaseSourceCountResultChart createResultChartCompsite(Composite parent, int style) {
		return new BaseSourceCountResultChart(parent, style);
	}

	@Override
	public void setFocus() {
		// do nothing
	}
}
