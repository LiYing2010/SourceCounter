package net.liying.sourceCounter.plugin.views.base;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public abstract class BaseSourceCountResultView extends ViewPart {
	public BaseSourceCountResultView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		CTabFolder tabFolder = new CTabFolder(parent, SWT.BORDER);

		CTabItem tabItemTable = new CTabItem(tabFolder, SWT.NONE);
		tabItemTable.setText("Table");

		BaseSourceCountResultTable resultTable = createResultTableCompsite(tabFolder, SWT.NONE);
		tabItemTable.setControl(resultTable);

		CTabItem tabItemChart = new CTabItem(tabFolder, SWT.NONE);
		tabItemChart.setText("Chart");

		BaseSourceCountResultChart resultChart = createResultChartCompsite(tabFolder, SWT.NONE);
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
