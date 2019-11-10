package com.wad.udo.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wad.udo.member.domain.RequestLogin;
import com.wad.udo.member.service.LoginService;

@RestController
@RequestMapping("/member/pwcheck")
public class PwCheckController {

	@Autowired
	private LoginService service;

	@CrossOrigin
	@GetMapping
	public String getPwUpdateForm() {

		return "member/pwCheckForm";
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> memberPwUpdate(@RequestBody RequestLogin login) {
		System.out.println(login.getLogin_id());
		System.out.println(login.getLogin_pw());

		int cnt = service.chkMember(login.getLogin_id(), login.getLogin_pw());
		return new ResponseEntity<String>(cnt > 0 ? "success" : "fail", HttpStatus.OK);
	}

}
