package dev.opoussa.write_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WriteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WriteServiceApplication.class, args);
	}

}
