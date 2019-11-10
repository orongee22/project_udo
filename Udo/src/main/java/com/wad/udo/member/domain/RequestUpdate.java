package com.wad.udo.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class RequestUpdate {
	private int updateIdx;
	private String updateName;
	private String updateEmail;
	private String updatePhone;
	private MultipartFile updatePhoto;

	public int getUpdateIdx() {
		return updateIdx;
	}

	public void setUpdateIdx(int updateIdx) {
		this.updateIdx = updateIdx;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public String getUpdateEmail() {
		return updateEmail;
	}

	public void setUpdateEmail(String updateEmail) {
		this.updateEmail = updateEmail;
	}

	public String getUpdatePhone() {
		return updatePhone;
	}

	public void setUpdatePhone(String updatePhone) {
		this.updatePhone = updatePhone;
	}

	public MultipartFile getUpdatePhoto() {
		return updatePhoto;
	}

	public void setUpdatePhoto(MultipartFile updatePhoto) {
		this.updatePhoto = updatePhoto;
	}

	@Override
	public String toString() {
		return "RequestUpdate [updateIdx=" + updateIdx + ", updateName=" + updateName + ", updateEmail=" + updateEmail
				+ ", updatePhone=" + updatePhone + ", updatePhoto=" + updatePhoto.getOriginalFilename() + "]";
	}

	public MemberInfo toMemberInfo() {
		MemberInfo info = new MemberInfo();
		info.setIdx(updateIdx);
		info.setName(updateName);
		info.setEmail(updateEmail);
		info.setPhone(updatePhone);

		return info;
	}

}
