package com.api.noithatmoho_backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.noithatmoho_backend.Model.UsersModel;
import com.api.noithatmoho_backend.Repository.UsersRepository;

@Service
public class UsersService implements UsersServiceInterface{
	
	@Autowired UsersRepository userRepository;

	@Override
	public UsersModel createUser(UsersModel user) {
		return userRepository.save(user);
	}

	@Override
	public Optional<UsersModel> getUserById(int id) {
		return userRepository.findById(id);
	}

	@Override
	public List<UsersModel> getAllUsers() {
		return userRepository.findAll();
	}
	
	


	@Override
	public UsersModel updateUser(int id, UsersModel user) {
		UsersModel updateUser = userRepository.findById(id).orElseThrow();
		updateUser.setEmail(user.getEmail());
		updateUser.setPhone_number(user.getPhone_number());
		updateUser.setFull_name(user.getFull_name());
		updateUser.setPassword(user.getPassword());
		updateUser.setIs_admin(user.getIs_admin());
		updateUser.setOtp(user.getOtp());
		updateUser.setAddress(user.getAddress());
		updateUser.setBirthday(user.getBirthday());
		updateUser.setVouchers(user.getVouchers());
		updateUser.setCheckout(user.getCheckout());
		updateUser.setAvatar(user.getAvatar());
		return userRepository.save(updateUser);
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}


}
