package com.ex5.model.unaire;

import com.ex5.visitor.Visitor;

public class IntExpression extends ExpressionUnaire {
    int value;
	
	public IntExpression() {
		super();
	}

	public int getInt() {
		return this.value;
	}

	public void setInt(int value) {
      this.value = value;
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
