package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import persistence.ManagerPersistence;
import Exceptions.IdProductInexistExeption;
import models.dao.Category;
import models.dao.Shop;
import models.entity.Product;
import views.DialogBio;
import views.DialogCreateProduct;
import views.DialogDescriptionProduct;
import views.DialogFileChooser;
import views.DialogSettings;
import views.MainWindowUser;
import views.MainWindows;
import views.login.DialogUserOrAdmin;

public class Controller implements ActionListener, MouseListener, KeyListener {

	private MainWindows mainWindows;
	private MainWindowUser mainWindowUser;
	private DialogCreateProduct dialogCreateProduct;
	private DialogSettings dialogSettings;
	private DialogFileChooser dialogFileChooser;
	private DialogBio dialogBio;
	private DialogUserOrAdmin dialogUserOrAdmin;
	private DialogDescriptionProduct dialogDescriptionProduct;
	private Shop shop;
	private ActionFileChooser actionFileChooser;
	
	public Controller() {
		mainWindows = new MainWindows(this);
		mainWindowUser = new MainWindowUser(this) ;
		dialogUserOrAdmin = new DialogUserOrAdmin(this);
		dialogCreateProduct = new DialogCreateProduct(this, mainWindows);
		dialogSettings = new DialogSettings(this, mainWindows);
		dialogFileChooser = new DialogFileChooser(this, mainWindows);
		dialogBio = new DialogBio(this, mainWindows);
		dialogDescriptionProduct = new DialogDescriptionProduct(this, mainWindows);
		shop = new Shop(1, "Shop", null);
		MAX_NUMBER_PAGES = 1;
		dataInit();
		dialogUserOrAdmin.setVisible(true);
	}

	private void dataInit() {
		try {
			ArrayList<Product> listProducts = ManagerPersistence.readProductsOfJson(new File(ManagerPersistence.PATH_NAME));
			shop.setListProducts(listProducts);
			shop.setListProductsFilter(listProducts);
			mainWindows.updateTable(shop.getListProductsFilter(), shop.getPointProductsForPage(mainWindows.getNumberPageCurrent()));
			mainWindowUser.getPanelShowProducts().addJbuttons(shop.getListProducts(), this);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(mainWindows, "Not exist File whit data");
		}
		numberMaxPages(shop.getListProductsFilter());
		mainWindows.setFormatPages(MAX_NUMBER_PAGES);
		if (shop.getListProductsFilter().size() <= Integer.parseInt(ManagerPersistence.readProperty("numberDataForPage"))) {
			mainWindows.disableButtonsControl();
		}
	}

