package com.ntr153.telusko.springbootweb1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
        System.out.println("Home method called");
		return "index";
	}
	
	@RequestMapping("add")
	public String add(HttpServletRequest req,HttpSession session) {
		
		int num1=Integer.parseInt(req.getParameter("num1"));
		int num2=Integer.parseInt(req.getParameter("num2"));
		int result=num1+num2;
		session.setAttribute("result", result);

		System.out.println(session.getAttribute("result"));
		
		return "result";
	}

}