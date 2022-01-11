package com.yejin.spring.util;

/**
 * @author ������ ����ó������ ����� ��� Enum Ÿ�� / 
 * �ۼ� ���� : 0001, �ۼ� ���� : 9991 /
 * ���� ���� : 0002, ���� ���� : 9991 /
 * ���� ���� : 0003, ���� ���� : 9993 / 
 * ���� ���� : 0004, ���� ���� : 9994
 */
public enum QuestionEnum {

	WRITE_SUCCESS("0001")
	, WRITE_FAIL("9991")
	, DELETE_SUCCESS("0002")
	, DELETE_FAIL("9992")
	, UPDATE_SUCCESS("0003")
	, UPDATE_FAIL("9993")
	, JOIN_SUCCESS("0004")
	, JOIN_FAIL("9994");

	private final String value;

	private QuestionEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
