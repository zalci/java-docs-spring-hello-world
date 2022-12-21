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
	public String index(Model model) throws IOException, GeneralSecurityException {
		DBManager.initDB();
		model.addAttribute("instances",DBManager.getAllInstances());
		return "index";
	}

	@PostMapping(path="/insert")
	public String insert(@ModelAttribute Instance instance) throws IOException, GeneralSecurityException {
		System.out.println(instance.toString());
		DBManager.insertInstance(instance);
		return "index";
	}

}
