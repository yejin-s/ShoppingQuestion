package com.yejin.spring.paging;

public class PageVo {
	
	/**
	 * 시작페이지
	 */
	private int startPage;
	
	/**
	 * 마지막페이지
	 */
	private int endPage;
	
	/**
	 * 이전페이지
	 */
	private boolean prev;
	
	/**
	 * 다음페이지
	 */
	private boolean next;
	
	/**
	 * 전체 게시글 수
	 */
	private int total;
	
	/**
	 * 요청한 페이지번호, 한페이지당 글개수
	 */
	private Criteria cri;
	
	public PageVo(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		// Math.ceil : 소수점을 올림 처리
		// 5는 페이지블로을 구성하는 페이지 개수
		this.endPage = (int)(Math.ceil(cri.getPageNum()/5.0)) * 5;
		this.startPage = this.endPage - (5-1);
		
		// 실제 끝페이지
		int realEnd = (int)Math.ceil((double)total / cri.getAmount());
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}

	
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	
}
