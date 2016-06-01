package net.liying.sourceCounter.plugin.views.base;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Tree;

public class BaseSourceCountResultChart extends Composite {
	protected Tree tree;
	protected Composite chartDisplayComposite;
	protected Button radioBtnBarChart;
	protected Button radioBtnCountByType;
	protected Button radioBtnCountByPath;
	protected Button radioBtnPieChart;

	protected void showChart() {
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
				BaseSourceCountResultChart.this.showChart();
			}
		});
		FormData fd_tree = new FormData();
		fd_tree.bottom = new FormAttachment(100, -4);
		fd_tree.right = new FormAttachment(0, 180);
		fd_tree.top = new FormAttachment(0, 4);
		fd_tree.left = new FormAttachment(0, 4);
		tree.setLayoutData(fd_tree);

		Composite composite1 = new Composite(this, SWT.NONE);
		composite1.setLayout(new FormLayout());
		FormData fd_composite1 = new FormData();
		fd_composite1.right = new FormAttachment(100, -4);
		fd_composite1.bottom = new FormAttachment(100, -4);
		fd_composite1.top = new FormAttachment(0, 4);
		fd_composite1.left = new FormAttachment(tree, 8);
		composite1.setLayoutData(fd_composite1);

		Composite optionsComposite = new Composite(composite1, SWT.NONE);
		FormData fd_optionsComposite = new FormData();
		fd_optionsComposite.top = new FormAttachment(0, 4);
		fd_optionsComposite.left = new FormAttachment(0, 4);
		optionsComposite.setLayoutData(fd_optionsComposite);
		FillLayout fl_optionsComposite = new FillLayout(SWT.HORIZONTAL);
		fl_optionsComposite.spacing = 4;
		optionsComposite.setLayout(fl_optionsComposite);

		Group grpCountMode = new Group(optionsComposite, SWT.NONE);
		grpCountMode.setText("Count Mode");
		grpCountMode.setLayout(new RowLayout(SWT.HORIZONTAL));

		radioBtnCountByType = new Button(grpCountMode, SWT.RADIO);
		radioBtnCountByType.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BaseSourceCountResultChart.this.showChart();
			}
		});
		radioBtnCountByType.setText("Count by Type");
		radioBtnCountByType.setSelection(true);

		radioBtnCountByPath = new Button(grpCountMode, SWT.RADIO);
		radioBtnCountByPath.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BaseSourceCountResultChart.this.showChart();
			}
		});
		radioBtnCountByPath.setText("Count by Path");

		Group grpChartType = new Group(optionsComposite, SWT.NONE);
		grpChartType.setText("Chart Type");
		grpChartType.setLayout(new RowLayout(SWT.HORIZONTAL));

		radioBtnPieChart = new Button(grpChartType, SWT.RADIO);
		radioBtnPieChart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BaseSourceCountResultChart.this.showChart();
			}
		});
		radioBtnPieChart.setSelection(true);
		radioBtnPieChart.setText("Pie Chart");

		radioBtnBarChart = new Button(grpChartType, SWT.RADIO);
		radioBtnBarChart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BaseSourceCountResultChart.this.showChart();
			}
		});
		radioBtnBarChart.setText("Bar Chart");

		chartDisplayComposite = new Composite(composite1, SWT.EMBEDDED);
		FormData fd_chartDisplayComposite = new FormData();
		fd_chartDisplayComposite.bottom = new FormAttachment(100);
		fd_chartDisplayComposite.top = new FormAttachment(0, 50);
		fd_chartDisplayComposite.right = new FormAttachment(100, -4);
		fd_chartDisplayComposite.left = new FormAttachment(0, 4);
		chartDisplayComposite.setLayoutData(fd_chartDisplayComposite);
		chartDisplayComposite.setLayout(new GridLayout(1, false));
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
