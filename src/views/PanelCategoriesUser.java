package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Action;
import controller.Constants;
import controller.Controller;

public class PanelCategoriesUser extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public PanelCategoriesUser(Controller  controller) {
		setLayout(new GridLayout(1, 10));
		setBackground(Constants.COLOR_BLUE_GENERAL);
		
		JLabel labelCategories = new JLabel("CATEGORIES");
		labelCategories.setHorizontalAlignment(SwingConstants.CENTER);
		labelCategories.setForeground(Color.WHITE);
		add(labelCategories);
		
		JButton botonTechnology = new JButton("Technology");
		botonTechnology.setToolTipText("Technology");
		botonTechnology.addActionListener(controller);
		botonTechnology.setActionCommand(Action.BUTTON_SHOW_PRODUCTS_TECHNOLOGY.name());
		add(botonTechnology);
		
		JButton botonAddClothesAndAccesories = new JButton("Clothes and Accesories");
		botonAddClothesAndAccesories.setToolTipText("Clothes and Accesories");
		botonAddClothesAndAccesories.addActionListener(controller);
		botonAddClothesAndAccesories.setActionCommand(Action.BUTTON__SHOW_PRODUCTS_CLOTHES_AND_ACCESSORIES.name());
		add(botonAddClothesAndAccesories);

		JButton botonAddSports = new JButton("Sports");
		botonAddSports.setToolTipText("Products");
		botonAddSports.addActionListener(controller);
		botonAddSports.setActionCommand(Action.BUTTON_SHOW_PRODUCTS_SPORTS.name());
		add(botonAddSports);
		
		JButton botonAddSupermarket = new JButton("Supermarket");
		botonAddSupermarket.setToolTipText("Supermarket");
		botonAddSupermarket.addActionListener(controller);
		botonAddSupermarket.setActionCommand(Action.BUTTON_SHOW_PRODUCTS_SUPERMARKET.name());
		add(botonAddSupermarket);
		
		JButton botonAddToys = new JButton("Toys");
		botonAddToys.setToolTipText("Toys");
		botonAddToys.addActionListener(controller);
		botonAddToys.setActionCommand(Action.BUTTON_SHOW_PRODUCTS_TOYS.name());
		add(botonAddToys);
		
		JButton botonAddHome = new JButton("Home");
		botonAddHome.setToolTipText("Home");
		botonAddHome.addActionListener(controller);
		botonAddHome.setActionCommand(Action.BUTTON_SHOW_PRODUCTS_HOME.name());
		add(botonAddHome);
		
		
		JButton botonAddBooks = new JButton("Books");
		botonAddBooks.setToolTipText("Books");
		botonAddBooks.addActionListener(controller);
		botonAddBooks.setActionCommand(Action.BUTTON_SHOW_PRODUCTS_BOOKS.name());
		add(botonAddBooks);
		
		JButton botonAddEntertainment = new JButton("Entertainment");
		botonAddEntertainment.setToolTipText("Entertainment");
		botonAddEntertainment.addActionListener(controller);
		botonAddEntertainment.setActionCommand(Action.BUTTON_SHOW_PRODUCTS_ENTERTAINMENT.name());
		add(botonAddEntertainment);
		
		JButton botonAddAutomovile = new JButton("Automovile ");
		botonAddAutomovile.setToolTipText("Automovile");
		botonAddAutomovile.addActionListener(controller);
		botonAddAutomovile.setActionCommand(Action.BUTTON_SHOW_PRODUCTS_AUTOMOVILE.name());
		add(botonAddAutomovile);
		
		assignValuesSharedsToComponents();
	}
	
	private void assignValuesSharedsToComponents() {
		Component[] listComponent = getComponents();
		for (Component component : listComponent) {
			if (component.getClass() != JLabel.class) {
				component.setBackground(Constants.COLOR_BLUE_GENERAL);
				component.setForeground(Color.WHITE);
				((JComponent) component).setBorder(BorderFactory.createLineBorder(Constants.COLOR_BLUE_GENERAL));
			}
		}
	}
}
