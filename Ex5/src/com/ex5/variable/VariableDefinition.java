package com.ex5.variable;

public class VariableDefinition {
  public String name;
  public String type;
  public String visibility;
  
  public VariableDefinition(String name,String type,String visibility) {
	  this.name = name;
	  this.type = type;
	  this.visibility = visibility;
  }
  public VariableDefinition() {
	  super();
  }
}
