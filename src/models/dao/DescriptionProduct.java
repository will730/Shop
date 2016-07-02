package models.dao;

import java.awt.Point;

public class DescriptionProduct {

	private String brand;
	private String model;
	private byte monthsWarranty;
	private Point size;
	private int yearOfCreation;

	public DescriptionProduct(String brand, String model, byte monthsWarranty, Point size, int yearOfCreation) {
		this.brand = brand;
		this.model = model;
		this.monthsWarranty = monthsWarranty;
		this.size = size;
		this.yearOfCreation = yearOfCreation;
	}
	

	public String toString() {
		return "Brand:" + brand +"\n"+ "Model:" + model +"\n"+ "MonthsWarranty:" + monthsWarranty + "\n" + "Size:" + size +"\n"+ "YearOfCreation:" + yearOfCreation;
	}

}
