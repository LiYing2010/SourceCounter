package net.liying.sourceCounter.plugin.views.base;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
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

import net.liying.sourceCounter.plugin.views.component.SourceCountResultTree;

public class BaseSourceCountResultChart extends Composite {
	protected SourceCountResultTree resultTree;
	protected Composite chartDisplayComposite;
	protected Button radioBtnBarChart;
	protected Button radioBtnCountByType;
	protected Button radioBtnCountByPath;
	protected Button radioBtnPieChart;
	private SashForm sashForm;

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

		sashForm = new SashForm(this, SWT.NONE);
		FormData fd_sashForm = new FormData();
		fd_sashForm.top = new FormAttachment(0);
		fd_sashForm.bottom = new FormAttachment(100);
		fd_sashForm.right = new FormAttachment(100);
		fd_sashForm.left = new FormAttachment(0);
		sashForm.setLayoutData(fd_sashForm);

		resultTree = new SourceCountResultTree(sashForm, SWT.NONE);
		resultTree.getTree().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BaseSourceCountResultChart.this.showChart();
			}
		});

		Composite composite1 = new Composite(sashForm, SWT.BORDER);
		composite1.setLayout(new FormLayout());

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

		sashForm.setWeights(new int[] { 10, 30 });
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
