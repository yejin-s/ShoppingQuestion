package com.yejin.spring.vo;

import java.util.Date;

/**
 * @author ������
 * ���θ� ���ǰԽ��� Vo
 */
public class ShoppingQuestionVo {

	/**
	 * �Խñ� ��ȣ
	 */
	private int questionNumber;
	
	/**
	 * �ۼ���
	 */
	private String userId;
	
	/**
	 * ����
	 */
	private String questionTitle;
	
	/**
	 * ����
	 */
	private String questionContent;	
	
	/**
	 * �����
	 */
	private Date questionRegdate;
	
	/**
	 * ������
	 */
	private Date questionModityRegdate;		
	
	/**
	 * ���� ���� (Y: ����, N: �̻���)
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
