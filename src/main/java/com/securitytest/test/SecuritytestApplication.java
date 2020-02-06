package com.securitytest.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SecuritytestApplication {

	@GetMapping("/")
	public String hello() {
		return "hello, spring security";
	}
	
	@Bean
	public OpenEntityManagerInViewFilter openEntityManagerInViewFilter(){
	   return new OpenEntityManagerInViewFilter();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SecuritytestApplication.class, args);
	}

}
