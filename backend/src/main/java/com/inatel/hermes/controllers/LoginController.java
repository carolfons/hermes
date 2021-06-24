package com.inatel.hermes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inatel.hermes.services.UsuarioService;



@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/home")
	public String inicio(Model model) {
		return "home"; // view
	}

	@GetMapping("/")
	public String home(Model model) {
		return "home"; // view
	}

	@GetMapping
	public String viewLoginPage() {
		return "login";
	}

//	@GetMapping("/registration")
//	public String registration(Model model) {
//		if (securityService.isAuthenticated()) {
//			return "redirect:/";
//		}
//
//		model.addAttribute("userForm", new Usuario());
//
//		return "registration";
//	}
//
//	@PostMapping("/registration")
//	public String registration(@ModelAttribute("userForm") Usuario userForm, BindingResult bindingResult) {
//		userValidator.validate(userForm, bindingResult);
//
//		if (bindingResult.hasErrors()) {
//			return "registration";
//		}
//
//		usuarioService.save(userForm);
//
//		securityService.autoLogin(userForm.getUsuarioname(), userForm.getPasswordConfirm());
//
//		return "redirect:/welcome";
//	}
}
