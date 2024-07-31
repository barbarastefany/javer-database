package com.javerbank.javer_database;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class JaverDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaverDatabaseApplication.class, args);
	}

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

	}
}
