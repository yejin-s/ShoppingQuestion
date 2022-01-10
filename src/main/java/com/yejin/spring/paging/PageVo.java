package com.yejin.spring.paging;

public class PageVo {
	
	/**
	 * ����������
	 */
	private int startPage;
	
	/**
	 * ������������
	 */
	private int endPage;
	
	/**
	 * ����������
	 */
	private boolean prev;
	
	/**
	 * ����������
	 */
	private boolean next;
	
	/**
	 * ��ü �Խñ� ��
	 */
	private int total;
	
	/**
	 * ��û�� ��������ȣ, ���������� �۰���
	 */
	private Criteria cri;
	
	public PageVo(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		// Math.ceil : �Ҽ����� �ø� ó��
		// 5�� ����������� �����ϴ� ������ ����
		this.endPage = (int)(Math.ceil(cri.getPageNum()/5.0)) * 5;
		this.startPage = this.endPage - (5-1);
		
		// ���� ��������
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
