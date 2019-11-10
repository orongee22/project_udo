package com.wad.udo.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wad.udo.member.service.ForgotService;

@Controller
public class ForgotController {

	@Autowired
	private ForgotService service;

	@CrossOrigin
	@RequestMapping("/member/forgotId")
	@ResponseBody
	public String forgotId(@RequestParam("name") String name, @RequestParam("email") String email) {

		int cnt = service.forgotId(name, email);

		return cnt > 0 ? "success" : "fail";
	}

	@CrossOrigin
	@RequestMapping("/member/forgotPw")
	@ResponseBody
	public String forgotPw(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("email") String email) {

		int cnt = service.forgotPw(id, name, email);

		return cnt > 0 ? "success" : "fail";
	}
}
