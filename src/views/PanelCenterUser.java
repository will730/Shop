package views;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;

import controller.Controller;

public class PanelCenterUser extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private PanelShowProducts panelShowProducts;

	public PanelCenterUser(Controller controller) {
		setLayout(new BorderLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();

		panelShowProducts = new PanelShowProducts();
		add(panelShowProducts,BorderLayout.CENTER);
		
		FilteringOptionsPanel filteringOptionsPanel = new FilteringOptionsPanel(controller);
		add(filteringOptionsPanel,BorderLayout.LINE_START);
	}

	public PanelShowProducts getPanelShowProducts() {
		return panelShowProducts;
	}
}
