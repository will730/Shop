package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Action;
import controller.Controller;

public class DialogDescriptionProduct extends JDialog{
	
	private JTextField textFieldBrand;
	private JTextField textFieldModel;
	private JTextField textFieldMonthsWarranty;
	private Component textFieldSize;
	private JTextField textFieldYearOfCreation;
	private JTextArea textAreaError;

	public DialogDescriptionProduct(Controller controller, JFrame jFrame) {
		super(jFrame);
		setModal(true);
		setSize(300, 350);
		setTitle("Create product");
		setLocationRelativeTo(jFrame);
		setLayout(new BorderLayout());
		
		JPanel panelData = new JPanel(new GridLayout(6, 1));
		JLabel labelBrand = new JLabel("Brand");
		labelBrand.setHorizontalAlignment(SwingConstants.RIGHT);
		panelData.add(labelBrand);
		
		textFieldBrand = new JTextField("a");
		panelData.add(textFieldBrand);
		
		JLabel labelModel = new JLabel("Model");
		labelModel.setHorizontalAlignment(SwingConstants.RIGHT);
		panelData.add(labelModel);
		
		textFieldModel = new JTextField("a");
		panelData.add(textFieldModel);
		
		JLabel labelMonthsWarranty = new JLabel("Months Warranty");
		labelMonthsWarranty.setHorizontalAlignment(SwingConstants.RIGHT);
		panelData.add(labelMonthsWarranty);
		
		textFieldMonthsWarranty = new JTextField("12");
		panelData.add(textFieldMonthsWarranty);
		
		JLabel labelSize = new JLabel("Size");
		labelSize.setHorizontalAlignment(SwingConstants.RIGHT);
		panelData.add(labelSize);
		
		textFieldSize = new JTextField("a");
		panelData.add(textFieldSize);
		
		JLabel labelYearOfCreation = new JLabel("Year Of Creation");
		labelYearOfCreation.setHorizontalAlignment(SwingConstants.RIGHT);
		panelData.add(labelYearOfCreation);
		
		textFieldYearOfCreation = new JTextField("2015");
		panelData.add(textFieldYearOfCreation);
		
		JButton buttonClose = new JButton("Close");
		buttonClose.setBackground(Color.decode("#40658A"));
		buttonClose.setForeground(Color.WHITE);
		buttonClose.addActionListener(controller);
		buttonClose.setActionCommand(Action.CLOSE_DIALOG_DESCRIPTION_PRODUCT.name());
		panelData.add(buttonClose);
		
		JButton buttonSave = new JButton("Save");
		buttonSave.setBackground(Color.decode("#5B7729"));
		buttonSave.setForeground(Color.WHITE);
		buttonSave.addActionListener(controller);
		buttonSave.setActionCommand(Action.BUTTON_SAVE_DESCRIPTION.name());
		panelData.add(buttonSave);
		
		textAreaError = new JTextArea();
		panelData.add(textAreaError);
		
		add(panelData, BorderLayout.CENTER);
		
		JPanel panelError = new JPanel();
		panelError.add(textAreaError);
		add(panelError, BorderLayout.PAGE_END);
	}
	
	public void displayErrors(String e) {
		textAreaError.setText(e);
		textAreaError.setForeground(Color.RED);
		revalidate();
	}

}
