package com.yejin.spring.vo;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import com.yejin.spring.sha256.Sha256;

/**
 * @author 설예진
 * 유저 Vo
 */
public class ShoppingUserVo {

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
		
		Sha256 sha256 = new Sha256();
		String encryptPassword = null;
		
		try {
			// Sha256 객체를 만들어 입력한 비밀번호를 암호화 한다.
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
