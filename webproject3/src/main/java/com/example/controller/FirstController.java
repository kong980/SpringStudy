package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

//어노테이션 사용하지 않겠음. 상당히 전통적인 방법으로 하겠음
public class FirstController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 반드시 실제 저장된 jsp파일이름으로 저장해야한다.
		return new ModelAndView("result").addObject("msg", "firstController");
	}

}
