package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exam.domain.Board;
import com.exam.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public ModelAndView list() throws Exception {
		List<Board> list = boardService.getList();
		
		ModelAndView mv = new ModelAndView("board/list"); // jsp에 데이터를 뿌려주기 위함
		mv.addObject("list", list); // list에 있는 데이터를 mv에 추가
		return mv; //  ModelAndView("board/list") --> addObject로 데이터를 넣어준 mv를 return
	}
	
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	//오버로딩 : 똑같은 이름의 메서드를 만들 수있다. 매개변수만다르게 해줘
	//요청은 요청방식으로 구분한다.
	@PostMapping("/write")
	public String write(@ModelAttribute Board board) throws Exception {
		boardService.write(board);
		return "redirect:/board/list"; //round trip
	}
	
	// @RequestParam : 1대1 매핑, @ModelAttribute : 객체 매핑
	@GetMapping("/read")
	public void read(@RequestParam int bNo, Model model) throws Exception {
		Board board = boardService.read(bNo);
		model.addAttribute(board);
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int bNo) throws Exception {
		boardService.delete(bNo);
		return "redirect:/board/list";
	}
	
	@GetMapping("/update")
	public void update(@RequestParam int bNo, Model model) throws Exception {
		Board board = boardService.read(bNo);
		model.addAttribute(board);
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Board board) throws Exception {
		boardService.update(board);
		return "redirect:/board/list";
	}
	
}
