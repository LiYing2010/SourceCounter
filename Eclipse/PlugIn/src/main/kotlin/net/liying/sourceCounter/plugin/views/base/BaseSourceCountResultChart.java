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

public class BaseSourceCountResultChart extends Composite {
	protected Tree tree;
	protected Composite chartDisplay_CountByPath;
	protected Composite chartDisplay_CountByType;

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

		chartDisplay_CountByPath = new Composite(this, SWT.EMBEDDED);
		chartDisplay_CountByPath.setLayout(new GridLayout(1, false));
		FormData fd_chartDisplay_CountByPath = new FormData();
		fd_chartDisplay_CountByPath.left = new FormAttachment(tree, 8);
		fd_chartDisplay_CountByPath.right = new FormAttachment(100, -8);
		fd_chartDisplay_CountByPath.top = new FormAttachment(0, 8);
		fd_chartDisplay_CountByPath.bottom = new FormAttachment(50, -4);
		chartDisplay_CountByPath.setLayoutData(fd_chartDisplay_CountByPath);

		chartDisplay_CountByType = new Composite(this, SWT.EMBEDDED);
		chartDisplay_CountByType.setLayout(new GridLayout(1, false));
		FormData fd_chartDisplay_CountByType = new FormData();
		fd_chartDisplay_CountByType.left = new FormAttachment(tree, 8);
		fd_chartDisplay_CountByType.right = new FormAttachment(100, -8);
		fd_chartDisplay_CountByType.top = new FormAttachment(50, 4);
		fd_chartDisplay_CountByType.bottom = new FormAttachment(100, -8);
		chartDisplay_CountByType.setLayoutData(fd_chartDisplay_CountByType);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
