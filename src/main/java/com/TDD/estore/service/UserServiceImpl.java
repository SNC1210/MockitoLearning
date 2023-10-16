package com.TDD.estore.service;

import java.util.UUID;

import com.TDD.estore.model.User;
import com.TDDMockito.estore.data.UserRepositoryImpl;
import com.TDDMockito.estore.data.UserRepository;

public class UserServiceImpl implements UserService {
	
	 UserRepository  userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
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
		  
		  boolean isUserCreated = userRepository.save(user);
		  if(!isUserCreated) throw new UserServiceException("could not create user");
		return user;
		
	}
}
