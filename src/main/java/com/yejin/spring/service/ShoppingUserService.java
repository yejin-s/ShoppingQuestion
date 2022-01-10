package com.yejin.spring.service;

import javax.servlet.http.HttpServletRequest;

import com.yejin.spring.vo.ShoppingUserVo;

/**
 * @author ������
 * ���� �α���, ȸ������ ���� �������̽�
 */
public interface ShoppingUserService {
	
	/**
	 * ���̵� �ߺ� Ȯ��
	 * @param shoppingUserVo
	 * @return String
	 */
	public String joinIdCheck(ShoppingUserVo shoppingUserVo);
	
	/**
	 * ȸ������
	 * @param shoppingUserVo
	 */
	public String userJoin(ShoppingUserVo shoppingUserVo);
	
	/**
	 * �α���
	 * @param req
	 * @return ShoppingUserVo
	 */
	public ShoppingUserVo loginCheck(HttpServletRequest req);
	
}
