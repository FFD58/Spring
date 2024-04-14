package ru.fafurin.lesson4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DBQueriesConfig.class)
public class Lesson4Application {

	public static void main(String[] args) {
		SpringApplication.run(Lesson4Application.class, args);
	}

}
