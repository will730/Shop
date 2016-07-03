package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.Action;
import controller.Controller;

public class CartDialog extends JDialog{

	private static final long serialVersionUID = 1L;
	private Font font = new Font("Berlin Sans FB", 4, 30);
	private Font font2 = new Font("Berlin Sans FB", 4, 15);
	private JPanel panelLogo;
	private JLabel lbLogo;
	private CartTablePanel cartTablePanel;
	
	public CartDialog(Controller controller) {
		setIconImage(new ImageIcon(".\\src\\img\\Icon.png").getImage());
		setModal(true);
		setSize(1300, 700);
		setTitle("Your Cart");
		setLocationRelativeTo(null);
		setBackground(Color.decode("#194290"));
		setLayout(new BorderLayout());
		
		cartTablePanel = new CartTablePanel(controller);
		add(cartTablePanel, BorderLayout.CENTER);
		
		panelLogo = new JPanel(new BorderLayout());
		panelLogo.setBackground(Color.decode("#194290"));
		add(panelLogo, BorderLayout.PAGE_START);
		
		lbLogo = new JLabel();
		lbLogo.setIcon(new ImageIcon(getClass().getResource("/img/Logo.png")));
		lbLogo.setText("Online Store");
		lbLogo.setFont(font);
		lbLogo.setForeground(Color.BLACK);
		lbLogo.setHorizontalTextPosition(SwingConstants.RIGHT);
		lbLogo.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelLogo.add(lbLogo, BorderLayout.LINE_START);
		
		JToolBar toolBarManager = new JToolBar();
		toolBarManager.setFloatable(false);
		toolBarManager.setBackground(Color.decode("#194290"));
		toolBarManager.setBorderPainted(false);	
		
		JButton buttonExit = new JButton("Exit");
		buttonExit.setBackground(Color.decode("#5B7729"));
		buttonExit.setForeground(Color.WHITE);
		buttonExit.setBorderPainted(false);
		buttonExit.setFont(font2);
		buttonExit.setFocusPainted(false);
		buttonExit.addActionListener(controller);
		buttonExit.setActionCommand(Action.CLOSE_CART_DIALOG.name());
		toolBarManager.add(buttonExit);
		
		double cartPrice = cartTablePanel.getTablePrice();
		JButton btnCartPrice = new JButton(new ImageIcon(getClass().getResource("/img/Cart_Price.png")));
		btnCartPrice.setBackground(Color.decode("#5B7729"));
		btnCartPrice.setText("Cart Price: " + cartPrice);
		btnCartPrice.setFocusPainted(false);
		btnCartPrice.setBorderPainted(false);
		btnCartPrice.setFont(font2);
		btnCartPrice.setForeground(Color.WHITE);
		btnCartPrice.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCartPrice.setVerticalTextPosition(SwingConstants.CENTER);
		toolBarManager.add(btnCartPrice);
		
		panelLogo.add(toolBarManager, BorderLayout.LINE_END);
	}
}
