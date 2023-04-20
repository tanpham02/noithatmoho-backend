package com.api.noithatmoho_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.api.noithatmoho_backend.Model.UsersModel;
import com.api.noithatmoho_backend.Repository.RestoreByMailRepository;
import com.api.noithatmoho_backend.Repository.UsersRepository;
import com.api.noithatmoho_backend.Services.SendOTPGmailRestoreAccountService;
import com.api.noithatmoho_backend.Services.UsersService;

import jakarta.mail.MessagingException;

import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping
public class SendOTPGmailRestoreAccountController {

	@Autowired
	private SendOTPGmailRestoreAccountService sendOTPGmailRestoreAccountService;
	
	@PostMapping("/api/sendOTPRestoreAccountByMail")
	public String SenderOTPMail(@RequestBody String email ) throws JsonMappingException, JsonProcessingException {
		
		String parseJson = email;
		ObjectMapper objectMapper = new ObjectMapper();
		String emailString = objectMapper.readTree(parseJson).get("email").asText();
		
		String otp = String.format("%06d", new Random().nextInt(999999));
		sendOTPGmailRestoreAccountService.sendOTPEmail(emailString, "OTP Khôi Phục Tài Khoản",
				"OTP khôi phục tài khoản của bạn là " + otp + ". Vui lòng không chia sẻ mã này cho bất kì ai!" );
		
		return otp;
	}

}
