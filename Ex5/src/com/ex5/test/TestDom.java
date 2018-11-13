package com.ex5.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ex5.tools.DOMParser;
import com.ex5.variable.Programme;
import com.ex5.visitor.Visitor;
import com.ex5.visitor.impl.VisitorImpl;

class TestDom {

	@Test
	void test() {
		Programme program = DOMParser.readXml();
		Visitor v = new VisitorImpl();
    program.accept(v);
		assertTrue(true);
	}

}
