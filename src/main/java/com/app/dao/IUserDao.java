package com.app.dao;

import java.util.List;

import com.app.model.User;

public interface IUserDao {
	public void saveUser(User user);
	
	public List<User> getAllUser();
	
	User findByEmail(String userName);
}
