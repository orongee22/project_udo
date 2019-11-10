package com.wad.udo.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.member.dao.MemberSessionDao;
import com.wad.udo.member.domain.MemberInfo;

@Service(value = "myPageService")
public class MyPageService {

	@Autowired
	private SqlSessionTemplate template;

	private MemberSessionDao dao;

	public MemberInfo getInfo(String id) {

		dao = template.getMapper(MemberSessionDao.class);

		MemberInfo memberInfo = null;

		memberInfo = dao.selectMemberById(id);

		return memberInfo;

	}
}
