package com.yejin.spring.vo;

import java.util.Date;

public class ShoppingQuestionBoardVo {

	// �Խñ� ��ȣ
	int questionNumber;
	
	// �ۼ���
	String questionUser;
	
	// ����
	String questionTitle;
	
	// ����
	String questionContent;	
	
	// �����
	Date questionRegDate;
	
	// ������
	Date qeustionModityRegDate;		
	
	// ���� ����
	String questionDeleteCheck;
	
	
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
	public String getQuestionUser() {
		return questionUser;
	}
	public void setQuestionUser(String questionUser) {
		this.questionUser = questionUser;
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
	public Date getQuestionRegDate() {
		return questionRegDate;
	}
	public void setQuestionRegDate(Date questionRegDate) {
		this.questionRegDate = questionRegDate;
	}
	public Date getQeustionModityRegDate() {
		return qeustionModityRegDate;
	}
	public void setQeustionModityRegDate(Date qeustionModityRegDate) {
		this.qeustionModityRegDate = qeustionModityRegDate;
	}
}
