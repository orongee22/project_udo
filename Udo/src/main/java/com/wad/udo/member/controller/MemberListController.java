package com.wad.udo.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wad.udo.member.domain.MemberInfo;
import com.wad.udo.member.service.MemberListService;

@RestController
@RequestMapping("/admin/memberlist")
public class MemberListController {

	@Autowired
	private MemberListService service;

	@CrossOrigin
	@GetMapping()
	public ResponseEntity<List<MemberInfo>> getAllList() {

		List<MemberInfo> list = service.getAllList();

		ResponseEntity<List<MemberInfo>> entitty = new ResponseEntity<List<MemberInfo>>(list, HttpStatus.OK);

		return entitty;
	}

}
