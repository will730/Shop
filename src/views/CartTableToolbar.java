package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SpinnerNumberModel;

import controller.Action;
import controller.Controller;
import models.dao.Category;

public class CartTableToolbar extends JToolBar{

	private static final long serialVersionUID = 1L;
	private JTextField textFiledSearchByName = new JTextField();
	private JSpinner spinnerSearchByPriceMin;
	private JSpinner spinneSearchByPriceMax;
	private JComboBox<Category> comboBoxSearchByCategory;
	Font font = new Font("Berlin Sans FB", 4, 13);
	
	public CartTableToolbar(Controller controller) {
		setLayout(new GridLayout(1, 10));
		setFloatable(false);
		
		JLabel name = new JLabel("Filter by: Name:");
		name.setForeground(Color.WHITE);
		add(name);
		
		textFiledSearchByName = new JTextField();
		add(textFiledSearchByName);
		
		JLabel price = new JLabel("Price:");
		price.setForeground(Color.WHITE);
		add(price);
		
		spinnerSearchByPriceMin = new JSpinner(new SpinnerNumberModel(50.0, 50.0, Double.MAX_VALUE, 50.0));
		add(spinnerSearchByPriceMin);
		
		spinneSearchByPriceMax = new JSpinner(new SpinnerNumberModel(5000.0, 50.0, Double.MAX_VALUE, 50.0));
		add(spinneSearchByPriceMax);
		
		JLabel category = new JLabel("Category:");
		category.setForeground(Color.WHITE);
		add(category);
		
		comboBoxSearchByCategory = new JComboBox<Category>(Category.values());
		add(comboBoxSearchByCategory);
		
		JButton buttonFilter = new JButton("Filter");
		buttonFilter.setToolTipText("Search product");
		buttonFilter.setBackground(Color.decode("#40658A"));
		buttonFilter.setForeground(Color.WHITE);
		buttonFilter.setBorderPainted(false);
		buttonFilter.setFocusPainted(false);
		buttonFilter.addActionListener(controller);
		buttonFilter.setActionCommand(Action.BUTTON_FILTER.name());
		add(buttonFilter);
		
		JButton buttonSeeAll = new JButton("All");
		buttonSeeAll.setToolTipText("Show all products");
		buttonSeeAll.setBackground(Color.decode("#5B7729"));
		buttonSeeAll.setForeground(Color.WHITE);
		buttonSeeAll.setBorderPainted(false);
		buttonSeeAll.setFocusPainted(false);
		buttonSeeAll.addActionListener(controller);
		buttonSeeAll.setActionCommand(Action.BUTTON_ALL.name());
		add(buttonSeeAll);
	}
}
