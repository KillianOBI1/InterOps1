package com.ex5.variable;

import com.ex5.model.Expression;

public class Affectation extends Instruction {
  protected Expression expression;
  protected VariableReference variableReference;
  
  public Affectation() {
	  super();
  }
}
