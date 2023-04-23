package com.ssafy.shop.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.shop.model.Board;
import com.ssafy.shop.model.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<Board> list() throws Exception {
		return boardDao.selectList();
	}

	@Override
	public Board getBoard(String code) throws Exception {
		return boardDao.selectBoard(code);
	}

	@Override
	public void regist(Board board) throws Exception {
		boardDao.insertBoard(board);
	}

}
