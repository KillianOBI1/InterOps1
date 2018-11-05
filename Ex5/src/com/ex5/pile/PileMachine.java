package com.ex5.pile;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.ex5.model.Expression;
import com.ex5.model.binaire.MultExpression;
import com.ex5.model.unaire.ExpressionUnaire;
import com.ex5.variable.VariableDefinition;

public class PileMachine {
  Stack<Expression> pile;
  Map<VariableDefinition,ExpressionUnaire> assoc;
  
  public PileMachine() {
	  pile = new Stack<Expression>();
	  this.assoc = new HashMap<VariableDefinition,ExpressionUnaire>();
  }
  
  public void addMultToPile(MultExpression mExpr) {
	  pile.push(mExpr.opLeft);
	  pile.push(mExpr.opRight);
  }
  
  public MultExpression getMultToPile() {
	  MultExpression mExpr = new MultExpression();
	  mExpr.opRight = pile.pop();
	  mExpr.opLeft = pile.pop();
	  return mExpr;
  }
  
}
