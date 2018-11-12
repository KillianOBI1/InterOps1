package com.ex5.variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.ex5.model.Expression;
import com.ex5.model.binaire.MultExpression;
import com.ex5.model.binaire.PlusExpression;
import com.ex5.model.unaire.ExpressionUnaire;
import com.ex5.visitor.impl.VisitorImpl;

public class Machine extends VisitorImpl {
	
	Stack<Expression> pile;
	Map<VariableDefinition,ExpressionUnaire> association;
	List<VariableDefinition> definitions;

	public Machine() {
		this.pile = new Stack<Expression>();
		this.association = new HashMap<VariableDefinition,ExpressionUnaire>();
		this.definitions = new ArrayList<VariableDefinition>();
	}
	
	public void addMultToPile(MultExpression mExpr) {
		pile.push(mExpr.opLeft);
		pile.push(mExpr.opRight);
	}
	
	public void addPlusToPile(PlusExpression pExpr) {
		pile.push(pExpr.opLeft);
		pile.push(pExpr.opRight);
	}
	
	public void addAssociation(VariableDefinition key,ExpressionUnaire value) {
		this.association.put(key, value);
		
	}
	
	public void addExprToPile(Expression expression) {
	  pile.push(expression);
	}
	
	public void addToListDef(VariableDefinition variableDefinition) {
	  this.definitions.add(variableDefinition);
	}
	
	public VariableDefinition getDefFromList(String name) {
	  for(VariableDefinition var : this.definitions) {
	    if(var.name.equals(name)) {
	      return var;
	    }
	  }
	  return null;
	}
	
	public void revertPile() {
	  Stack<Expression> tmp = new Stack<Expression>();
	  while(!this.pile.empty()) {
	    tmp.push(this.pile.pop());
   }
	  this.pile = tmp;
	}
	
	public void popAll() {
	  Expression last;
	  while(!this.pile.empty()) {
	      Expression expr = this.pile.pop();
	      expr.accept(this);
	  }
	}
	
}
