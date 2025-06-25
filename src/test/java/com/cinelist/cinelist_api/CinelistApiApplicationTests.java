package com.cinelist.cinelist_api;

import com.cinelist.cinelist_api.domain.user.User;
import com.cinelist.cinelist_api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CinelistApiApplicationTests {

	@Autowired
	UserRepository repository;


	@Test
	void contextLoads() {
	}


	@Test
	@Transactional
	void criarUser() {
		User user = new User();

		user.setUsername("kotiomiro");
		user.setEmail("AFADKJGDA@gmail.com");
		user.setPassword("ewr325sd2#");

		repository.save(user);
	}


	@Test
	@Transactional
	void checarUser() {

	}
}
