package com.yejin.spring.sha256;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author ������
 * SHA-256 ������� ��й�ȣ ��ȣȭ �ϱ� ���� Ŭ���� / 
 * SHA-256 ����� ����ȭ�� �ȵǴ� �ܹ��� ��ȣȭ ����̴�.
 */
public class Sha256 {
	
	/**
	 * SHA-256���� �ؽ��ϴ� �޼���
	 * @param userPassword
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public String encrypt(String userPassword) throws NoSuchAlgorithmException{
		
		// MessageDigest : ���� ũ���� �����͸� ������ ���� ���� �ؽð��� ����ϴ� �ܹ��� �ؽ� �Լ�
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		md.update(userPassword.getBytes());
		
		return bytesToHex(md.digest());
	}
	
	/**
	 * ����Ʈ�� �������� ��ȯ
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
