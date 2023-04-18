package com.ssafy.first.javaconfig.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ssafy.first.javaconfig.model.dao.BoardDao;

@Service
@Primary	// 같은 타입이 있다면 얘를 우선으로 해줘!
public class BoardServiceImpl2 implements BoardService {
	
	@Autowired
	private BoardDao boardDao;	// 애도 주입되려면 스프링이 관리하는 빈에 등록되어있어야한다 -> dao ㄱㄱ~
	
	public BoardServiceImpl2() {
		System.out.println("BoardServiceImpl() 객체 생성");
	}
	
	public BoardServiceImpl2(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public String toString() {
		return "BoardServiceImpl [boardDao=" + boardDao + "]";
	}
	
}
