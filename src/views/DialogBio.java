package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import models.entity.Product;
import controller.Action;
import controller.Controller;

public class DialogBio extends JDialog{
	
	private static final long serialVersionUID = 1L;
	private JLabel labelImage;
	private JLabel labelPrice;
	private JLabel labelQuantumAvailable;
	private JLabel labelCategory;
	private JLabel labelDiscont;
	private JLabel labelName;
	public static final int WORD_SIZE = 12;
	public static final String TYPE_WORD = "Arial Black";
	

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
			labelImage.setHorizontalAlignment(SwingConstants.CENTER);
			panelImage.add(labelImage);
			add(panelImage, BorderLayout.PAGE_START);
			
			JPanel panelData = new JPanel(new GridLayout(5, 2));
			
			JLabel labelMessageName = new JLabel("Name");
			labelMessageName.setFont(new Font(TYPE_WORD, Font.PLAIN, WORD_SIZE));
//			labelMessageName.setHorizontalAlignment(SwingConstants.RIGHT);
			panelData.add(labelMessageName);
			
			labelName = new JLabel("");
			panelData.add(labelName);
			
			JLabel labelMessagePrice = new JLabel("Price ($)");
//			labelMessagePrice.setHorizontalAlignment(SwingConstants.RIGHT);
			panelData.add(labelMessagePrice);
			
			labelPrice = new JLabel("");
			panelData.add(labelPrice);
			
			JLabel labelMessageQuantumAvailable = new JLabel("Quantum Available");
//			labelMessageQuantumAvailable.setHorizontalAlignment(SwingConstants.RIGHT);
			panelData.add(labelMessageQuantumAvailable);
			
			labelQuantumAvailable = new JLabel("");
			panelData.add(labelQuantumAvailable);
			
			JLabel labelMeesageCategory = new JLabel("Category");
//			labelMeesageCategory.setHorizontalAlignment(SwingConstants.RIGHT);
			panelData.add(labelMeesageCategory);
			
			labelCategory = new JLabel("");
			panelData.add(labelCategory);
			
			JLabel labelMessageDiscont = new JLabel("Discont (%)");
//			labelMessageDiscont.setHorizontalAlignment(SwingConstants.RIGHT);
			panelData.add(labelMessageDiscont);
			
			labelDiscont = new JLabel("");
			panelData.add(labelDiscont);
			
			JButton buttonClose = new JButton("Close");
			buttonClose.setBackground(Color.decode("#40658A"));
			buttonClose.setForeground(Color.WHITE);
			buttonClose.addActionListener(controller);
			buttonClose.setActionCommand(Action.CLOSE_DIALOG_BIO_PRODUCT.name());
			panelData.add(buttonClose);
			
			add(panelData ,BorderLayout.CENTER);
			add(buttonClose, BorderLayout.PAGE_END);
	}
	
	public void assignProduct(Product product) {
		if (product.getListImages() != null && product.getListImages().size() != 0) {
			labelImage.setIcon(new ImageIcon(product.getListImages().get(0)));
		}else {
			labelImage.setIcon(null);
			labelImage.setText("Not Image");
		}
		labelName.setText(product.getName());
		labelPrice.setText(String.valueOf(product.getPrice()));
		labelQuantumAvailable.setText(String.valueOf(product.getQuantumAvailable()));
		labelCategory.setText(product.getCategory().toString());
		labelDiscont.setText(String.valueOf(product.getDiscont()));
		setVisible(true);
	}

}
