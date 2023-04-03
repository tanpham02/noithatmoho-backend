package com.api.noithatmoho_backend.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.noithatmoho_backend.Model.UsersModel;
import com.api.noithatmoho_backend.Repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
    private LoginRepository loginRepository;

    public boolean authenticate(String email, String password) {
        Optional<UsersModel> LoginOptional = loginRepository.findByEmail(email);
        if (LoginOptional.isEmpty()) {
            return false;
        }
        UsersModel user = LoginOptional.get();
        return user.getPassword().equals(password);
    }
}

