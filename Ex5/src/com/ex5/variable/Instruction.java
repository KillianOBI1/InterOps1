package com.ex5.variable;

public class Instruction extends Element {
  protected String instruction;
  
  public Instruction() {
	  super();
  }

  public String getInstruction() {
    return instruction;
  }

  public void setInstruction(String instruction) {
    this.instruction = instruction;
  }
}
