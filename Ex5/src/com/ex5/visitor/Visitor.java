package com.ex5.visitor;

import com.ex5.model.binaire.MultExpression;
import com.ex5.model.binaire.PlusExpression;
import com.ex5.model.unaire.IntExpression;
import com.ex5.model.unaire.RealExpression;
import com.ex5.model.unaire.StringExpression;

public interface Visitor {
  public void visitInt(IntExpression e);
  public void visitReal(RealExpression e);
  public void visitString(StringExpression e);
  public void visitMult(MultExpression e);
  public void visitPlus(PlusExpression e);
  public String result();
}
