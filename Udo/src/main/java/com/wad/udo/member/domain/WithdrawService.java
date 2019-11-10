package com.wad.udo.member.domain;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.member.dao.MemberSessionDao;

@Service("withdrawService")
public class WithdrawService {

	@Autowired
	private SqlSessionTemplate template;

	private MemberSessionDao dao;

	public int deleteMember(int idx) {

		dao = template.getMapper(MemberSessionDao.class);

		int cnt = 0;

		cnt = dao.deleteMember(idx);

		return cnt;
	}

}
