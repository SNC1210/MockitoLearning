package com.appsdeveloperblog.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.*;

import com.appsdeveloperblog.io.UsersDatabase;
import com.appsdeveloperblog.io.UsersDatabaseMapImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceImplTest {
	
	UsersDatabase usersDatabase;
	UserService userService;
	String createdUserId="";

    @BeforeAll
    void setup() {
        // Create & initialize database
    	usersDatabase = new UsersDatabaseMapImpl();
    	usersDatabase.init();
    	userService = new UserServiceImpl(usersDatabase);
    }

    @AfterAll
    void cleanup() {
        // Close connection
        // Delete database
    	usersDatabase.close();
    }

    @Test
    @Order(1)
    @DisplayName("Create User works")
    void testCreateUser_whenProvidedWithValidDetails_returnsUserId() {
    	
    	//Arrange
    	Map<String,String> user = new HashMap();
    	user.put("firstName", "AADI");
    	user.put("lastName", "AANANT");
    	
    	//ACT
    	 createdUserId = userService.createUser(user);
    	
    	//Assert
    	assertNotNull(createdUserId,"User Id should not be null");
    	

    }


    @Test
    @Order(2)
    @DisplayName("Update user works")
    void testUpdateUser_whenProvidedWithValidDetails_returnsUpdatedUserDetails() {

    	//Arrange
    	Map<String,String> newUserDetails = new HashMap();
    	newUserDetails.put("firstName","john");
    	newUserDetails.put("lastName", "george");
    	
    	//Act
    	Map updatedUserDetails = userService.updateUser(createdUserId,newUserDetails);
    	
    	//Assert
    	assertEquals(newUserDetails.get("firstName"), updatedUserDetails.get("firstName"), "Returned value of user firstname is incorrect");
    	assertEquals(newUserDetails.get("lastName"), updatedUserDetails.get("lastName"), "Returned value of user lastname is incorrect");
    	
    }

    @Test
    @Order(3)
    @DisplayName("Find user works")
    void testGetUserDetails_whenProvidedWithValidUserId_returnsUserDetails() {
    	//ACT
    	Map userDetails = userService.getUserDetails(createdUserId);
    	
    	//Assert
    	assertNotNull(userDetails,"User Details should not be null");
    	assertEquals(createdUserId,userDetails.get("userId"),"Returns userdetails contains incorrect userid");
    	
    }

    @Test
    @Order(4)
    @DisplayName("Delete user works")
    void testDeleteUser_whenProvidedWithValidUserId_returnsUserDetails() {

    	//Act
    	userService.deleteUser(createdUserId);
    	
    	//Assert
    	assertNull(userService.getUserDetails(createdUserId),"users should not be found");
    }

}
