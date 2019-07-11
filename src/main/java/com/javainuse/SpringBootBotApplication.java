package com.javainuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class SpringBootBotApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(SpringBootBotApplication.class, args);
		System.out.println("So, start! Go work...");
	}
}
