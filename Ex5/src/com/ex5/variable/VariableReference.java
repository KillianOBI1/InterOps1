package com.ex5.variable;

public class VariableReference extends Reference {
  public VariableDefinition variableDefinition;
  
  public VariableReference() {
	  super();
	  this.variableDefinition = new VariableDefinition();
  }
  
  public void setName(String name) {
	  this.name = name;
  }
}
