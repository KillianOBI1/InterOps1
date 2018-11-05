package com.ex5.variable;

import java.util.ArrayList;
import java.util.List;

public class VariableDefinition {
  public String name;
  public String type;
  public String visibility;
  List<VariableReference> listReference;
  
  public VariableDefinition(String name,String type,String visibility) {
	  this.name = name;
	  this.type = type;
	  this.visibility = visibility;
	  this.listReference = new ArrayList<VariableReference>();
  }
  
  public VariableDefinition() {
	  super();
  }
}
