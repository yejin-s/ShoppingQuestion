package com.yejin.spring.vo;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import com.yejin.spring.sha256.Sha256;

/**
 * @author ������
 * ���� Vo
 */
public class ShoppingUserVo {

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
		
		Sha256 sha256 = new Sha256();
		String encryptPassword = null;
		
		try {
			// Sha256 ��ü�� ����� �Է��� ��й�ȣ�� ��ȣȭ �Ѵ�.
			encryptPassword = sha256.encrypt(userPassword);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return encryptPassword;
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
