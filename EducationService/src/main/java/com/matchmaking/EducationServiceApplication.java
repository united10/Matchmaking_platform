package com.matchmaking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class EducationServiceApplication {

	static Logger logger= LoggerFactory.getLogger(EducationServiceApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(EducationServiceApplication.class, args);
	}
}
