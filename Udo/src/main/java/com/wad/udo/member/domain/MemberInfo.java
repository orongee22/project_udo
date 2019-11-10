package com.wad.udo.member.domain;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MemberInfo {
	private int idx;
	private String id;
	@JsonIgnore
	private String pw;
	private String name;
	private String email;
	private String phone;
	private String photo;
	@JsonIgnore
	private String code;
	private char verify;
	/* private Date regDate; */

	/*
	 * public Date getRegDate() { return regDate; }
	 * 
	 * public void setRegDate(Date regDate) { this.regDate = regDate; }
	 */

	@Override
	public String toString() {
		return "MemberInfo [idx=" + idx + ", id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email
				+ ", phone=" + phone + ", photo=" + photo + ", code=" + code + ", verify=" + verify + ", regDate="
				+ /* regDate + */"]";
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public char getVerify() {
		return verify;
	}

	public void setVerify(char verify) {
		this.verify = verify;
	}

	public MemberInfo() {
		/* this.regDate = new Date(); */
		getRandomString();
	}

	public MemberInfo(String id, String pw, String name, String email, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.phone = phone;
		/* this.regDate = new Date(); */
		getRandomString();
	}

	public boolean chkPw(String login_pw) {
		return pw != null && pw.trim().length() > 0 && pw.equals(login_pw);
	}

	// 영문 + 숫자 난수 발생
	private void getRandomString() {

		Random r = new Random(System.nanoTime());
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < 20; i++) {
			// r.nextBoolean() == true : 숫자,
			// r.nextBoolean() == false : 영문자
			if (r.nextBoolean()) {
				sb.append(r.nextInt(10));
			} else {
				sb.append((char) (r.nextInt(26) + 97));
			}
		}

		System.out.println("난수 코드 생성 : " + sb);

		setCode(sb.toString());
	}

}
