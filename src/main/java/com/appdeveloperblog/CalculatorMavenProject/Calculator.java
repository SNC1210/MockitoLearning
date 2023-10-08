package com.appdeveloperblog.CalculatorMavenProject;

public class Calculator {
	public int integerDivision(int dividend , int divisor) {
		return dividend/divisor;
	}
	
	public int integerSubstraction(int value1 , int value2) {
		int result = 0;
		if(value1 > value2) {
		   result=(value1-value2);
		}
		if(value1 < value2) {
		   result=(value2-value1);
		}
		return result;
	}
}
