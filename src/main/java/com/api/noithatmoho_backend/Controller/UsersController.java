package com.api.noithatmoho_backend.Controller;


import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.noithatmoho_backend.Model.UsersModel;
import com.api.noithatmoho_backend.Services.SendOTPGmailAccountService;
import com.api.noithatmoho_backend.Services.UsersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@RestController
@RequestMapping("/api/users")
//@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {

	@Autowired
	UsersService userService;
	private SendOTPGmailAccountService sendOTPGmailAccountService;

	@Autowired
	private JavaMailSender emailSender;

	@PostMapping
	public UsersModel createUser(@RequestBody UsersModel user) throws MessagingException {
		MimeMessage mimeMessage = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		helper.setTo(user.getEmail());
		helper.setSubject("Nội Thất MOHO - Xác nhận tài khoản khách hàng");
		String message = "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "  <head>\r\n"
				+ "    <meta charset=\"UTF-8\" />\r\n" + "  </head>\r\n"
				+ "  <body style=\"width: 50%; max-width: 100%; margin: 0 auto;\">\r\n" + "    <img\r\n"
				+ "      style=\"display: inline-block; margin-bottom: 26px;\"\r\n"
				+ "      src=\"https://theme.hstatic.net/200000065946/1000806110/14/logo.png?v=2476\"\r\n"
				+ "    />\r\n" + "    <span\r\n" + "      style=\"\r\n" + "        display: block;\r\n"
				+ "        color: black;\r\n" + "        font-size: 22px;\r\n" + "        font-weight: 600;\r\n"
				+ "        margin-bottom: 14px;\r\n" + "      \"\r\n" + "    >\r\n"
				+ "      Chào mừng " + user.getFull_name()
				+ " đến với Nội Thất MOHO!</span\r\n" + "    >\r\n" + "\r\n"
				+ "    <span\r\n" + "      style=\"\r\n" + "        color: #777;\r\n" + "        font-size: 15px;\r\n"
				+ "        display: inline-block;\r\n" + "        margin-bottom: 22px;\r\n" + "        width: 100%;\r\n"
				+ "      \"\r\n" + "    >\r\n"
				+ "      Chúc mừng quý khách hàng đã kích hoạt tài khoản khách hàng thành công. Lần\r\n"
				+ "      mua hàng tiếp theo, hãy đăng nhập để tích lũy điểm nhận ưu đãi và việc\r\n"
				+ "      thanh toán sẽ thuận tiện hơn.\r\n" + "    </span>\r\n" + "\r\n" + "    <a\r\n"
				+ "      href=\"https://moho.vercel.app\"\r\n" + "      style=\"\r\n" + "        font-size: 15px;\r\n"
				+ "        color: white;\r\n" + "        background: #1666a2;\r\n"
				+ "        text-decoration: none;\r\n" + "        display: inline-block;\r\n"
				+ "        height: 52px;\r\n" + "        padding: 0 20px;\r\n" + "        line-height: 52px;\r\n"
				+ "        text-align: center;\r\n" + "        border-radius: 4px;\r\n"
				+ "        text-transform: none;\r\n" + "        font-weight: 600;\r\n" + "      \"\r\n" + "    >\r\n"
				+ "      Ghé thăm website của MOHO\r\n" + "    </a>\r\n" + "<span\r\n" + "      style=\"\r\n"
				+ "        display: block;\r\n" + "        margin-top: 30px;\r\n" + "        color: #777;\r\n"
				+ "        font-size: 14px;\r\n" + "      \"\r\n"
				+ "    >\r\n" + "      Nếu quý khách hàng có bất cứ câu hỏi nào, đừng ngần ngại liên lạc với MOHO\r\n"
				+ "      qua hotline\r\n"
				+ "      <a style=\"color: #1666a2; text-decoration: none;\" href=\"tel:0372800762\"\r\n"
				+ "        >037 280 0762\r\n" + "      </a>\r\n" + "      hoặc email:\r\n" + "      <a\r\n"
				+ "        style=\"color: #1666a2; text-decoration: none;\"\r\n"
				+ "        href=\"mailto:phamvantan1311@gmail.com\"\r\n" + "        target=\"_blank\"\r\n"
				+ "        href=\"mailto:cskh@moho.com.vn\"\r\n" + "      >\r\n"
				+ "        phamvantan1311@gmail.com</a\r\n" + "      >\r\n" + "    </span>" + "  </body>\r\n"
				+ "</html>";
		helper.setText(message, true);
		emailSender.send(mimeMessage);

		System.out.print("Success");
		return userService.createUser(user);

	}

	@GetMapping
	public List<UsersModel> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public Optional<UsersModel> getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@PutMapping("/{id}")
	
	
	public UsersModel updateUser(@PathVariable int id, @RequestBody UsersModel user) {
		return userService.updateUser(id, user);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}

}
