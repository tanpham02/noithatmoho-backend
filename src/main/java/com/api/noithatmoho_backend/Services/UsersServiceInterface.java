package com.api.noithatmoho_backend.Services;

import java.util.List;
import java.util.Optional;

import com.api.noithatmoho_backend.Model.UsersModel;

public interface UsersServiceInterface {
	public UsersModel createUser(UsersModel user);
	public Optional<UsersModel> getUserById(int id);
	List<UsersModel> getAllUsers();
	public UsersModel updateUser(int id, UsersModel user);
	public void deleteUser(int id);
}

