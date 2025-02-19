package com.sistema.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.sistema.api.entities.User;
import com.sistema.api.repositories.UserRepository;

public class TestConfig implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(1L, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(2L, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));		
	}

}
