package com.ssafy.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.shop.model.Board;
import com.ssafy.shop.model.service.BoardService;

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
		if (session.getAttribute("userInfo") == null) {
			redirectAttributes.addFlashAttribute("msg", "로그인 후 사용해주세요");
			return "redirect:/";
		}

		return "regist";
	}

	@PostMapping("/regist")
	public String regist(Board board, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		Board b = boardService.getBoard(board.getCode());

		if (b != null) {
			redirectAttributes.addFlashAttribute("msg", "상품코드를 확인하세요");
			return "redirect:/board/regist";
		}
		
		boardService.regist(board);
		redirectAttributes.addFlashAttribute("msg", "등록되었습니다.");

		return "redirect:/board/list";
	}
}
