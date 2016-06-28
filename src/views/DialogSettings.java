package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.jdesktop.swingx.prompt.PromptSupport;

import persistence.ManagerPersistence;
import controller.Action;
import controller.Controller;

public class DialogSettings extends JDialog{

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNumberProducts;
	private ButtonGroup buttonGroup;
	private JRadioButton radioButtonFolder;
	private JRadioButton radioButtonFile;
	private JRadioButton radioButtonQuestion;
	
	public DialogSettings(Controller controller, JFrame frame) {
		super(frame);
		setSize(450, 200);
		setModal(true);
		setTitle("Settings");
		setLocationRelativeTo(frame);
		setLayout(new GridLayout(3,2));
		
		JPanel panelSettingsNumberProducts = new JPanel(new GridLayout(1, 2));
		textFieldNumberProducts = new JTextField();
		panelSettingsNumberProducts.add(new JLabel("Number Products for Page (default: 5)"));
		PromptSupport.setPrompt("current: " + ManagerPersistence.readProperty("numberDataForPage"), textFieldNumberProducts);
		panelSettingsNumberProducts.add(textFieldNumberProducts);
		add(panelSettingsNumberProducts);
		
		JPanel panelSettingsImageProduct = new JPanel(new FlowLayout());
		buttonGroup = new ButtonGroup();
		radioButtonFile = new JRadioButton("For File");
		buttonGroup.add(radioButtonFile);
		radioButtonFolder = new JRadioButton("In Folder");
		buttonGroup.add(radioButtonFolder);
		radioButtonQuestion = new JRadioButton("Question");
		buttonGroup.add(radioButtonQuestion);
		panelSettingsImageProduct.add(new JLabel("Choose a Image of Product"), FlowLayout.LEFT);
		panelSettingsImageProduct.add(radioButtonFile);
		panelSettingsImageProduct.add(radioButtonFolder);
		panelSettingsImageProduct.add(radioButtonQuestion);
		add(panelSettingsImageProduct);
		
		JPanel panelButtons = new JPanel(new FlowLayout());
		JButton buttonSaveSettings = new JButton("Save");
		buttonSaveSettings.addActionListener(controller);
		buttonSaveSettings.setActionCommand(Action.BUTTON_SAVE_SETTINGS.name());
		panelButtons.add(buttonSaveSettings);
		JButton buttonCancelSettings = new JButton("Cancel");
		buttonCancelSettings.addActionListener(controller);
		buttonCancelSettings.setActionCommand(Action.BUTTON_CANCEL_SETTINGS.name());
		panelButtons.add(buttonCancelSettings);
		add(panelButtons);
		
		selectValueRadioButton();
	}

	private void selectValueRadioButton() {
		switch (ManagerPersistence.readProperty("chooseFiles")) {
		case "1":
			radioButtonFile.setSelected(true);
			break;
		case "2":
			radioButtonFolder.setSelected(true);
			break;
		case "3":
			radioButtonQuestion.setSelected(true);
			break;
		default:
			radioButtonQuestion.setSelected(true);
			break;
		}
	}

	public void saveSettingNumberDataForPage() {
		if (textFieldNumberProducts.getText().equals("")) {
			ManagerPersistence.writeProperty("numberDataForPage", "5");
			return;
		}
		ManagerPersistence.writeProperty("numberDataForPage", textFieldNumberProducts.getText());
		textFieldNumberProducts.setText("");
	}

	public void saveSettingChooseImage() {
		if (radioButtonFile.isSelected()) {
			ManagerPersistence.writeProperty("chooseFiles", "1");
		}else if (radioButtonFolder.isSelected()) {
			ManagerPersistence.writeProperty("chooseFiles", "2");
		}else {
			ManagerPersistence.writeProperty("chooseFiles", "3");
		}
	}

}
