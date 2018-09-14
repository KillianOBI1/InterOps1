package com.ex1.model;

import java.util.HashMap;
import java.util.Map;

public class Contact {

	protected int id;
	protected String lastName;
	protected String firstName;
	protected String adress;
	protected String phoneNumber;
	protected Map<String,String> information;
	
	public Contact(int id,String lastName,String firstName,String adress,String phoneNumber) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.information = new HashMap<String,String>();
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void addInformation(String attribut,String info) {
		this.information.put(attribut, info);
	}
	
	public Map<String,String> getInformation() {
		return this.information;
	}
}
