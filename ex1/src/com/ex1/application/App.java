package com.ex1.application;

import com.ex1.export.ExportXML;
import com.ex1.model.Carnet;
import com.ex1.model.Contact;
import com.ex1.model.Gestionnaire;

public class App {

	public static void main(String[] args) {
		Gestionnaire g = new Gestionnaire();
		g.addCarnet(new Carnet(0));
		g.addCarnet(new Carnet(1));
		g.addCarnet(new Carnet(2));
		g.addCarnet(new Carnet(3));
		//first
		Carnet c = g.getCarnetById(0);
		c.addContact(new Contact(0, "Raikonen", "Kimi", "Finland", "0202020202"));
		c.addContact(new Contact(1, "Robotas", "Valteri", "Finland", "0202020202"));
		c.addContact(new Contact(2, "Verstappen", "Jos", "Je frappe ma femme", "0202020202"));
		c.addContact(new Contact(3, "Flag", "Blue", "Deustchland", "0202020202"));
		c.addContact(new Contact(4, "Wheel", "Steering", "COME ON", "0202020202"));
		//second
		c = g.getCarnetById(1);
    c.addContact(new Contact(0, "Couilles", "Gobe", "Finland", "0202020202"));
    c.addContact(new Contact(1, "de Couilles", "test", "Finland", "0202020202"));
    c.addContact(new Contact(2, "De Couille", "Bleu", "Je frappe ma femme", "0202020202"));
    c.addContact(new Contact(3, "Pas", "a", "Deustchland", "0202020202"));
    c.addContact(new Contact(4, "zz", "zz", "COME ON", "0202020202"));
    //third
    c = g.getCarnetById(2);
    c.addContact(new Contact(0, "MO", "LE", "Finland", "0202020202"));
    c.addContact(new Contact(1, "Ros", "Vi", "Finland", "0202020202"));
    c.addContact(new Contact(2, "Vern", "Jo", "Je frappe ma femme", "0202020202"));
    c.addContact(new Contact(3, "Fla", "Blu", "Deustchland", "0202020202"));
    c.addContact(new Contact(4, "Whel", "Stering", "COME ON", "0202020202"));
    //fourth
    c = g.getCarnetById(3);
    c.addContact(new Contact(0, "Rn", "Ki", "Finland", "0202020202"));
    c.addContact(new Contact(1, "Robo", "Val", "Finland", "0202020202"));
    c.addContact(new Contact(2, "Verst", "J", "Je frappe ma femme", "0202020202"));
    c.addContact(new Contact(3, "Fl", "Bl", "Deustchland", "0202020202"));
    c.addContact(new Contact(4, "Wh", "St", "COME ON", "0202020202"));
		if(g.getCarnetById(0).equals(c)) System.out.println("ok");
		ExportXML export = new ExportXML();
		export.exportXMLManlyManAttribut(g);
		export.exportXMLManlyManElement(g);
//		export.exportCarnetAttributWithLib(g);
	}

}
