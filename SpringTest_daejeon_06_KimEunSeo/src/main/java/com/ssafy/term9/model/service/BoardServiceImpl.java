package com.ssafy.term9.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.term9.model.Board;
import com.ssafy.term9.model.dao.BoardDao;

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

//	@Override
//	public Board getBoard(String code) throws Exception {
//		return boardDao.selectBoard(code);
//	}

	@Override
	public void regist(Board board) throws Exception {
		boardDao.insertBoard(board);
	}
	
	@Override
	public Board detail(int ano) throws Exception {
		return boardDao.selectBoardByPk(ano);
	}
	
	@Override
	public void multiDelete(List<String> anoList) throws Exception {
		for(String ano : anoList) {
			boardDao.deleteBoard(ano);
		}
	}

}
