package com.wad.udo.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wad.udo.member.domain.WithdrawService;

@RestController
@RequestMapping("/member/withdraw")
public class WithDrawController {

	@Autowired
	private WithdrawService service;

	@CrossOrigin
	@DeleteMapping("/{idx}")
	public ResponseEntity<String> memberDelete(@PathVariable("idx") int idx) {

		System.out.println(idx);

		return new ResponseEntity<String>(service.deleteMember(idx) > 0 ? "success" : "fail", HttpStatus.OK);

	}

}