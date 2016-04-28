package net.liying.sourceCounter.plugin.views.base;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;

public class BaseSourceCountResultView extends ViewPart {
	protected Table table;

	public BaseSourceCountResultView() {
	}

	@Override
	public void createPartControl(Composite parent) {

		TableViewer tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_1.getColumn();
		tblclmnNewColumn_1.setWidth(200);
		tblclmnNewColumn_1.setText("Name");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_2 = tableViewerColumn_2.getColumn();
		tblclmnNewColumn_2.setWidth(150);
		tblclmnNewColumn_2.setText("Resource Path");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_3 = tableViewerColumn_3.getColumn();
		tblclmnNewColumn_3.setWidth(150);
		tblclmnNewColumn_3.setText("File Path");

		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_4 = tableViewerColumn_4.getColumn();
		tblclmnNewColumn_4.setWidth(100);
		tblclmnNewColumn_4.setText("Extension");

		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_5 = tableViewerColumn_5.getColumn();
		tblclmnNewColumn_5.setWidth(100);
		tblclmnNewColumn_5.setText("Type");

		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_6 = tableViewerColumn_6.getColumn();
		tblclmnNewColumn_6.setAlignment(SWT.RIGHT);
		tblclmnNewColumn_6.setWidth(100);
		tblclmnNewColumn_6.setText("Statement");

		TableViewerColumn tableViewerColumn_7 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_7 = tableViewerColumn_7.getColumn();
		tblclmnNewColumn_7.setAlignment(SWT.RIGHT);
		tblclmnNewColumn_7.setWidth(100);
		tblclmnNewColumn_7.setText("Document");

		TableViewerColumn tableViewerColumn_8 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_8 = tableViewerColumn_8.getColumn();
		tblclmnNewColumn_8.setAlignment(SWT.RIGHT);
		tblclmnNewColumn_8.setWidth(100);
		tblclmnNewColumn_8.setText("Comment");

		TableViewerColumn tableViewerColumn_9 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_9 = tableViewerColumn_9.getColumn();
		tblclmnNewColumn_9.setAlignment(SWT.RIGHT);
		tblclmnNewColumn_9.setWidth(100);
		tblclmnNewColumn_9.setText("Empty");

		TableViewerColumn tableViewerColumn_10 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_10 = tableViewerColumn_10.getColumn();
		tblclmnNewColumn_10.setAlignment(SWT.RIGHT);
		tblclmnNewColumn_10.setWidth(100);
		tblclmnNewColumn_10.setText("Total");
	}

	@Override
	public void setFocus() {
		// do nothing
	}
}
