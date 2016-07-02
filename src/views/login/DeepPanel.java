package views.login;

import java.awt.Graphics;
import java.awt.Graphics2D;

import controller.Action;
import controller.Constants;
import controller.Controller;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DeepPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon imagen;

	public DeepPanel(Controller controller) {
		imagen = new ImageIcon(getClass().getResource(Constants.IMAGE_BACKGROUND_WELCOME));

		setLayout(null);
		setSize(Constants.SIZE_OF_TOOLKIT_WIDTH, Constants.SIZE_OF_TOOLKIT_HEIGHT);

		JButton botonUser = new JButton();
		botonUser.setOpaque(false);
		botonUser.setBorderPainted(false);
		botonUser.setBounds(200, 200, 350, 300);
		botonUser.addActionListener(controller);
		botonUser.setActionCommand(Action.BUTTON_OPEN_DIALOG_ADMIN.name());
		botonUser.setFocusPainted(false);
		botonUser.setContentAreaFilled(false);
		add(botonUser);

		JButton botonVisitante = new JButton();
		botonVisitante.setOpaque(false);
		botonVisitante.setBounds(950, 250, 200, 200);
		botonVisitante.setBorderPainted(false);
		botonVisitante.addActionListener(controller);
		botonVisitante.setActionCommand(Action.BUTTON_OPEN_DIALOG_CUSTOMER.name());
		botonVisitante.setFocusPainted(false);
		botonVisitante.setContentAreaFilled(false);
		add(botonVisitante);
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