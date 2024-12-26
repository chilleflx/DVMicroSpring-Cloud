package com.mcommandes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class McommandesApplication {

	public static void main(String[] args) {
		SpringApplication.run(McommandesApplication.class, args);
	}
}
