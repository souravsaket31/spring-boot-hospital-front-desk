package com.java.assessement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
public class SpringBootHospitalFrontDeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHospitalFrontDeskApplication.class, args);

	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
