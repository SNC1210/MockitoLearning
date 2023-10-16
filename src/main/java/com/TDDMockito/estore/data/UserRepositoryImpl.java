package com.TDDMockito.estore.data;

import java.util.HashMap;
import java.util.Map;

import com.TDD.estore.model.User;

public class UserRepositoryImpl implements UserRepository {
	
	Map<String,User> users = new HashMap();

	@Override
	public boolean save(User user) {
		boolean returnValue = false;
		// TODO Auto-generated method stub
		if(!users.containsKey(user.getId())) {
			users.put(user.getId(),user);
			returnValue = true;
		}
		return returnValue;
	}

}
