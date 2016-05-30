package net.liying.sourceCounter.plugin.views.base;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.part.ViewPart;

public abstract class BaseSourceCountResultView extends ViewPart {
	protected BaseSourceCountResultTable sourceCountResultTable;
	protected Tree tree;

	public BaseSourceCountResultView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		TabFolder tabFolder = new TabFolder(parent, SWT.NONE);

		TabItem tabItemTable = new TabItem(tabFolder, SWT.NONE);
		tabItemTable.setText("Table");

		sourceCountResultTable = createResultTableCompsite(tabFolder, SWT.NONE);
		tabItemTable.setControl(sourceCountResultTable);

		TabItem tabItemChart = new TabItem(tabFolder, SWT.NONE);
		tabItemChart.setText("Chart");

		tree = new Tree(tabFolder, SWT.BORDER);
		tabItemChart.setControl(tree);
	}

	protected BaseSourceCountResultTable createResultTableCompsite(Composite parent, int style) {
		return new BaseSourceCountResultTable(parent, style);
	}

	@Override
	public void setFocus() {
		// do nothing
	}
}
