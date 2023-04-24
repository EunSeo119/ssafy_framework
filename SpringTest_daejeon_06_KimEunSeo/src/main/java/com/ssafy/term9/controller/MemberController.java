package com.ssafy.term9.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.term9.model.Member;
import com.ssafy.term9.model.service.MemberService;


@Controller
@RequestMapping("/user")
public class MemberController {
	
	private MemberService memberService;
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@PostMapping("login")
	public String login(Member member, HttpSession session) throws Exception {
		Member userInfo = memberService.login(member);
		if(userInfo != null) {
			session.setAttribute("userInfo", userInfo);
			return "redirect:/board/regist";
		} else {			
			return "redirect:/";
		}
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";	// HomeController 보면 "/" 이게  index로 되어있어서 뒤에 index 안붙여줌!
	}
	
}
