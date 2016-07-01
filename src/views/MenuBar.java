package views;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import controller.Action;
import controller.Controller;

public class MenuBar extends JMenuBar{

	private static final long serialVersionUID = 1L;

	public MenuBar(Controller controller) {
		add(Box.createHorizontalGlue());
		
		JMenu jmenuActions = new JMenu("Admin");		
		
		JMenuItem itemAddProduct = new JMenuItem("Settings");
		itemAddProduct.addActionListener(controller);
		itemAddProduct.setActionCommand(Action.SHOW_DIALOG_SETTINGS.name());
		jmenuActions.add(itemAddProduct);
		
		JMenuItem itemEditProduct = new JMenuItem("Exit");
		itemEditProduct.addActionListener(controller);
		itemEditProduct.setActionCommand(Action.EXIT.name());
		jmenuActions.add(itemEditProduct);
		
		add(jmenuActions);
	}
}