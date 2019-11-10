package com.wad.udo.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wad.udo.member.domain.RequestSignUp;
import com.wad.udo.member.service.SignUpService;

@RestController
@RequestMapping("/member/signup")
public class SignUpController {

	@Autowired
	private SignUpService service;

	@CrossOrigin
	@GetMapping
	public String getSignUpForm() {

		return "member/signUpForm";
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> memberRegist(RequestSignUp signup) {

		/* System.out.println(regist); */

		int cnt = service.memberInsert(signup);

		return new ResponseEntity<String>(cnt > 0 ? "success" : "fail", HttpStatus.OK);
	}
}
