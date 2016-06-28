package views.login;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;

import controller.Controller;


public class DialogUserOrAdmin extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public static final int TAMANO_LETRA = 15;
	public static final String TYPE_WORD = "Arial Black";
	private Panelfondo ventanaLogin;
	
	public DialogUserOrAdmin(Controller controller) {
//		super(frame);
		setTitle("User Or Admin");
		setLayout(null);
		setBackground(Color.decode("#4d4d4f"));
		ImageIcon iconoAplicacion = new ImageIcon(getClass().getResource("/img/logito.PNG"));
		setIconImage(iconoAplicacion.getImage());
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height - 38);

		
		ventanaLogin = new Panelfondo(controller);
		add(ventanaLogin);
	}
	
}