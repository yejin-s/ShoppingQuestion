package com.yejin.spring.dao;

import com.yejin.spring.vo.ShoppingUserVo;

/**
 * @author ������
 * ���� �α���, ȸ������ Dao �������̽�
 */
public interface ShoppingUserDao {
	
	/**
	 * ���̵� �ߺ�Ȯ��
	 * @param userId
	 * @return ShoppingUserVo
	 */
	public ShoppingUserVo idCheck(String userId);
	
	/**
	 * ȸ������
	 * @param shoppingUserVo
	 */
	public void userJoin(ShoppingUserVo shoppingUserVo);
	
	/**
	 * ���� ���� ��������
	 * @param shoppingUserVo
	 * @return ShoppingUserVo
	 */
	public ShoppingUserVo loginUserInfomation(ShoppingUserVo shoppingUserVo);

}
