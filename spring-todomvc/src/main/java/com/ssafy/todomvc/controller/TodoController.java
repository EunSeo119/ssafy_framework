package com.ssafy.todomvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.todomvc.model.Member;
import com.ssafy.todomvc.model.Todo;
import com.ssafy.todomvc.model.service.TodoService;
// 화면 위치 : WEB-INF/views/todo/index.jsp
@Controller
@RequestMapping("/todo")	// GetMapping PostMapping 할 때 앞에 붙여줌 "/" 도 없으면 붙여주고 있으면 안붙여줌 
public class TodoController {
	private final TodoService todoService;
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
//	@RequestMapping("/todo/list")	// GET, POST 모두 가능
//	@RequestMapping(value="/todo/list", method = RequestMethod.GET)	// GET 방식만 가능하게
//	@GetMapping(value="/todo/list")	// GET 방식만 가능하게
	@GetMapping("list")	// 하나니까 value 생략 가능
	public String listTodo(Model model) throws Exception {
//		return "/WEB-INF/view/todo/index.jsp";
//		List<Todo> list = todoService.listTodo();
		model.addAttribute("list", todoService.listTodo());
		return "todo/index";
	}
	
	@PostMapping("regist")
	public String registTodo(String content, HttpSession session) throws Exception {
		Member member = (Member) session.getAttribute("userInfo");
		Todo todo = new Todo();
		todo.setContent(content);
		todo.setUserId(member.getId());
		todoService.registTodo(todo);
//		return "redirect:/todo/list";
		return "redirect:list"; 	// "/" 없으면 뒤에만 바뀌기 때문에 이렇게도 가능!
	}
	
	@GetMapping("clear")
	public String clearTodo(HttpSession session) throws Exception {
		Member member = (Member) session.getAttribute("userInfo");
		todoService.clearTodo(member.getId());
		return "redirect:list";
	}
	
	@GetMapping("delete")
	public String deleteTodo(int no, String userId) throws Exception {
		todoService.deleteTodo(no, userId);
		return "redirect:list";
	}
	
	@PostMapping("login")
	public String login(Member member, HttpSession session) throws Exception {
		Member userInfo = todoService.login(member);
		if(userInfo != null) {
			session.setAttribute("userInfo", userInfo);
		}
		return "redirect:list";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:list";	// HomeController 보면 "/" 이게  index로 되어있어서 뒤에 index 안붙여줌!
	}
}







