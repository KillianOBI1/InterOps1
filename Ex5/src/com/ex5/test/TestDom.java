package com.ex5.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ex5.tools.DOMParser;
import com.ex5.variable.Machine;
import com.ex5.variable.Programme;
import com.ex5.visitor.Visitor;
import com.ex5.visitor.impl.VisitorImpl;

class TestDom {
  Programme programme;
	@Test
	void test() {
		this.programme = DOMParser.readXml();
		Visitor v = new VisitorImpl();
		this.programme.accept(v);
		assertTrue(true);
	}
	
	@Test
	void testCompute() {
	  this.programme = DOMParser.readXml();
    Visitor v = new VisitorImpl();
    this.programme.accept(v);
    assertTrue(true);
    Machine machine = new Machine();
    machine.initMachine(programme);
    machine.pushList(this.programme.getElements());
    machine.computePile();
	}
	
	

}
