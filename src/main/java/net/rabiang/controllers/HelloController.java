package net.rabiang.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/")
	public String hello(Model model) {
		model.addAttribute("greeting", "Hello");

		return "hello";
	}

}
