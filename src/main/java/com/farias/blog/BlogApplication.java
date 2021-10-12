package com.farias.blog;

import com.farias.blog.dao.UserRepository;
import com.farias.blog.models.User;
import com.farias.blog.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);

	}

}
