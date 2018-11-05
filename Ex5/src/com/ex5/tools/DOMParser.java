package com.ex5.tools;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class DOMParser {
	protected static DocumentBuilder builder;
	protected static File file;
	static String FILE_LOCATION = "ressources/input.xml";

	public DOMParser() {
		file = new File(FILE_LOCATION);
	}
	
	public static void readXml() {
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			builder = factory.newDocumentBuilder();
			final Document document= builder.parse(file);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     

	}
}
