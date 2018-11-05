package com.ex5.variable;

import java.util.HashMap;
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

	public Machine() {
		this.pile = new Stack<Expression>();
		this.association = new HashMap<VariableDefinition,ExpressionUnaire>();
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
	
	public void addPlusToPile(PlusExpression pExpr) {
		pile.push(pExpr.opLeft);
		pile.push(pExpr.opRight);
	}

	public PlusExpression getPlusToPile() {
		PlusExpression pExpr = new PlusExpression();
		pExpr.opRight = pile.pop();
		pExpr.opLeft = pile.pop();
		return pExpr;
	}

}
