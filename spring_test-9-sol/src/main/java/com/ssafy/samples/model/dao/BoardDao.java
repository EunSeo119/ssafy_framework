package com.ssafy.samples.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.samples.model.Board;

public interface BoardDao {

	List<Board> selectList() throws SQLException;

	Board selectBoard(String code) throws SQLException;

	void insertBoard(Board board) throws SQLException;
}
