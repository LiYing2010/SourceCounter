package net.liying.sourceCounter.plugin.views.base;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import net.liying.sourceCounter.plugin.views.SourceCountResultChart;
import net.liying.sourceCounter.plugin.views.SourceCountResultTable;

public class BaseSourceCountResultView extends ViewPart {
	protected SourceCountResultTable resultTable;
	protected SourceCountResultChart resultChart;

	public BaseSourceCountResultView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		CTabFolder tabFolder = new CTabFolder(parent, SWT.FLAT);
		tabFolder.setSimple(false);

		CTabItem tabItemTable = new CTabItem(tabFolder, SWT.NONE);
		tabItemTable.setText("Table");

		resultTable = new SourceCountResultTable(tabFolder, SWT.NONE);
		tabItemTable.setControl(resultTable);

		CTabItem tabItemChart = new CTabItem(tabFolder, SWT.NONE);
		tabItemChart.setText("Chart");

		resultChart = new SourceCountResultChart(tabFolder, SWT.NONE);
		tabItemChart.setControl(resultChart);

		tabFolder.setSelection(0);
	}

	@Override
	public void setFocus() {
		// do nothing
	}
}
