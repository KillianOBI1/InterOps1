package com.ex5.variable;

import com.ex5.visitor.Visitor;

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

  @Override
  public void accept(Visitor v) {
    v.visitReference(this);
  }
  
  @Override
  public String toString() {
    return this.variableDefinition.name;
//    return "VariableRef name: "+this.name+" VariableDef :"+this.variableDefinition.toString();
  }
}
