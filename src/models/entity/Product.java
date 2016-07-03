package models.entity;

import java.util.ArrayList;

import models.dao.Category;
import models.dao.DescriptionProduct;

public class Product {

	private int id;
	private String name;
	private double price;
	private DescriptionProduct description;
	private ArrayList<String> listImages;
	private int quantumAvailable;
	private ArrayList<Double> listCalifications;
	private Category category;
	private double discont;
	private ArrayList<String> listComentarys;

	public Product(int id, String name, double price, DescriptionProduct description, ArrayList<String> listImages,
			int quantumAvailable, Category category, double discont) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.listImages = listImages;
		this.quantumAvailable = quantumAvailable;
		this.category = category;
		this.discont = discont;
		listCalifications = new ArrayList<>();
		listComentarys = new ArrayList<>();
	}

	public void addCalification(double calification) {
		listCalifications.add(calification);
	}

	public void applyDiscont(double discont) {
		this.discont = discont;
	}

	public void addComentary(String comentary) {
		listComentarys.add(comentary);
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public DescriptionProduct getDescription() {
		return description;
	}

	public ArrayList<String> getListImages() {
		return listImages;
	}

	public int getQuantumAvailable() {
		return quantumAvailable;
	}

	public ArrayList<Double> getListCalifications() {
		return listCalifications;
	}

	public Category getCategory() {
		return category;
	}

	public double getDiscont() {
		return discont;
	}

	public ArrayList<String> getListComentarys() {
		return listComentarys;
	}

	public int getId() {
		return id;
	}

	public void setQuantumAvailable(int quantumAvailable) {
		this.quantumAvailable = quantumAvailable;
	}

	public Object[] getArrayContent() {
		return new Object[] { getId(), getName(), getPrice() + "$", getQuantumAvailable(), getCategory(),
				getDiscont() + "%" };
	}

	public Object[] getArrayContentForCart() {
		return new Object[] { getName(), getPrice() + "$", getQuantumAvailable(), getCategory(),
				getDiscont() + "%" };
	}

}