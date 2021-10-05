package com.mysecondapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.DependsOn;

@SpringBootApplication

public class MySecondAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySecondAppApplication.class, args);
	}

}
