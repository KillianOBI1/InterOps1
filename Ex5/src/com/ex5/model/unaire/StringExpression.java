package com.ex5.model.unaire;

import com.ex5.visitor.Visitor;

public class StringExpression extends ExpressionUnaire {
	String value;
	
	public StringExpression() {
		super();
	}

	public String getString() {
		return this.value;
	}

	public void setString(String value) {
      this.value = value;
	}

	@Override
	public void accept(Visitor v) {
		v.visitString(this);
	}

	@Override
	public String toString() {
		return "StringExpression [value=" + value + "]";
	}

}
