package com.cinelist.cinelist_api;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EntityScan("com.cinelist.cinelist_api.domain")
@EnableJpaRepositories("com.cinelist.cinelist_api.repository")
public class CinelistApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinelistApiApplication.class, args);
	}

}
