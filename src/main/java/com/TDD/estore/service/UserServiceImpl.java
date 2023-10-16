package com.TDD.estore.service;

import java.util.UUID;

import com.TDD.estore.model.User;

public class UserServiceImpl implements UserService {

	@Override
	public User createUser(String firstName,
			String lastName,
			String email,
			String password,
			String repeatPassword) {
		
		return new User(firstName,lastName,email,UUID.randomUUID().toString());
		
	}
}
