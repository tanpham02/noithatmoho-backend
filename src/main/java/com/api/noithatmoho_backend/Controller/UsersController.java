package com.api.noithatmoho_backend.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.api.noithatmoho_backend.Services.UsersService;

@RestController
@RequestMapping("/api/users")
//@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {

	@Autowired
	UsersService userService;

	@PostMapping
	public UsersModel createUser(@RequestBody UsersModel user) {
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
