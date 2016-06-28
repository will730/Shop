package models.dao;

import java.util.ArrayList;

public class DescriptionShop {
	
	private String address;
	private ArrayList<Integer> listPhoneNumbers;
	private String nameOwner;
	private int yearOfCreation;
	private String info;
	
	public DescriptionShop(String address, ArrayList<Integer> listPhoneNumbers, String nameOwner, int yearOfCreation, String info) {
		this.address = address;
		this.listPhoneNumbers = listPhoneNumbers;
		this.nameOwner = nameOwner;
		this.yearOfCreation = yearOfCreation;
		this.info = info;
	}
	
	public void addPhoneNumber(int phoneNumber) {
		listPhoneNumbers.add(phoneNumber);
	}
	
	public void editPhoneNumber(int phoneNumberCurrent, int phoneNumberNew) {
		listPhoneNumbers.add(listPhoneNumbers.indexOf((Object)phoneNumberCurrent), phoneNumberNew);
	}
	
	public void removePhoneNumber(int phoneNumber) {
		listPhoneNumbers.remove((Object)phoneNumber);
	}

	public String getAddress() {
		return address;
	}

	public ArrayList<Integer> getListPhoneNumbers() {
		return listPhoneNumbers;
	}

	public String getNameOwner() {
		return nameOwner;
	}

	public int getYearOfCreation() {
		return yearOfCreation;
	}

	public String getInfo() {
		return info;
	}
	
}
