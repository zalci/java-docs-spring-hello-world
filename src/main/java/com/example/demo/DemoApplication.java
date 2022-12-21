package com.example.demo;

import java.io.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	String sayHello() {
		String currentPath = new java.io.File(".").getCanonicalPath();
		//System.out.println("Current dir:" + currentPath);
		//return "Hello Zalci & Co. World, na ná TEST TEST2 TEST3!";
		return currentPath;
	}
}