	private void numberMaxPages(ArrayList<Product> listProducts) {
		if (((double)listProducts.size() / Integer.parseInt(ManagerPersistence.readProperty("numberDataForPage")))%1 == 0) {
			MAX_NUMBER_PAGES = listProducts.size() / Integer.parseInt(ManagerPersistence.readProperty("numberDataForPage"));
		}else {
			MAX_NUMBER_PAGES = (listProducts.size() / Integer.parseInt(ManagerPersistence.readProperty("numberDataForPage"))) + 1;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Action.valueOf(e.getActionCommand())) {
		case BUTTON_OPEN_DIALOG_ADMIN:
			actionButtonOpenDialogAdmin();
			break;
		case BUTTON_OPEN_DIALOG_CUSTOMER:
			actionButtonOpenDialogUser();
			break;
		case OPEN_DIALOG_DESCRIPTION_PRODUCT:
			dialogDescriptionProduct.setVisible(true);
			break;
		case CLOSE_DIALOG_DESCRIPTION_PRODUCT:
			dialogDescriptionProduct.setVisible(false);
			break;
		case BUTTON_SAVE_DESCRIPTION:
			actionButtonSaveDescription();
			break;
		case BUTTON_ADD_PRODUCT:
			dialogCreateProduct.setVisible(true);
			break;
		case CLOSE_DIALOG_CREATE_PRODUCT:
			actionButtonCloseDialogCreateProduct();
			break;
		case BUTTON_SAVE_PRODUCT:
			actionButtonSave();
			break;
		case EXIT:
			System.exit(0);
			break;
		case BUTTON_LAST_PAGE_BACK:
			actionButtonLastPageBack();
			break;
		case BUTTON_PAGE_BACK:
			actionButtonPageBack();
			break;
		case BUTTON_PAGE_NEXT:
			actionButtonPageNext();
			break;
		case BUTTON_LAST_PAGE_NEXT:
			actionButtonLastPageNext();
			break;
		case SHOW_DIALOG_SETTINGS:
			dialogSettings.setVisible(true);
			break;
		case BUTTON_SAVE_SETTINGS:
			actionButtonSaveSettings();
			break;
		case BUTTON_CANCEL_SETTINGS:
			dialogSettings.setVisible(false);
			break;
		case BUTTON_SELECT_IMAGE:
			actionButtonSelectImage();
			break;
		case SAVE_PATH:
			actionButtonSavePath();
			break;
		case CANCEL_PATH:
			dialogFileChooser.setVisible(false);
			break;
		case BUTTON_CHOOSE_IMAGE_FOR_FILES:
			chooseForFiles();
			break;
		case BUTTON_CHOOSE_IMAGE_FOR_FOLDERS:
			chooseForFolders();
			break;
		case BUTTON_CLOSE_CHOOSER_FILES:
			dialogCreateProduct.closeDialogChoose();
			break;
		case BUTTON_FILTER:
			actionButtonFilter();
			break;
		case BUTTON_ALL:
			actionButtonAll();
			break;
		case CLOSE_DIALOG_BIO_PRODUCT:
			dialogBio.setVisible(false);
			break;
		case BUTTON_PRODUCTOS:
			break;
		case BUTTON_SHOW_PRODUCTS_AUTOMOVILE:
			actionButtonShowCategorys(Category.AUTOMOTIVE);
			break;
		case BUTTON_SHOW_PRODUCTS_BOOKS:
			actionButtonShowCategorys(Category.BOOKS);
			break;
		case BUTTON_SHOW_PRODUCTS_ENTERTAINMENT:
			actionButtonShowCategorys(Category.ENTERTAINMENT);
			break;
		case BUTTON_SHOW_PRODUCTS_HOME:
			actionButtonShowCategorys(Category.HOME);
			break;
		case BUTTON_SHOW_PRODUCTS_SPORTS:
			actionButtonShowCategorys(Category.SPORTS);
			break;
		case BUTTON_SHOW_PRODUCTS_SUPERMARKET:
			actionButtonShowCategorys(Category.SUPERMARKET);
			break;
		case BUTTON_SHOW_PRODUCTS_TECHNOLOGY:
			actionButtonShowCategorys(Category.TECHNOLOGY);
			break;
		case BUTTON_SHOW_PRODUCTS_TOYS:
			actionButtonShowCategorys(Category.TOYS);
			break;
		case BUTTON__SHOW_PRODUCTS_CLOTHES_AND_ACCESSORIES:
			actionButtonShowCategorys(Category.CLOTHES_AND_ACCESSORIES);
			break;
		case SHOW_TABLE:
			mainWindows.setVisibleTable();
			break;
		case SHOW_CLIENTS:
			mainWindows.setInvisibleTable();
			break;
		case BUTTON_PRINT:
			break;
		case BUTTON_PAPERS:
			break;
		default:
			break;
		}
	}

	private void actionButtonOpenDialogUser() {
		dialogUserOrAdmin.setVisible(false);
		mainWindowUser.setVisible(true);
	}

	private void actionButtonOpenDialogAdmin() {
		dialogUserOrAdmin.setVisible(false);
		mainWindows.setVisible(true);
	}

	private void actionButtonSaveDescription() {
		dialogDescriptionProduct.setVisible(false);
		dialogCreateProduct.addDescription(dialogDescriptionProduct.getDescriptionProduct());
		dialogCreateProduct.setVisible(true);
	}

