package com.api.noithatmoho_backend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.noithatmoho_backend.Model.UsersModel;

public interface LoginRepository extends JpaRepository<UsersModel, Long>{
	Optional<UsersModel> findByEmail(String email);
}
