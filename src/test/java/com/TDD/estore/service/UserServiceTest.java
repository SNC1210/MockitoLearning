package com.TDD.estore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.TDD.estore.model.User;
import com.TDDMockito.estore.data.UserRepository;

public class UserServiceTest {
	
	@ExtendWith(MockitoExtension.class)
	
	@InjectMocks
	UserServiceImpl userService; 
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	EmailNotificationService emailNotificationService;
	
    String firstName;
    String lastName;
    String email;
    String password;
    String repeatPassword;
	
	
	@BeforeEach
	void init() { 
	     firstName="AADI";
	     lastName="Annant";
	     email="annand.com";
	     password="1234567";
	     repeatPassword ="1234567";
	}
	

	@Test
	@DisplayName("User Object Created")
	void testCreateUser_WhenUserDetailsIsProvided_returnUserObject() {
		//Arrange
		when(userRepository.save(any(User.class))).thenReturn(true);
	     
		//Act
		 User user= userService.createUser(firstName,lastName,email,password,repeatPassword);
		
		//Assert
		 assertNotNull(user, "The createUser() method should not have returned null");
	     assertEquals(firstName, user.getFirstName(),"User firstname is not same");
	     assertEquals(lastName, user.getLastName(),"user last name is incorrect");
	     assertEquals(email,user.getEmail(),"user email is incorrect");
	     assertNotNull(user.getId(),"user id is missing");
	     //Mockito.verify(userRepository,times(1)).save(any(User.class));
	     Mockito.verify(userRepository).save(any(User.class));  
	     
	     
	}
	
	@DisplayName("Empty first name causes correct exception")
	@Test
	void testCreateUser_WhenFirstNameIsEmpty_throwsIllegalArgumentException() {
		//Arrange
	     String firstName="";
	     String lastName="";
	     String expectedExceptionMessage = "User firstname is empty";
	     //Act and Assert
		 IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			 userService.createUser(firstName, lastName, email, password, repeatPassword);
		 },"Empty First name should cause an illegal argument exception"); 
	     
		//Assert
		 assertEquals(expectedExceptionMessage,thrown.getMessage(),"User firstname is not null");
		
	}
	
	@DisplayName("Empty last name causes correct exception")
	@Test
	void testCreateUser_WhenLastNameIsEmpty_throwsIllegalArgumentException() {
		//Arrange
	     String lastName="";
	     String expectedExceptionMessage = "User lastName is empty";
	     //Act and Assert
		 IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			 userService.createUser(firstName, lastName, email, password, repeatPassword);
		 },"Empty First name should cause an illegal argument exception"); 
	     
		//Assert
		 assertEquals(expectedExceptionMessage,thrown.getMessage(),"User lastname is not null");
		
	}
	
	@DisplayName("If Save Method Cause RuntimeException , a UserException is thrown")
	@Test
	void testCreateUser_WhenSaveMethodThrowsexception_thenThrowsUserSericeexception() {
		//Arrange
		when(userRepository.save(any(User.class))).thenThrow(RuntimeException.class);
		
		//Act and assert
		 assertThrows(UserServiceException.class, ()-> {
			 userService.createUser(firstName, lastName, email, password, repeatPassword);
		 },"should have thrown UsererviceException instead");
		
		//Assert
	}
	
	@DisplayName("EmailNotificatioNException is handled")
	@Test
	void testCreateUser_whenEmailNotificationExceptioThrown_throwsUserServiceException() {
		//Arrange
		   when(userRepository.save(any(User.class))).thenReturn(true);
		   
		   //below code is not complied so here we use doThrow().when()
		   //when(emailNotificationService.scheduleEmailConfirmation(any(User.class))).thenThrow();
		
		    doThrow(EmailNotificationServiceException.class)
		    	   .when(emailNotificationService)
		    	   .scheduleEmailConfirmation(any(User.class));
		    //this doNothing will make sure to stop the method
//		    doNothing().when(emailNotificationService)
//		               .scheduleEmailConfirmation(any(User.class));
		//Act and assert
		    assertThrows(UserServiceException.class, ()-> {
				 userService.createUser(firstName, lastName, email, password, repeatPassword);
			 },"should have thrown UsererviceException instead");
			
		//Assert
		    verify(emailNotificationService,times(1))
		          .scheduleEmailConfirmation(any(User.class));
	}
}
