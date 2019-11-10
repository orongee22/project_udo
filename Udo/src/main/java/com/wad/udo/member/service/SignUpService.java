package com.wad.udo.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.member.dao.MemberSessionDao;
import com.wad.udo.member.domain.MemberInfo;
import com.wad.udo.member.domain.RequestSignUp;

@Service(value = "signUpService")
public class SignUpService {

	@Autowired
	MailService mailService;

	@Autowired
	private SqlSessionTemplate template;

	private MemberSessionDao dao;

	public int memberInsert(RequestSignUp signup) {

		// dao 생성
		dao = template.getMapper(MemberSessionDao.class);

		MemberInfo memberInfo = signup.toMemberInfo();

		int cnt = 0;

		if (memberInfo != null) {
			memberInfo.setPhoto("no_img.jpg");

			cnt = dao.insertMember(memberInfo);

			mailService.send(memberInfo.getId(), memberInfo.getEmail(), memberInfo.getName(), memberInfo.getCode());

		}

		return cnt;
	}

	public String idCheck(String id) {
		dao = template.getMapper(MemberSessionDao.class);

		String chk = dao.selectMemberById(id) == null ? "Y" : "N";
		return chk;
	}

	public String emailCheck(String email) {

		dao = template.getMapper(MemberSessionDao.class);
		
		String chk = dao.selectMemberByEmail(email) == null ? "Y" : "N";
		return chk;
	}
}
