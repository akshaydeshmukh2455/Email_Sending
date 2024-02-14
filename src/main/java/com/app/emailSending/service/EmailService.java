package com.app.emailSending.service;

public interface EmailService {
	public void sendWelcomeEmail(String to, String username, String password);
}
