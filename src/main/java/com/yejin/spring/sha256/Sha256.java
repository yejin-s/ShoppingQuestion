package com.yejin.spring.sha256;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256 {
	
	public String encrypt(String userPassword) throws NoSuchAlgorithmException{
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		md.update(userPassword.getBytes());
		
		return bytesToHex(md.digest());
	}
	
	public String bytesToHex(byte[] bytes) {
		
		StringBuilder builder = new StringBuilder();
		for(byte b : bytes) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}
}
