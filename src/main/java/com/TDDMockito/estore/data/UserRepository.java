package com.TDDMockito.estore.data;

import com.TDD.estore.model.User;

public interface UserRepository {

	boolean save(User user);
}
