package com.wad.udo.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wad.udo.member.domain.MemberInfo;
import com.wad.udo.member.service.MyPageService;

@RestController
@RequestMapping(value = "/member/mypage")
public class MyPageController {

	@Autowired
	private MyPageService service;

	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<MemberInfo> myInfo(@PathVariable("id") String id) {
		MemberInfo info = service.getInfo(id);
		/* System.out.println(info); */
		return new ResponseEntity<MemberInfo>(info, HttpStatus.OK);
	}

}
