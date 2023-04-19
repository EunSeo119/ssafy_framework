package com.ssafy.basic;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
//	@RequestMapping(value = "hello", method = RequestMethod.GET)
	@GetMapping("/hello")
	public ModelAndView hello() {
//		ModelAndView mav = new ModelAndView("basic/result", "msg", "안녕하세요 안효인입니다.");
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "안녕하세요 안효인입니다.");
		mav.setViewName("basic/result");
		return mav;
	}
	
	@GetMapping("/single")
	public String single() {
		return "single";
	}
	
	@PostMapping("/single")
//	public String single(String userid, String username, int area, Model model) {
	public String single(@RequestParam("userid") String userId, @RequestParam("username")String userName, @RequestParam(name = "area", required = true, defaultValue = "0") int area, Map<String, Object> map) {
		String msg = userName + "(" + userId + ")님의 지역 :: " + area;
		System.out.println(msg);
//		model.addAttribute("msg", msg);
		map.put("msg", msg);
		return "basic/result";
	}
	
	@GetMapping("/multi")
	public String multi() {
		return "multi";
	}
	
	@PostMapping("/multi")
	public String multi(ParamDto paramDto, ModelMap modelMap) {
		modelMap.addAttribute("msg", paramDto);
		return "basic/result";
	}
}
