package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
	@ComponentScan("com.app.controller")
public class WebsiteApplication {

	public static void main(String[] args) {
		
	SpringApplication.run(WebsiteApplication.class, args);
	
	
	
	
	}
}
