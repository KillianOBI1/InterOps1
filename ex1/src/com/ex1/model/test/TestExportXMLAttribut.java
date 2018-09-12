package com.ex1.model.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.ex1.export.ExportXML;
import com.ex1.model.Carnet;
import com.ex1.model.Gestionnaire;

class TestExportXMLAttribut {
	
	Gestionnaire g = new Gestionnaire();
	File f = new File("D:\\file.xml");
	@Before
	void initGestionnaire() {
		g.addCarnet(new Carnet(0));
		g.addCarnet(new Carnet(43));
		g.addCarnet(new Carnet(50));
	}

	@Test
	void testExport() {
		
		ExportXML export = new ExportXML();
		assertTrue(export.exportCarnetAttributWithLib(g));
		
	}
	
	@Test
	void testExportInformation() {
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
		    final Document document= builder.parse(f);
		    assertTrue(document.getDocumentElement().getTagName().equals("Gestionnaire"));
		    assertTrue(document.getFirstChild().getNodeName().equals("Carnet"));
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
	@After
	void removeFile() {
		f.delete();
		System.out.println("File deleted");
	}

}
