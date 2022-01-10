package com.yejin.spring.paging;

/**
 * @author ������
 * pageNum�� amount ���� ���� �����ϴ� �뵵 /
 * �����ڸ� ���ؼ� �⺻���� 1������, 10���� �����ؼ� ó��
 */
public class Criteria {
	
	/**
	 * ���� ������ ��ȣ
	 */
	private int pageNum;
	
	/**
	 * �� �������� ������ �Խù��� ��
	 */
	private int amount;
	
	// �����ڸ� ���ؼ� �⺻���� 1������, 10���� �����ؼ� ó��
	public Criteria() {
		this(1, 10);
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
