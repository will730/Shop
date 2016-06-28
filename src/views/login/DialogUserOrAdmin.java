package views.login;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

import controller.Controller;


public class DialogUserOrAdmin extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public static final int TAMANO_LETRA = 15;
	public static final String TYPE_WORD = "Arial Black";
	private DeepPanel ventanaLogin;
	
	public DialogUserOrAdmin(Controller controller) {
//		super(frame);
		setTitle("User Or Admin");
		setLayout(null);
		setBackground(Color.decode("#4d4d4f"));
		ImageIcon iconoAplicacion = new ImageIcon(getClass().getResource("/img/logito.PNG"));
		setIconImage(iconoAplicacion.getImage());
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height - 38);
		UIManager.put("Button.background", Color.decode("#A9BCF5"));
		UIManager.put("Button.BorderFactory.createLineBorder", Color.decode("#FE2E64"));
		UIManager.put("OptionPane.background",Color.decode("#58ACFA"));
		UIManager.put("Panel.background",Color.decode("#58ACFA"));
		
		ventanaLogin = new DeepPanel(controller);
		add(ventanaLogin);
	}
	
}