	private void actionButtonCloseDialogCreateProduct() {
		dialogCreateProduct.setVisible(false);
		dialogCreateProduct.clearnText();
	}

	private void actionButtonShowCategorys(Category category) {
		shop.setListProductsFilter(shop.searchProductForCategory(category));
		mainWindowUser.getPanelShowProducts().addJbuttons(shop.getListProductsFilter(), this);
		mainWindowUser.revalidate();
	}
	
	private void actionButtonAll() {
		mainWindows.setNumberPageCurrent(1, MAX_NUMBER_PAGES);
		mainWindows.disableButtonsControlBack();
		shop.setListProductsFilter(shop.getListProducts());
		mainWindows.updateTable(shop.getListProductsFilter(), shop.getPointProductsForPage(mainWindows.getNumberPageCurrent()));
		numberMaxPages(shop.getListProductsFilter());
		if (shop.getListProductsFilter().size() <= Integer.parseInt(ManagerPersistence.readProperty("numberDataForPage"))) {
			mainWindows.disableButtonsControl();
		}else {
			mainWindows.enableButtonsControl();
		}
		mainWindows.setFormatPages(MAX_NUMBER_PAGES);
	}

	private void actionButtonFilter() {
		if (mainWindows.isVisible()) {
			filterMainWindow();
		}else if(mainWindowUser.isVisible()){
			filterMainWindowUser();
		}
		
	}
	
	private void filterMainWindowUser(){
		ArrayList<Product> listProducts = shop.getListProductsForFilter(mainWindowUser.getFilteringOptions().getTextFiledSearchByName(), mainWindowUser.getFilteringOptions().getSpinnerSearchByPriceMin(), mainWindowUser.getFilteringOptions().getSpinneSearchByPriceMax(), mainWindowUser.getFilteringOptions().getComboBoxSearchByCategory());
		mainWindowUser.getPanelShowProducts().addJbuttons(listProducts, this);
		mainWindowUser.revalidate();
	}
	
	private void filterMainWindow(){
		mainWindows.setNumberPageCurrent(1, MAX_NUMBER_PAGES);
		mainWindows.disableButtonsControlBack();
		shop.setListProductsFilter(shop.getListProductsForFilter((String)mainWindows.getListValuesForFilter()[0], (double)mainWindows.getListValuesForFilter()[1], (double)mainWindows.getListValuesForFilter()[2], (Category)mainWindows.getListValuesForFilter()[3]));
		mainWindows.updateTable(shop.getListProductsFilter(), shop.getPointProductsForPage(mainWindows.getNumberPageCurrent()));
		numberMaxPages(shop.getListProductsFilter());
		if ((shop.getListProductsFilter().size() > Integer.parseInt(ManagerPersistence.readProperty("numberDataForPage")))) {
			mainWindows.enableButtonsControl();
		}else {
			mainWindows.disableButtonsControl();
		}
		mainWindows.setFormatPages(MAX_NUMBER_PAGES);
	}

	private void actionButtonSavePath() {
		if (actionFileChooser.equals(ActionFileChooser.FILTER_FOR_FILE)) {
			dialogCreateProduct.setImages(dialogFileChooser.getPathName());
		}else {
			dialogCreateProduct.setImages(dialogFileChooser.getCurrentDirectory());
		}
		dialogFileChooser.setVisible(false);
	}

	private void actionButtonSelectImage() {
		switch (ManagerPersistence.readProperty("chooseFiles")) {
		case "1":
			chooseForFiles();
			break;
		case "2":
			chooseForFolders();
			break;
		case "3":
			dialogCreateProduct.showDialogChoose();
			break;
		}
	}

	private void chooseForFolders() {
		dialogFileChooser.setFileFilter("Folders", "Folder");
		dialogFileChooser.filterFor(JFileChooser.DIRECTORIES_ONLY);
		dialogFileChooser.setVisible(true);
		actionFileChooser = ActionFileChooser.FILTER_FOR_FOLDER;
	}

