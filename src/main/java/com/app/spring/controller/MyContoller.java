package com.app.spring.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyContoller {

	@GetMapping("/")
	public String index(Model model, Principal principal) {
		model.addAttribute("message", "You are logged in as " + principal.getName());
		return "index";
	}

	@GetMapping("/test")
	public String getDetails() {
		return "index2";

	}

	// @PostMapping("/")
	// public String logMeOut(HttpSession hs,Model map,HttpServletRequest
	// request,HttpServletResponse response)
	// {
	// System.out.println("in logout method");
	// //retrieve user dtls from sesion scope & add it to model
	//// map.addAttribute("user_dtls",hs.getAttribute("user_dtls"));
	// //discard session
	// hs.invalidate();
	// response.setHeader("refresh", "10;url="+request.getContextPath());
	//
	// return "/login";
	// }

}
