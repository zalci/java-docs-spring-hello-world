package com.example.demo.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.DBManager;
import com.example.demo.model.Instance;

@Controller
public class IndexController {

	@GetMapping(path="/")
	public String index(Model model) {
		try {
			DBManager.initDB();
			model.addAttribute("instances",DBManager.getAllInstances());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return e.getMessage();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return e.getMessage();
		}		
		return "index";
	}

	@PostMapping(path="/insert")
	public String insert(@ModelAttribute Instance instance){
		System.out.println(instance.toString());
		try {
			DBManager.insertInstance(instance);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return e.getMessage();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return e.getMessage();
		}
		return "index";
	}

}
