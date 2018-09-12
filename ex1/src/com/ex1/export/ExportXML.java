package com.ex1.export;

import java.io.File;

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
import com.ex1.model.Gestionnaire;

public class ExportXML {
	
	public ExportXML() {
		super();
	}
	
	public boolean exportCarnetAttributWithLib(Gestionnaire g) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder;

			docBuilder = docFactory.newDocumentBuilder();
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Gestionnaire");
			doc.appendChild(rootElement);
			
			
			for(Carnet c : g.getCarnets()) {
				Element carnet = doc.createElement("Carnet");
				rootElement.appendChild(carnet);
				// set attribute to staff element
				Attr attr = doc.createAttribute("id");
				attr.setValue(c.getId()+"");
				carnet.setAttributeNode(attr);
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("D:\\file.xml"));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");
			return true;
		} catch (ParserConfigurationException | TransformerConfigurationException e ) {
			// TODO Auto-generated catch block
			
			System.err.println("Couldn't save");
			e.printStackTrace();
			return false;
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			System.err.println("Couldn't save");
			e.printStackTrace();
			return false;
		}


	}
	
	public void exportXMLManlyMan(Gestionnaire g) {
			
	}
}
