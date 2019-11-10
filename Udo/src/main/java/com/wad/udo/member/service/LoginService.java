package com.wad.udo.member.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.member.dao.MemberSessionDao;
import com.wad.udo.member.domain.MemberInfo;

@Service(value = "loginService")
public class LoginService {

	@Autowired
	private SqlSessionTemplate template;

	private MemberSessionDao dao;

	public int login(String id, String pw, HttpServletRequest request) {

		dao = template.getMapper(MemberSessionDao.class);

		MemberInfo memberInfo = null;

		memberInfo = dao.selectMemberById(id);

		int cnt = 0;
		if (memberInfo != null && memberInfo.chkPw(pw)) {
			request.getSession(true).setAttribute("loginId", memberInfo.getId());
			if (memberInfo.getVerify() == 'N') {
				cnt = 2;
			} else {
				cnt = 1;
			}
		}
		return cnt;
	}

	public int chkMember(String id, String pw) {

		dao = template.getMapper(MemberSessionDao.class);

		MemberInfo memberInfo = null;

		memberInfo = dao.selectMemberById(id);

		int cnt = 0;
		if (memberInfo != null && memberInfo.chkPw(pw)) {

			cnt = 1;
			return cnt;
		}
		return cnt;
	}

}
