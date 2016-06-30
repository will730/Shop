package views;

import java.awt.BorderLayout;
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
import controller.Controller;
import models.dao.Category;

public class FilteringOptionsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField textFiledSearchByName;
	private JSpinner spinnerSearchByPriceMin;
	private JSpinner spinneSearchByPriceMax;
	private JComboBox<Category> comboBoxSearchByCategory;
	private static final int width = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	
	private PanelCategoriesUser categoriesUser;
	
	public FilteringOptionsPanel(Controller controller) {
		setLayout(new GridLayout(1, 2));
		setPreferredSize(new Dimension(width/7, 1000));
		
		textFiledSearchByName = new JTextField();
		
		spinnerSearchByPriceMin = new JSpinner(new SpinnerNumberModel(50.0, 50.0, Double.MAX_VALUE, 50.0));
		spinneSearchByPriceMax = new JSpinner(new SpinnerNumberModel(5000.0, 50.0, Double.MAX_VALUE, 50.0));
		
		comboBoxSearchByCategory = new JComboBox(Category.values());
		
		JButton buttonFilter = new JButton("Filter");
		buttonFilter.setToolTipText("Search product");
		buttonFilter.setBackground(Color.decode("#40658A"));
		buttonFilter.setForeground(Color.WHITE);
		buttonFilter.addActionListener(controller);
		buttonFilter.setActionCommand(Action.BUTTON_FILTER.name());
		
		JPanel panelFilter = new JPanel(new GridLayout(9, 1));
		panelFilter.setBackground(Color.decode("#40658A"));
		JLabel name = new JLabel("Filter: Name:");
		name.setForeground(Color.WHITE);
		panelFilter.add(name);
		panelFilter.add(textFiledSearchByName);
		JLabel price = new JLabel("Price:");
		price.setForeground(Color.WHITE);
		panelFilter.add(price);
		panelFilter.add(spinnerSearchByPriceMin);
		panelFilter.add(spinneSearchByPriceMax);
		JLabel category = new JLabel("Category:");
		category.setForeground(Color.WHITE);
		panelFilter.add(category);
		panelFilter.add(comboBoxSearchByCategory);
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
		return (double)spinnerSearchByPriceMin.getValue();
	}
	
	public double getSpinneSearchByPriceMax() {
		return (double)spinneSearchByPriceMax.getValue();
	}
}
