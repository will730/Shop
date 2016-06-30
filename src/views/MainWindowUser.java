package views;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.Controller;

public class MainWindowUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelCategoriesUser categoriesUser;
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
