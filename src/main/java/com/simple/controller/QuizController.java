package com.simple.controller;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.soap.AddressingFeature;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	//============quiz01=============
	//화면처리
	@RequestMapping("/quiz01")
	public String quiz01() {
		return "quiz/quiz01";
	}
	
	@RequestMapping("/sendBirth")
	public String sendBirth(Quiz01VO vo, Model model ) {
		
		System.out.println(vo.toString());
		model.addAttribute("year",vo.getYear());
		model.addAttribute("month",vo.getMonth());
		model.addAttribute("day",vo.getDay());
		
		return "quiz/quiz01_ok";
	}
	
	//========quiz02==============
	//화면처리 
	@RequestMapping("/quiz02")
	public String quiz02() {
		return "quiz/quiz02";
	}
	
	@RequestMapping("/join")
	public ModelAndView join(HttpServletRequest req) {
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		mv.addObject("pw",pw);
		mv.addObject("name",name);
		mv.addObject("email",email);
		
		mv.setViewName("quiz/quiz02_ok");
		
		return mv;
	}
	
	
	//==============quiz03=================
	@RequestMapping("quiz03")
	public String quiz03() {
		return "quiz/quiz03";
	}
	
	@RequestMapping("join2")
	public String join2(@ModelAttribute("id") String id, //ModelAttribute로 받아와서 quiz03_ok 에서도 사용가능
						@RequestParam("pw") String pw,
						@RequestParam("pw_check") String pw_check,
						RedirectAttributes RA){
		if(id==null || id.equals("")) { //아이디 미입력
			RA.addFlashAttribute("msg", "아이디를 입력하세요");
			return "redirect:/quiz/quiz03";
		}else if(pw==null || pw.equals("")) { //비밀번호 미입력
			RA.addFlashAttribute("msg", "비밀번호를 입력하세요");
			return "redirect:/quiz/quiz03";
		}else if(!pw.equals(pw_check)) { //확인비밀번호 불일치
			RA.addFlashAttribute("msg", "비밀번호와 비밀번호확인이 일치하지 않습니다.");
			return "redirect:/quiz/quiz03";
		}else {// 성공
			return "quiz/quiz03_ok";
		}
	
	}
}
