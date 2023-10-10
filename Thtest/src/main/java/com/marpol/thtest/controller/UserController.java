package com.marpol.thtest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.marpol.thtest.models.UserDto;
import com.marpol.thtest.service.UserService;

@SessionAttributes("USER")
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	protected final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(name = "ERROR", required = false)String error,
			@ModelAttribute("USER")UserDto userDto,
			 Model model) {
		
			model.addAttribute("ERROR", error);
		
		return "user/login";
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("USER")UserDto userDto, HttpSession httpSession, SessionStatus sessionStatus) {
	
		try {
			UserDto resultDto = userService.login(userDto);
			httpSession.setAttribute("LOGINUSER", resultDto);
		} catch (Exception e) {
			
			String message = e.getMessage();
			return "redirect:/user/login?ERROR=" + message;
		}
		
		sessionStatus.setComplete();
		return "redirect:/";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(@ModelAttribute UserDto userDto) {
		
		return "user/join";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(@ModelAttribute("USER")UserDto userDto, Model model, SessionStatus sessionStatus ) {
		
		int result = userService.join(userDto);
		sessionStatus.setComplete();
		
		return "redirect:/user/login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		
		httpSession.removeAttribute("LOGINUSER");
		return "redirect:/";
	}
	
	@ModelAttribute("USER")
	public UserDto userDto() {
		return new UserDto();
	}
}
