package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class Constants {
	public static final int SIZE_OF_TOOLKIT_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int SIZE_OF_TOOLKIT_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height - 38;
	public static final int WIDTH_MAIN_ADMIN = 1300;
	public static final int HEIGHT_MAIN_ADMIN = 700;
	public static final int WIDTH_MAIN_USER = 1300;
	public static final int HEIGHT_MAIN_USER = 700;
	public static final String IMAGE_BACKGROUND_WELCOME = "/img/backgroundAdminOrUser.png";
	public static final String IMAGE_LOGO_WELCOME = "/img/iconAdminOrUser.PNG";
	public static final String ICON_MAIN = "/img/shop.png";
	public static final String IMAGE_ADD_PRODUCT = "/img/addProduct.png";
	public static final String IMAGE_PRODUCTS = "/img/Products.png";
	public static final String IMAGE_CLIENTS = "/img/Clients.png";
	public static final String IMAGE_PAPERS = "/img/Papers.png";
	public static final String IMAGE_PRINT = "/img/Print.png";
	public static final String IMAGE_WELCOME = "/img/Welcome.png";
	public static final String IMAGE_LOGO = "/img/Logo.png";
	public static final Color COLOR_BACKGROUND_BUTTONS = Color.decode("#A9BCF5");
	public static final Color COLOR_BORDER_FACTORY_BUTTONS = Color.decode("#FE2E64");
	public static final Color COLOR_BACKGROUND_OPTION_PANE = Color.decode("#58ACFA");
	public static final Color COLOR_BACKGROUND_PANELS = Color.decode("#58ACFA");
	public static final Color COLOR_BLUE_GENERAL = Color.decode("#40658A");
	public static final Color COLOR_GREEN_GENERAL = Color.decode("#5B7729");
	public static final Color COLOR_DARK_BLUE_GENERAL = Color.decode("#194290");
	public static final Color COLOR_BACKGROUND_SELECTION_TABLE = Color.decode("#F2E7B4");
	public static final double INIT_VALUE_PRICE_PRODUCT_USER = 50.0;
	public static final double INIT_VALUE_SKIP_PRICE_PRODUCT_USER = 50.0;
	public static final double INIT_VALUE_DISCONT_PRODUCT = 0.0;
	public static final double INIT_VALUE_SKIP_DISCONT_PRODUCT = 0.5;
	public static final double INIT_VALUE_MAX_PRICE_PRODUCT_FILTER_USER = 5000.0;
	public static final double INIT_VALUE_MAX_PRICE_SKIP_PRODUCT_FILTER_USER = 50.0;
	public static final double INIT_VALUE_PRICE_PRODUCT_ADMIN = 50.0;
	public static final double INIT_VALUE_SKIP_PRICE_PRODUCT_ADMIN = 50.0;
	public static final double INIT_VALUE_MAX_PRICE_PRODUCT_FILTER_ADMIN = 5000.0;
	public static final double INIT_VALUE_MAX_PRICE_SKIP_PRODUCT_FILTER_ADMIN = 50.0;
	public static final Font FONT_TABLE = new Font("Tahoma", 4, 15);

}
