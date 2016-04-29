package net.liying.sourceCounter.plugin.views.base;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

public class BaseSourceCountResultView extends ViewPart {
	protected Table table;
	protected TableColumn nameColumn;
	protected TableColumn resPathColumn;
	protected TableColumn filePathColumn;
	protected TableColumn extensionColumn;
	protected TableColumn typeColumn;
	protected TableColumn statementColumn;
	protected TableColumn documentColumn;
	protected TableColumn commentColumn;
	protected TableColumn emptyColumn;
	protected TableColumn totalColumn;
	protected MenuItem copyMenuItem;
	protected MenuItem clearMenuItem;
	protected MenuItem selectAllMenuItem;

	public BaseSourceCountResultView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		TableViewer tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		nameColumn = tableViewerColumn_1.getColumn();
		nameColumn.setWidth(200);
		nameColumn.setText("Name");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		resPathColumn = tableViewerColumn_2.getColumn();
		resPathColumn.setWidth(150);
		resPathColumn.setText("Resource Path");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		filePathColumn = tableViewerColumn_3.getColumn();
		filePathColumn.setWidth(150);
		filePathColumn.setText("File Path");

		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer, SWT.NONE);
		extensionColumn = tableViewerColumn_4.getColumn();
		extensionColumn.setWidth(100);
		extensionColumn.setText("Extension");

		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer, SWT.NONE);
		typeColumn = tableViewerColumn_5.getColumn();
		typeColumn.setWidth(100);
		typeColumn.setText("Type");

		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer, SWT.NONE);
		statementColumn = tableViewerColumn_6.getColumn();
		statementColumn.setAlignment(SWT.RIGHT);
		statementColumn.setWidth(100);
		statementColumn.setText("Statement");

		TableViewerColumn tableViewerColumn_7 = new TableViewerColumn(tableViewer, SWT.NONE);
		documentColumn = tableViewerColumn_7.getColumn();
		documentColumn.setAlignment(SWT.RIGHT);
		documentColumn.setWidth(100);
		documentColumn.setText("Document");

		TableViewerColumn tableViewerColumn_8 = new TableViewerColumn(tableViewer, SWT.NONE);
		commentColumn = tableViewerColumn_8.getColumn();
		commentColumn.setAlignment(SWT.RIGHT);
		commentColumn.setWidth(100);
		commentColumn.setText("Comment");

		TableViewerColumn tableViewerColumn_9 = new TableViewerColumn(tableViewer, SWT.NONE);
		emptyColumn = tableViewerColumn_9.getColumn();
		emptyColumn.setAlignment(SWT.RIGHT);
		emptyColumn.setWidth(100);
		emptyColumn.setText("Empty");

		TableViewerColumn tableViewerColumn_10 = new TableViewerColumn(tableViewer, SWT.NONE);
		totalColumn = tableViewerColumn_10.getColumn();
		totalColumn.setAlignment(SWT.RIGHT);
		totalColumn.setWidth(100);
		totalColumn.setText("Total");

		Menu menu = new Menu(table);
		table.setMenu(menu);

		selectAllMenuItem = new MenuItem(menu, SWT.NONE);
		selectAllMenuItem.setText("Select All");

		copyMenuItem = new MenuItem(menu, SWT.NONE);
		copyMenuItem.setText("Copy");

		new MenuItem(menu, SWT.SEPARATOR);

		clearMenuItem = new MenuItem(menu, SWT.NONE);
		clearMenuItem.setText("Clear");
	}

	@Override
	public void setFocus() {
		// do nothing
	}
}
