package com.example.demo;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DBManager;

@SpringBootApplication
@RestController
public class Firstbluetomato1Application {

	public static void main(String[] args) {
		SpringApplication.run(Firstbluetomato1Application.class, args);
	}

	@GetMapping(path="/api")
	String sayHello() {
		try {
			DBManager.initDB();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return e.getCause().getMessage();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			return e.getCause().getMessage();
		}
		//System.out.println("Current dir:" + currentPath);
		//return "Hello Zalci & Co. World, na ná TEST TEST2 TEST3!";
		return DBManager.getDBPath();
	}


}
