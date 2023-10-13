package com.TDD.estore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.TDD.estore.model.User;

public class UserServiceTest {

	@Test
	void testCreateUser_WhenUserDetailsIsProvided_returnUserObject() {
		//Arrange
	     UserService userService = new UserServiceImpl(); 
	     String firstName="AADI";
	     String lastName="Annant";
	     String email="annand.com";
	     String password="1234567";
	     String repeatPassword ="1234567";
	     
		//Act
		 User user= userService.createUser(firstName,lastName,email,password,repeatPassword);
		
		//Assert
		 assertNotNull(user, "The createUser() method should not have returned null");
	}
	
	@Test
	void testCreateUser_WhenUserCreated_returnedUserObjectContainsSameFirstName() {
		//Arrange
		UserService userService = new UserServiceImpl(); 
	     String firstName="AADI";
	     String lastName="Annant";
	     String email="annand.com";
	     String password="1234567";
	     String repeatPassword ="1234567";
	     
		
		//Act
	     User user= userService.createUser(firstName,lastName,email,password,repeatPassword);
			
		//Assert
	     assertEquals(firstName, user.getFirstName(),"User firstname is not same");
	}
}
