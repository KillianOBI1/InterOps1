package com.ex5.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ex5.tools.DOMParser;
import com.ex5.variable.Programme;

class TestDom {

	@Test
	void test() {
		Programme program = DOMParser.readXml();
		assertTrue(true);
	}

}
