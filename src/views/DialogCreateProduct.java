package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import net.iharder.dnd.FileDrop;
import net.iharder.dnd.FileDrop.Listener;
import models.dao.Category;
import models.dao.DescriptionProduct;
import models.dao.Shop;
import models.entity.Product;
import controller.Action;
import controller.Constants;
import controller.Controller;

public class DialogCreateProduct extends JDialog{
	
	private static final long serialVersionUID = 1L;
	private JPanel panelData;
	private JPanel panelErrors;
	private JTextField textFieldId;
	private JTextField textFieldName;
	private JSpinner spinnerPrice;
	private JSpinner spinnerQuantumAvalilable;
	private JSpinner spinnerDiscont;
	private JComboBox<Category> comboBoxCategory;
	private JTextArea textAreaError;
	private JDialog dialogChooseFiles = new JDialog();
	private ArrayList<String> listImages = new ArrayList<>();
	private JLabel labelImage;
	private DescriptionProduct descripcionFinal;

	public DialogCreateProduct(Controller controller, JFrame jFrame) {
		super(jFrame);
		setModal(true);
		setSize(300, 450);
		setTitle("Create product");
		setLocationRelativeTo(jFrame);
		setLayout(new GridLayout(2, 1));
		
		JPanel panelImage = new JPanel(new GridLayout(1, 2));
		
		JButton buttonSelectImage = new JButton("Select Image");
		buttonSelectImage.setToolTipText("Select Image of Product");
		buttonSelectImage.addActionListener(controller);
		buttonSelectImage.setActionCommand(Action.BUTTON_SELECT_IMAGE.name());
		panelImage.add(buttonSelectImage);
		
		labelImage = new JLabel("Drag Image(s)", SwingConstants.CENTER);
		labelImage.setHorizontalAlignment(SwingConstants.CENTER);
		panelImage.add(labelImage);
		
		new FileDrop(labelImage, new Listener() {
			@Override
			public void filesDropped(File[] files) {
				listImages.clear();
				for (int i = 0; i < files.length; i++) {
					listImages.add(files[i].getAbsolutePath());
				}
				labelImage.setText("");
				labelImage.setIcon(new ImageIcon(files[0].getAbsolutePath()));
			}
		});
		
		JPanel panelSouth = new JPanel(new BorderLayout());
		
		panelData = new JPanel();
		panelData.setLayout(new GridLayout(9, 2));
		
		JLabel labelId = new JLabel("Integer Id");
		labelId.setHorizontalAlignment(SwingConstants.RIGHT);
		panelData.add(labelId);
		
		textFieldId = new JTextField("1");
		panelData.add(textFieldId);
		
		JLabel labelName = new JLabel("Name");
		labelName.setHorizontalAlignment(SwingConstants.RIGHT);
		panelData.add(labelName);
		
		textFieldName = new JTextField("a");
		panelData.add(textFieldName);
		
		JLabel labelPrice = new JLabel("Price ($)");
		labelPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		panelData.add(labelPrice);
		
		spinnerPrice = new JSpinner(new SpinnerNumberModel(Constants.INIT_VALUE_PRICE_PRODUCT_ADMIN, 50.0, Double.MAX_VALUE, Constants.INIT_VALUE_SKIP_PRICE_PRODUCT_ADMIN));
		panelData.add(spinnerPrice);
		
		JLabel labelDescription = new JLabel("Description");
		labelDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		panelData.add(labelDescription);
		
		JButton buttonDescription = new JButton("Insert Desciption");
		buttonDescription.setBackground(Constants.COLOR_BLUE_GENERAL);
		buttonDescription.setForeground(Color.WHITE);
		buttonDescription.setToolTipText("Insert Description of Product");
		buttonDescription.addActionListener(controller);
		buttonDescription.setActionCommand(Action.OPEN_DIALOG_DESCRIPTION_PRODUCT.name());
		panelData.add(buttonDescription);
		
		JLabel labelQuantumAvailable = new JLabel("Quantum Available");
		labelQuantumAvailable.setHorizontalAlignment(SwingConstants.RIGHT);
		panelData.add(labelQuantumAvailable);
		
		spinnerQuantumAvalilable = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		panelData.add(spinnerQuantumAvalilable);
		
		JLabel labelCategory = new JLabel("Category");
		labelCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		panelData.add(labelCategory);
		
		comboBoxCategory = new JComboBox<>(Category.values());
		panelData.add(comboBoxCategory);
		
		JLabel labelDiscont = new JLabel("Discont (%)");
		labelDiscont.setHorizontalAlignment(SwingConstants.RIGHT);
		panelData.add(labelDiscont);
		
		spinnerDiscont = new JSpinner(new SpinnerNumberModel(Constants.INIT_VALUE_DISCONT_PRODUCT, 0.0, 100, Constants.INIT_VALUE_SKIP_DISCONT_PRODUCT));
		panelData.add(spinnerDiscont);
		
		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.setBackground(Constants.COLOR_BLUE_GENERAL);
		buttonCancel.setForeground(Color.WHITE);
		buttonCancel.addActionListener(controller);
		buttonCancel.setActionCommand(Action.CLOSE_DIALOG_CREATE_PRODUCT.name());
		panelData.add(buttonCancel);
		
		JButton buttonSave = new JButton("Add");
		buttonSave.setBackground(Constants.COLOR_GREEN_GENERAL);
		buttonSave.setForeground(Color.WHITE);
		buttonSave.addActionListener(controller);
		buttonSave.setActionCommand(Action.BUTTON_SAVE_PRODUCT.name());
		panelData.add(buttonSave);
		
		panelSouth.add(panelData, BorderLayout.CENTER);
		
		panelErrors = new JPanel(new FlowLayout());
		panelErrors.add(textAreaError = new JTextArea());
		panelSouth.add(panelErrors, BorderLayout.PAGE_END);
		
		
		dialogChooseFiles.setSize(250, 150);
		dialogChooseFiles.setModal(true);
		dialogChooseFiles.setLocationRelativeTo(this);
		dialogChooseFiles.setTitle("Choose Image For");
		
		JPanel panelChooseFiles = new JPanel(new GridLayout(1, 2));
		
		JButton buttonChooseForFile = new JButton("For File");
		buttonChooseForFile.addActionListener(controller);
		buttonChooseForFile.setActionCommand(Action.BUTTON_CHOOSE_IMAGE_FOR_FILES.name());
		panelChooseFiles.add(buttonChooseForFile);
		
		JButton buttonChooseForFolder = new JButton("For Folder");
		buttonChooseForFolder.addActionListener(controller);
		buttonChooseForFolder.setActionCommand(Action.BUTTON_CHOOSE_IMAGE_FOR_FOLDERS.name());
		panelChooseFiles.add(buttonChooseForFolder);
		dialogChooseFiles.add(panelChooseFiles, BorderLayout.CENTER);
		
		JButton buttonCloseChooseFiles = new JButton("Close");
		buttonCloseChooseFiles.addActionListener(controller);
		buttonCloseChooseFiles.setActionCommand(Action.BUTTON_CLOSE_CHOOSER_FILES.name());
		dialogChooseFiles.add(buttonCloseChooseFiles, BorderLayout.PAGE_END);
		
		add(panelImage, BorderLayout.PAGE_START);
		add(panelSouth, BorderLayout.CENTER);
	}
	
