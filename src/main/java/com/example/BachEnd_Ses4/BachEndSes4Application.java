package com.example.BachEnd_Ses4;

import com.example.BachEnd_Ses4.model.System.Role;
import com.example.BachEnd_Ses4.model.System.User;
import com.example.BachEnd_Ses4.model.System.UserLog;
import com.example.BachEnd_Ses4.service.system.UserLogService;
import com.example.BachEnd_Ses4.service.system.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@SpringBootApplication
public class BachEndSes4Application {

	public static void main(String[] args) {
		SpringApplication.run(BachEndSes4Application.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService, UserLogService userLogService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new User(null, "The Hien", "hien", "123", new ArrayList<>()));
			userService.saveUser(new User(null, "Kieu Phong", "phong", "123", new ArrayList<>()));
			userService.saveUser(new User(null, "Doan Du", "doan", "123", new ArrayList<>()));
			userService.saveUser(new User(null, "Duong Qua", "duong", "123", new ArrayList<>()));

			userService.addRoleToUser("hien", "ROLE_ADMIN");
			userService.addRoleToUser("phong", "ROLE_ADMIN");
			userService.addRoleToUser("doan", "ROLE_USER");
			userService.addRoleToUser("duong", "ROLE_USER");

			userLogService.addUserLog(new UserLog(null, "log demo 1", "doan"));
			userLogService.addUserLog(new UserLog(null, "log demo 2", "doan"));
			userLogService.addUserLog(new UserLog(null, "log demo 3", "doan"));
			userLogService.addUserLog(new UserLog(null, "log demo 4", "duong"));
			userLogService.addUserLog(new UserLog(null, "log demo 5", "duong"));
			userLogService.addUserLog(new UserLog(null, "log demo 6", "duong"));
			userLogService.addUserLog(new UserLog(null, "log demo 7", "doan"));
			userLogService.addUserLog(new UserLog(null, "log demo 8", "doan"));
			userLogService.addUserLog(new UserLog(null, "log demo 9", "duong"));
		};
	}

}
