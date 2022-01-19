package com.yejin.spring.vo;

import java.util.Date;

/**
 * @author 설예진
 * 쇼핑몰 문의게시판 Vo
 */
public class ShoppingQuestionVo {

	/**
	 * 게시글 번호
	 */
	private int questionNumber;
	
	/**
	 * 작성자
	 */
	private String userId;
	
	/**
	 * 제목
	 */
	private String questionTitle;
	
	/**
	 * 내용
	 */
	private String questionContent;	
	
	/**
	 * 등록일
	 */
	private Date questionRegdate;
	
	/**
	 * 수정일
	 */
	private Date questionModityRegdate;		
	
	/**
	 * 삭제 여부 (Y: 삭제, N: 미삭제)
	 */
	private String questionDeleteCheck;
	
	private int rowNumber;
	
	
	public String getQuestionDeleteCheck() {
		return questionDeleteCheck;
	}
	public void setQuestionDeleteCheck(String questionDeleteCheck) {
		this.questionDeleteCheck = questionDeleteCheck;
	}
	public int getQuestionNumber() {
		return questionNumber;
	}
	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public Date getQuestionRegdate() {
		return questionRegdate;
	}
	public void setQuestionRegdate(Date questionRegdate) {
		this.questionRegdate = questionRegdate;
	}
	public Date getQuestionModityRegdate() {
		return questionModityRegdate;
	}
	public void setQuestionModityRegdate(Date questionModityRegdate) {
		this.questionModityRegdate = questionModityRegdate;
	}
	public int getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}


}
