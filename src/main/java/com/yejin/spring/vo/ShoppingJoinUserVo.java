package com.yejin.spring.vo;

import java.util.Date;

public class ShoppingJoinUserVo {

	/**
	 * ���� ���̵�
	 */
	private String userId;
	
	/**
	 * ���� ��й�ȣ
	 */
	private String userPassword;
	
	/**
	 * ���� �̸�
	 */
	private String userName;
	
	/**
	 * ���� �����
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
