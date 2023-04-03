package com.api.noithatmoho_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.noithatmoho_backend.Model.UsersModel;
import com.api.noithatmoho_backend.Services.LoginService;

@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping
	public ResponseEntity<String> login(@RequestBody UsersModel login, Model model) {
		String email = login.getEmail();
		String password = login.getPassword();
		
		return ResponseEntity.ok("Đăng nhập thành công!");
	}
}
