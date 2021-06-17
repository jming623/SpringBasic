package com.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.BoardVO;
import com.simple.service.BoardService;

@Controller
@RequestMapping("/service")
public class BoardServiceController {
	
	@Autowired
	@Qualifier("BoardService")
	private BoardService boardService;
	
	@RequestMapping("/boardRegister")
	public void boardRegister() {
		
	}
	
	@RequestMapping("/boardResult")
	public void boardResult() {
		
	}
	
	@RequestMapping("/boardList")
	public void boardList(Model model) {
		
		model.addAttribute("list", boardService.getList());
	}
	
	@RequestMapping("boardForm")
	public String boardRegist(BoardVO vo) {
		
		boardService.boardRegist(vo);
		
		return "service/boardResult";
	}
	
	@RequestMapping("/delete")
	public String delete(int num,RedirectAttributes RA) {
		
		boardService.boardDelete(num);
		RA.addFlashAttribute("msg", "삭제가 완료되었습니다.");
		
		return "redirect:/service/boardList";
	}
	
}
