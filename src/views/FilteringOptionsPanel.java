package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import controller.Action;
import controller.Constants;
import controller.Controller;
import models.dao.Category;

public class FilteringOptionsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFiledSearchByName;
	private JSpinner spinnerSearchByPriceMin;
	private JSpinner spinneSearchByPriceMax;
	private JComboBox<Category> comboBoxSearchByCategory;

	public FilteringOptionsPanel(Controller controller) {
		setLayout(new GridLayout(1, 2));
		setPreferredSize(new Dimension(Constants.SIZE_OF_TOOLKIT_WIDTH / 7, 1000));

		JPanel panelFilter = new JPanel(new GridLayout(9, 1));
		panelFilter.setBackground(Constants.COLOR_BLUE_GENERAL);

		JLabel name = new JLabel("Filter: Name:");
		name.setForeground(Color.WHITE);
		panelFilter.add(name);

		textFiledSearchByName = new JTextField();
		panelFilter.add(textFiledSearchByName);

		JLabel price = new JLabel("Price:");
		price.setForeground(Color.WHITE);
		panelFilter.add(price);

		spinnerSearchByPriceMin = new JSpinner(new SpinnerNumberModel(Constants.INIT_VALUE_PRICE_PRODUCT_USER, 50.0, Double.MAX_VALUE, Constants.INIT_VALUE_SKIP_PRICE_PRODUCT_USER));
		panelFilter.add(spinnerSearchByPriceMin);

		spinneSearchByPriceMax = new JSpinner(new SpinnerNumberModel(Constants.INIT_VALUE_MAX_PRICE_PRODUCT_FILTER_USER, 50.0, Double.MAX_VALUE, Constants.INIT_VALUE_MAX_PRICE_SKIP_PRODUCT_FILTER_USER));
		panelFilter.add(spinneSearchByPriceMax);

		JLabel category = new JLabel("Category:");
		category.setForeground(Color.WHITE);
		panelFilter.add(category);

		comboBoxSearchByCategory = new JComboBox<Category>(Category.values());
		panelFilter.add(comboBoxSearchByCategory);
		
		JButton buttonFilter = new JButton("Filter");
		buttonFilter.setToolTipText("Search product");
		buttonFilter.setBackground(Color.decode("#40658A"));
		buttonFilter.setForeground(Color.WHITE);
		buttonFilter.addActionListener(controller);
		buttonFilter.setActionCommand(Action.BUTTON_FILTER.name());
		panelFilter.add(buttonFilter);

		add(panelFilter);
	}

	public String getTextFiledSearchByName() {
		return textFiledSearchByName.getText();
	}

	public Category getComboBoxSearchByCategory() {
		return (Category) comboBoxSearchByCategory.getSelectedItem();
	}

	public double getSpinnerSearchByPriceMin() {
		return (double) spinnerSearchByPriceMin.getValue();
	}

	public double getSpinneSearchByPriceMax() {
		return (double) spinneSearchByPriceMax.getValue();
	}
}