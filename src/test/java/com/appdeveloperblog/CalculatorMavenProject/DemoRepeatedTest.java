package com.appdeveloperblog.CalculatorMavenProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;


public class DemoRepeatedTest {
	Calculator calculator;
	

	@BeforeEach
	void beforeEachTestMethod() {
		calculator = new Calculator();
	  System.out.println("Executing @BeforeEach method");
	}
	

	//@Disabled("TODO: Still Need to work on it")
		@DisplayName("Division By Zero")
	    @RepeatedTest(value=3, name="{displayName}.Repetition {currentRepetition} of " + "{totalRepetitions}")
	    public void testIntegerDivison_WhenDividendIsDivisbleByZero_ShouldThroughArithmeticException(
	    		RepetitionInfo repetitionInfo,
	    		TestInfo testInfo) {
			System.out.println("Test Division By Zero");
			System.out.println("Running" + testInfo.getTestMethod().get().getName());
			System.out.println("Repetion number" +repetitionInfo.getCurrentRepetition()+"of" +repetitionInfo.getTotalRepetitions());
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

}
