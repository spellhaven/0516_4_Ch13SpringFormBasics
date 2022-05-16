package com.spellhaven.spring0516_4;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/loginOk")
	public String loginOk(HttpServletRequest request, Model model){
		// 폼이 값을 request 객체에 담아서 보내는 건 알지, ㅋ? 컨트롤러는 그 값을 Model에 담아 loginOk.jsp에 보내긔.
		// 그것이... "Spring의 MVC 패턴의 특징이다."
		
		String pid = request.getParameter("id");
		String ppw = request.getParameter("pw");
		
		model.addAttribute("pid", pid);
		model.addAttribute("ppw", ppw);
		
		return "loginOk";
	}
	
	
	// @RequestParam을 쓰는 애들, login2와 그에 딸린 loginCheck를 만들어 보자.
	@RequestMapping(value = "/login2")
	public String login2() {
		return "login2";
	}
	
	@RequestMapping(value = "/loginCheck")
	public String loginCheck(@RequestParam("id") String pid, @RequestParam("pw") String ppw, Model model) { 
	
		// 위의 loginOk 함수랑 같은 기능을 한다.
		// 괄호 안의 파라미터는 Request 객체에 들어 있는 "id" 값을 찾아서 String pid에 넣어 준다는 뜻이고... 이런 뜻이다.

		// 근데 보다시피, 괄호 안 파라미터 부분이 너무 길어져서 가독성 ㅆㅎㅌㅊ 된다.
		// 그래서 @RequestParam을 쓰는 이 방법은 보통 파라미터가 한두 개일 때만 쓴다.
		
		model.addAttribute("pid", pid);
		model.addAttribute("ppw", ppw);
		
		return "loginCheck";
	}
	
	
	// Request와 Model을 쓰는 대신 DTO를 쓰는 것! 연습해 보자. (pdf 13강 - 4슬라이드)
	@RequestMapping(value = "/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(MemberDto dto, Model model) {
			
		// 이렇게만 써도 되나요? 어 돼. Form과 dto의 객체들 이름만 일치한다면 각 속성이 알아서 척척 들어가.
		// 헐... 그렇게 편리하고 발전한 기능이 있어요? 말도 안 돼요! "Spring이니까 돼"
		model.addAttribute("dto", dto);
		
		return "joinOk";
	}
	
	
	// pdf 13-4, PathVariable 내용. 경로 자체에 변수를 바로 넣어서 파라미터로 이용 가능.
	@RequestMapping(value = "/studentNum/{studentNum}")
	public String getStudentNum(@PathVariable String studentNum, Model model) {
		
		model.addAttribute("studentNum", studentNum);
		
		return "paramTest";
	}
	
}





















