package net.liying.sourceCounter.plugin.views.base;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.ResourceManager;

public abstract class BaseSourceCountResultView extends ViewPart {
	protected TableViewer tableViewer;
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
	private Action selectAllAction;
	private Action copyAction;
	private Action clearAction;

	public BaseSourceCountResultView() {
	}

	protected abstract void runSelectAllAction();

	protected abstract void runClearAction();

	protected abstract void runCopyAction();

	@Override
	public void createPartControl(Composite parent) {
		createActions();
		initializeToolBar();
		initializeMenu();

		tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
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

		initializeTableContextMenu();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
		{
			selectAllAction = new Action("Select All") {
				@Override
				public void run() {
					BaseSourceCountResultView.this.runSelectAllAction();
				}
			};
			selectAllAction.setImageDescriptor(ResourceManager.getPluginImageDescriptor("SourceCounter", "images/buttons/select-all.png"));
		}
		{
			copyAction = new Action("Copy") {
				@Override
				public void run() {
					BaseSourceCountResultView.this.runCopyAction();
				}
			};
			copyAction.setImageDescriptor(ResourceManager.getPluginImageDescriptor("org.eclipse.ui", "/icons/full/etool16/copy_edit.gif"));
		}
		{
			clearAction = new Action("Clear") {
				@Override
				public void run() {
					BaseSourceCountResultView.this.runClearAction();
				}
			};
			clearAction.setImageDescriptor(ResourceManager.getPluginImageDescriptor("org.eclipse.ui", "/icons/full/etool16/delete.png"));
		}
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
		toolbarManager.add(selectAllAction);
		toolbarManager.add(copyAction);
		toolbarManager.add(clearAction);
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
		menuManager.add(selectAllAction);
		menuManager.add(copyAction);
		menuManager.add(new Separator());
		menuManager.add(clearAction);
	}

	/**
	 * Initialize the context menu for table.
	 */
	private void initializeTableContextMenu() {
		MenuManager menuManager = new MenuManager("#PopupMenu");
		menuManager.add(selectAllAction);
		menuManager.add(copyAction);
		menuManager.add(new Separator());
		menuManager.add(clearAction);

		Menu menu = menuManager.createContextMenu(tableViewer.getControl());
		tableViewer.getControl().setMenu(menu);
	}

	@Override
	public void setFocus() {
		// do nothing
	}
}
