package com.wad.udo.member.dao;

import java.util.List;

import com.wad.udo.member.domain.MemberInfo;
import com.wad.udo.member.domain.RequestPwUpdate;

public interface MemberSessionDao {

	public int insertMember(MemberInfo memberInfo);

	public MemberInfo selectMemberById(String id);

	public MemberInfo selectMemberByEmail(String email);

	public int updateMember(MemberInfo memberInfo);

	public int updateMemberPw(RequestPwUpdate pwUpdate);

	public List<MemberInfo> selectAllList();

	public int verify(String id, String code);

	public MemberInfo searchId(String name, String email);

	public MemberInfo searchPw(String id, String name, String email);

	public int changeRandomPw(String pw, String id);

	public int deleteMember(int idx);
}
