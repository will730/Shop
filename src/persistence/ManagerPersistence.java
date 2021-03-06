package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import models.dao.Category;
import models.dao.DescriptionProduct;
import models.dao.Shop;
import models.entity.Product;

public class ManagerPersistence {
	
	public static final String PATH_NAME = "src/data/ListProducts.json";
	public static final String PATH_NAME_PROPERTIES = "src/data/config.properties";
	
	public static void writeProperty(String key, String value) {
		Properties properties = new Properties();
		try {
			properties.setProperty("numberDataForPage", readProperty("numberDataForPage"));
			FileWriter fileWriter = new FileWriter(new File(PATH_NAME_PROPERTIES));
			properties.setProperty(key, value);
			properties.store(fileWriter, null);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String readProperty(String key) {
		Properties properties = new Properties();
		try {
			FileReader fileReader = new FileReader(new File(PATH_NAME_PROPERTIES));
			properties.load(fileReader);
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}

	public static void writeProductsInJson(ArrayList<Product> listProduct) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(listProduct);
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH_NAME));
		bufferedWriter.write(json);
		bufferedWriter.close();
	}
	
	public static ArrayList<Product> readProductsOfJson(File file) throws FileNotFoundException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_NAME));
		Gson gson = new Gson();
		JsonArray jsonArray = (JsonArray) gson.fromJson(bufferedReader, JsonArray.class);
		ArrayList<Product> listProducts = new ArrayList<>();
		for (JsonElement jsonElement : jsonArray) {
			ArrayList<String> listImagesProduct = new ArrayList<>();
			for (JsonElement images : jsonElement.getAsJsonObject().get("listImages").getAsJsonArray()) {
				listImagesProduct.add(images.getAsString());
			}
			JsonObject modeloJson= jsonElement.getAsJsonObject().get("description").getAsJsonObject(); 
			DescriptionProduct descriptionProduct = new DescriptionProduct(modeloJson.get("brand").getAsString(), modeloJson.get("model").getAsString(), modeloJson.get("monthsWarranty").getAsByte(),null, modeloJson.get("yearOfCreation").getAsInt() );
			listProducts.add(Shop.createProduct(jsonElement.getAsJsonObject().get("id").getAsInt(), jsonElement.getAsJsonObject().get("name").getAsString(), jsonElement.getAsJsonObject().get("price").getAsDouble(), descriptionProduct, jsonElement.getAsJsonObject().get("quantumAvailable").getAsInt(), Category.valueOf(jsonElement.getAsJsonObject().get("category").getAsString()), jsonElement.getAsJsonObject().get("discont").getAsDouble(), listImagesProduct));
		}
		return listProducts;
	}
}
