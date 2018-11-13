package com.ex5.variable;

import java.util.ArrayList;
import java.util.List;

import com.ex5.visitor.Visitable;
import com.ex5.visitor.Visitor;

public class Programme implements Visitable{
  List<Element> elements;
  String programName;
  
  public Programme(String programName) {
    this.programName = programName;
    this.elements = new ArrayList<Element>();
  }
  
  @Override
  public void accept(Visitor v) {
    for(Element element : this.elements) {
      v.visitElement(element);
    }
  }
  
  public void addElement(Element e) {
    this.elements.add(e);
  }
  
  public List<Element> getElements() {
    return this.elements;
  }
 
}
