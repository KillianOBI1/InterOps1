package com.ex5.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ex5.model.binaire.MultExpression;
import com.ex5.model.binaire.PlusExpression;
import com.ex5.model.unaire.IntExpression;

class TestComute {

	@Test
	void test() {
		IntExpression alpha = new IntExpression();
		IntExpression bravo = new IntExpression();
		alpha.setInt(1);
		bravo.setInt(2);
	    MultExpression charlie = new MultExpression();
	    MultExpression delta = new MultExpression();
	    charlie.opLeft = alpha;
	    charlie.opRight = bravo;
	    System.out.println(charlie.compute(alpha, bravo).getInt());
	    IntExpression echo = new IntExpression();
	    echo.setInt(2);
	    System.out.println(delta.compute(charlie, echo).getInt());
	    
	}
	
	@Test
	void test1() {
	  
	}

}
