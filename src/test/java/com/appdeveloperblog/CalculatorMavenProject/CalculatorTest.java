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
		int value1=5;
		int value2=3;
		int expectedResult=2;
		int result = calculator.integerSubstraction(value1,value2);
		assertEquals(expectedResult,result,value1+ "-" + value2+"did not produced" + expectedResult);
	}
}
