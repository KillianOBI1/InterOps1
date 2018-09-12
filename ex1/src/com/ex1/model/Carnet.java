package com.ex1.model;

import java.util.ArrayList;
import java.util.List;

public class Carnet {
	int id;
	protected List<Contact> contacts;
	
	public Carnet(int id) {
		this.id = id;
		this.contacts = new ArrayList<Contact>();
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void addContact(Contact c) {
		if(!this.contacts.contains(c)) {
			this.contacts.add(c);
		}
	}

	public void removeContact(Contact c) {
		if(this.contacts.contains(c)) this.contacts.remove(c);
	}
	
	public Contact getContact(int id) {
		for(Contact c: this.contacts) {
			if(c.getId()==id) return c;
		}
		return null;
	}
	
}
