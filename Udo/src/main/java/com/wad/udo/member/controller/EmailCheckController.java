package com.wad.udo.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wad.udo.member.service.SignUpService;

@Controller
public class EmailCheckController {

	@Autowired
	private SignUpService service;

	@CrossOrigin
	@RequestMapping("/member/emailCheck")
	@ResponseBody
	public String emailCheck(@RequestParam("email") String email) {
		System.out.println(email);
		System.out.println(service.emailCheck(email));

		return service.emailCheck(email);
	}
}
