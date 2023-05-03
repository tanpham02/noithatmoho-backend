package com.api.noithatmoho_backend.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class SendOTPGmailAccountService {

	@Value("${spring.mail.username}")
	private String springMailUsername;

	@Autowired
	private JavaMailSender mailSender;

	public void sendOTPEmail(String toEmail, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(springMailUsername);
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		mailSender.send(message);
	}
}



