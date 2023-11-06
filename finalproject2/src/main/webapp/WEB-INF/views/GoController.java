package com.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/go")
public class GoController {
	
	@GetMapping("go")
	public String go() {
	
		return "go/go";
	}
	
	@PostMapping("/gogo")
	public void go(@RequestParam("where")String where, Model model) {
		model.addAttribute("where", where);
	}
	

}