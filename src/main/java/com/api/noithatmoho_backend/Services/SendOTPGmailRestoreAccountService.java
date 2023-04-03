package com.api.noithatmoho_backend.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.api.noithatmoho_backend.Repository.RestoreByMailRepository;

@Service
public class SendOTPGmailRestoreAccountService {
	@Value("${spring.mail.host}")
	private String springMailHost;

	@Value("${spring.mail.port}")
	private String springMailPort;
	
	@Value("${spring.mail.username}")
	private String springMailUsername;

	@Value("${spring.mail.password}")
	private String springMailPassword;


	@Autowired
	private JavaMailSender mailSender;
	private RestoreByMailRepository restoreByMailRepository; 

	public void sendOTPEmail(String toEmail, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(springMailUsername);
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		mailSender.send(message);
	}


}
