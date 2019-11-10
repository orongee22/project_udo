package com.wad.udo.member.service;

import java.util.Random;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.member.dao.MemberSessionDao;
import com.wad.udo.member.domain.MemberInfo;

@Service("forgotService")
public class ForgotService {

	@Autowired
	private MailService service;

	@Autowired
	private SqlSessionTemplate template;

	private MemberSessionDao dao;

	public int forgotId(String name, String email) {

		dao = template.getMapper(MemberSessionDao.class);

		MemberInfo info = dao.searchId(name, email);

		if (info != null) {
			service.sendId(info.getId(), info.getEmail(), info.getName());
			return 1;
		}
		return 0;
	}

	public int forgotPw(String id, String name, String email) {

		dao = template.getMapper(MemberSessionDao.class);

		MemberInfo info = dao.searchPw(id, name, email);
		int cnt = 0;

		if (info != null) {

			Random r = new Random(System.nanoTime());
			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < 14; i++) {
				// r.nextBoolean() == true : 숫자,
				// r.nextBoolean() == false : 영문자
				if (r.nextBoolean()) {
					sb.append(r.nextInt(10));
				} else {
					sb.append((char) (r.nextInt(26) + 97));
				}
			}
			cnt = dao.changeRandomPw(sb.toString(), info.getId());

			service.sendPw(info.getId(), info.getEmail(), info.getName(), sb.toString());
			return cnt;
		}
		return cnt;
	}

}
