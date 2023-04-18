package com.ssafy.first.javaconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ssafy.first.javaconfig.model.service.BoardService;

@Controller
public class BoardController {
	
//	@Autowired	
	private final BoardService boardService; // 이걸 쓰려면(주입하려면) 스프링 컨테이너에 있어야함! -> service ㄱㄱ (권장 x -> 생성자 주입!)
	
	@Autowired // 생성자가 하나만 있으면 안써줘도 자동 주입되긴함! (-> 얘는 첫번째로 타입으로 찾음 -> 타입이 여러개면 (매개변수와)같은 이름의 bean 먼저 선택!)
	public BoardController(BoardService boardService) {
		System.out.println("BoardController(Service) 생성자 호출");
		this.boardService = boardService;
	}

	@Override
	public String toString() {
		return "BoardController [boardService=" + boardService + "]";
	}
	
}
