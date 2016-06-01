package net.liying.sourceCounter.plugin.views.base;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.custom.CTabItem;

public class BaseSourceCountResultChart extends Composite {
	protected Tree tree;
	protected Composite chartDisplay_CountByPath;
	protected Composite chartDisplay_CountByType;
	private CTabFolder tabFolder;
	private CTabItem tbtmNewItem2;
	private CTabItem tbtmNewItem1;

	protected void treeSelectionListener(SelectionEvent e) {
		// do nothing here, implemented in sub-class
	}

	/**
	 * Create the composite.
	 *
	 * @param parent
	 * @param style
	 */
	public BaseSourceCountResultChart(Composite parent, int style) {
		super(parent, style);
		setLayout(new FormLayout());

		tree = new Tree(this, SWT.BORDER);
		tree.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BaseSourceCountResultChart.this.treeSelectionListener(e);
			}
		});
		FormData fd_tree = new FormData();
		fd_tree.bottom = new FormAttachment(100, -4);
		fd_tree.right = new FormAttachment(0, 180);
		fd_tree.top = new FormAttachment(0, 4);
		fd_tree.left = new FormAttachment(0, 4);
		tree.setLayoutData(fd_tree);

		tabFolder = new CTabFolder(this, SWT.BORDER);
		FormData fd_tabFolder = new FormData();
		fd_tabFolder.left = new FormAttachment(tree, 8);
		fd_tabFolder.bottom = new FormAttachment(100, -4);
		fd_tabFolder.right = new FormAttachment(100, -8);
		fd_tabFolder.top = new FormAttachment(0, 4);
		tabFolder.setLayoutData(fd_tabFolder);
		tabFolder.setSelectionBackground(
				Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));

		tbtmNewItem1 = new CTabItem(tabFolder, SWT.NONE);
		tbtmNewItem1.setText("Count by Type");

		chartDisplay_CountByType = new Composite(tabFolder, SWT.EMBEDDED);
		tbtmNewItem1.setControl(chartDisplay_CountByType);
		chartDisplay_CountByType.setLayout(new GridLayout(1, false));

		tbtmNewItem2 = new CTabItem(tabFolder, SWT.NONE);
		tbtmNewItem2.setText("Count by Path");

		chartDisplay_CountByPath = new Composite(tabFolder, SWT.EMBEDDED);
		tbtmNewItem2.setControl(chartDisplay_CountByPath);
		chartDisplay_CountByPath.setLayout(new GridLayout(1, false));
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
