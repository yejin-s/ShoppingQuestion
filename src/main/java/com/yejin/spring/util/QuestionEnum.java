package com.yejin.spring.util;

/**
 * @author 설예진 예외처리에서 사용할 결과 Enum 타입 / 
 * 작성 성공 : 0001, 작성 실패 : 9991 /
 * 삭제 성공 : 0002, 삭제 실패 : 9991 /
 * 수정 성공 : 0003, 수정 실패 : 9993 / 
 * 가입 성공 : 0004, 가입 실패 : 9994
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
