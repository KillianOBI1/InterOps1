package com.ex5.pile;

import java.util.Stack;

import com.ex5.model.Expression;
import com.ex5.model.binaire.MultExpression;

public class PileMachine {
  Stack<Expression> pile;
  
  public PileMachine() {
	  pile = new Stack<Expression>();
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
