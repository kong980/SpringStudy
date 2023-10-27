package com.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.domain.Board;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping("/list")
	public String list() {
		System.out.println("List Page 실행");
		return "board/list";
	}
	
	@GetMapping("/write")
	public String write() {
		System.out.println("Write Page 실행");
		return "board/write";
	}
	//오버로딩 : 똑같은 이름의 메서드를 만들 수있다. 매개변수만다르게 해줘
	//요청은 요청방식으로 구분한다.
	@PostMapping("/write")
	public String write(@ModelAttribute Board board) {
		//System.out.println("write");
		//System.out.println(board.getbContent());
		return null;
	}
	
	@GetMapping("/read")
	public String read() {
		System.out.println("Read Page 실행");
		return "board/read";
	}
	@GetMapping("/delete")
	public String delete() {
		return null;
	}
	
}
