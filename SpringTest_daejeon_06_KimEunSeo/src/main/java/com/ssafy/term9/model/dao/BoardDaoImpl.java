package com.ssafy.term9.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.term9.model.Board;

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
				PreparedStatement pstmt = conn.prepareStatement("select * from attendance ");
		) {
			ResultSet rs = pstmt.executeQuery();

			List<Board> list = new ArrayList<>();
			while (rs.next()) {
				Board board = new Board();

				board.setAno(rs.getString("ano"));
				board.setUserid(rs.getString("userid"));
				board.setIssuedate(rs.getString("issuedate"));
				board.setIssue(rs.getString("issue"));

				list.add(board);
			}
			return list;
		}
	}

//	@Override
//	public Board selectBoard(String code) throws SQLException {
//		try (
//				Connection conn = dataSource.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement("select * from product where code = ?");
//		) {
//			pstmt.setString(1, code);
//			ResultSet rs = pstmt.executeQuery();
//
//			if (rs.next()) {
//				Board board = new Board();
//
//				board.setCode(rs.getString("code"));
//				board.setModel(rs.getString("model"));
//				board.setPrice(rs.getInt("price"));
//
//				return board;
//			}
//			return null;
//		}
//	}

	@Override
	public void insertBoard(Board board) throws SQLException {
		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("insert into attendance (ano, userid, issuedate, issue) values (?, ?, ?, ?)");
		) {

			int idx = 0;
			pstmt.setString(++idx, board.getAno());
			pstmt.setString(++idx, board.getUserid());
			pstmt.setString(++idx, board.getIssuedate());
			pstmt.setString(++idx, board.getIssue());

			pstmt.executeUpdate();
		}
	}
	
	@Override
	public Board selectBoardByPk(int ano) throws SQLException {
		try(
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
				"select a.ano, a.userid, u.name, u.rclass, u.rname, a.issuedate, a.issue from attendance a join userinfo u on a.userid = u.userid where ano =?"
			);
		){
			pstmt.setInt(1, ano);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Board b = new Board();
				b.setAno(rs.getString("ano"));
				b.setUserid(rs.getString("userid"));
				b.setName(rs.getString("name"));
				b.setRclass(rs.getInt("rclass"));
				b.setRname(rs.getString("rname"));
				b.setIssuedate(rs.getString("issuedate"));
				b.setIssue(rs.getString("issue"));
				return b;
			}
		}
		return null;
	}

	@Override
	public void deleteBoard(String ano) throws SQLException {
		try(
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
				"delete from attendance where ano = ?"
			);
		){
			pstmt.setString(1, ano);
			pstmt.executeUpdate();
		}
	}

}
