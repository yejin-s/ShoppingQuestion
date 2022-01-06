package com.yejin.spring.vo;

import java.util.Date;

public class ShoppingJoinUserVo {

	/**
	 * 유저 아이디
	 */
	private String userId;
	
	/**
	 * 유저 비밀번호
	 */
	private String userPassword;
	
	/**
	 * 유저 이름
	 */
	private String userName;
	
	/**
	 * 유저 등록일
	 */
	private Date userJoindate;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getUserJoindate() {
		return userJoindate;
	}

	public void setUserJoindate(Date userJoindate) {
		this.userJoindate = userJoindate;
	}
	
	
}
