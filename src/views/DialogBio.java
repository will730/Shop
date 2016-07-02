package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import models.entity.Product;
import controller.Action;
import controller.Constants;
import controller.Controller;

public class DialogBio extends JDialog{
	
	private static final long serialVersionUID = 1L;
	private JLabel labelImage;
	private JLabel labelPrice;
	private JLabel labelQuantumAvailable;
	private JLabel labelCategory;
	private JLabel labelDiscont;
	private JLabel labelName;
	private JTextArea textAreaDescription;

	public DialogBio(Controller controller, JFrame jFrame) {
			super(jFrame);
			setModal(true);
			setSize(300, 400);
			setTitle("Bio Product");
			setLocationRelativeTo(jFrame);
			setLayout(new BorderLayout());
			
			JPanel panelImage = new JPanel(new GridLayout(1, 2));
			
			JLabel labelMessageImage = new JLabel("Image Product");
			panelImage.add(labelMessageImage);
			
			
			labelImage = new JLabel("Image", SwingConstants.CENTER);
			labelImage.setToolTipText("hola </br> mundo");
			labelImage.setHorizontalAlignment(SwingConstants.CENTER);
			panelImage.add(labelImage);
			
			JPanel panelData = new JPanel(new GridLayout(6, 2));
			
			JLabel labelMessageName = new JLabel("Name");
			panelData.add(labelMessageName);
			
			labelName = new JLabel("");
			panelData.add(labelName);
			
			JLabel labelMessagePrice = new JLabel("Price ($)");
			panelData.add(labelMessagePrice);
			
			labelPrice = new JLabel("");
			panelData.add(labelPrice);
			
			JLabel labelMessageQuantumAvailable = new JLabel("Quantum Available");
			panelData.add(labelMessageQuantumAvailable);
			
			labelQuantumAvailable = new JLabel("");
			panelData.add(labelQuantumAvailable);
			
			JLabel labelMeesageCategory = new JLabel("Category");
			panelData.add(labelMeesageCategory);
			
			labelCategory = new JLabel("");
			panelData.add(labelCategory);
			
			JLabel labelMessageDiscont = new JLabel("Discont (%)");
			panelData.add(labelMessageDiscont);
			
			labelDiscont = new JLabel("");
			panelData.add(labelDiscont);			
			
			JLabel description = new JLabel("Description");
			panelData.add(description);
			
			
			textAreaDescription = new JTextArea();
			textAreaDescription.setEditable(false);
			textAreaDescription.setBackground(Constants.COLOR_BACKGROUND_PANELS);
			JScrollPane jScrollPane = new JScrollPane(textAreaDescription);
			jScrollPane.setBorder(null);
			panelData.add(jScrollPane);
			
			JButton buttonClose = new JButton("Close");
			buttonClose.setBackground(Constants.COLOR_BLUE_GENERAL);
			buttonClose.setForeground(Color.WHITE);
			buttonClose.addActionListener(controller);
			buttonClose.setActionCommand(Action.CLOSE_DIALOG_BIO_PRODUCT.name());
			
			add(panelImage, BorderLayout.PAGE_START);
			add(panelData ,BorderLayout.CENTER);
			add(buttonClose, BorderLayout.PAGE_END);
	}
	
	public void assignProduct(Product product) {
		if (product.getListImages() != null && product.getListImages().size() != 0) {
			labelImage.setIcon(new ImageIcon(product.getListImages().get(0)));
			labelImage.setText("");
		}else {
			labelImage.setIcon(null);
			labelImage.setText("Not Image");
		}
		labelName.setText(product.getName());
		labelPrice.setText(String.valueOf(product.getPrice()));
		labelQuantumAvailable.setText(String.valueOf(product.getQuantumAvailable()));
		labelCategory.setText(product.getCategory().toString());
		labelDiscont.setText(String.valueOf(product.getDiscont()));
		textAreaDescription.setText(product.getDescription().toString());
		setVisible(true);
	}

}