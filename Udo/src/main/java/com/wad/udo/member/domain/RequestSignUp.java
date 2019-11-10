package com.wad.udo.member.domain;

public class RequestSignUp {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String phone;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "RequestMemberSignUp [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", phone="
				+ phone + "]";
	}

	public MemberInfo toMemberInfo() {
		MemberInfo info = new MemberInfo();
		info.setId(id);
		info.setPw(pw);
		info.setName(name);
		info.setEmail(email);
		info.setPhone(phone);
		return info;
	}

}
