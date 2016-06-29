package views;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import controller.Controller;

public class PanelCenterUser extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private PanelShowProducts panelShowProducts;

	public PanelCenterUser(Controller controller) {
		setLayout(new BorderLayout());
		
		
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.7;
		gbc.weighty = 0.1;
		gbc.gridheight = 0;
		gbc.gridwidth = 1;
		panelShowProducts = new PanelShowProducts();
		add(panelShowProducts,BorderLayout.CENTER);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.3;
		gbc.weighty = 1;
		gbc.gridheight = 0;
		gbc.gridwidth = 1;
		FilteringOptionsPanel filteringOptionsPanel = new FilteringOptionsPanel(controller);
		add(filteringOptionsPanel,BorderLayout.LINE_START);
	}

	public PanelShowProducts getPanelShowProducts() {
		return panelShowProducts;
	}
}