	private void chooseForFiles() {
		actionFileChooser = ActionFileChooser.FILTER_FOR_FILE;
		dialogFileChooser.setFileFilter("Images", "png");
		dialogFileChooser.filterFor(JFileChooser.FILES_ONLY);
		dialogFileChooser.setVisible(true);
	}

	private void actionButtonSaveSettings() {
		dialogSettings.saveSettingNumberDataForPage();
		dialogSettings.saveSettingChooseImage();
		numberMaxPages(shop.getListProductsFilter());
		mainWindows.setFormatPages(MAX_NUMBER_PAGES);
		validationsButtonSaveSettings();
		mainWindows.updateTable(shop.getListProductsFilter(), shop.getPointProductsForPage(mainWindows.getNumberPageCurrent()));
		numberMaxPages(shop.getListProductsFilter());
		dialogSettings.setVisible(false);
	}

	private void validationsButtonSaveSettings() {
		if (mainWindows.getNumberPageCurrent() > MAX_NUMBER_PAGES) {
			mainWindows.setNumberPageCurrent(MAX_NUMBER_PAGES, MAX_NUMBER_PAGES);
			mainWindows.disableButtonsControl();
		}
		if (mainWindows.getNumberRowsCurrent() == 1) {
			if (mainWindows.getNumberPageCurrent() > 1 && mainWindows.getNumberPageCurrent() > MAX_NUMBER_PAGES) {
				mainWindows.setNumberPageCurrent(mainWindows.getNumberPageCurrent()-1, MAX_NUMBER_PAGES);
			}
			mainWindows.disableButtonsControl();
		}
		if (MAX_NUMBER_PAGES == 1) {
			mainWindows.disableButtonsControl();
		}else {
			if (mainWindows.getNumberPageCurrent() != MAX_NUMBER_PAGES) {
				mainWindows.enableButtonsControl();				
			}
		}
	}
	
	private int MAX_NUMBER_PAGES = 1;
	
	private void actionButtonLastPageNext() {
		mainWindows.setNumberPageCurrent(MAX_NUMBER_PAGES, MAX_NUMBER_PAGES);
		advanceForPages(Action.BUTTON_LAST_PAGE_NEXT);
	}

	private void advanceForPages(Action action) {
		mainWindows.advanceForPage(shop.getListProductsFilter(), shop.getPointProductsForPage(mainWindows.getNumberPageCurrent()), action, MAX_NUMBER_PAGES);
	}

	private void actionButtonPageNext() {
		mainWindows.setNumberPageCurrent(mainWindows.getNumberPageCurrent()+1, MAX_NUMBER_PAGES);
		advanceForPages(Action.BUTTON_PAGE_NEXT);
	}

	private void actionButtonPageBack() {
		mainWindows.setNumberPageCurrent(mainWindows.getNumberPageCurrent()-1, MAX_NUMBER_PAGES);
		advanceForPages(Action.BUTTON_PAGE_BACK);
	}

	private void actionButtonLastPageBack() {
		mainWindows.setNumberPageCurrent(1, MAX_NUMBER_PAGES);
		advanceForPages(Action.BUTTON_LAST_PAGE_BACK);
	}

	private void actionButtonEdit(int id) {
		try {
			dialogCreateProduct.setVisible(true);
			shop.getListProducts().remove(shop.getListProducts().size()-1);
			shop.editProduct(id, dialogCreateProduct.getProduct());
			shop.setListProductsFilter(shop.getListProducts());
			numberMaxPages(shop.getListProductsFilter());
			mainWindows.updateTable(shop.getListProductsFilter(), shop.getPointProductsForPage(mainWindows.getNumberPageCurrent()));
		} catch (IdProductInexistExeption e) {
			JOptionPane.showMessageDialog(mainWindows, "Error the integer the product, please try again");
		}
		reloadListProducts();
	}
	
