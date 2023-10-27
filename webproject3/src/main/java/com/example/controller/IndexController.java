package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
/*
public class IndexController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return new ModelAndView("/WEB-INF/views/index.jsp");
	}
	
	
}
*/
/*
@Controller
public class IndexController{
	/*
	//@RequestMapping은 클래스 레벨과 메소드 둘다 맵핑 할 수 있고
	//@GetMapping은 메소드에만 맵핑 할 수 있다.
	@GetMapping("/")
	public String index() {
		return "/WEB-INF/views/index.jsp";
	}
	
	@GetMapping("/")
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return new ModelAndView("index");
	}

}
*/