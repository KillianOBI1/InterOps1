package com.ex5.model.unaire;

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

}
