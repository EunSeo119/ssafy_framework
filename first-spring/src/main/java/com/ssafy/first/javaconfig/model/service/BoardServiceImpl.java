package com.ssafy.first.javaconfig.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ssafy.first.javaconfig.model.dao.BoardDao;

@Service("boardService")
@Qualifier("bs")	//같은 빈이 있을때 구분자로 사용! (하지만 얘는 몰라도 ok)
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;	// 애도 주입되려면 스프링이 관리하는 빈에 등록되어있어야한다 -> dao ㄱㄱ~
	
	public BoardServiceImpl() {
		System.out.println("BoardServiceImpl() 객체 생성");
	}
	
	public BoardServiceImpl(BoardDao boardDao) {
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
