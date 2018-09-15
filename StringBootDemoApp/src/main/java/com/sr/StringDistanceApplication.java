package com.sr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class StringDistanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringDistanceApplication.class, args);
	}
}
