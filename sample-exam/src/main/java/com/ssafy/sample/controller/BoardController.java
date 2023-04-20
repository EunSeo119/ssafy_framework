package com.ssafy.sample.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.sample.model.Board;
import com.ssafy.sample.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}


	@GetMapping("list")
	public String list(Model model) throws Exception {
		List<Board> list = boardService.list();
		model.addAttribute("list", list);
		return "list";	// /WEB-INF/views/.jsp
	}
	
	@GetMapping("detail")
	public String list(int no, Model model) throws Exception {
		Board board = boardService.detail(no);
		model.addAttribute("board", board);
		return "detail";
	}

	@GetMapping("delete")
	public String delete(int no) throws Exception {
		boardService.delete(no);
		return "redirect:/board/list";
//		return "redirect:list";
	}
	
	@GetMapping("write")	// 글쓰기 방식 이동
	public String writeForm() throws Exception {
		return "write";		// write.jsp
	}
	
	@PostMapping("write")
	public String write(Board board) throws Exception {
		boardService.write(board);
		return "redirect:/board/list";
//		return "redirect:list";
	}
	
	@GetMapping("multi-delete")
	public String multiDelete(@RequestParam(name = "no") List<Integer> noList) throws Exception {	// dto는 상관없지만 list로 직접 받을 때는 requestParam 필요!, noList로 하고 싶은데 이름은 no 일때
		boardService.multiDelete(noList);
		return "redirect:list";
	}
}
