package com.example.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.model.User;
import com.example.app.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("users", userRepository.findAll());
		
		return "/users/index";
	}
     
    @GetMapping("/new")
    public String showFormCreate(User user) {
        return "/users/new";
    }
     
    @PostMapping("/save")
    public String save(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/users/new";
        }
         
        userRepository.save(user);
        
        return "redirect:/users";
    }
}