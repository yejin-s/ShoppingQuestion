package com.yejin.spring.sha256;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 설예진
 * SHA-256 방식으로 비밀번호 암호화 하기 위한 클래스 / 
 * SHA-256 방식은 복구화가 안되는 단방향 암호화 방식이다.
 */
public class Sha256 {
	
	/**
	 * SHA-256으로 해싱하는 메서드
	 * @param userPassword
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public String encrypt(String userPassword) throws NoSuchAlgorithmException{
		
		// MessageDigest : 임의 크기의 데이터를 가져와 고정 길이 해시값을 출력하는 단방향 해시 함수
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		md.update(userPassword.getBytes());
		
		return bytesToHex(md.digest());
	}
	
	/**
	 * 바이트를 헥스값으로 변환
	 * @param bytes
	 * @return
	 */
	public String bytesToHex(byte[] bytes) {
		
		StringBuilder builder = new StringBuilder();
		for(byte b : bytes) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}
}
