package com.TDD.estore.service;

import java.util.UUID;

import com.TDD.estore.model.User;
import com.TDDMockito.estore.data.UserRepositoryImpl;
import com.TDDMockito.estore.data.UserRepository;

public class UserServiceImpl implements UserService {
	
	 UserRepository  userRepository;
	 EmailNotificationService emailNotificationService;

	public UserServiceImpl(UserRepository userRepository, EmailNotificationService emailNotificationService) {
		super();
		this.userRepository = userRepository;
		this.emailNotificationService= emailNotificationService;
	}



	@Override
	public User createUser(String firstName,
			String lastName,
			String email,
			String password,
			String repeatPassword) {
		
		if(firstName == null || firstName.trim().length() == 0) {
			throw new IllegalArgumentException("User firstname is empty");
		}
		
		if(lastName == null || lastName.trim().length() == 0) {
			throw new IllegalArgumentException("User lastName is empty");
		}
		  User user = new User(firstName,lastName,email,UUID.randomUUID().toString());
		  
		  boolean isUserCreated = false;
		  try {
			  isUserCreated= userRepository.save(user);
		  }catch(RuntimeException ex) {
			 throw new UserServiceException(ex.getMessage()); 
		  }
		  
		  if(!isUserCreated) throw new UserServiceException("could not create user");
		  try {
			  emailNotificationService.scheduleEmailConfirmation(user); 
		  }catch(RuntimeException ex) {
			  throw new UserServiceException(ex.getMessage()); 
		  }
		  
		return user;
		
	}
}
