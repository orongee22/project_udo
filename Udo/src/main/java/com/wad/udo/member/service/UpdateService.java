package com.wad.udo.member.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wad.udo.member.dao.MemberSessionDao;
import com.wad.udo.member.domain.MemberInfo;
import com.wad.udo.member.domain.RequestPwUpdate;
import com.wad.udo.member.domain.RequestUpdate;

@Service(value = "updateService")
public class UpdateService {

	@Autowired
	private SqlSessionTemplate template;

	private MemberSessionDao dao;

	public int memberUpdate(RequestUpdate update, HttpServletRequest request) {

		dao = template.getMapper(MemberSessionDao.class);

		int cnt = 0;

		String path = "/uploadfile/userphoto";

		String dir = request.getSession().getServletContext().getRealPath(path);

		MemberInfo info = update.toMemberInfo();

		try {
			if (update.getUpdatePhoto() != null) {
				String newFileName = update.getUpdateIdx() + "_" + update.getUpdatePhoto().getOriginalFilename();
				new File(dir, newFileName).delete();

				info.setPhoto(newFileName);
				update.getUpdatePhoto().transferTo(new File(dir, newFileName));
			}

			cnt = dao.updateMember(info);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("파일 업로드 오류");
		}

		/* int cnt = dao.updateMember(update); */

		return cnt;
	}

	public int memberPwUpdate(RequestPwUpdate pwUpdate) {

		dao = template.getMapper(MemberSessionDao.class);
		int cnt = dao.updateMemberPw(pwUpdate);
		return cnt;
	}
}
