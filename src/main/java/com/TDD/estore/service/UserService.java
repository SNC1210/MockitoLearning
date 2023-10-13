package com.TDD.estore.service;

import com.TDD.estore.model.User;

public interface UserService {

	User createUser(String firstName,
					String lastName,
					String email,
					String password,
					String repeatPassword);
	
}
