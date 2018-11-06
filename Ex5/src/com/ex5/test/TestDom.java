package com.ex5.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ex5.tools.DOMParser;

class TestDom {

	@Test
	void test() {
		DOMParser.readXml();
		assertTrue(true);
	}

}
