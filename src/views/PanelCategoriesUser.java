package views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Action;
import controller.Controller;

public class PanelCategoriesUser extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private Color BACKGROUND_COLOR = Color.decode("#40658A");
	private Color FONT_COLOR = Color.WHITE;
	
	public PanelCategoriesUser(Controller  controller) {
		setLayout(new GridLayout(10, 1));
		setBackground(BACKGROUND_COLOR);
		
		JLabel lbCategories = new JLabel("CATEGORIES");
		lbCategories.setHorizontalAlignment(SwingConstants.CENTER);
		lbCategories.setForeground(FONT_COLOR);
		add(lbCategories);
		
		JButton btnTechnology = new JButton("Technology");
		btnTechnology.setToolTipText("Technology");
		btnTechnology.addActionListener(controller);
//		btnTechnology.setActionCommand(Action.BUTTON_SHOW_PRODUCTS_TECHNOLOGY.name());
		btnTechnology.setForeground(FONT_COLOR);
		btnTechnology.setBackground(BACKGROUND_COLOR);
		btnTechnology.setBorder(BorderFactory.createLineBorder(BACKGROUND_COLOR));
		add(btnTechnology);
		
		JButton btnAddClothesAndAccesories = new JButton("Clothes and Accesories");
		btnAddClothesAndAccesories.setToolTipText("Clothes and Accesories");
		btnAddClothesAndAccesories.addActionListener(controller);
//		btnAddClothesAndAccesories.setActionCommand(Action.BUTTON__SHOW_PRODUCTS_CLOTHES_AND_ACCESSORIES.name());
		btnAddClothesAndAccesories.setBackground(BACKGROUND_COLOR);
		btnAddClothesAndAccesories.setForeground(FONT_COLOR);
		btnAddClothesAndAccesories.setBorder(BorderFactory.createLineBorder(BACKGROUND_COLOR));
		add(btnAddClothesAndAccesories);

		JButton btnAddSports = new JButton("Sports");
		btnAddSports.setToolTipText("Products");
		btnAddSports.addActionListener(controller);
		btnAddSports.setForeground(FONT_COLOR);
//		btnAddSports.setActionCommand(Action.BUTTON_SHOW_PRODUCTS_SPORTS.name());
		btnAddSports.setBackground(BACKGROUND_COLOR);
		btnAddSports.setBorder(BorderFactory.createLineBorder(BACKGROUND_COLOR));
		add(btnAddSports);
		
		JButton btnAddSupermarket = new JButton("Supermarket");
		btnAddSupermarket.setToolTipText("Supermarket");
		btnAddSupermarket.addActionListener(controller);
		btnAddSupermarket.setForeground(FONT_COLOR);
//		btnAddSupermarket.setActionCommand(Action.BUTTON_SHOW_PRODUCTS_SUPERMARKET.name());
		btnAddSupermarket.setBackground(BACKGROUND_COLOR);
		btnAddSupermarket.setBorder(BorderFactory.createLineBorder(BACKGROUND_COLOR));
		add(btnAddSupermarket);
		
		JButton btnAddToys = new JButton("Toys");
		btnAddToys.setToolTipText("Toys");
		btnAddToys.addActionListener(controller);
		btnAddToys.setForeground(FONT_COLOR);
//		btnAddToys.setActionCommand(Action.BUTTON_SHOW_PRODUCTS_TOYS.name());
		btnAddToys.setBackground(BACKGROUND_COLOR);
		btnAddToys.setBorder(BorderFactory.createLineBorder(BACKGROUND_COLOR));
		add(btnAddToys);
		
		JButton btnAddHome = new JButton("Home");
		btnAddHome.setToolTipText("Home");
		btnAddHome.addActionListener(controller);
//		btnAddHome.setActionCommand(Action.BUTTON_SHOW_PRODUCTS_HOME.name());
		btnAddHome.setBackground(BACKGROUND_COLOR);
		btnAddHome.setForeground(FONT_COLOR);
		btnAddHome.setBorder(BorderFactory.createLineBorder(BACKGROUND_COLOR));
		add(btnAddHome);
		
		
		JButton btnAddBooks = new JButton("Books");
		btnAddBooks.setToolTipText("Books");
		btnAddBooks.addActionListener(controller);
//		btnAddBooks.setActionCommand(Action.BUTTON_SHOW_PRODUCTS_BOOKS.name());
		btnAddBooks.setBackground(BACKGROUND_COLOR);
		btnAddBooks.setForeground(FONT_COLOR);
		btnAddBooks.setBorder(BorderFactory.createLineBorder(BACKGROUND_COLOR));
		add(btnAddBooks);
		
		JButton btnAddEntertainment = new JButton("Entertainment");
		btnAddEntertainment.setToolTipText("Entertainment");
		btnAddEntertainment.addActionListener(controller);
//		btnAddEntertainment.setActionCommand(Action.BUTTON_SHOW_PRODUCTS_ENTERTAINMENT.name());
		btnAddEntertainment.setBackground(BACKGROUND_COLOR);
		btnAddEntertainment.setForeground(FONT_COLOR);
		btnAddEntertainment.setBorder(BorderFactory.createLineBorder(BACKGROUND_COLOR));
		add(btnAddEntertainment);
		
		JButton btnAddAutomovile = new JButton("Automovile ");
		btnAddAutomovile.setToolTipText("Automovile");
		btnAddAutomovile.addActionListener(controller);
//		btnAddAutomovile.setActionCommand(Action.BUTTON_SHOW_PRODUCTS_AUTOMOVILE.name());
		btnAddAutomovile.setBackground(BACKGROUND_COLOR);
		btnAddAutomovile.setForeground(FONT_COLOR);
		btnAddAutomovile.setBorder(BorderFactory.createLineBorder(BACKGROUND_COLOR));
		add(btnAddAutomovile);
	}
}
