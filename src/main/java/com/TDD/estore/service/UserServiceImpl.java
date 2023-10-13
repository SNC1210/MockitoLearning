package com.TDD.estore.service;

import com.TDD.estore.model.User;

public class UserServiceImpl implements UserService {

	@Override
	public User createUser(String firstName,
			String lastName,
			String email,
			String password,
			String repeatPassword) {
		
		return new User();
		
	}
}
