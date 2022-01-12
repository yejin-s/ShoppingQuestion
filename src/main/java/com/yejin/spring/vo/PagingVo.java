package com.yejin.spring.vo;

public class PagingVo {
	
	private int startQuestionNumber = 1;
	
	private int endQuestionNumber = 5;
	
	private int pageNumber = 0;
	
	private int pageTotalQuestionNumber = 5;

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




	
	
}
