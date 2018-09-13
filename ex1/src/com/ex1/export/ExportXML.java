package com.ex1.export;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Field;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ex1.model.Carnet;
import com.ex1.model.Contact;
import com.ex1.model.Gestionnaire;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ExportXML {
  
  protected final static String HEAD = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n<Gestionnaire>\n";
  protected final static String END = "</Gestionnaire>";
	public ExportXML() {
		super();
	}
	
	//TODO find a way to make more generic
	public static boolean exportXMLManlyManAttribut(Gestionnaire g) {
	  try (
	      Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ressources/gestionnaireAttribut.xml"), "utf-8"))) {
	      writer.write(HEAD);
	      //node carnet
	      for(Carnet carnet : g.getCarnets()) {
	        String carnetNode = "\t<"+carnet.getClass().getSimpleName();
	        carnetNode += " id=\""+carnet.getId()+"\"";
	        writer.write(carnetNode+">\n");
	        for(Contact contact : carnet.getContacts()) {
	          String contactNode = "\t\t<"+contact.getClass().getSimpleName();
	          contactNode += " id=\""+contact.getId()+"\"";
	          contactNode += " lastName=\""+contact.getLastName()+"\"";
	          contactNode += " firstName=\""+contact.getFirstName()+"\"";
	          contactNode += " adress=\""+contact.getAdress()+"\"";
	          contactNode += " phoneNumber=\""+contact.getPhoneNumber()+"\"";
	          writer.write(contactNode+"></"+contact.getClass().getSimpleName()+">\n");
	        }
	         writer.write("</"+carnet.getClass().getSimpleName()+">\n");
	      }
	      writer.write(END);
	      writer.close();
	      return true;
	  } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
	  return false;
	}
	//TODO find a way to make more generic
	public boolean exportXMLManlyManElement(Gestionnaire g) {
	  try (
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ressources/gestionnaireElement.xml"), "utf-8"))) {
        writer.write(HEAD);
        //node carnet
        for(Carnet carnet : g.getCarnets()) {
          writer.write("\t<"+carnet.getClass().getSimpleName()+">\n");
          writer.write("\t\t <id>"+carnet.getId()+"</id>\n");
          
          for(Contact contact : carnet.getContacts()) {
            writer.write("\t\t <contact>\n");
            writer.write("\t\t\t<id>"+contact.getId()+"</id>\n");
            writer.write("\t\t\t<lastName>"+contact.getLastName()+"</lastName>\n");
            writer.write("\t\t\t<firstName>"+contact.getFirstName()+"</firstName>\n");
            writer.write("\t\t\t<adress>"+contact.getAdress()+"</adress>\n");
            writer.write("\t\t\t<phoneNumber>"+contact.getPhoneNumber()+"</phoneNumber>\n");
            writer.write("\t\t </contact>\n");
          }
          
          writer.write("\t</"+carnet.getClass().getSimpleName()+">\n");
        }
        writer.write(END);
        writer.close();
        return true;
    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
	  return false;
	}
}
