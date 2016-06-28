package models.dao;

public enum ToolTipConstants {
	SEE_LIST_PRODUCTS, ADD_NEW_PRODUCT;
	
	public String toString() {
		return name().substring(0, 1).toUpperCase() + name().replaceAll("_", " ").substring(1, name().length()).toLowerCase();
	}
}
