package com.app.service;

import java.util.List;

import com.app.model.User;

public interface IUserService {
	public void saveUser(User user);

	User findByEmail(String userEmail);
	
	public List<User> getAllUser();
}
