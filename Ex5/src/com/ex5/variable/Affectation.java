package com.ex5.variable;

import com.ex5.model.Expression;

public class Affectation extends Instruction {
  protected Expression expression;
  protected VariableReference variableReference;
  
  public Affectation() {
	  super();
  }

  public Expression getExpression() {
    return expression;
  }

  public void setExpression(Expression expression) {
    this.expression = expression;
  }

  public VariableReference getVariableReference() {
    return variableReference;
  }

  public void setVariableReference(VariableReference variableReference) {
    this.variableReference = variableReference;
  }
  
  @Override
  public String toString() {
    return variableReference.toString()+" := "+expression.toString(); 
  }
  
}
