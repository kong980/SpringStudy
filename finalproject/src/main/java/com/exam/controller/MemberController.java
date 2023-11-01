package com.exam.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.exam.domain.Member;
import com.exam.domain.RegisterRequest;
import com.exam.service.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {
	// 서비스 객체 주입
	@Autowired
	private MemberService memberService;	
	
	@GetMapping("/add")
	public String step1() {
		return "member/step1";
	}
	
	// (value="agree", defaultValue="false") 만약 선택을 하지 않는다면 null 값이 아닌 false 값이 넘어간다.
	
	@PostMapping("/step2")
	public String step2(@RequestParam(value="agree", defaultValue="false") boolean agree) {
		if(!agree) {
			return "member/step1";
		}
		return "member/step2";
	}
	
	//step3라는 요청이 들어오면, 바로 페이지를 이동하는게 아니라 넘어오는 데이터를 service에 넘기고 dao에게 넘기고 mybatis에 넘겨줌
	@PostMapping("/step3")
	public String step3(@ModelAttribute RegisterRequest dto) throws Exception{
		memberService.RegisterMember(dto);
		return "member/step3";
	}
	
	//로그인 페이지로 이동
	// if) void : 요청하려는 이름과 가려는 경로가 이름이 같기 때문에 return 값을 지정하지 않아도 된다.
	@GetMapping("/login")
	public void login() {
		
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, HttpServletRequest req){ //(@RequestParam ) 생략
		String msg = null;
		try {
			msg = URLEncoder.encode("id 또는 password가 일치하지 않습니다.", "utf-8");
			Member member = memberService.selectWithPass(id, pwd); // 아이디가 맞는지 조회
			
//			HttpSession session = req.getSession();
//			session.setAttribute("id", member.getEmail());
			WebUtils.setSessionAttribute(req, "id", member.getName());
		} catch (Exception e) {
			
			return "redirect:/member/login?msg=" + msg;
		}

		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}

