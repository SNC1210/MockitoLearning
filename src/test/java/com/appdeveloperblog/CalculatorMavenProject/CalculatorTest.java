package com.appdeveloperblog.CalculatorMavenProject;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Test Math Operation in Calculator class")
public class CalculatorTest {
	
	Calculator calculator;
	
	@BeforeAll
	static void setup() {
		System.out.println("Exceuting @BeforeAll method");
	}
	
	@AfterAll
	static void cleanup() {
		System.out.println("Executing @AfterAll method");
	}
	
	@BeforeEach
	void beforeEachTestMethod() {
		calculator = new Calculator();
	  System.out.println("Executing @BeforeEach method");
	}
	
	@AfterEach
	void afterEachTestMethod() {
		System.out.println("Exceuting @AfterEach Method");
	}
	
	
	//test<System under test>_<Condition or state change>_<Expected Result>

	@DisplayName("Test 4/2 =2")
	@Test
	public void testIntegerDivison_WhenFourIsDivisbleByTwo_ShouldReturnTwo() {
		System.out.println("Test 4/2 = 2");
		//Arrange(Given)
		    int dividend =4;
		    int divisor=2;
		    int expectedResult=2;
		
		//Act(When)
			int actualResult = calculator.integerDivision(dividend,divisor);
		    
		//Assert(Then)
			assertEquals(expectedResult, actualResult,"4/2 didnot produced 2");
	}
	
	//@Disabled("TODO: Still Need to work on it")
	@DisplayName("Division By Zero")
    @Test
    public void testIntegerDivison_WhenDividendIsDivisbleByZero_ShouldThroughArithmeticException() {
		System.out.println("Test Division By Zero");
		//Arrange
		int dividend =4;
		int divisor= 0;
		String ExpectedExceptionMessage="/ by zero";
		
		//Act and assert
		ArithmeticException actaulException = assertThrows(ArithmeticException.class,()->{
			//Act
			calculator.integerDivision(dividend, divisor);
		},"Division by zero should throw an arithmetic exception");
		
		//Assert
		assertEquals(ExpectedExceptionMessage,actaulException.getMessage(),"unexpectedExceptionMessage" );
    }
    
	@DisplayName("Test 5 -3 =2")
	@Test
	public void testIntegerSubstraction_WhenThreeIsSubtractedFromFive_ShouldGivesTwo() {
		System.out.println("Test 5-3 = 2");
		int value1=5;
		int value2=3;
		int expectedResult=2;
		int result = calculator.integerSubstraction(value1,value2);
		assertEquals(expectedResult,result,()-> value1+ "-" + value2+"did not produced" + expectedResult);
	}
	
	@DisplayName("Test Integer Substraction (value1, value2,expectedResult)")
	@ParameterizedTest
	//@MethodSource("integerSubstractionInputParameter") //another way to do the work here we give stream resource same name
	@MethodSource()
	public void integerSubstractionInputParameter(int value1, int value2, int expectedResult) {
		System.out.println("Running Test"+ value1 + "-" + value2+ "="+ expectedResult );
		int result = calculator.integerSubstraction(value1,value2);
		assertEquals(expectedResult,result,()-> value1+ "-" + value2+"did not produced" + expectedResult);
	}
	
	
	@DisplayName("Test 2 + 5 = 7")
	@Test
	public void testIntegerAddition_WhenTwoIsAddedWithFive_ShouldGiveSeven() {
		System.out.println("Test 2 + 5 = 7");
		int result= calculator.integerAddition(2, 5);
		assertEquals(7, result,"2 + 5 didn't produced 7");	
	}
	
	private static Stream<Arguments> integerSubstractionInputParameter() {
		
		return Stream.of(
				    Arguments.of(5,3,2),
				    Arguments.of(33,1,32),
				    Arguments.of(23,3,20)
				);
	}
}
