package com.ex5.variable;

import java.util.ArrayList;
import java.util.List;

import com.ex5.visitor.Visitable;
import com.ex5.visitor.Visitor;

public class Programme implements Visitable{
  List<Statement> elements;
  String programName;
  
  public Programme(String programName) {
    this.programName = programName;
    this.elements = new ArrayList<Statement>();
  }
  
  @Override
  public void accept(Visitor v) {
    for(Statement element : this.elements) {
      v.visitElement(element);
    }
  }
  
  public void addElement(Statement e) {
    this.elements.add(e);
  }
  
  public List<Statement> getElements() {
    return this.elements;
  }
 
}
