package com.api.noithatmoho_backend.CorsConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
	@Bean
	   public WebMvcConfigurer corsConfigurer() {
	      return new WebMvcConfigurer() {
	         @Override
	         public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**")
	               .allowedOrigins("https://noithatmoho-frontend-92p6.vercel.app")
	               .allowedMethods("GET", "POST", "PUT", "DELETE")
	               .allowCredentials(true);
	         }
	      };
	}
}
