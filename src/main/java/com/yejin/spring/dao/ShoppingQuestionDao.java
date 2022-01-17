package com.yejin.spring.dao;

import java.util.List;

import com.yejin.spring.vo.PagingVo;
import com.yejin.spring.vo.ShoppingQuestionVo;

/**
 * @author ������
 * ���θ� ���ǰԽ��� ���, ���, ������ ����, ����, ���� Dao �������̽� 
 *
 */
public interface ShoppingQuestionDao {

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
	
	/**
	 * ��ü �Խñ��� �� ��������
	 * @return int
	 */
	public int qeustionTotalCount(PagingVo pagingVo);
	
	/**
	 * ����¡ ó���� ���θ� ���� �Խ��� 
	 * @param pagingVo
	 * @return List<ShoppingQuestionVo>
	 */
	public List<ShoppingQuestionVo> questionListPaging(PagingVo pagingVo);
	
	/**
	 * Json �� ��������
	 */
	public List<ShoppingQuestionVo> questionListJson();
}
