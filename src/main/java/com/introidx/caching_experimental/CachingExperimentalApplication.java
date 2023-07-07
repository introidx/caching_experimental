package com.introidx.caching_experimental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CachingExperimentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachingExperimentalApplication.class, args);
	}

}
