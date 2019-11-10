
package com.wad.udo.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.member.dao.MemberSessionDao;
import com.wad.udo.member.domain.MemberInfo;

@Service("listService")
public class MemberListService {

	// 페이지에 표시될 수 final int MEMBER_CNT_LIST = 3;

	@Autowired
	private SqlSessionTemplate template;

	private MemberSessionDao dao;

	public List<MemberInfo> getAllList() {
		dao = template.getMapper(MemberSessionDao.class);

		List<MemberInfo> list = dao.selectAllList();

		return list;
	}

}
