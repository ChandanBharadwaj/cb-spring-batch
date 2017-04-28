package com.sai;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class MySpringBatchApplication {
	public static void main(String[] args) {
		SpringApplication.run(MySpringBatchApplication.class, args);
	}
}
