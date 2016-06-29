package views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import controller.Action;
import controller.Controller;

public class DialogOptionUserOrAdmin extends JDialog{

	private static final long serialVersionUID = 1L;

	public DialogOptionUserOrAdmin(Controller controller, JFrame frame) {
		super(frame);
		setModal(true);
		setSize(300, 150);
		setTitle("Admin Or User");
		setLocationRelativeTo(frame);
		setLayout(new GridLayout(1, 2));
		
		JButton buttonAdmin = new JButton("Admin");
		buttonAdmin.setBackground(Color.LIGHT_GRAY);
		buttonAdmin.addActionListener(controller);
		buttonAdmin.setActionCommand(Action.BUTTON_OPEN_DIALOG_ADMIN.name());
		
		JButton buttonCustommer = new JButton("Customer");
		buttonCustommer.setBackground(Color.LIGHT_GRAY);
		buttonCustommer.addActionListener(controller);
		buttonCustommer.setActionCommand(Action.BUTTON_OPEN_DIALOG_CUSTOMER.name());
		
		add(buttonAdmin);
		add(buttonCustommer);
		
//		setVisible(true);
	}
}
