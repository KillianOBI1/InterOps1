package com.ex5.variable;

import java.util.ArrayList;
import java.util.List;

import com.ex5.model.Expression;

public class ProcCall extends Instruction{
  protected List<Expression> args;
  public ProcCall()  {
	  super();
	  this.args = new ArrayList<Expression>();
  }
}
