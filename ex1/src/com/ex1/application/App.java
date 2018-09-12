package com.ex1.application;

import com.ex1.export.ExportXML;
import com.ex1.model.Carnet;
import com.ex1.model.Contact;
import com.ex1.model.Gestionnaire;

public class App {

	public static void main(String[] args) {
		Gestionnaire g = new Gestionnaire();
		g.addCarnet(new Carnet(0));
		Carnet c = g.getCarnetById(0);
		c.addContact(new Contact(0, "Raikonen", "Kimi", "Finland", "0202020202"));
		if(g.getCarnetById(0).equals(c)) System.out.println("ok");
		ExportXML export = new ExportXML();
		export.exportCarnetAttributWithLib(g);
	}

}
