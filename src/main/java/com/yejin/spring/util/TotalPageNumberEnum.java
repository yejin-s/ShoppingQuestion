package com.yejin.spring.util;

public enum TotalPageNumberEnum {

	TOTAL_PAGE_5("5","5")
	,TOTAL_PAGE_10("10","10")
	,TOTAL_PAGE_15("15","15")
	,TOTAL_PAGE_20("20","20");
	
	private String code;
	private String name;
	
	private TotalPageNumberEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
}
