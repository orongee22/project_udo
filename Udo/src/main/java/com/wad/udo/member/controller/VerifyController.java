package com.wad.udo.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wad.udo.member.service.VerifyService;

@Controller
public class VerifyController {

	@Autowired
	private VerifyService service;

	@RequestMapping("/member/verify")
	public String verify(@RequestParam("id") String id, @RequestParam("code") String code) {

		String verifyResult = service.verify(id, code);
		return "member/verify" + verifyResult;
	}

	@CrossOrigin
	@RequestMapping("/member/remail")
	@ResponseBody
	public String reSendMail(@RequestParam("id") String id) {

		if (id != null) {
			service.reMailSend(id);
			return "success";
		} else {
			return "fail";
		}
	}
}
