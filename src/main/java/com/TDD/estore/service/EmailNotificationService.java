package com.TDD.estore.service;

import com.TDD.estore.model.User;

public interface EmailNotificationService {

	void scheduleEmailConfirmation(User user);
}
