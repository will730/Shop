package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;
import models.entity.Product;

public class PanelShowProducts extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public PanelShowProducts() {
		setLayout(new FlowLayout());
		setBackground(Color.white);
	}
	
	public void addJbuttons(ArrayList<Product> listProducts, Controller controller) {
		this.removeAll();
		for (Product product : listProducts) {
			JButton botonProduct = new JButton(product.getName());
			botonProduct.setBackground(Color.white);
			botonProduct.setName(""+ product.getId() + product.getPrice());
			botonProduct.setBorder(BorderFactory.createTitledBorder(product.getName() + product.getPrice()));
			if(!product.getListImages().isEmpty()){
				botonProduct.setIcon(new ImageIcon(product.getListImages().get(0)));
			}else{
				botonProduct.setIcon(new ImageIcon(getClass().getResource("/img/noImage.png")));
			}
			add(botonProduct);
		}
		repaint();
	}
}
