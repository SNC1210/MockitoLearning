package com.appdeveloperblog.CalculatorMavenProject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderedByOrderIndex {
	
	StringBuilder completed = new StringBuilder(""); 
	
	@AfterEach
	void aftereach() {
		System.out.println("The State of completed object is:" + completed);
	}
	
	@Order(1)
	@Test
	void testA() {
		System.out.println("Running Test A");
		completed.append("1");
	}

	@Order(3)
	@Test
	void testB() {
		System.out.println("Running Test B");
		completed.append("3");
	}
	
	@Order(2)
	@Test
	void testD(){
		System.out.println("Running Test D");
		completed.append("2");
	}
	
	@Order(4)
	@Test
	void testC() {
		System.out.println("Running Test C");
		completed.append("4");
	}
}
