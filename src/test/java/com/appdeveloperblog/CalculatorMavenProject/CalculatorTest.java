package com.appdeveloperblog.CalculatorMavenProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class CalculatorTest {
	Calculator calculator = new Calculator();

	@Test
	public void integerDivison() {
		int result = calculator.integerDivision(4,2);
		assertEquals(2, result,"4/2 didnot produced 2");
	}
	
	@Test
	public void integerSubstraction() {
		int result = calculator.integerSubstraction(3, 5);
		assertEquals(2,result,"5-3 didnot produced 2");
	}
}
