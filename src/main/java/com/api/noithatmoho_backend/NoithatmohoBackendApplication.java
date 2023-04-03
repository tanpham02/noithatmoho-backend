package com.api.noithatmoho_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class NoithatmohoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoithatmohoBackendApplication.class, args);
	}

}
      



