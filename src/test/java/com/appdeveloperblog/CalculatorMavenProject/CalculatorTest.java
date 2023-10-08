package com.appdeveloperblog.CalculatorMavenProject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void integerDivison() {
		Calculator calculator = new Calculator();
		int result = calculator.integerDivision(4,2);
		assertEquals(2, result);
	}
}
