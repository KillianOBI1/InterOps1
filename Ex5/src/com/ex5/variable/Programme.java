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
    // TODO Auto-generated method stub
    
  }
 
}
