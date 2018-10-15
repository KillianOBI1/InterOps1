package com.ex5.model.binaire;

import com.ex5.model.Expression;
import com.ex5.model.unaire.IntExpression;

public abstract class ExpressionBinaire extends Expression {
  public Expression opLeft;
  public Expression opRight;
  abstract public IntExpression compute(Expression opLeft,Expression opRight);
}
