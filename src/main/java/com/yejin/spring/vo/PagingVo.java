package com.yejin.spring.vo;

public class PagingVo {
	
	// �������� ���� �Խù� ��ȣ
	private int startQuestionNumber = 1;
	
	// �������� �� �Խù� ��ȣ
	private int endQuestionNumber = 5;
	
	// ������
	private int pageNumber = 0;
	
	// �� ������ �� ������ �Խù� ��
	// �α��� �� �� ������ �� 5���� �Խù��� �����ֱ� ���� �⺻�� �ֱ�
	private int pageTotalQuestionNumber = 5;
	
	// �˻���� �ڽ� : �ۼ���, ����, ���� 
	private String searchType;
	
	// �˻���� �˻���
	private String searchKeyword;
	
	// �˻���� ���� ��¥
	private String startDate;
	
	// �˻���� �� ��¥
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

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
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
