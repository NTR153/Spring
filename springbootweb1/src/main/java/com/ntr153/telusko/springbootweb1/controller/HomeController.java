package com.ntr153.telusko.springbootweb1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	// http://localhost:8080/
	@GetMapping("/")
	public String home() {
        System.out.println("Home method called");
		return "homeIndex";
	}
	
	// http://localhost:8080/add?num1=5&num2=6
	@GetMapping("add")
	public String add(HttpServletRequest req,HttpSession session) {
		
		int num1=Integer.parseInt(req.getParameter("num1"));
		int num2=Integer.parseInt(req.getParameter("num2"));
		int result=num1+num2;
		
		session.setAttribute("additionResult", result);
		
		System.out.println("Add - " + session.getAttribute("additionResult"));
		
		return "additionResult";
	}

	// http://localhost:8080/subtract?num1=5&num2=6
	@GetMapping("subtract")
	public String subtract(@RequestParam("num1") int num1, int num2, Model model) {
						// @RequestParam("xyz") int abc -> xyz is url name, abc is local name
						// if same, no need to have @RequestParam annotation
		
		int result=num1-num2;
		
		model.addAttribute("subtractionResult", result);
		
		System.out.println("Subtract - " + model.getAttribute("subtractionResult"));
		
		return "subtractionResult";
	}

	// http://localhost:8080/multiply?num1=5&num2=6
	@GetMapping("multiply")
	public ModelAndView multiply(@RequestParam("num1") int num1, int num2, ModelAndView modelAndView) {
		
		int result=num1*num2;
		
		modelAndView.addObject("multiplicationResult", result);
		modelAndView.setViewName("multiplicationResult");

		System.out.println("Multiply - " + modelAndView.getModel().get("multiplicationResult"));
		
		return modelAndView;
	}
}