package views;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import controller.Controller;

public class PanelCenterUser extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelShowProducts panelShowProducts;
	private FilteringOptionsPanel filteringOptionsPanel;

	public PanelCenterUser(Controller controller) {
		setLayout(new BorderLayout());

		panelShowProducts = new PanelShowProducts();
		add(panelShowProducts, BorderLayout.CENTER);

		filteringOptionsPanel = new FilteringOptionsPanel(controller);
		add(filteringOptionsPanel, BorderLayout.LINE_START);
	}

	public PanelShowProducts getPanelShowProducts() {
		return panelShowProducts;
	}

	public FilteringOptionsPanel getFilteringOptionsPanel() {
		return filteringOptionsPanel;
	}
}