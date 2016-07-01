package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import persistence.ManagerPersistence;
import controller.Action;
import controller.Controller;
import models.dao.Category;
import models.dao.ToolTipConstants;
import models.entity.Product;

public class PanelTabla extends JPanel {

	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar;
	private JTable table;
	private DefaultTableModel defaultTableModel;
	private JButton buttonNext;
	private JButton buttonLastNext;
	private JLabel labelCountPage;
	private JButton buttonBack;
	private JButton buttonLastBack;
	public static final String[] titlesTable = { "ID", "NAME", "PRICE", "QUANTUM AVAILABLE", "CATEGORY", "DISCONT" };
	private int numberPageCurrent = 1;
	private JButton buttonRemoveProduct;
	private JButton buttonEditProduct;
	private JButton buttonBioProduct;

	public PanelTabla(Controller controller) {
		setBackground(Color.decode("#63DFE3"));

		setLayout(new BorderLayout());
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.decode("#40658A"));
		menuBar.setBorder(BorderFactory.createLineBorder(Color.white));
		JButton btnAddProduct = new JButton(new ImageIcon(getClass().getResource("/img/addProduct.png")));
		btnAddProduct.setToolTipText(ToolTipConstants.ADD_NEW_PRODUCT.toString());
		btnAddProduct.addActionListener(controller);
		btnAddProduct.setActionCommand(Action.BUTTON_ADD_PRODUCT.name());
		btnAddProduct.setBackground(Color.black);
		btnAddProduct.setBorder(BorderFactory.createLineBorder(Color.black));
		menuBar.add(btnAddProduct);
		add(menuBar, BorderLayout.PAGE_START);

		JPanel panelTable = new JPanel(new BorderLayout());
		panelTable.setBorder(BorderFactory.createLineBorder(Color.white));
		table = new JTable();
		table.setShowGrid(!true);
		table.setOpaque(!true);
		table.getTableHeader().setReorderingAllowed(false);
		table.setSelectionBackground(Color.YELLOW);
		table.setGridColor(Color.GREEN);
		table.setGridColor(Color.BLACK);
		// table.setFont(new Font("Times New Roman", 15, 15));
		panelTable.add(new JScrollPane(table));

		add(panelTable, BorderLayout.CENTER);

		addpanelControl(controller);
		
		
		assignColorDissableBack();

