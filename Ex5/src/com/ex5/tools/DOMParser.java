package com.ex5.tools;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ex5.factory.impl.VariableDefintionFactoryImpl;
import com.ex5.variable.Machine;
import com.ex5.variable.UnresolvedSymbol;
import com.ex5.variable.VariableDefinition;

public class DOMParser {
	protected static DocumentBuilder builder;
	protected static File file;
	static String FILE_LOCATION = "ressources/expression.xml";

	public DOMParser() {
		file = new File(FILE_LOCATION);
	}
	
	public static void readXml() {
	  Machine machine = new Machine();
		file = new File(FILE_LOCATION);
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			builder = factory.newDocumentBuilder();
			final Document document= builder.parse(file);
			NodeList langage = document.getDocumentElement().getChildNodes();
			for(int i = 0 ; i < langage.getLength() ; i++) {
				if(langage.item(i).getNodeType() == Node.ELEMENT_NODE) {
					switch(langage.item(i).getNodeName()) {
					  case "VariableDefinition":
					    VariableDefinition variableDefition = VariableDefintionFactoryImpl.createVariableDefinition((Element)(langage.item(i)));
					    machine.addAssociation(variableDefition, new UnresolvedSymbol());
						  break;
					  case "Affectation":
					    System.out.println("affec");
					    break;
					  case "ProcCall":
					    System.out.println("ProcCall");
					    break;
					  default :
					    System.err.println("Bad node");
					    break;
					}
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     

	}
}
