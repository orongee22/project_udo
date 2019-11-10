package com.wad.udo.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wad.udo.member.domain.RequestUpdate;
import com.wad.udo.member.service.UpdateService;

@RequestMapping(value = "/member/update")
@RestController
public class UpdateController {

	@Autowired
	private UpdateService service;

	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> memberUpdate(RequestUpdate update, HttpServletRequest request) {

		int cnt = 0;

		System.out.println(update);

		cnt = service.memberUpdate(update, request);

		return new ResponseEntity<String>(cnt > 0 ? "success" : "fail", HttpStatus.OK);
	}

}
