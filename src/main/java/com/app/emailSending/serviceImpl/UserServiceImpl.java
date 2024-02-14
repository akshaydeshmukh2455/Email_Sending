package com.app.emailSending.serviceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.emailSending.entity.User;
import com.app.emailSending.repository.UserRepository;
import com.app.emailSending.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		// Generate password
		String password = generatePassword();
		user.setPassword(password);

		// Save user in the database
		return userRepository.save(user);
	}

	private String generatePassword() {
		// Generate a random password using UUID
		return UUID.randomUUID().toString().substring(0, 8); // Use first 8 characters as the password
	}
}
