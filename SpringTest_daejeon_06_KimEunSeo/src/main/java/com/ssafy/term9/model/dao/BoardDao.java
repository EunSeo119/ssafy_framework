package com.ssafy.term9.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.term9.model.Board;

public interface BoardDao {

	List<Board> selectList() throws SQLException;

//	Board selectBoard(String code) throws SQLException;

	void insertBoard(Board board) throws SQLException;
	
	Board selectBoardByPk(int ano) throws SQLException;
	
	void deleteBoard(String ano) throws SQLException;
}
