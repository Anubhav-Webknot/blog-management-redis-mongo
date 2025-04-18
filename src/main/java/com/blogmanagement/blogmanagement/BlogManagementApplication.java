package com.blogmanagement.blogmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BlogManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(BlogManagementApplication.class, args);
	}

}
