package com.simple.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/request") //RequestController클래스 하위에 생성된 모든 메서드에 적용
public class RequestController {
	
	@RequestMapping("/req_ex01") //url로 들어오는 경로(메서드의 요청경로)
	public String req_ex01() {
		System.out.println("실행됨");
		
		return "/request/req_ex01"; //화면단에 나가는 경로 뷰리졸버를 통해 WEB-INF/views와 .jsp가 앞뒤에 추가된다.
		
	}
	
	//보이드형 메서드는 메서드 요청경로가 뷰 리졸버로 돌아가게 됩니다.
	@RequestMapping("/req_ex02")
	public void req_ex02() {
		
	}
	
//	//basic01에대한 요청
//	@RequestMapping(value="/basic01", method = RequestMethod.GET)
//	public void basic01() {
//		System.out.println("basic01");
//	}
//	
//	//basic02에대한 요청
//	@RequestMapping(value="/basic02", method = RequestMethod.POST)
//	public void basic2() {
//		System.out.println("basic02");
//	}
//	
//	//basic03에대한 요청
//	@RequestMapping(value="/basic3") //method값을 넣어주지안으면 get,post둘다허용
//	public void basic03() {
//		System.out.println("basic03");
//	}
	
	//basic01, 02, 03을 하나의 메서드로 받아서 처리.
	@RequestMapping({"/basic01","/basic02","/basic03"})
	public void basic() {
		System.out.println("basic1,2,3");
	}
	
	//======================================요청파라미터값 받기=======================================
	
	//req_ex03화면처리
	@RequestMapping(value="/req_ex03")
	public String req_ex03() {
		
		return "request/req_ex03";
	}
	
	//param요청처리
	//1st - request객체 이용하기
//	@RequestMapping("/param")
//	public String param(HttpServletRequest request) {
//		System.out.println(request.getParameter("id"));
//		System.out.println( Arrays.toString(request.getParameterValues("inter")) );
//		
//		return "request/req_ex03_result";
//	}
	
	//2nd - 어노테이션 방법 (RequestParam에도 속성을 넣어줄 수 있다. required=false defaultValue="" 이 둘은 세트)
	//단일값을 받을 때 사용하고 뒤에 선언한 타입과 변수명으로 받을 수 있다.
//	@RequestMapping("/param")
//	public String param(@RequestParam("id") String id, 
//						@RequestParam("pw") String pw,
//						@RequestParam("name") String name,
//						@RequestParam(value="inter", required=false, defaultValue="") ArrayList<String> inter
//						) {
//		System.out.println(id);
//		System.out.println(pw);
//		System.out.println(name);
//		System.out.println(inter.toString());
//		
//		return "request/req_ex03_result";
//	}
	
	//3nd - 커맨드객체를 이용하는 방법
	@RequestMapping("/param")
	public String Param(ReqVO vo) {
		
		System.out.println(vo.toString());
		
		return "request/req_ex03_result";
	}
	
	
	//quiz01
	@RequestMapping("/req_quiz01")
	public String login() {	
		return "request/req_quiz01";
	}
	
	//quiz01- request객체 사용
	@RequestMapping("/quiz01_01")
	public String quiz01_1(HttpServletRequest req) {
		System.out.println("request객체 사용");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		if(id.equals("abc123")&&pw.equals("xxx123")) return "request/req_quiz01_ok";
		
		return "request/req_quiz01_no";
	}
		
	//quiz01 - 어노테이션사용
	@RequestMapping("/quiz01_02")
	public String quiz01_2(@RequestParam("id") String id, @RequestParam("pw") String pw){
		System.out.println("어노테이션방법 사용");
		if(id.equals("abc123")&&pw.equals("xxx123")) return "request/req_quiz01_ok";
		return "request/req_quiz01_no";
	}
	
	//quiz01 - 커맨드객체사용
	@RequestMapping("/quiz01_03")
	public String quiz01_3(ReqVO vo) {
		System.out.println("커맨드객체 사용");
		if(vo.getId().equals("abc123")&&vo.getPw().equals("xxx123")) {
			return "request/req_quiz01_ok";
		}else {		
			return "request/req_quiz01_no";
		}
	}
	
}
