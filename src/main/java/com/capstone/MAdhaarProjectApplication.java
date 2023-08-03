package com.capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan({"com.capstone.controllers","com.capstone.entity","com.capstone.repository","com.capstone.service"})

@SpringBootApplication
public class MAdhaarProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MAdhaarProjectApplication.class, args);
	}

}
