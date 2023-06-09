package com.api.noithatmoho_backend.Controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.noithatmoho_backend.Model.UsersModel;
import com.api.noithatmoho_backend.Repository.UsersRepository;
import com.api.noithatmoho_backend.Services.TwilioService;
import com.api.noithatmoho_backend.Services.UsersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class SendOTPRegisterbyPhoneController {
	@Autowired
	private TwilioService twilioService;

	@Autowired
	private UsersService usersService;

	@PostMapping("/send-otp-sms")
	public String sendSms(@RequestBody String phone_number, UsersModel usersModel)
			throws JsonMappingException, JsonProcessingException {
		String parseJson = phone_number;
		ObjectMapper objectMapper = new ObjectMapper();
		String stringPhoneNumber = objectMapper.readTree(parseJson).get("phone_number").asText();

		String otp = String.format("%06d", new Random().nextInt(999999));
		twilioService.sendSms(stringPhoneNumber,
				"OTP xác thực tài khoản của bạn là " + otp + ". Vui lòng không chia sẻ mã này cho bất kì ai!");

		usersModel.setPhone_number("0" + stringPhoneNumber.substring(3));
		usersModel.setOtp(otp);
		usersService.createUser(usersModel);

		return stringPhoneNumber;
	}
}



