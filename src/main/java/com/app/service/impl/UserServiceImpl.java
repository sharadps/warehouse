package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.model.User;
import com.app.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Transactional
	public void saveUser(User user) {
		user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
		dao.saveUser(user);
	}

	@Transactional(readOnly = true)
	public User findByEmail(String userEmail) {
		return dao.findByEmail(userEmail);
	}

	@Override
	public List<User> getAllUser() {
		return dao.getAllUser();
	}

}
