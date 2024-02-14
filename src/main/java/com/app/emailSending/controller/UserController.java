package com.app.emailSending.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.emailSending.entity.User;
import com.app.emailSending.service.EmailService;
import com.app.emailSending.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private EmailService emailService;

	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		// Save user in the database
		User savedUser = userService.saveUser(user);

		// Send welcome email with username and password
		if (savedUser != null) {
			String username = savedUser.getUsername();
			String password = savedUser.getPassword();
			emailService.sendWelcomeEmail(savedUser.getEmail(), username, password);
			return "User registered successfully and welcome email sent.";
		} else {
			return "Failed to register user.";
		}
	}
}
