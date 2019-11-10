package com.wad.udo.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wad.udo.member.domain.RequestPwUpdate;
import com.wad.udo.member.service.UpdateService;

@RequestMapping(value = "/member/pwupdate")
@RestController
public class PwUpdateController {

	@Autowired
	private UpdateService service;

	@CrossOrigin
	@PutMapping
	public ResponseEntity<String> memberPwUpdate(@RequestBody RequestPwUpdate pwUpdate) {
		int cnt = 0;
		System.out.println(pwUpdate);

		cnt = service.memberPwUpdate(pwUpdate);

		return new ResponseEntity<String>(cnt > 0 ? "success" : "fail", HttpStatus.OK);
	}

}
