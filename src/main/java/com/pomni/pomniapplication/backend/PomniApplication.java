package com.pomni.pomniapplication.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Основной класс приложения, используется для запуска приложения.
 */
@SpringBootApplication
public class PomniApplication {

	public static void main(String[] args) {
		SpringApplication.run(PomniApplication.class, args);
	}

}