	private void actionButtonRemove(int id) {
		if(JOptionPane.showConfirmDialog(mainWindows, "Really want to remove this product?", "Remove Product", JOptionPane.WARNING_MESSAGE) == 0){
			try {
				validationsButtonRemove();
				shop.deleteProduct(id);
				shop.setListProductsFilter(shop.getListProducts());
				ManagerPersistence.writeProductsInJson(shop.getListProducts());
				mainWindows.updateTable(shop.getListProductsFilter(), shop.getPointProductsForPage(mainWindows.getNumberPageCurrent()));
				numberMaxPages(shop.getListProductsFilter());
			} catch (IdProductInexistExeption | IOException e) {
				e.printStackTrace();
			}
			mainWindows.setFormatPages(MAX_NUMBER_PAGES);
		}
		reloadListProducts();
	}

	private void validationsButtonRemove() {
		if (mainWindows.getNumberRowsCurrent() == 1) {
			if (mainWindows.getNumberPageCurrent() > 1) {
				mainWindows.setNumberPageCurrent(mainWindows.getNumberPageCurrent()-1, MAX_NUMBER_PAGES);
			}
			mainWindows.disableButtonsControl();
		}
	}

	private void actionButtonSave() {
		try {
			Product product = dialogCreateProduct.getProduct();
			validationsButtonSave();
			if (product.getDescription() == null) {
				dialogCreateProduct.displayErrors("The description can´t is void");
				return;
			}
			shop.addProduct(product);
			shop.setListProductsFilter(shop.getListProducts());
			ManagerPersistence.writeProductsInJson(shop.getListProducts());
			mainWindows.updateTable(shop.getListProductsFilter(), shop.getPointProductsForPage(mainWindows.getNumberPageCurrent()));
		} catch (Exception e) {
			dialogCreateProduct.displayErrors(e.getMessage());
			return;
		}
		dialogCreateProduct.setVisible(false);
		numberMaxPages(shop.getListProductsFilter());
		mainWindows.setFormatPages(MAX_NUMBER_PAGES);
		dialogCreateProduct.clearnText();
		reloadListProducts();
	}

	private void validationsButtonSave() {
		if (mainWindows.getNumberRowsCurrent() == Integer.parseInt(ManagerPersistence.readProperty("numberDataForPage")) && mainWindows.getNumberPageCurrent() == MAX_NUMBER_PAGES) {
			mainWindows.enableButtonsControl();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Se activa cuando se presiona y suelta el boton del mouse(un click)
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object objectSelectedInTable = ((JTable)e.getComponent()).getModel().getValueAt(0, ((JTable)e.getComponent()).getSelectedColumn());
		
		if (objectSelectedInTable.getClass().equals(JButton.class)) {
			int columnCount = ((JTable)e.getComponent()).columnAtPoint(e.getPoint());
			int id = 0;
			for (int i = 0; i < columnCount; i++) {
				if(((JTable)e.getComponent()).getModel().getColumnName(i).equals("ID")){
					id = (Integer)((JTable)e.getComponent()).getModel().getValueAt(mainWindows.getNumberRowSelect(), i);
				}
			}
			switch (Action.valueOf(((JButton)objectSelectedInTable).getActionCommand())) {
			case BUTTON_REMOVE_PRODUCT:
				actionButtonRemove(id);
				break;
			case BUTTON_EDIT_PRODUCT:
				actionButtonEdit(id);
				break;
			case BUTTON_BIO_PRODUCT:
				reloadListProducts();
				dialogBio.assignProduct(shop.findProductForId(id));
				break;
			default:
				break;
			}
		}
	}

	private void reloadListProducts() {
		try {
			shop.setListProducts(ManagerPersistence.readProductsOfJson(new File(ManagerPersistence.PATH_NAME)));
			shop.setListProductsFilter(shop.getListProducts());
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Se activa cuando se suelta el el boton del mouse
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Se activa cuando pasa el puntero entra al componente
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Se activa cuando pasa el puntero sale del componente
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Se activa cuando se presiona y suelta una tecla
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// Se activa cuando se presiona una tecla
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Se activa cuando se suelta una tecla
	}

}