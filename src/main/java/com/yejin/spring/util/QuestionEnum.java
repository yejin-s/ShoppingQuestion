package com.yejin.spring.util;

/**
 * @author 설예진
 * 예외처리에서 사용할 결과 Enum 타입 /
 * 성공 : 0000 , 실패 : 9999
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

