package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


public class SecondController  extends AbstractController{
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// bundleview
		// 꼭 jsp 파일 이름이 아닌 내가 정한이름을 사용해도 된다.-> two	
		return new ModelAndView("two").addObject("msg", "SecondController");
	}

}
