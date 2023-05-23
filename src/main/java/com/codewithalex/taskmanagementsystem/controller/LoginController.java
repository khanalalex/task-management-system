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
public class LoginController {
	
	
	@Autowired
	private UserRepository userRepo;
	
	
	//handlers for get and post requests
	
	@GetMapping({ "/", "/login" })
	public String Login() {
		return "LoginForm";
	}

	@PostMapping("/login")
	public String loginUser(@ModelAttribute User user, Model model) {
		
		User usr = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(usr != null) {
			model.addAttribute("uname",user.getName());
			return "Home";
		}
		model.addAttribute("message","User not Found!");
		return "LoginForm";
	}
	@GetMapping("/logout")
	public String logout() {
		
		return "LoginForm";
	}
	
	

}
