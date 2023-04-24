package com.ssafy.term9.model.service;

import java.util.List;

import com.ssafy.term9.model.Board;

public interface BoardService {

	List<Board> list() throws Exception;

//	Board getBoard(String code) throws Exception;

	void regist(Board board) throws Exception;
	
	Board detail(int ano) throws Exception;
	
	void multiDelete(List<String> anoList) throws Exception;
}
