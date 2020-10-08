package com.seproject.meetgreetapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MeetGreetAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetGreetAppApplication.class, args);
	}

	@Bean
	public org.modelmapper.ModelMapper modelMapper() {
		return new org.modelmapper.ModelMapper();
	}
}
