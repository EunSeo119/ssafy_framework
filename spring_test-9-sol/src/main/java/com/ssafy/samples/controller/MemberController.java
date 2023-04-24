package com.ssafy.samples.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.samples.model.User;
import com.ssafy.samples.model.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {

	private MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@PostMapping("/login")
	public String login(User user, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		User rtn = memberService.login(user);

		if (rtn != null) {
			session.setAttribute("userInfo", rtn);
		} else {
			redirectAttributes.addFlashAttribute("msg", "id 또는 pass 를 확인하세요");
		}

		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();

		return "redirect:/";
	}
}
