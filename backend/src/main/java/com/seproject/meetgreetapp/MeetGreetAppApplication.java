package com.seproject.meetgreetapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.*")
public class MeetGreetAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetGreetAppApplication.class, args);
	}

}
