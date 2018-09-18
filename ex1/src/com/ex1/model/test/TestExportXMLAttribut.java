package com.ex1.model.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ex1.export.ExportXML;
import com.ex1.model.Carnet;
import com.ex1.model.Contact;
import com.ex1.model.Gestionnaire;

class TestExportXMLAttribut {
	
	@Parameter(0)
  public Gestionnaire g;

  // creates the test data
  @Parameters
  public static Gestionnaire data() {
      Gestionnaire result = new Gestionnaire();
      Carnet c = new Carnet(1);
      Contact contact = new Contact(10, "Random", "Randy", "Space", "0658929723");
      contact.addInformation("Profession", "randomisateur");
      c.addContact(contact);
      contact = new Contact(20, "Aurèle", "Mark", "Rome", "0658929723");
      contact.addInformation("Profession", "Empereur");
      c.addContact(contact);
      result.addCarnet(c);
      c = new Carnet(2);
      contact = new Contact(30, "Bradley", "Omar", "USA", "0658929723");
      contact.addInformation("Allegeance", "US Army");
      c.addContact(contact);
      contact = new Contact(40, "Patton", "Georges", "USA", "0658929723");
      contact.addInformation("Arme", "Blindée");
      c.addContact(contact);
      result.addCarnet(c);
      c = new Carnet(3);
      contact = new Contact(50, "Skywalker", "Anakin", "Tatooine", "0658929723");
      c.addContact(contact);
      c.addContact(new Contact(60, "Kenobi", "Obi-wan", "Corusant", "0658929723"));
      result.addCarnet(c);
      return result;
  }

	@Test
	void testExport() {
	  g = TestExportXMLAttribut.data();
		ExportXML export = new ExportXML();
		assertTrue(ExportXML.exportXMLManlyManAttribut(g));
		
	}
	
	@Test
	void testExportInformation() {
	  int size = 0;
	  g = TestExportXMLAttribut.data();
	  File f = new File("ressources/gestionnaireAttribut.xml");
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
		    final Document document= builder.parse(f);
		    assertTrue(document.getDocumentElement().getNodeName().equals(g.getClass().getSimpleName()));
		    NodeList nList = document.getDocumentElement().getChildNodes();
		    List<Element> listCarnet = new ArrayList<Element>();
		    for(int i = 0 ; i < nList.getLength(); i++) {
		      if(nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
		        Element element = (Element) nList.item(i);
		        size++;
		        listCarnet.add(element);
		      }
		    }
        assertTrue(listCarnet.size() == g.getCarnets().size());
        //check each carnet id
        for(int i = 0 ; i < listCarnet.size(); i++) {
          assertTrue(listCarnet.get(i).getAttribute("id").equals(g.getCarnets().get(i).getId()+""));
        }
        //Contact extract and check size
        for(int i = 0 ; i < listCarnet.size() ; i++) {
          List<Element> listContact = new ArrayList<Element>();
          for(int j = 0; j < listCarnet.get(i).getChildNodes().getLength();j++) {
            if(listCarnet.get(i).getChildNodes().item(j).getNodeType() == Node.ELEMENT_NODE) {
              Element element = (Element) listCarnet.get(i).getChildNodes().item(j);
              listContact.add(element);
            }
          }
          assertTrue(g.getCarnets().get(i).getContacts().size() == listContact.size());
          for(int j = 0; j < listContact.size() ; j++) {
            assertTrue(listContact.get(j).getAttribute("id").equals(g.getCarnets().get(i).getContacts().get(j).getId()+""));
            assertTrue(listContact.get(j).getAttribute("lastName").equals(g.getCarnets().get(i).getContacts().get(j).getLastName()));
            assertTrue(listContact.get(j).getAttribute("firstName").equals(g.getCarnets().get(i).getContacts().get(j).getFirstName()));
            assertTrue(listContact.get(j).getAttribute("adress").equals(g.getCarnets().get(i).getContacts().get(j).getAdress()));
            assertTrue(listContact.get(j).getAttribute("phoneNumber").equals(g.getCarnets().get(i).getContacts().get(j).getPhoneNumber()));
            for(int k = 0; k < listContact.get(j).getChildNodes().getLength(); k++) {
              if(listContact.get(j).getChildNodes().item(k).getNodeType() == Node.ELEMENT_NODE) {
                //assertTrue(g.getCarnets().get(i).getContacts().get(j).getInformation().containsKey(listContact.get(j).getChildNodes().item(k).getAttributes()));
                for(int m = 0; m < listContact.get(j).getChildNodes().item(k).getChildNodes().getLength(); m++) {
                  if(listContact.get(j).getChildNodes().item(k).getChildNodes().item(m).getNodeType() == Node.ELEMENT_NODE) {
                    assertTrue(g.getCarnets().get(i).getContacts().get(j).getInformation().containsKey(listContact.get(j).getChildNodes().item(k).getChildNodes().item(1).getTextContent()));
                    assertTrue(g.getCarnets().get(i).getContacts().get(j).getInformation().containsValue(listContact.get(j).getChildNodes().item(k).getChildNodes().item(3).getTextContent()));
                    break;
                  }
                }
              }
            }
          }
        }
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	

}
