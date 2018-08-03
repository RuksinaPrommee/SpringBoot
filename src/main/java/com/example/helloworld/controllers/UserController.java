package com.example.helloworld.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.helloworld.User;
import com.example.helloworld.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping("/form")
	public String welcome(@ModelAttribute User user, Model model) {

		List<User> users = repository.findAll();
		model.addAttribute("users", users);

		return "userform";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute User user, Model model) {
		model.addAttribute("user", user);
		repository.save(user);

		return "result";
	}


}