package com.example.upstream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UpstreamServiceApplication {

	static Logger logger= LoggerFactory.getLogger(UpstreamServiceApplication.class);

	public static void main(String[] args) {
	    logger.info("Hi, I am in main");
		SpringApplication.run(UpstreamServiceApplication.class, args);
	}
}
