package com.wad.udo.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wad.udo.member.domain.RequestLogin;
import com.wad.udo.member.service.LoginService;

@RequestMapping(value = "/member/login")
@RestController
public class LoginController {

	@Autowired
	private LoginService service;

	@GetMapping
	public String getLoginForm() {
		return "member/loginForm";
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> memberLogin(RequestLogin login, HttpServletRequest request) {

		int cnt = 0;

		cnt = service.login(login.getLogin_id(), login.getLogin_pw(), request);

		String loginId = (String) request.getSession().getAttribute("loginId");

		System.out.println(loginId);
		if (cnt == 2) {
			return new ResponseEntity<String>(loginId + "_notVerify", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(cnt == 1 ? loginId : "fail", HttpStatus.OK);
		}
	}

}
