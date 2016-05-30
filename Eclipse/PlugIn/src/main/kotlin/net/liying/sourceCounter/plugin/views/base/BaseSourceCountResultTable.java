package net.liying.sourceCounter.plugin.views.base;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.wb.swt.ResourceManager;

public class BaseSourceCountResultTable extends Composite {
	private TableViewer tableViewer;
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

	private Action openAction;
	private Action selectAllAction;
	private Action copyAction;
	private Action clearAction;

	private ToolBar toolBar;
	private ToolItem tltmNewItem;
	private ToolItem tltmNewItem_1;
	private ToolItem tltmNewItem_2;
	private ToolItem tltmNewItem_3;

	protected void initUI() {
		// do nothing
	}

	protected void runOpenAction() {
		// do nothing
	}

	protected void runSelectAllAction() {
		// do nothing
	}

	protected void runClearAction() {
		// do nothing
	}

	protected void runCopyAction() {
		// do nothing
	}

	/**
	 * Create the composite.
	 *
	 * @param parent
	 * @param style
	 */
	public BaseSourceCountResultTable(Composite parent, int style) {
		super(parent, SWT.NONE);
		setLayout(new FormLayout());

		toolBar = new ToolBar(this, SWT.FLAT | SWT.RIGHT);
		FormData fd_toolBar = new FormData();
		fd_toolBar.bottom = new FormAttachment(0, 20);
		fd_toolBar.right = new FormAttachment(100);
		fd_toolBar.top = new FormAttachment(0);
		fd_toolBar.left = new FormAttachment(0);
		toolBar.setLayoutData(fd_toolBar);

		tableViewer = new TableViewer(this, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		table = tableViewer.getTable();
		FormData fd_table = new FormData();
		fd_table.top = new FormAttachment(toolBar, 4);

		tltmNewItem = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem.setText("New Item");

		tltmNewItem_1 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_1.setText("New Item");

		tltmNewItem_2 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_2.setText("New Item");

		tltmNewItem_3 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_3.setText("New Item");
		fd_table.bottom = new FormAttachment(100);
		fd_table.right = new FormAttachment(100);
		fd_table.left = new FormAttachment(0);
		table.setLayoutData(fd_table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				BaseSourceCountResultTable.this.runOpenAction();
			}
		});
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

		createActions();

		initializeToolBar();
		initializeMenu();
		initializeTableContextMenu();

		this.initUI();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
		{
			openAction = new Action("Open") {
				@Override
				public void run() {
					BaseSourceCountResultTable.this.runOpenAction();
				}
			};
			openAction.setImageDescriptor(
					ResourceManager.getPluginImageDescriptor("SourceCounter", "images/buttons/open.gif"));
		}
		{
			selectAllAction = new Action("Select All") {
				@Override
				public void run() {
					BaseSourceCountResultTable.this.runSelectAllAction();
				}
			};
			selectAllAction.setImageDescriptor(
					ResourceManager.getPluginImageDescriptor("SourceCounter", "images/buttons/select-all.png"));
		}
		{
			copyAction = new Action("Copy") {
				@Override
				public void run() {
					BaseSourceCountResultTable.this.runCopyAction();
				}
			};
			copyAction.setImageDescriptor(
					ResourceManager.getPluginImageDescriptor("org.eclipse.ui", "/icons/full/etool16/copy_edit.gif"));
		}
		{
			clearAction = new Action("Clear") {
				@Override
				public void run() {
					BaseSourceCountResultTable.this.runClearAction();
				}
			};
			clearAction.setImageDescriptor(
					ResourceManager.getPluginImageDescriptor("org.eclipse.ui", "/icons/full/etool16/delete.png"));
		}
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		// TODO
		// IToolBarManager toolbarManager =
		// getViewSite().getActionBars().getToolBarManager();
		// toolbarManager.add(openAction);
		// toolbarManager.add(selectAllAction);
		// toolbarManager.add(copyAction);
		// toolbarManager.add(clearAction);
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		// TODO
		// IMenuManager menuManager =
		// getViewSite().getActionBars().getMenuManager();
		// menuManager.add(openAction);
		// menuManager.add(selectAllAction);
		// menuManager.add(copyAction);
		// menuManager.add(new Separator());
		// menuManager.add(clearAction);
	}

	/**
	 * Initialize the context menu for table.
	 */
	private void initializeTableContextMenu() {
		MenuManager menuManager = new MenuManager("#PopupMenu");
		menuManager.add(openAction);
		menuManager.add(selectAllAction);
		menuManager.add(copyAction);
		menuManager.add(new Separator());
		menuManager.add(clearAction);

		Menu menu = menuManager.createContextMenu(table);
		table.setMenu(menu);
	}
}
