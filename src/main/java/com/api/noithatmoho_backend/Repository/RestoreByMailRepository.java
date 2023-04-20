package com.api.noithatmoho_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.noithatmoho_backend.Model.UsersModel;

public interface RestoreByMailRepository extends JpaRepository<UsersModel, Long>{
	
	
}
