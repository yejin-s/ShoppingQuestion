package com.yejin.spring.util;

/**
 * @author ������
 * ����ó������ ����� ��� Enum Ÿ�� /
 * ���� : 0000 , ���� : 9999
 */
public enum QuestionEnum {

	RESULT_SUCCESS("0000")
	, RESULT_FAIL("9999")
	;

	private final String value;

	private QuestionEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}

