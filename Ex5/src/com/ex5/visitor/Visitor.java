package com.ex5.visitor;

import com.ex5.model.Expression;
import com.ex5.model.binaire.MultExpression;
import com.ex5.model.binaire.PlusExpression;
import com.ex5.model.unaire.IntExpression;

public interface Visitor {
  public void visitInt(IntExpression e);
  public void visitMult(MultExpression e);
  public void visitPlus(PlusExpression e);
  public String result();
}
