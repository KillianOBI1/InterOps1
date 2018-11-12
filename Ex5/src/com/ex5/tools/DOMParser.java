package com.ex5.tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ex5.model.Expression;
import com.ex5.model.binaire.PlusExpression;
import com.ex5.model.unaire.IntExpression;
import com.ex5.variable.Affectation;
import com.ex5.variable.Instruction;
import com.ex5.variable.Machine;
import com.ex5.variable.ProcCall;
import com.ex5.variable.UnresolvedSymbol;
import com.ex5.variable.VariableDefinition;
import com.ex5.variable.VariableReference;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NodeType;

public class DOMParser {
	protected static DocumentBuilder builder;
	protected static File file;
	static String FILE_LOCATION = "ressources/expression.xml";
	public static Machine machine;

	public DOMParser() {
		file = new File(FILE_LOCATION);
	}
	
	public static void readXml() {
		file = new File(FILE_LOCATION);
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	  machine = new Machine();
		try {
			builder = factory.newDocumentBuilder();
			final Document document= builder.parse(file);
			NodeList langage = document.getDocumentElement().getChildNodes();
			for(int i = 0 ; i < langage.getLength() ; i++) {
				if(langage.item(i).getNodeType() == Node.ELEMENT_NODE) {
					switch(langage.item(i).getNodeName()) {
					  case "VariableDefinition":
					    VariableDefinition variableDefinition = createVariableDefinition((Element)(langage.item(i)));
					    machine.addAssociation(variableDefinition, new UnresolvedSymbol());
					    machine.addToListDef(variableDefinition);
						  break;
					  case "Affectation":
					    //TODO stack ref then value update ref in appropiate variableDef
					    Element elementAffectation = (Element)(langage.item(i));
					    Affectation affectation = CreateAffectation(elementAffectation);
					    machine.addExprToPile(affectation.getExpression());
					    machine.addExprToPile(affectation.getVariableReference());
					    break;
					  case "ProcCall":
					    //TODO think about it
					    ProcCall procCall = new ProcCall();
					    String instruction = ((Element) langage.item(i)).getAttribute("instruction");
					    procCall.setInstruction(instruction);
					    procCall.setArgs(CreateArg((Element) langage.item(i)));
					    System.out.print(procCall.getInstruction()+" ");
					    System.out.println(procCall.getArgs().toString());
					    break;
					  default :
					    System.err.println("Bad node "+langage.item(i).getNodeName()+" in readXml");
					    break;
					}
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		machine.revertPile();
	}
	
	private static VariableDefinition createVariableDefinition(Element e) {
    VariableDefinition variableDefinition = new VariableDefinition();
    variableDefinition.setName(e.getAttribute("name"));
    variableDefinition.setVisibility(e.getAttribute("visibility"));
    variableDefinition.setType(e.getAttribute("type"));
    return variableDefinition;
  }
	
	 public static Affectation CreateAffectation(Element e) {
	    Affectation affectation = new Affectation();
	    NodeList nodes = e.getChildNodes();
	    for(int i = 0; i < nodes.getLength();i++) {
	      if(nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
	        Element subElement = (Element)(nodes.item(i));
	        switch(subElement.getNodeName()) {
	          case "IntExpression":
	            IntExpression intExpr = new IntExpression();
	            intExpr.setInt((Integer.parseInt(subElement.getAttribute("value"))));
	            affectation.setExpression(intExpr);
	            break;
	          case "PlusExpression":
	            PlusExpression plusExpression = CreatePlusExpr(subElement);
	            affectation.setExpression(plusExpression);
	            break;
	          case "VariableReference":
	            VariableReference variableReference = new VariableReference();
	            variableReference.name = subElement.getAttribute("name");
	            variableReference.setDefinition(machine.getDefFromList(subElement.getAttribute("variableDefinition")));
	            machine.getDefFromList(subElement.getAttribute("variableDefinition")).addListReference(variableReference);
	            affectation.setVariableReference(variableReference);
	            break;
	          default:
	            System.err.println("bad node "+ subElement.getNodeName()+" in CreateAffectation");
	            break;
	        }
	        
	      }
	    }
	    return affectation;
	  }
	 
	 public static PlusExpression CreatePlusExpr(Element e) {
	   PlusExpression plusExpression = new PlusExpression();
	   NodeList nodes =  e.getChildNodes();
	   Element opLeft=null;
	   Element opRight=null;
	   for(int i = 0 ; i<nodes.getLength();i++) {
	     if(nodes.item(i).getNodeName().equals("opLeft")) {
	       opLeft =(Element)(nodes.item(i));
	     } else if (nodes.item(i).getNodeName().equals("opRight")) {
	       opRight =(Element)(nodes.item(i));
	     }
	   }
	   //TODO OPTIMIZE
	   for(int i = 0; i<opLeft.getChildNodes().getLength();i++) {
	     if(opLeft.getChildNodes().item(i).getNodeType() == Node.ELEMENT_NODE) {
	       Element subElement = (Element)(opLeft.getChildNodes().item(i));
	       switch(subElement.getNodeName()) {
	         case "IntExpression":
	           IntExpression intExpr = new IntExpression();
             intExpr.setInt((Integer.parseInt(subElement.getAttribute("value"))));
             plusExpression.opLeft = intExpr;
	           break;
	         case "VariableReference":
	           VariableReference variableReference = new VariableReference();
             variableReference.name = subElement.getAttribute("name");
             variableReference.setDefinition(machine.getDefFromList(subElement.getAttribute("variableDefinition")));
             machine.getDefFromList(subElement.getAttribute("variableDefinition")).addListReference(variableReference);
             plusExpression.opLeft = variableReference;
	           break;
	         case "PlusExpression":
	           PlusExpression expr = CreatePlusExpr(subElement);
	           plusExpression.opLeft = expr;
	           break;
	         default:
	           System.err.println("Bad node"+ subElement.getNodeName()+"in CreatePlusExpr");
	           break;
	       }
	     }
	   }
	   for(int i = 0; i<opRight.getChildNodes().getLength();i++) {
       if(opRight.getChildNodes().item(i).getNodeType() == Node.ELEMENT_NODE) {
         Element subElement = (Element)(opRight.getChildNodes().item(i));
         switch(subElement.getNodeName()) {
           case "IntExpression":
             IntExpression intExpr = new IntExpression();
             intExpr.setInt((Integer.parseInt(subElement.getAttribute("value"))));
             plusExpression.opRight = intExpr;
             break;
           case "VariableReference":
             VariableReference variableReference = new VariableReference();
             variableReference.name = subElement.getAttribute("name");
             variableReference.setDefinition(machine.getDefFromList(subElement.getAttribute("variableDefinition")));
             machine.getDefFromList(subElement.getAttribute("variableDefinition")).addListReference(variableReference);
             plusExpression.opRight = variableReference;
             break;
           case "PlusExpression":
             PlusExpression expr = CreatePlusExpr(subElement);
             plusExpression.opRight = expr;
             break;
         }
       }
     }
	   return plusExpression;
	 }
	 
	 public static List<Expression> CreateArg(Element element) {
	   List<Expression> args = new ArrayList<Expression>();
	   NodeList n = element.getChildNodes();
	   Element e = null;
	   for(int i = 0 ; i< n.getLength(); i++) {
	     if(n.item(i).getNodeName().equals("args")) {
	       e=(Element)(n.item(i));
	     }
	   }
	   for(int i = 0; i < e.getChildNodes().getLength();i++) {
	     if(e.getChildNodes().item(i).getNodeType() == Node.ELEMENT_NODE) {
	       Element subElement = (Element) e.getChildNodes().item(i);
	       switch(subElement.getNodeName()) {
	       case "IntExpression":
           IntExpression intExpr = new IntExpression();
           intExpr.setInt((Integer.parseInt(subElement.getAttribute("value"))));
           args.add(intExpr);
           break;
         case "PlusExpression":
           PlusExpression plusExpression = CreatePlusExpr(subElement);
           args.add(plusExpression);
           break;
         case "VariableReference":
           VariableReference variableReference = new VariableReference();
           variableReference.name = subElement.getAttribute("name");
           variableReference.setDefinition(machine.getDefFromList(subElement.getAttribute("variableDefinition")));
           machine.getDefFromList(subElement.getAttribute("variableDefinition")).addListReference(variableReference);
           args.add(variableReference);
           break;
         default:
           System.err.println("bad node "+ subElement.getNodeName()+" in createArg");
           break;
	       }
	     }
	   }
	   return args;
	 }
}
