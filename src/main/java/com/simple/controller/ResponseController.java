package com.simple.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/response")
public class ResponseController {
	
	//res_ex01화면처리
	@RequestMapping("/res_ex01")
	public void res_ex01() {
		
	}
	
	//Model전달자 - 화면으로 전달할 데이터를 addAttribute(키,값)
	@RequestMapping("res_ex02")
	public String res_ex02(Model model) { //ModelMap이나 Model둘다 써도됨
		
		model.addAttribute("serverTime", new Date());
		model.addAttribute("name", "홍길동");
		
		return "response/res_ex02";
	}
	
	//ModelAndView방법 - 데이터는 addObject(키,값) ,화면정보는 setViewName()
	@RequestMapping("res_ex03")
	public ModelAndView res_ex03() { //반환타입은 String이 아니라 ModelAndView타입이다.
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("serverTime",new Date());
		mv.setViewName("response/res_ex03"); //return값이 그대로 들어온다고 생각하면됨
		
		return mv;
	}
	
	//@ModelAttribute전달자 - @RequestParam + Model
	@RequestMapping("/res_ex04")
	public String res_ex04(@ModelAttribute("id") String a) { //@ModelAttribute("") -화면에서 받고 다음화면에서 사용할 값
		
		System.out.println("넘어온값:"+ a);
		return "response/res_ex04"; //주의 ex04로 넘어가서 사용되는 값은 a가아니라 id이다.
	}
	
	//@ModelAttribute여러값
	@RequestMapping("/res_ex05")
	public String res_ex05(@ModelAttribute("info") ReqVO vo) {
		
		System.out.println("넘어온값:"+vo.toString());
		return "response/res_ex05"; //주의 ex05로 넘어가서 사용되는 값은 vo가아니라 info이다.
	}
	
	//===============리다이렉트와 리다이렌트 어트리뷰트====================
	
	@RequestMapping("/res_redirect")
	public void res_redirect() {
		
	}
	//가정 - 아이디,비밀번호가 동일하면 성공화면 , 다르다면 다시 로그인화면으로 이동
	@RequestMapping("/login")
	public String login(ReqVO vo, RedirectAttributes RA) {// RedirectAttribute를 사용하면 리다이렉트 이동할때 파라미터값을 전달해 줄 수 있다.(단 딱 한번만,1회성 데이터 새로고침하면 없어짐)
		
		if(vo.getId().equals(vo.getPw())) {//성공			
			return "response/res_login_ok";
		}else {//실패
			// redirect:/절대경로 - 다시 컨트롤러를 타게한다.(이렇게 해주면 로그인에 실패해도 주소가 login으로 남지않고 redirect로 남게된다.)
			//이때 화면에 1회성 데이터로 값을 전달하고 싶다면 RedirectAttribute객체의 addFlashAttribute를 이용합니다.
			
			RA.addFlashAttribute("msg","아이디 비밀번호를 확인하세요");
			return "redirect:/response/res_redirect"; //다시로그인화면
		}
	}
	
	
	//=================res_quiz01==================
	
	//화면처리
	@RequestMapping("/res_quiz01")
	public String res_quiz01() {
		return "response/res_quiz01";
	}
	
	@RequestMapping( value="/res_login", method=RequestMethod.POST)
	public String res_login(ReqVO vo,Model model) {
		
		model.addAttribute("id",vo.getId());
		model.addAttribute("pw",vo.getPw());
		
		if(vo.getId().equals("kim12")&&vo.getPw().equals("1234")) {//로그인성공
					
			return "response/res_quiz02";
		}else { //로그인실패
			
			return "response/res_quiz03";
		}
		
		
				
		
	}
	
}