		modificateTabla(controller);
		defaultTableModel.setColumnIdentifiers(titlesTable);
		defaultTableModel.addColumn("#");
		defaultTableModel.addColumn("Remove");
		defaultTableModel.addColumn("Edit");
		defaultTableModel.addColumn("Bio");
		table.moveColumn(6, 0);
		buttonRemoveProduct = new JButton("Remove");
		buttonRemoveProduct.setToolTipText("Delete this product");
		buttonRemoveProduct.addActionListener(controller);
		buttonRemoveProduct.setBackground(Color.RED);
		buttonEditProduct = new JButton("Edit");
		buttonEditProduct.setToolTipText("Edit this product");
		buttonEditProduct.addActionListener(controller);
		buttonEditProduct.setBackground(Color.GREEN);
		buttonBioProduct = new JButton("Bio");
		buttonBioProduct.setToolTipText("Show Bio of this product");
		buttonBioProduct.addActionListener(controller);
		buttonBioProduct.setBackground(Color.BLUE);
		// table.setBackground(new Color(80, 250, 22, 50));
	}

	private void modificateTabla(Controller controller) {

		String[] columnas = new String[] {};

		final Class[] tiposColumnas = new Class[] { Object.class, String.class, Object.class, Object.class,
				Category.class, Object.class, String.class, JButton.class, JButton.class, JButton.class };

		Object[][] datos = new Object[][] {};

		table.setModel(defaultTableModel = new javax.swing.table.DefaultTableModel(datos, columnas) {
			Class[] tipos = tiposColumnas;

			@Override
			public Class getColumnClass(int columnIndex) {
				return tipos[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return !true;
			}
		});

		table.setDefaultRenderer(JButton.class, new TableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean isSelected,
					boolean hasFocus, int row, int column) {
				// Component cell =
				// table.getDefaultRenderer(getClass()).getTableCellRendererComponent(table,
				// objeto, isSelected, hasFocus, row, column);
				// if (row == 1 || row == 3 || row == 5) {
				// cell.setBackground(Color.LIGHT_GRAY);
				// }
				return (Component) objeto;
			}
		});

		table.addMouseListener(controller);
	}

	private void addpanelControl(Controller controller) {
		JPanel panelControl = new JPanel(new FlowLayout());

		panelControl.add(buttonLastBack = new JButton("<<"));
		buttonLastBack.setBackground(Color.decode("#40658A"));
		buttonLastBack.setForeground(Color.WHITE);
		buttonLastBack.setToolTipText("go to ferst page");
		buttonLastBack.addActionListener(controller);
		buttonLastBack.setActionCommand(Action.BUTTON_LAST_PAGE_BACK.name());
		buttonLastBack.setEnabled(false);

		panelControl.add(buttonBack = new JButton("<"));
		buttonBack.setBackground(Color.decode("#5B7729"));
		buttonBack.setForeground(Color.WHITE);
		buttonBack.setToolTipText("advance to the previous page");
		buttonBack.addActionListener(controller);
		buttonBack.setActionCommand(Action.BUTTON_PAGE_BACK.name());
		buttonBack.setEnabled(false);

		panelControl.add(labelCountPage = new JLabel("1"));

		panelControl.add(buttonNext = new JButton(">"));
		buttonNext.setBackground(Color.decode("#5B7729"));
		buttonNext.setForeground(Color.WHITE);
		buttonNext.setToolTipText("advance to the next page");
		buttonNext.addActionListener(controller);
		buttonNext.setActionCommand(Action.BUTTON_PAGE_NEXT.name());

		panelControl.add(buttonLastNext = new JButton(">>"));
		buttonLastNext.setBackground(Color.decode("#40658A"));
		buttonLastNext.setForeground(Color.WHITE);
		buttonLastNext.setToolTipText("go to last page");
		buttonLastNext.addActionListener(controller);
		buttonLastNext.setActionCommand(Action.BUTTON_LAST_PAGE_NEXT.name());

		panelControl.setOpaque(false);
		add(panelControl, BorderLayout.PAGE_END);
	}

	public void advanceBackPage(int maxNumberPage) {
		labelCountPage.setText(String.valueOf(getNumberPageCurrent() + "/" + maxNumberPage));
		if (getNumberPageCurrent() == 1) {
			buttonBack.setEnabled(false);
			buttonLastBack.setEnabled(false);
			assignColorDissableBack();
		}
		if (!buttonLastNext.isEnabled()) {
			buttonNext.setEnabled(true);
			buttonLastNext.setEnabled(true);
			assignColorEnableNext();
		}
	}

	public void advanceLastBackPage(int maxNumberPage) {
		labelCountPage.setText(String.valueOf(getNumberPageCurrent() + "/" + maxNumberPage));
		if (buttonLastBack.isEnabled() && numberPageCurrent == 1) {
			buttonBack.setEnabled(false);
			buttonLastBack.setEnabled(false);
			assignColorDissableBack();
		}
		if (!buttonLastNext.isEnabled()) {
			buttonNext.setEnabled(true);
			buttonLastNext.setEnabled(true);
			assignColorEnableNext();
		}
	}

	public void advanceNextPage(int maxNumberPage) {
		labelCountPage.setText(String.valueOf(getNumberPageCurrent() + "/" + maxNumberPage));
		if (getNumberPageCurrent() == maxNumberPage) {
			buttonNext.setEnabled(false);
			buttonLastNext.setEnabled(false);
			assignColorDissableNext();
		}
		if (!buttonLastBack.isEnabled()) {
			buttonBack.setEnabled(true);
			buttonLastBack.setEnabled(true);
			assignColorEnableBack();
		}
	}

	public void advanceLastNextPage(int maxNumberPage) {
		labelCountPage.setText(String.valueOf(getNumberPageCurrent() + "/" + maxNumberPage));
		buttonNext.setEnabled(false);
		buttonLastNext.setEnabled(false);
		assignColorDissableNext();
		if (!buttonLastBack.isEnabled()) {
			buttonBack.setEnabled(true);
			buttonLastBack.setEnabled(true);
			assignColorEnableBack();
		}
	}

	private void assignColorEnableBack() {
		buttonLastBack.setBackground(Color.decode("#40658A"));
		buttonLastBack.setForeground(Color.WHITE);
		buttonBack.setBackground(Color.decode("#5B7729"));
		buttonBack.setForeground(Color.WHITE);
	}

	private void assignColorDissableBack() {
		buttonLastBack.setBackground(getBackground());
		buttonLastBack.setForeground(Color.BLACK);
		buttonBack.setBackground(getBackground());
		buttonBack.setForeground(Color.BLACK);
	}

	private void assignColorEnableNext() {
		buttonLastNext.setBackground(Color.decode("#40658A"));
		buttonLastNext.setForeground(Color.WHITE);
		buttonNext.setBackground(Color.decode("#5B7729"));
		buttonNext.setForeground(Color.WHITE);
	}

	private void assignColorDissableNext() {
		buttonLastNext.setBackground(getBackground());
		buttonLastNext.setForeground(Color.BLACK);
		buttonNext.setBackground(getBackground());
		buttonNext.setForeground(Color.BLACK);
	}

	public int getNumberPageCurrent() {
		return numberPageCurrent;
	}

	public void setNumberPageCurrent(int numberPageCurrent, int maxNumberPage) {
		this.numberPageCurrent = numberPageCurrent;
		advanceLastBackPage(maxNumberPage);
	}

	public void addProductToTable(Product product) {
		defaultTableModel.addRow(product.getArrayContent());
	}

	public void updateTable(ArrayList<Product> listProducts) {
		defaultTableModel.setRowCount(0);
		for (int i = 0; i < listProducts.size(); i++) {
			addProductToTable(listProducts.get(i));
			int numberForPage = Integer.parseInt(ManagerPersistence.readProperty("numberDataForPage"));
			defaultTableModel.setValueAt(((getNumberPageCurrent() * numberForPage) + i) - (numberForPage - 1), i, 6);
			buttonRemoveProduct.setActionCommand(Action.BUTTON_REMOVE_PRODUCT.name());
			defaultTableModel.setValueAt(buttonRemoveProduct, i, 7);
			buttonEditProduct.setActionCommand(Action.BUTTON_EDIT_PRODUCT.name());
			defaultTableModel.setValueAt(buttonEditProduct, i, 8);
			buttonBioProduct.setActionCommand(Action.BUTTON_BIO_PRODUCT.name());
			defaultTableModel.setValueAt(buttonBioProduct, i, 9);
		}
	}

	public void disableButtonsControl() {
		buttonNext.setEnabled(false);
		buttonLastNext.setEnabled(false);
		assignColorDissableNext();
	}

	public void disableButtonsControlBack() {
		buttonBack.setEnabled(false);
		buttonLastBack.setEnabled(false);
		assignColorDissableBack();
	}

	public void enableButtonsControl() {
		buttonNext.setEnabled(true);
		buttonLastNext.setEnabled(true);
		assignColorEnableNext();
	}

	public int getNumberRowsCurrent() {
		return table.getRowCount();
	}

	public int getNumberRowSelect() {
		return table.getSelectedRow();
	}

	public void setNumberPages(int maxNumberPages) {
		labelCountPage.setText(numberPageCurrent + "/" + maxNumberPages);
	}
}
