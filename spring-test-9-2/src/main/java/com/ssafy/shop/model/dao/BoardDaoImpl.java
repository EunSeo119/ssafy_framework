package com.ssafy.shop.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.shop.model.Board;

@Repository
public class BoardDaoImpl implements BoardDao {

	private DataSource dataSource;

	public BoardDaoImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<Board> selectList() throws SQLException {
		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from product ");
		) {
			ResultSet rs = pstmt.executeQuery();

			List<Board> list = new ArrayList<>();
			while (rs.next()) {
				Board board = new Board();

				board.setCode(rs.getString("code"));
				board.setModel(rs.getString("model"));
				board.setPrice(rs.getInt("price"));

				list.add(board);
			}
			return list;
		}
	}

	@Override
	public Board selectBoard(String code) throws SQLException {
		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from product where code = ?");
		) {
			pstmt.setString(1, code);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Board board = new Board();

				board.setCode(rs.getString("code"));
				board.setModel(rs.getString("model"));
				board.setPrice(rs.getInt("price"));

				return board;
			}
			return null;
		}
	}

	@Override
	public void insertBoard(Board board) throws SQLException {
		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("insert into product (code, model, price) values (?, ?, ?)");
		) {

			int idx = 0;
			pstmt.setString(++idx, board.getCode());
			pstmt.setString(++idx, board.getModel());
			pstmt.setInt(++idx, board.getPrice());

			pstmt.executeUpdate();
		}
	}

}
