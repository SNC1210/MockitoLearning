package com.appdeveloperblog.CalculatorMavenProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Math OPeration in Calculator class")
public class CalculatorTest {
	Calculator calculator = new Calculator();
	
	//test<System under test>_<Condition or state change>_<Expected Result>

	@DisplayName("Test 4/2 =2")
	@Test
	public void testIntegerDivison_WhenFourIsDivisbleByTwo_ShouldReturnTwo() {
		int result = calculator.integerDivision(4,2);
		assertEquals(2, result,"4/2 didnot produced 2");
	}
	
	@DisplayName("Division By Zero")
    @Test
    public void testIntegerDivison_WhenDividendIsDivisbleByZero_ShouldThroughArithmeticException() {
		fail("Not Implemented Yet");
    }
    
	@DisplayName("Test 5 -3 =2")
	@Test
	public void integerSubstraction() {
		int value1=5;
		int value2=3;
		int expectedResult=2;
		int result = calculator.integerSubstraction(value1,value2);
		assertEquals(expectedResult,result,()-> value1+ "-" + value2+"did not produced" + expectedResult);
	}
	
	@Test
	public void integerAddition() {
		int result= calculator.integerAddition(2, 5);
		assertEquals(7, result,"2 + 5 didn't produced 7");	
	}
}
