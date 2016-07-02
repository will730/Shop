package views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import controller.Action;
import controller.Constants;
import controller.Controller;
import models.dao.Category;
import models.dao.ToolTipConstants;

public class TableToolbar extends JToolBar{

	private static final long serialVersionUID = 1L;
	private JTextField textFiledSearchByName;
	private JSpinner spinnerSearchByPriceMin;
	private JSpinner spinneSearchByPriceMax;
	private JComboBox<Category> comboBoxSearchByCategory;
	
	public TableToolbar(Controller controller) {
		setLayout(new GridLayout(1, 10));
		setFloatable(false);
		
		JButton botonAddProduct = new JButton("Add product", new ImageIcon(getClass().getResource(Constants.IMAGE_ADD_PRODUCT)));
		botonAddProduct.setToolTipText(ToolTipConstants.ADD_NEW_PRODUCT.toString());
		botonAddProduct.addActionListener(controller);
		botonAddProduct.setActionCommand(Action.BUTTON_ADD_PRODUCT.name());
		botonAddProduct.setBackground(Color.black);
		botonAddProduct.setFont(Constants.FONT_TABLE);
		botonAddProduct.setBorderPainted(false);
		botonAddProduct.setFocusPainted(false);
		botonAddProduct.setForeground(Color.WHITE);
		botonAddProduct.setHorizontalTextPosition(SwingConstants.RIGHT);
		botonAddProduct.setBorder(BorderFactory.createLineBorder(Color.black));
		add(botonAddProduct);
		
		JLabel name = new JLabel("Filter by: Name:");
		name.setForeground(Color.WHITE);
		add(name);
		
		textFiledSearchByName = new JTextField();
		add(textFiledSearchByName);
		
		JLabel price = new JLabel("Price:");
		price.setForeground(Color.WHITE);
		add(price);
		
		spinnerSearchByPriceMin = new JSpinner(new SpinnerNumberModel(Constants.INIT_VALUE_PRICE_PRODUCT_ADMIN, 50.0, Double.MAX_VALUE, Constants.INIT_VALUE_SKIP_PRICE_PRODUCT_ADMIN));
		add(spinnerSearchByPriceMin);
		
		spinneSearchByPriceMax = new JSpinner(new SpinnerNumberModel(Constants.INIT_VALUE_MAX_PRICE_PRODUCT_FILTER_ADMIN, 50.0, Double.MAX_VALUE, Constants.INIT_VALUE_MAX_PRICE_SKIP_PRODUCT_FILTER_ADMIN));
		add(spinneSearchByPriceMax);
		
		JLabel category = new JLabel("Category:");
		category.setForeground(Color.WHITE);
		add(category);
		
		comboBoxSearchByCategory = new JComboBox<Category>(Category.values());
		add(comboBoxSearchByCategory);
		
		JButton buttonFilter = new JButton("Filter");
		buttonFilter.setToolTipText("Search product");
		buttonFilter.setBackground(Constants.COLOR_BLUE_GENERAL);
		buttonFilter.setForeground(Color.WHITE);
		buttonFilter.setBorderPainted(false);
		buttonFilter.setFocusPainted(false);
		buttonFilter.addActionListener(controller);
		buttonFilter.setActionCommand(Action.BUTTON_FILTER.name());
		add(buttonFilter);
		
		JButton buttonSeeAll = new JButton("All");
		buttonSeeAll.setToolTipText("Show all products");
		buttonSeeAll.setBackground(Constants.COLOR_GREEN_GENERAL);
		buttonSeeAll.setForeground(Color.WHITE);
		buttonSeeAll.setBorderPainted(false);
		buttonSeeAll.setFocusPainted(false);
		buttonSeeAll.addActionListener(controller);
		buttonSeeAll.setActionCommand(Action.BUTTON_ALL.name());
		add(buttonSeeAll);
	}
	
	public Object[] getListValuesForFilter() {
		return new Object[] {textFiledSearchByName.getText(), spinnerSearchByPriceMin.getValue(), spinneSearchByPriceMax.getValue(), comboBoxSearchByCategory.getSelectedItem()};
	}
}
