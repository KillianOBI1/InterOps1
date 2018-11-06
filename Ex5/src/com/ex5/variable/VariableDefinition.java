package com.ex5.variable;

import java.util.ArrayList;
import java.util.List;

public class VariableDefinition {
  protected String name;
  protected String type;
  protected String visibility;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getVisibility() {
    return visibility;
  }

  public void setVisibility(String visibility) {
    this.visibility = visibility;
  }

  public VariableReference getVariableReference(int index) {
    return this.listReference.get(index);
  }

  public void addListReference(VariableReference variableReference) {
    this.listReference.add(variableReference);
  }
}
