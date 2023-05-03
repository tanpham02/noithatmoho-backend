package com.api.noithatmoho_backend.Controller;

import java.util.Optional;
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
public class SendOTPRestorebyPhoneController {
	@Autowired
	private TwilioService twilioService;

	@Autowired
	private UsersService usersService;

	@Autowired
	private UsersRepository usersRepository;

	@PostMapping("/send-otp-sms-reset")
	public String  sendSms(@RequestBody String userInfo, UsersModel usersModel)
			throws JsonMappingException, JsonProcessingException {
		String parseJson = userInfo;
		ObjectMapper objectMapper = new ObjectMapper();
		String stringPhoneNumber = objectMapper.readTree(parseJson).get("phone_number").asText();
		int id = objectMapper.readTree(parseJson).get("id").asInt();

		String otp = String.format("%06d", new Random().nextInt(999999));
		twilioService.sendSms(stringPhoneNumber,
				"OTP khôi phục tài khoản của bạn là " + otp + ". Vui lòng không chia sẻ mã này cho bất kì ai!");
	
		Optional<UsersModel> findId = usersRepository.findById(id);
		UsersModel user = findId.get();

		user.setOtp(otp);
		usersRepository.save(user);

		return stringPhoneNumber;	
	}
}
