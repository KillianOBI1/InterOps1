package com.ex5.variable;

public class VariableReference extends Reference {
  protected VariableDefinition variableDefinition;
  
  public VariableReference() {
	  super();
  }
  
  public void setName(String name) {
	  this.name = name;
  }
  
  
  public void setDefinition(VariableDefinition variableDefinition) {
	  this.variableDefinition = variableDefinition;
  }
  
  public VariableDefinition getVariableDefinition() {
	return this.variableDefinition;
  }
}
