package com.ex5.visitor.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ex5.model.binaire.MultExpression;
import com.ex5.model.unaire.IntExpression;
import com.ex5.visitor.Visitor;
import com.ex5.visitor.impl.VisitorImpl;

class TestVisitor {

	@Test
	void test1() {
		IntExpression e = new IntExpression();
		e.setInt(5);
		Visitor pp = new VisitorImpl();
		e.accept(pp);
		assertTrue(pp.result().equals("5"));
	}
	
	@Test
	void test2() {
		MultExpression e = new MultExpression();
		IntExpression left = new IntExpression();
		IntExpression right = new IntExpression();
		left.setInt(5);
		right.setInt(3);
		e.opLeft = left;
		e.opRight = right;
		Visitor pp = new VisitorImpl();
		e.accept(pp);
		assertTrue(pp.result().equals("15"));
		
	}

}
