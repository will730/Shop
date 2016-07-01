package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import models.dao.Category;
import models.dao.ToolTipConstants;
import models.entity.Product;
import controller.Action;
import controller.Controller;

public class MainWindows extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelOpcionesAdministrador opcionesAdministrador;
	private PanelTabla panelTable;
	// private Controller controller;
	private JTextField textFiledSearchByName;
	private JSpinner spinnerSearchByPriceMin;
	private JSpinner spinneSearchByPriceMax;
	private JComboBox<Category> comboBoxSearchByCategory;

	public MainWindows(Controller controller) {
		// this.controller = controller;
		setIconImage(new ImageIcon(".\\src\\img\\shop.png").getImage());
		setSize(1300, 500);
		setTitle("Shop Admin");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		setJMenuBar(new MenuBar(controller));

		showPanelOpcionesAdministrador(controller);

		JPanel panelSouth = new JPanel(new GridLayout(1, 2));

		// panel de agregar producto
		JPanel panelAddProduct = new JPanel(new FlowLayout());
		panelAddProduct.setBackground(Color.decode("#40658A"));

		JButton buttonAddProduct = new JButton("Add Product");
		buttonAddProduct.setBackground(Color.decode("#5B7729"));
		buttonAddProduct.setForeground(Color.WHITE);
		buttonAddProduct.setToolTipText(ToolTipConstants.ADD_NEW_PRODUCT.toString());
		buttonAddProduct.addActionListener(controller);
		buttonAddProduct.setActionCommand(Action.BUTTON_ADD_PRODUCT.name());
		buttonAddProduct.setFocusPainted(false);
		panelAddProduct.add(buttonAddProduct);

		panelSouth.add(panelAddProduct);

		// panel para filtrar
		JPanel panelFilter = new JPanel(new GridLayout(1, 9));
		panelFilter.setBackground(Color.decode("#40658A"));

		JLabel name = new JLabel("Filter: Name:");
		name.setForeground(Color.WHITE);
		panelFilter.add(name);

		textFiledSearchByName = new JTextField();
		panelFilter.add(textFiledSearchByName);

		JLabel price = new JLabel("Price:");
		price.setForeground(Color.WHITE);
		panelFilter.add(price);

		spinnerSearchByPriceMin = new JSpinner(new SpinnerNumberModel(50.0, 50.0, Double.MAX_VALUE, 50.0));
		panelFilter.add(spinnerSearchByPriceMin);

		spinneSearchByPriceMax = new JSpinner(new SpinnerNumberModel(5000.0, 50.0, Double.MAX_VALUE, 50.0));
		panelFilter.add(spinneSearchByPriceMax);

		JLabel category = new JLabel("Category:");
		category.setForeground(Color.WHITE);
		panelFilter.add(category);

		comboBoxSearchByCategory = new JComboBox<Category>(Category.values());
		panelFilter.add(comboBoxSearchByCategory);

		JButton buttonFilter = new JButton("Filter");
		buttonFilter.setToolTipText("Search product");
		buttonFilter.setFocusPainted(false);
		buttonFilter.setBackground(Color.decode("#40658A"));
		buttonFilter.setForeground(Color.WHITE);
		buttonFilter.addActionListener(controller);
		buttonFilter.setActionCommand(Action.BUTTON_FILTER.name());
		panelFilter.add(buttonFilter);

		JButton buttonSeeAlls = new JButton("Alls");
		buttonSeeAlls.setFocusPainted(false);
		buttonSeeAlls.setToolTipText("Show all products");
		buttonSeeAlls.setBackground(Color.decode("#5B7729"));
		buttonSeeAlls.setForeground(Color.WHITE);
		buttonSeeAlls.addActionListener(controller);
		buttonSeeAlls.setActionCommand(Action.BUTTON_ALL.name());
		panelFilter.add(buttonSeeAlls);

		panelSouth.add(panelFilter);
		add(panelSouth, BorderLayout.PAGE_START);

		panelTable = new PanelTabla(controller);
		add(panelTable, BorderLayout.CENTER);

	}

	public void showPanelOpcionesAdministrador(Controller controller) {
		opcionesAdministrador = new PanelOpcionesAdministrador(controller);
		add(opcionesAdministrador, BorderLayout.LINE_START);
	}

	public void showPanelAddProduct() {

	}

	public void addProductToTable(Product product) {
		panelTable.addProductToTable(product);
	}

	public void updateTable(ArrayList<Product> listProducts) {
		panelTable.updateTable(listProducts);
	}

	public void advanceForPage(ArrayList<Product> listProducts, Action action, int maxNumberPage) {
		switch (Action.valueOf(action.name())) {
		case BUTTON_LAST_PAGE_BACK:
			panelTable.advanceLastBackPage(maxNumberPage);
			break;
		case BUTTON_PAGE_BACK:
			panelTable.advanceBackPage(maxNumberPage);
			break;
		case BUTTON_LAST_PAGE_NEXT:
			panelTable.advanceLastNextPage(maxNumberPage);
			break;
		case BUTTON_PAGE_NEXT:
			panelTable.advanceNextPage(maxNumberPage);
			break;
		default:
			break;
		}
		updateTable(listProducts);
	}

	public void disableButtonsControl() {
		panelTable.disableButtonsControl();
	}

	public void enableButtonsControl() {
		panelTable.enableButtonsControl();
	}

	public void disableButtonsControlBack() {
		panelTable.disableButtonsControlBack();
	}

	public void setNumberPageCurrent(int numberPage, int maxNumberPage) {
		panelTable.setNumberPageCurrent(numberPage, maxNumberPage);
	}

	public int getNumberPageCurrent() {
		return panelTable.getNumberPageCurrent();
	}

	public String getTextFiledSearchByName() {
		return textFiledSearchByName.getText();
	}

	public double getSpinnerSearchByPriceMin() {
		return (double) spinnerSearchByPriceMin.getValue();
	}

	public double getSpinneSearchByPriceMax() {
		return (double) spinneSearchByPriceMax.getValue();
	}

	public Category getComboBoxSearchByCategory() {
		return (Category) comboBoxSearchByCategory.getSelectedItem();
	}

	public int getNumberRowsCurrent() {
		return panelTable.getNumberRowsCurrent();
	}

	public int getNumberRowSelect() {
		return panelTable.getNumberRowSelect();
	}

	public void setFormatPages(int maxNumberPages) {
		panelTable.setNumberPages(maxNumberPages);
	}

}