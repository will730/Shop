package models.dao;

public enum Category {
	TECHNOLOGY, CLOTHES_AND_ACCESSORIES, SPORTS, SUPERMARKET, TOYS, HOME, BOOKS, ENTERTAINMENT, AUTOMOTIVE;
	
	public String toString() {
		return name().substring(0, 1).toUpperCase() + name().replaceAll("_", " ").substring(1, name().length()).toLowerCase();
	}
}