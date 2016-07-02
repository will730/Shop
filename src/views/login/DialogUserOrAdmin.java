package views.login;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

import controller.Constants;
import controller.Controller;

public class DialogUserOrAdmin extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public DialogUserOrAdmin(Controller controller) {
		setTitle("User Or Admin");
		setLayout(null);
		setIconImage(new ImageIcon(getClass().getResource(Constants.IMAGE_LOGO_WELCOME)).getImage());
		
		setSize(Constants.SIZE_OF_TOOLKIT_WIDTH, Constants.SIZE_OF_TOOLKIT_HEIGHT);
		UIManager.put("Button.background", Constants.COLOR_BACKGROUND_BUTTONS);
		UIManager.put("Button.BorderFactory.createLineBorder", Constants.COLOR_BORDER_FACTORY_BUTTONS);
		UIManager.put("OptionPane.background", Constants.COLOR_BACKGROUND_OPTION_PANE);
		UIManager.put("Panel.background", Constants.COLOR_BACKGROUND_PANELS);
		
		add(new DeepPanel(controller));
	}
	
}