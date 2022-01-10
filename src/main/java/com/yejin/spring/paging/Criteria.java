package com.yejin.spring.paging;

/**
 * @author 설예진
 * pageNum과 amount 값을 같이 전달하는 용도 /
 * 생성자를 통해서 기본값을 1페이지, 10개로 지정해서 처리
 */
public class Criteria {
	
	/**
	 * 현재 페이지 번호
	 */
	private int pageNum;
	
	/**
	 * 한 페이지에 나오는 게시물의 수
	 */
	private int amount;
	
	// 생성자를 통해서 기본값을 1페이지, 10개로 지정해서 처리
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
