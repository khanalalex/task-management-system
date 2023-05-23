package com.codewithalex.taskmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codewithalex.taskmanagementsystem.model.User;
import com.codewithalex.taskmanagementsystem.repository.UserRepository;

@Controller
public class SignupController {
	
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/signup")
	public String SignupUser() {
		return "SignupForm";
	}
	
	
	@PostMapping("/signup")
	public String signupUser(@ModelAttribute User user , Model model) {
		userRepo.save(user);
	
		model.addAttribute("uname", user.getUsername());
		
		return "LoginForm";
	
	

}
}
