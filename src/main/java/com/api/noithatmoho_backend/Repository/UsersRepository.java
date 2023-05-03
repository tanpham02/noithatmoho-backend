package com.api.noithatmoho_backend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.noithatmoho_backend.Model.UsersModel;

public interface UsersRepository extends JpaRepository<UsersModel, Integer>{ 
	Optional<UsersModel> findByEmail(String email);
	Optional<UsersModel> findById(int id);
}
