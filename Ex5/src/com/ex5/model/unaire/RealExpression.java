package com.ex5.model.unaire;

import com.ex5.visitor.Visitor;

public class RealExpression extends ExpressionUnaire {
	float value;
	
	public RealExpression() {
		super();
	}

	public float getFloat() {
		return this.value;
	}

	public void setFloat(float value) {
      this.value = value;
	}

	@Override
	public void accept(Visitor v) {
		v.visitReal(this);
	}

	@Override
	public String toString() {
		return "RealExpression [value=" + value + "]";
	}

}
