package models.dao;

import java.awt.Point;
import java.util.ArrayList;

import persistence.ManagerPersistence;
import Exceptions.ExhaustedProductExeption;
import Exceptions.IdProductInexistExeption;
import Exceptions.idRegistered;
import models.entity.Product;

public class Shop {

	private int id;
	private String name;
	private DescriptionShop descriptionShop;
	private ArrayList<Product> listProducts;
	private ArrayList<Product> listProductsFilter;

	public Shop(int id, String name, DescriptionShop descriptionShop) {
		this.id = id;
		this.name = name;
		this.descriptionShop = descriptionShop;
		listProducts = new ArrayList<>();
		listProductsFilter = new ArrayList<>();
	}

	private boolean idCheck(Product product) {
		for (Product product1 : listProducts) {
			if (product1.getId() == product.getId()) {
				return true;
			}
		}
		return false;
	}

	public static Product createProduct(int id, String name, double price, DescriptionProduct description,
			int quantumAvailable, Category category, double discont, ArrayList<String> listImages) {
		return new Product(id, name, price, description, listImages, quantumAvailable, category, discont);
	}

	public void addProduct(Product product) throws idRegistered {
		if (!idCheck(product)) {
			listProducts.add(product);
		} else {
			throw new idRegistered();
		}
	}

	public double getCalificationProduct(int id) throws IdProductInexistExeption {
		double result = 0;
		for (Product product : listProducts) {
			if (id == product.getId()) {
				for (int i = 0; i < product.getListCalifications().size(); i++) {
					result += product.getListCalifications().get(i);
				}
				return result / product.getListCalifications().size();
			}
		}
		throw new IdProductInexistExeption();
	}

	public boolean isIdExist(int id) {
		for (Product product : listProducts) {
			if (product.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public void editProduct(int id, Product product) throws IdProductInexistExeption {
		for (int i = 0; i < listProducts.size(); i++) {
			if (listProducts.get(i).getId() == id) {
				listProducts.remove(i);
				listProducts.add(i, product);
				return;
			}
		}
		throw new IdProductInexistExeption();
	}

	public void deleteProduct(int id) throws IdProductInexistExeption {
		for (Product product : listProducts) {
			if (product.getId() == id) {
				listProducts.remove(product);
				return;
			}
		}
		throw new IdProductInexistExeption();
	}

	public void saleProduct(int id) throws ExhaustedProductExeption {
		for (Product product : listProducts) {
			if (product.getId() == id && product.getQuantumAvailable() > 0) {
				product.setQuantumAvailable(product.getQuantumAvailable() - 1);
				return;
			}
		}
		throw new ExhaustedProductExeption();
	}

	public ArrayList<Product> searchProductForName(String name) {
		ArrayList<Product> listProductsResult = new ArrayList<>();
		for (Product product : listProducts) {
			if (product.getName().contains(name)) {
				listProductsResult.add(product);
			}
		}
		return listProductsResult;
	}

	public ArrayList<Product> searchProductForPrice(int priceMin, int priceMax) {
		ArrayList<Product> listProductsResult = new ArrayList<>();
		for (Product product : listProducts) {
			if (product.getPrice() > priceMin && product.getPrice() < priceMin) {
				listProductsResult.add(product);
			}
		}
		return listProductsResult;
	}

	public ArrayList<Product> searchProductForCategory(Category category) {
		ArrayList<Product> listProductsResult = new ArrayList<>();
		for (Product product : listProducts) {
			if (product.getCategory().equals(category)) {
				listProductsResult.add(product);
			}
		}
		return listProductsResult;
	}

	public ArrayList<Product> getProductsWhithDiscont() {
		ArrayList<Product> listProductsResult = new ArrayList<>();
		for (Product product : listProducts) {
			if (product.getDiscont() != 0) {
				listProductsResult.add(product);
			}
		}
		return listProductsResult;
	}

	public ArrayList<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(ArrayList<Product> listProducts) {
		this.listProducts = listProducts;
	}

	public ArrayList<Product> getListProductsForFilter(String name, double priceMin, double priceMax, Category category) {
		ArrayList<Product> listProductsResult = new ArrayList<>();
		for (Product product : listProducts) {
			if (product.getName().contains(name) && (product.getPrice() >= priceMin && product.getPrice() <= priceMax)) {
				if (category.equals(Category.ALL) ||product.getCategory().equals(category)) {
					listProductsResult.add(product);					
				}
			}
		}
		return listProductsResult;
	}

	public ArrayList<Product> getListProductsFilter() {
		return listProductsFilter;
	}
	
	public void setListProductsFilter(ArrayList<Product> listProductsFilter) {
		this.listProductsFilter = listProductsFilter;
	}

	public Product findProductForId(int id) {
		for (Product product : listProductsFilter) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}
	
	public Point getPointProductsForPage(int numberPageCurrent) {
		int initCount = ((numberPageCurrent - 1) * Integer.parseInt(ManagerPersistence.readProperty("numberDataForPage")));
		int finishCount = numberPageCurrent * Integer.parseInt(ManagerPersistence.readProperty("numberDataForPage"));
		if (finishCount > listProductsFilter.size()) {
			finishCount = listProductsFilter.size();
		}
		return new Point(initCount, finishCount);
	}
	
	public ArrayList<Product> readProductsFiltersForPage(int numberPageCurrent) {
		ArrayList<Product> listProductsResult = new ArrayList<>();
		Point point = getPointProductsForPage(numberPageCurrent);
		for (int i = (int)point.getX(); i < (int)point.getY(); i++) {
			ArrayList<String> listImagesProduct = new ArrayList<>();
			for (String images : listProducts.get(i).getListImages()) {
				listImagesProduct.add(images);
			}
			listProductsResult.add(Shop.createProduct(listProducts.get(i).getId(), listProducts.get(i).getName(), listProducts.get(i).getPrice(), null, listProducts.get(i).getQuantumAvailable(), listProducts.get(i).getCategory(), listProducts.get(i).getDiscont(), listImagesProduct));
		}
		return listProductsResult;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public DescriptionShop getDescriptionShop() {
		return descriptionShop;
	}

}