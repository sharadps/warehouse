package com.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;

	@RequestMapping("/reg")
	public String showUser(ModelMap map) {
		map.addAttribute("user", new User());
		return "UserRegistration";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user, ModelMap map) {

		service.saveUser(user);
		String msg = "User saved succesfully...";
		map.addAttribute("message", msg);
		// clear the form after data inserted
		map.addAttribute("user", new User());
		return "UserRegistration";
	}

	@RequestMapping("/all")
	public String allUser(ModelMap map) {

		List<User> list = service.getAllUser();
		map.addAttribute("list", list);
		return "UserData";
	}

}
