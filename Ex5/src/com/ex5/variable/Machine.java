package com.ex5.variable;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.ex5.model.Expression;
import com.ex5.model.unaire.ExpressionUnaire;
import com.ex5.visitor.impl.VisitorImpl;

public class Machine extends VisitorImpl {
	
	Stack<Expression> pile;
	Map<VariableDefinition,ExpressionUnaire> association;

	public Machine() {
		this.pile = new Stack<Expression>();
		this.association = new HashMap<VariableDefinition,ExpressionUnaire>();
	}

}
