package com.yejin.spring.vo;

public class PagingVo {
	
	// 페이지의 시작 게시물 번호
	private int startQuestionNumber = 1;
	
	// 페이지의 끝 게시물 번호
	private int endQuestionNumber = 5;
	
	// 페이지
	private int pageNumber = 0;
	
	// 한 페이지 당 보여줄 게시물 수
	private int pageTotalQuestionNumber = 5;
	
	// 검색기능 박스 : 작성자, 제목, 내용 
	private String searchSelect;
	
	// 검색기능 검색어
	private String searchKeyword;
	
	// 검색기능 시작 날짜
	private String startDate;
	
	// 검색기능 끝 날짜
	private String endDate;

	public int getStartQuestionNumber() {
		return startQuestionNumber;
	}

	public void setStartQuestionNumber(int startQuestionNumber) {
		this.startQuestionNumber = startQuestionNumber;
	}

	public int getEndQuestionNumber() {
		return endQuestionNumber;
	}

	public void setEndQuestionNumber(int endQuestionNumber) {
		this.endQuestionNumber = endQuestionNumber;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageTotalQuestionNumber() {
		return pageTotalQuestionNumber;
	}

	public void setPageTotalQuestionNumber(int pageTotalQuestionNumber) {
		this.pageTotalQuestionNumber = pageTotalQuestionNumber;
	}

	public String getSearchSelect() {
		return searchSelect;
	}

	public void setSearchSelect(String searchSelect) {
		this.searchSelect = searchSelect;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	

}
