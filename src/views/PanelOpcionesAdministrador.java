package views;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import models.dao.ToolTipConstants;
import controller.Action;
import controller.Controller;

public class PanelOpcionesAdministrador extends JPanel {

	private static final long serialVersionUID = 1L;
	private Color colorForeground = Color.white;
	private Color colorBackground = Color.black;
	private JButton btnProductos;
	
	public PanelOpcionesAdministrador(Controller controller) {
			setBackground(Color.decode("#40658A"));
			
			btnProductos = new JButton("Products");
			btnProductos.setToolTipText(ToolTipConstants.SEE_LIST_PRODUCTS.toString());
			btnProductos.addActionListener(controller);
			btnProductos.setActionCommand(Action.BUTTON_PRODUCTOS.name());
			btnProductos.setBackground(colorBackground);
			btnProductos.setForeground(colorForeground);
			btnProductos.setBorder(BorderFactory.createLineBorder(colorBackground));
			add(btnProductos);
	}

}
