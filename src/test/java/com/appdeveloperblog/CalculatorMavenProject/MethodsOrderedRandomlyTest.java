package com.appdeveloperblog.CalculatorMavenProject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.Random.class)
public class MethodsOrderedRandomlyTest {
	@Test
	void testA() {
		System.out.println("Running Test A");
	}

	@Test
	void testB() {
		System.out.println("Running Test B");
	}
	
	@Test
	void testC() {
		System.out.println("Running Test C");
	}
	
	@Test
	void testD(){
		System.out.println("Running Test D");
	}
}
