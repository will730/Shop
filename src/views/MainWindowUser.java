package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import controller.Action;
import controller.Controller;
import models.dao.Category;

public class MainWindowUser extends JFrame {

	private PanelCategoriesUser categoriesUser;
	private PanelShowProducts panelShowProducts;
	private FilteringOptionsPanel filteringOptionsPanel;
	private PanelCenterUser panelCenterUser;

	public MainWindowUser(Controller controller) {
		setIconImage(new ImageIcon(".\\src\\img\\shop.png").getImage());
		setSize(1300, 500);
		setTitle("Shop Admin");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setLayout(new BorderLayout());

		categoriesUser = new PanelCategoriesUser(controller);
		add(categoriesUser, BorderLayout.PAGE_START);

		panelCenterUser = new PanelCenterUser(controller);
		add(panelCenterUser, BorderLayout.CENTER);
	}

	public PanelShowProducts getPanelShowProducts() {
		return panelCenterUser.getPanelShowProducts();
	}
}
