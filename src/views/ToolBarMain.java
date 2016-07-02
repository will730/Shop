package views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import models.dao.ToolTipConstants;
import controller.Action;
import controller.Constants;
import controller.Controller;

public class ToolBarMain extends JToolBar{
	
	private static final long serialVersionUID = 1L;
	
	public ToolBarMain(Controller controller) {
		setLayout(new GridLayout(0, 1));
		setFont(Constants.FONT_TABLE);
		setBorderPainted(false);
		setBackground(Constants.COLOR_DARK_BLUE_GENERAL);
		
		JButton botonProducts = new JButton("Products", new ImageIcon(getClass().getResource(Constants.IMAGE_PRINT)));
		botonProducts.addActionListener(controller);
		botonProducts.setActionCommand(Action.SHOW_TABLE.name());
		botonProducts.setToolTipText(ToolTipConstants.PRODUCTS.toString());
		botonProducts.setFocusPainted(false);
		botonProducts.setFont(Constants.FONT_TABLE);
		botonProducts.setBackground(Color.WHITE);
		add(botonProducts);
		
		JButton botonClient = new JButton("Clients", new ImageIcon(getClass().getResource(Constants.IMAGE_CLIENTS)));
		botonClient.addActionListener(controller);
		botonClient.setActionCommand(Action.SHOW_CLIENTS.name());
		botonClient.setToolTipText(ToolTipConstants.CLIENTS.toString());
		botonClient.setFocusPainted(false);
		botonClient.setFont(Constants.FONT_TABLE);
		botonClient.setBackground(Color.WHITE);
		add(botonClient);
		
		JButton botonPapers = new JButton("Papers", new ImageIcon(getClass().getResource(Constants.IMAGE_PAPERS)));
		botonPapers.addActionListener(controller);
		botonPapers.setActionCommand(Action.BUTTON_PAPERS.name());
		botonPapers.setToolTipText(ToolTipConstants.PAPERS.toString());
		botonPapers.setFocusPainted(false);
		botonPapers.setFont(Constants.FONT_TABLE);
		botonPapers.setBackground(Color.WHITE);
		add(botonPapers);
		
		JButton botonPrint = new JButton("Print", new ImageIcon(getClass().getResource(Constants.IMAGE_PRINT)));
		botonPrint.addActionListener(controller);
		botonPrint.setActionCommand(Action.BUTTON_PRINT.name());
		botonPrint.setToolTipText(ToolTipConstants.PRINT.toString());
		botonPrint.setFocusPainted(false);
		botonPrint.setFont(Constants.FONT_TABLE);
		botonPrint.setBackground(Color.WHITE);
		add(botonPrint);
		
		setFloatable(false);
	}	
}