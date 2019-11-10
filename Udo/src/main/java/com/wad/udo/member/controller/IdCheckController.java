package com.wad.udo.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wad.udo.member.service.SignUpService;

@Controller
public class IdCheckController {

	@Autowired
	private SignUpService service;

	@CrossOrigin
	@RequestMapping("/member/idCheck")
	@ResponseBody
	public String idCheck(@RequestParam("id") String id) {

		System.out.println(id);
		System.out.println(service.idCheck(id));

		return service.idCheck(id);
	}
}
