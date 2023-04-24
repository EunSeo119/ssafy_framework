package com.ssafy.term9.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.term9.model.Board;
import com.ssafy.term9.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	private BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping("/list")
	public String list(Model model) throws Exception {
		List<Board> list = boardService.list();
		model.addAttribute("list", list);
		return "list";
	}

	@GetMapping("/regist")
	public String registForm(HttpSession session, RedirectAttributes redirectAttributes) {
//		if (session.getAttribute("userInfo") == null) {
//			redirectAttributes.addFlashAttribute("msg", "로그인 후 사용해주세요");
//			return "redirect:/";
//		}

		return "regist";
	}

	@PostMapping("/regist")
	public String regist(Board board, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
//		Board b = boardService.getBoard(board.getCode());
//
//		if (b != null) {
//			redirectAttributes.addFlashAttribute("msg", "상품코드를 확인하세요");
//			return "redirect:/board/regist";
//		}
		try {
			boardService.regist(board);
			redirectAttributes.addFlashAttribute("resultCode","1");			
		} catch(Exception e) {
			redirectAttributes.addFlashAttribute("resultCode","0");			
		}
		
		return "redirect:/board/regist";
	}
	
	@GetMapping("detail")
	public String list(int ano, Model model) throws Exception {
		Board board = boardService.detail(ano);
		model.addAttribute("board", board);
		return "detail";
	}
	
	@GetMapping("multi-delete")
	public String multiDelete(@RequestParam(name = "ano") List<String> noList) throws Exception {	
		boardService.multiDelete(noList);
		return "redirect:list";
	}
}
