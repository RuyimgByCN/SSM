package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "login")
	public ModelAndView Login(User user) {
		ModelAndView mav = new ModelAndView("index", "user1", user);
		return mav;
	}

	@RequestMapping(value = "login1")
	@ResponseBody
	public User Login1(User user) {
		ModelAndView mav = new ModelAndView("index", "user1", user);
		return user;

	}
	
	@RequestMapping(value = "login2")
	public ModelAndView Login3(User user,HttpServletRequest request) {
		request.getSession().setAttribute("loginuser", user);
		ModelAndView mav = new ModelAndView("index", "user1", user);
		return mav;
	}
	
	@RequestMapping(value = "login3")
	public ModelAndView Login2(User user,HttpServletRequest request) {
		if(user.getUname().equals("admin")&&user.getUpwd().equals("123")) {
		request.getSession().setAttribute("loginuser", user);
		ModelAndView mav = new ModelAndView("index", "user1", user);
		return mav;
		}
		ModelAndView mav = new ModelAndView("error");
		return mav;
	}
	
}
