package com.ssafy.todomvc.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.todomvc.model.Member;
import com.ssafy.todomvc.model.Todo;
import com.ssafy.todomvc.model.dao.TodoDao;

@Service
public class TodoServiceImpl implements TodoService {
	private final TodoDao todoDao;
	public TodoServiceImpl(TodoDao todoDao) {
		this.todoDao = todoDao;
	}

	@Override
	public void clearTodo(String userId) throws SQLException {
		todoDao.deleteAllTodo(userId);
	}
	
	@Override
	public void deleteTodo(int no, String userId) throws SQLException {
		todoDao.deleteTodo(no, userId);
	}

	@Override
	public void registTodo(Todo todo) throws SQLException {
		todoDao.insertTodo(todo);
	}

	@Override
	public List<Todo> listTodo() throws SQLException {
		return todoDao.selectTodo();
	}

	@Override
	public Member login(Member member) throws Exception {
		return todoDao.selectLogin(member);
	}
}















