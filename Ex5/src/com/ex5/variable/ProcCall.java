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
  
  public void addArgs(Expression e) {
    this.args.add(e);
  }
  
  public List<Expression> getArgs() {
    return this.args;
  }
  
  public void setArgs(List<Expression> args) {
    this.args = args;
  }
}
