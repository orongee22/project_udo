package com.wad.udo.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.member.dao.MemberSessionDao;
import com.wad.udo.member.domain.MemberInfo;

@Service("verifyService")
public class VerifyService {

	@Autowired
	private MailService service;

	@Autowired
	private SqlSessionTemplate template;

	private MemberSessionDao dao;

	public String verify(String id, String code) {

		dao = template.getMapper(MemberSessionDao.class);

		int cnt = dao.verify(id, code);

		return cnt > 0 ? "Success" : "Fail";
	}

	public int reMailSend(String id) {

		dao = template.getMapper(MemberSessionDao.class);

		MemberInfo info = dao.selectMemberById(id);

		if (info != null) {
			service.send(info.getId(), info.getEmail(), info.getName(), info.getCode());
			return 1;
		}
		return 0;
	}
}
