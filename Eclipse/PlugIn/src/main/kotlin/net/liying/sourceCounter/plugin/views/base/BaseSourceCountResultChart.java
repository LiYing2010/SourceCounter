package net.liying.sourceCounter.plugin.views.base;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class BaseSourceCountResultChart extends Composite {
	protected Tree tree;

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
		fd_tree.right = new FormAttachment(100, -4);
		fd_tree.top = new FormAttachment(0, 4);
		fd_tree.left = new FormAttachment(0, 4);
		tree.setLayoutData(fd_tree);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
