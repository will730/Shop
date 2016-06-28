package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Action;
import controller.Controller;

public class DialogFileChooser extends JDialog{
	
	private static final long serialVersionUID = 1L;
	private JFileChooser fileChooser;
	
	public DialogFileChooser(Controller controller, JFrame jFrame) {
		super(jFrame);
		setModal(true);
		setTitle("File Chooser");
		setSize(500, 500);
		setLocationRelativeTo(jFrame);
		
		fileChooser = new JFileChooser(".//src");
		add(fileChooser);
		
		JPanel panelSouth = new JPanel();
		
		JButton buttonSave = new JButton("Save");
		buttonSave.setActionCommand(Action.SAVE_PATH.name());
		buttonSave.addActionListener(controller);
		buttonSave.setBackground(Color.decode("#40658A"));
		buttonSave.setForeground(Color.WHITE);
		panelSouth.add(buttonSave);
		
		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.setActionCommand(Action.CANCEL_PATH.name());
		buttonCancel.addActionListener(controller);
		buttonCancel.setBackground(Color.decode("#40658A"));
		buttonCancel.setForeground(Color.WHITE);
		panelSouth.add(buttonCancel);
		
		panelSouth.setBackground(Color.decode("#5B7729"));
		add(panelSouth, BorderLayout.PAGE_END);
	}
	
	public void filterFor(int condition) {
		fileChooser.setFileSelectionMode(condition);
	    fileChooser.setAcceptAllFileFilterUsed(false);
	}
	
	public void setFileFilter(String description, String extensions) {
		fileChooser.setFileFilter(new FileNameExtensionFilter(description, extensions));
	}
	
	public String getPathName() {
		return fileChooser.getSelectedFile().getAbsolutePath();
	}
	
	public String getCurrentDirectory() {
		return fileChooser.getCurrentDirectory().getAbsolutePath();
	}
	
	public File getSelectedFile() {
		return fileChooser.getSelectedFile();
	}

	public void getMessageSelectedFile() {
		JOptionPane.showMessageDialog(this, "Please, Select a file");
	}

	public void setPathName() {
		fileChooser.setSelectedFile(null);
	}
	
}
