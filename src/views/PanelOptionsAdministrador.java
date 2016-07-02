package views;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import models.dao.ToolTipConstants;
import controller.Action;
import controller.Constants;
import controller.Controller;

public class PanelOptionsAdministrador extends JPanel {

	private static final long serialVersionUID = 1L;
	private Color colorForeground = Color.white;
	private Color colorBackground = Color.black;
	private JButton botonProductos;

	public PanelOptionsAdministrador(Controller controller) {
		setBackground(Constants.COLOR_BLUE_GENERAL);

		botonProductos = new JButton("Products");
		botonProductos.setFocusPainted(false);
		botonProductos.setToolTipText(ToolTipConstants.SEE_LIST_PRODUCTS.toString());
		botonProductos.addActionListener(controller);
		botonProductos.setActionCommand(Action.BUTTON_PRODUCTOS.name());
		botonProductos.setBackground(colorBackground);
		botonProductos.setForeground(colorForeground);
		botonProductos.setOpaque(false);
		botonProductos.setBorderPainted(false);
		add(botonProductos);
	}

}
