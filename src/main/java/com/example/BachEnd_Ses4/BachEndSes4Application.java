package com.example.BachEnd_Ses4;

import com.example.BachEnd_Ses4.model.Role;
import com.example.BachEnd_Ses4.model.User;
import com.example.BachEnd_Ses4.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class BachEndSes4Application {

	public static void main(String[] args) {
		SpringApplication.run(BachEndSes4Application.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
//	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new User(null, "Hien Dang", "Hien", "123", new ArrayList<>()));
			userService.saveUser(new User(null, "Ly Truc", "Ly", "123", new ArrayList<>()));
			userService.saveUser(new User(null, "Coop", "coop", "123", new ArrayList<>()));
			userService.saveUser(new User(null, "Lotte", "lotte", "123", new ArrayList<>()));

			userService.addRoleToUser("Hien", "ROLE_ADMIN");
			userService.addRoleToUser("Ly", "ROLE_ADMIN");
			userService.addRoleToUser("coop", "ROLE_USER");
			userService.addRoleToUser("lotte", "ROLE_USER");
		};
	}

}
