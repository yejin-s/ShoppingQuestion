package com.yejin.spring.dao;

import java.util.List;

import com.yejin.spring.vo.ShoppingQuestionVo;

/**
 * @author ������
 * ���θ� ���ǰԽ��� ���, ���, ������ ����, ����, ���� Dao �������̽� 
 *
 */
public interface ShoppingQuestionDao {
	
	/**
	 * �Խñ� ��� 
	 * @return List<ShoppingQuestiondVo>
	 */
	public List<ShoppingQuestionVo> questionList();
	
	/**
	 * �Խñ� ���
	 * @param shoppingQuestionVo
	 */
	public void questionWriteEnrollment(ShoppingQuestionVo shoppingQuestionVo);
	
	/**
	 * �Խñ� ������
	 * @param questionNumber
	 * @return ShoppingQuestionVo
	 */
	public ShoppingQuestionVo questionDetail(int questionNumber);

	/**
	 * �Խñ� ����
	 * @param shoppingQuestionVo
	 */
	public void questionUpdate(ShoppingQuestionVo shoppingQuestionVo);
	
	/**
	 * �Խñ� ����
	 * @param questionNumber
	 */
	public void questionDelete(int questionNumber);
}
