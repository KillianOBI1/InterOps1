package com.ex5.model.unaire;

import com.ex5.visitor.Visitor;

public class IntExpression extends ExpressionUnaire {
    int value;
	
	public IntExpression() {
		super();
	}
	@Override
	public int getInt() {
		return this.value;
	}

	@Override
	public void setInt(int value) {
      this.value = value;
	}
	@Override
	public IntExpression getValue() {
		return this;
	}

	@Override
	public void accept(Visitor v) {
		v.visitInt(this);
	}
	@Override
	public String toString() {
		return "IntExpression [value=" + value + "]";
	}

}
