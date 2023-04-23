package com.ssafy.todomvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.todomvc.model.Member;
import com.ssafy.todomvc.model.Todo;

@Repository
public class TodoDaoImpl implements TodoDao {
	private final DataSource dataSource;
	
	public TodoDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void deleteAllTodo(String userId) throws SQLException {
		try(
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from todo where user_id = ?");
		){
			pstmt.setString(1, userId);
			pstmt.executeUpdate();
		}
	}
	
	@Override
	public void deleteTodo(int no, String userId) throws SQLException {
		try(
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from todo where no = ? and user_id = ?");
		){
			pstmt.setInt(1, no);
			pstmt.setString(2, userId);
			pstmt.executeUpdate();
		}
	}

	@Override
	public void insertTodo(Todo todo) throws SQLException {
		try(
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into todo(content, user_id) values(?, ?)");
		){
			pstmt.setString(1, todo.getContent());
			pstmt.setString(2, todo.getUserId());
			pstmt.executeUpdate();
		}
	}

	@Override
	public List<Todo> selectTodo() throws SQLException {
		List<Todo> list = new ArrayList<Todo>();
		try(
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select no, content from todo order by no");
		){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Todo todo = new Todo();
				todo.setNo(rs.getInt("no"));
				todo.setContent(rs.getString("content"));
				list.add(todo);
			}
		}
		return list;
	}

	@Override
	public Member selectLogin(Member member) throws SQLException {
		try(
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
				"select id, name, password from user where id = ? and password = ?"
			);
		){
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Member userInfo = new Member();
				userInfo.setId(rs.getString("id"));
				userInfo.setPassword(rs.getString("password"));
				userInfo.setName(rs.getString("name"));
				return userInfo;
			}
		}
		return null;
	}
}















