package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//실제로 작업을 수행하는 컨트롤러
public class SpringController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ModelAndView = RequestDispatcher
		return new ModelAndView("/WEB-INF/views/spring_result.jsp");
	}
	
	
}
