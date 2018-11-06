package com.ex5.factory.impl;

import org.w3c.dom.Element;

import com.ex5.variable.VariableDefinition;

public class VariableDefintionFactoryImpl {

  public static VariableDefinition createVariableDefinition(Element e) {
    VariableDefinition variableDefinition = new VariableDefinition();
    variableDefinition.setName(e.getAttribute("name"));
    variableDefinition.setVisibility(e.getAttribute("visibility"));
    variableDefinition.setType(e.getAttribute("type"));
    return variableDefinition;
  }

}
