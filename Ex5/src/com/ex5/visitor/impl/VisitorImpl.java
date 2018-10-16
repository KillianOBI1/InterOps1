package com.ex5.visitor.impl;

import com.ex5.model.binaire.MultExpression;
import com.ex5.model.binaire.PlusExpression;
import com.ex5.model.unaire.IntExpression;
import com.ex5.visitor.Visitor;

public class VisitorImpl implements Visitor {
    protected String result;
    
    public VisitorImpl() {
    	
    }
    
	@Override
	public void visitInt(IntExpression e) {
		this.result = e.getInt()+"";
		System.out.println(e.getInt());
	}

	@Override
	public void visitMult(MultExpression e) {
		this.result = (((IntExpression) e.opLeft).getInt() * ((IntExpression) e.opRight).getInt())+"";
		System.out.println(e.toString());	
	}

	@Override
	public void visitPlus(PlusExpression e) {
		this.result = (((IntExpression) e.opLeft).getInt() + ((IntExpression) e.opRight).getInt())+"";
		System.out.println(e.toString());
	}
	
	public String result() {
		return this.result;
	}

}
