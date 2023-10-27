package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.User;

//Mapping은 어떻게 할 것인가 ->@RequestMapping => name과 똑같은일을 한다.
@Controller
public class SecondController {
	
	//임의의 메소드 생성
	@RequestMapping("/first")
	public String firstPage() {
		//System.out.println("firstPage 실행");
		//페이지 이동
		return "/WEB-INF/views/first.jsp";
	}
	@RequestMapping("/second")
	//public String SecondPage(HttpServletRequest req) { 리턴값도 ModelAndView로 바꿔줌
	public ModelAndView SecondPage(HttpServletRequest req) {
		//System.out.println("secondPage 실행");
		//파라미터 두개 받음 -> request 만들어(HttpServletRequest req)
		String p1 = req.getParameter("p1");
		String p2 = req.getParameter("p2");
		//System.out.println(p1 + ", " + p2);
		
		//데이터를 가지고 페이지 이동 해야함 ->ModelAndView가 필요하다.
		ModelAndView mv = new ModelAndView("/WEB-INF/views/second.jsp");
		mv.addObject("param1", p1);
		mv.addObject("param2", p2);
		
		return mv;
	}
	//@RequestMapping 메소드도 설정할수있음 인자를 2 이상 사용하면 써줘야함
	//value="third", method=RequestMethod.GET/POST/PUT/DELETE
	//@RequestMapping(value="/third" ,method=RequestMethod.POST)
	//public String thirdPage(@RequestParam String name, @RequestParam int age, @RequestParam double point) {
	//@RequestParam 생략되어있음, 요청할 때 내보내는 name="name" 이 같을 때는 생략 가능하다.
	//만약 name이 다를경우 @RequestParam("age") int nai라고 적어주어야함
	@PostMapping("/third")
	//public String thirdPag(String name, int age, double point){
	public String thirdPage(@RequestParam String name,
							@RequestParam("age") int nai,
							@RequestParam double point) {
		//System.out.println("third 실행2");
		//System.out.println(name +", " + age+ ", " + point);
		System.out.println(name +", " + nai+ ", " + point);
		return "/WEB-INF/views/third.jsp";
	}
	/*1.원초적인 방법 
	@GetMapping("/fourth")
	public ModelAndView fourthPage(String name, int age, double point) {
		//System.out.println("fourth 실행");
		//Dto 추가해서 dto로 묶어줌
		User dto = new User();
		dto.setName(name);
		dto.setAge(age);
		dto.setPoint(point);
		
		//view에 실어 날라야하자나
		ModelAndView mv = new ModelAndView("/WEB-INF/views/fourth.jsp");
		mv.addObject("user", dto);
		
		return mv;
	}
	*/
	/*2.
	@GetMapping("/fourth")
	public String fourthPage(String name, int age, double point, 
			Model model) {
		
		User dto = new User();
		dto.setName(name);
		dto.setAge(age);
		dto.setPoint(point);
		
		model.addAttribute("user", dto);
		
		return "/WEB-INF/views/fourth.jsp";
	}
	*/
	/*3. html->jsp action태그를 이용한 setProperty를 사용해서 dto를 자동으로 담아주는거*/
	//@ModelAttribute가 생략되어있는데 생략안하시는게 좋아요 
	//만약 dto에 없는 값은 어떻게 전달해야하는가? -> @RequestParam String chk 이런식으로 추가해줌
	//checkbox check안하면 null값으로 전달 되기 때문에 HTTP 상태 400
	@GetMapping("/fourth")
	public ModelAndView fourthPage(@ModelAttribute User dto, @RequestParam String chk) {		
		//view에 실어 날라야하자나
		ModelAndView mv = new ModelAndView("/WEB-INF/views/fourth.jsp");
		mv.addObject("user", dto);
		//잘 전달되는지 확인
		System.out.println("check : " + chk);
		
		return mv;
	}
	@RequestMapping("/fifth")
	public ModelAndView fifthPage() {
		//ArrayList 이용해서 데이터 준비
		List list = new ArrayList();
		list.add("삼계탕");
		list.add("반계탕");
		list.add("추어탕");
		list.add("갈비탕");
		
		//<키 자료형, 값 자료형>
		Map map = new HashMap<String, String>();
		map.put("f1", "사과");
		map.put("f2", "포도");
		map.put("f3", "수박");
		
		List listDay = new ArrayList<String>();
		listDay.add("월요일");
		listDay.add("화요일");
		listDay.add("수요일");
		listDay.add("목요일");
		
		//<키 자료형, 값 자료형>
		Map mapDay = new HashMap<String, List>();
		mapDay.put("day", listDay);
		
		ModelAndView mv = new ModelAndView("/WEB-INF/views/fifth.jsp");
		mv.addObject("tang", list);
		//map은 리스트 타입이 달라서 add가 아니고 put / 그래서 mv에 넣어줄 때도 다르다고 그랬어요 값이 하나가 아니라
		mv.addAllObjects(map);
		mv.addAllObjects(mapDay);
		
		return mv;
	}
	
}
