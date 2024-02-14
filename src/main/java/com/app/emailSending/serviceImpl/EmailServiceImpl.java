package com.app.emailSending.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.app.emailSending.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender emailSender;

	public void sendWelcomeEmail(String to, String username, String password) {
		// Compose email message
		String subject = "Welcome to Our Platform!";
		String text = "Dear " + username + ",\n\n" + "Thank you for registering with us!\n\n" + "Your username: "
				+ username + "\n" + "Your password: " + password + "\n\n"
				+ "Please keep your login credentials secure.\n\n" + "Regards,\n" + "Your Platform Team";

		// Send email
		sendSimpleMessage(to, subject, text);
	}

	public void sendSimpleMessage(String to, String subject, String text) {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);
//			helper.addInline("additionalInfo", new ByteArrayResource(additionalInfo.getBytes()));
			emailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			// Handle exception
		}
	}
}