	public Product getProduct() {
		if (listImages.size() == 0) {
			listImages.add((new File(getClass().getResource(Constants.ICON_NO_IMAME).getFile())).getAbsolutePath());
		}
		return Shop.createProduct(Integer.parseInt(textFieldId.getText()), textFieldName.getText(), (double)spinnerPrice.getValue(), descripcionFinal, (int)spinnerQuantumAvalilable.getValue(), (Category)comboBoxCategory.getSelectedItem(), (double)spinnerDiscont.getValue(), listImages);
	}
	
	public void addDescription(DescriptionProduct descripcion){
		descripcionFinal = descripcion;
	}
	
	public void clearnText() {
//		textFieldId.setText("");
//		textFieldName.setText("");
//		spinnerPrice.setValue(50);
//		spinnerQuantumAvalilable.setValue(1);
//		spinnerDiscont.setValue(0.0);
		labelImage.setIcon(null);
		labelImage.setText("Drag Image(s)");
		listImages.clear();
	}
	
	public void displayErrors(String e) {
		textAreaError.setText(e);
		textAreaError.setForeground(Color.RED);
		revalidate();
	}

	public void showDialogChoose() {
		dialogChooseFiles.setVisible(true);
	}

	public void closeDialogChoose() {
		dialogChooseFiles.setVisible(false);
	}

	public void setOneImages(String currentDirectory) {
		listImages.add(currentDirectory);
		labelImage.setText("");
		labelImage.setIcon(new ImageIcon(currentDirectory));
	}
	
	public void setListImages(String currentDirectory) {
		File[] files = new File(currentDirectory).listFiles();
		for (int i = 0; i < files.length; i++) {
			listImages.add(files[i].getAbsolutePath());			
		}
		labelImage.setText("");
		labelImage.setIcon(new ImageIcon(currentDirectory));
	}
}