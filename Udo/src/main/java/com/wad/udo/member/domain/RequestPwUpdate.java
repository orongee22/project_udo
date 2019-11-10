package com.wad.udo.member.domain;

public class RequestPwUpdate {

	private int updateIdx;
	private String updatePw1;

	public int getUpdateIdx() {
		return updateIdx;
	}

	public void setUpdateIdx(int updateIdx) {
		this.updateIdx = updateIdx;
	}

	public String getUpdatePw1() {
		return updatePw1;
	}

	public void setUpdatePw1(String updatePw1) {
		this.updatePw1 = updatePw1;
	}

	@Override
	public String toString() {
		return "RequestPwUpdate [updateIdx=" + updateIdx + ", updatePw1=" + updatePw1 + "]";
	}

}
