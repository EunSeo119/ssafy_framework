package com.ssafy.shop.model.service;

import java.util.List;

import com.ssafy.shop.model.Board;

public interface BoardService {

	List<Board> list() throws Exception;

	Board getBoard(String code) throws Exception;

	void regist(Board board) throws Exception;
}
