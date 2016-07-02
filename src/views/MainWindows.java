package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import models.entity.Product;
import controller.Action;
import controller.Constants;
import controller.Controller;

public class MainWindows extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelOptionsAdministrador opcionesAdministrador;
	private PanelTabla panelTable;
	private JPanel welcomePanel;
	private JPanel panelLogo;
	private JLabel labelLogo;
	private JLabel labelWelcome;
	private ToolBarMain toolBarMain;

	public MainWindows(Controller controller) {
		setIconImage(new ImageIcon(getClass().getResource(Constants.ICON_MAIN)).getImage());
		setSize(Constants.WIDTH_MAIN_ADMIN, Constants.HEIGHT_MAIN_ADMIN);
		setTitle("Shop Admin");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		welcomePanel = new JPanel();
		add(welcomePanel, BorderLayout.CENTER);
		
		labelWelcome = new JLabel(new ImageIcon(getClass().getResource(Constants.IMAGE_WELCOME)));
		labelWelcome.setText("Glad You're Here :D");
		labelWelcome.setHorizontalTextPosition(SwingConstants.CENTER);
		labelWelcome.setVerticalTextPosition(SwingConstants.BOTTOM);
		labelWelcome.setFont(Constants.FONT_TABLE.deriveFont((float)50));
		labelWelcome.setForeground(Color.BLACK);
		welcomePanel.setBackground(Color.WHITE);
		welcomePanel.add(labelWelcome, BorderLayout.CENTER);
		
		panelLogo = new JPanel(new BorderLayout());
		panelLogo.setBackground(Constants.COLOR_DARK_BLUE_GENERAL);
		add(panelLogo, BorderLayout.PAGE_START);
		
		labelLogo = new JLabel();
		labelLogo.setIcon(new ImageIcon(getClass().getResource(Constants.IMAGE_LOGO)));
		labelLogo.setText("Online Store");
		labelLogo.setFont(Constants.FONT_TABLE.deriveFont((float)30));
		labelLogo.setForeground(Color.BLACK);
		labelLogo.setHorizontalTextPosition(SwingConstants.RIGHT);
		labelLogo.setVerticalTextPosition(SwingConstants.CENTER);
		panelLogo.add(labelLogo, BorderLayout.LINE_START);

		JToolBar toolBarManager = new JToolBar();
		toolBarManager.setFloatable(false);
		toolBarManager.setBackground(Constants.COLOR_DARK_BLUE_GENERAL);
		toolBarManager.setBorderPainted(false);
		
		JButton buttonStettings = new JButton("Settings");
		buttonStettings.setBackground(Constants.COLOR_GREEN_GENERAL);
		buttonStettings.setForeground(Color.WHITE);
		buttonStettings.setBorderPainted(false);
		buttonStettings.setFocusPainted(false);
		buttonStettings.addActionListener(controller);
		buttonStettings.setActionCommand(Action.SHOW_DIALOG_SETTINGS.name());
		toolBarManager.add(buttonStettings);
		
		JButton buttonExit = new JButton("Exit");
		buttonExit.setBackground(Constants.COLOR_GREEN_GENERAL);
		buttonExit.setForeground(Color.WHITE);
		buttonExit.setBorderPainted(false);
		buttonExit.setFocusPainted(false);
		buttonExit.addActionListener(controller);
		buttonExit.setActionCommand(Action.EXIT.name());
		toolBarManager.add(buttonExit);
		panelLogo.add(toolBarManager, BorderLayout.LINE_END);
		
		toolBarMain = new ToolBarMain(controller);
		add(toolBarMain, BorderLayout.LINE_START);
		
		panelTable = new PanelTabla(controller);
		panelTable.setVisible(false);
	}

	public void showPanelOptionsAdministrador(Controller controller) {
		opcionesAdministrador = new PanelOptionsAdministrador(controller);
		add(opcionesAdministrador, BorderLayout.LINE_START);
	}

	public void showPanelAddProduct() {

	}

	public void addProductToTable(Product product) {
		panelTable.addProductToTable(product);
	}
	
	public void updateTable(ArrayList<Product> listProducts, Point point) {
		panelTable.updateTable(listProducts, point);
	}

	public void advanceForPage(ArrayList<Product> listProducts, Point point, Action action, int maxNumberPage) {
		switch (Action.valueOf(action.name())) {
		case BUTTON_LAST_PAGE_BACK:
			panelTable.advanceLastBackPage(maxNumberPage);
			break;
		case BUTTON_PAGE_BACK:
			panelTable.advanceBackPage(maxNumberPage);
			break;
		case BUTTON_LAST_PAGE_NEXT:
			panelTable.advanceLastNextPage(maxNumberPage);
			break;
		case BUTTON_PAGE_NEXT:
			panelTable.advanceNextPage(maxNumberPage);
			break;
		default:
			break;
		}
		updateTable(listProducts, point);
	}
	
	public void setVisibleTable(){
		welcomePanel.setVisible(false);
		add(panelTable, BorderLayout.CENTER);
		panelTable.setVisible(true);
	}
	
	public void setInvisibleTable(){
//		welcomePanel.setVisible(false);
		panelTable.setVisible(false);
	}

	public void disableButtonsControl() {
		panelTable.disableButtonsControl();
	}

	public void enableButtonsControl() {
		panelTable.enableButtonsControl();
	}

	public void disableButtonsControlBack() {
		panelTable.disableButtonsControlBack();
	}

	public void setNumberPageCurrent(int numberPage, int maxNumberPage) {
		panelTable.setNumberPageCurrent(numberPage, maxNumberPage);
	}

	public int getNumberPageCurrent() {
		return panelTable.getNumberPageCurrent();
	}

	public Object[] getListValuesForFilter() {
		return panelTable.getListValuesForFilter();
	}

	public int getNumberRowsCurrent() {
		return panelTable.getNumberRowsCurrent();
	}

	public int getNumberRowSelect() {
		return panelTable.getNumberRowSelect();
	}

	public void setFormatPages(int maxNumberPages) {
		panelTable.setNumberPages(maxNumberPages);
	}

}