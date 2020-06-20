package com.br.victorvaz.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.victorvaz.springboot.service.UserService;
import com.br.victorvaz.springboot.web.dto.UserRegistratioDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public UserRegistratioDto userRegistrationDto() {
	return new UserRegistratioDto();	
	}

	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAcount(@ModelAttribute("user") UserRegistratioDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
	
}
