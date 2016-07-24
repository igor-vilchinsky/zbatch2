package com.batch2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Batch2Application {

	public static void main(String[] args) {
		SpringApplication.run(Batch2Application.class, args);
	}
}
