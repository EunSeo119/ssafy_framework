package com.ssafy.todomvc.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.todomvc.model.Member;
import com.ssafy.todomvc.model.Todo;

public interface TodoService {
	void deleteTodo(int no, String userId) throws SQLException;
	void registTodo(Todo todo) throws SQLException;
	List<Todo> listTodo() throws SQLException;
	void clearTodo(String userId) throws SQLException;
	Member login(Member member) throws Exception;
}
