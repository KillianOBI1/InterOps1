package com.ex5.model;

import com.ex5.model.unaire.IntExpression;
import com.ex5.visitor.Visitable;

public abstract class Expression implements Visitable {
  abstract public IntExpression getValue();
}
