package views.login;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import controller.Action;
import controller.Controller;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Panelfondo extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon imagen;
	public static final int TAMAGNO_LETRA = 15;
	public static final String TYPE_WORD = "Arial Black";

	public Panelfondo(Controller controller) {
		imagen = new ImageIcon(getClass().getResource("/img/fff.png"));

		setLayout(null);
		setBackground(Color.WHITE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width,
				Toolkit.getDefaultToolkit().getScreenSize().height - 38);

		JButton btnUser = new JButton();
		btnUser.setOpaque(false);
		btnUser.setBorderPainted(false);
		btnUser.setBounds(200, 200, 350, 300);
		btnUser.addActionListener(controller);
		btnUser.setActionCommand(Action.BUTTON_OPEN_DIALOG_ADMIN.name());
		btnUser.setFocusPainted(false);
		btnUser.setContentAreaFilled(false);
		add(btnUser);
		
		btnUser.setFocusPainted(false);
		btnUser.setContentAreaFilled(false);

		JButton btnVisitante = new JButton();
		btnVisitante.setOpaque(false);
		btnVisitante.setBounds(950, 250, 200, 200);
		btnVisitante.setBorderPainted(false);
		btnVisitante.addActionListener(controller);
		btnVisitante.setActionCommand(Action.BUTTON_OPEN_DIALOG_CUSTOMER.name());
		btnVisitante.setFocusPainted(false);
		btnVisitante.setContentAreaFilled(false);
		add(btnVisitante);

//		setVisible(true);
	}

	public void pintar(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(imagen.getImage(), 0, 0, this);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		pintar(g);
	}
}