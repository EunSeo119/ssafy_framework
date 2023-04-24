package com.ssafy.samples.model.service;

import java.util.List;

import com.ssafy.samples.model.Board;

public interface BoardService {

	List<Board> list() throws Exception;

	Board getBoard(String code) throws Exception;

	void regist(Board board) throws Exception;
}
