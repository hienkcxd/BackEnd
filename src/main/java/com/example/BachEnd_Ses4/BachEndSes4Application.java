package com.example.BachEnd_Ses4;

import com.example.BachEnd_Ses4.UTIL.ConvertDateToLong;
import com.example.BachEnd_Ses4.model.System.Role;
import com.example.BachEnd_Ses4.model.System.Store;
import com.example.BachEnd_Ses4.model.System.User;
import com.example.BachEnd_Ses4.model.System.UserLog;
import com.example.BachEnd_Ses4.service.system.StoreService;
import com.example.BachEnd_Ses4.service.system.UserLogService;
import com.example.BachEnd_Ses4.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	CommandLineRunner run(UserService userService, UserLogService userLogService, StoreService storeService){
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

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			long mills = new Date().getTime()/3600000;
			userLogService.addUserLog(new UserLog(null, "log demo 1", "doan",
					mills)
			);
			userLogService.addUserLog(new UserLog(null, "log demo 2", "doan",
					mills)
			);
			userLogService.addUserLog(new UserLog(null, "log demo 3", "doan",
					mills)
			);
			userLogService.addUserLog(new UserLog(null, "log demo 4", "duong",
					mills)
			);
			userLogService.addUserLog(new UserLog(null, "log demo 5", "duong",
					mills)
			);
			userLogService.addUserLog(new UserLog(null, "log demo 6", "duong",
					mills)
			);
			userLogService.addUserLog(new UserLog(null, "log demo 7", "doan",
					mills)
			);
			storeService.addStore(new Store(null, "store 1", "doan"));
			storeService.addStore(new Store(null, "store 2", "duong"));
			storeService.addStore(new Store(null, "store 3", "duong"));
			storeService.addStore(new Store(null, "store 4", "duong"));
			storeService.addStore(new Store(null, "store 5", "doan"));
			storeService.addStore(new Store(null, "store 6", "doan"));
		};
	}

}
