package com.yejin.spring.dao;

import java.util.List;

import com.yejin.spring.vo.ShoppingQuestionBoardVo;

public interface ShoppingQuestionBoardDao {
	
	// �Խñ� ��� 
	public List<ShoppingQuestionBoardVo> shoppingQuestionBoardList();
	
	// �Խñ� ���
	public void shoppingQeustionBoardWriteEnrollment(ShoppingQuestionBoardVo shoppingQuestionBoardVo);
	
	// �Խñ� ������
	public ShoppingQuestionBoardVo shoppingQuestionBoardDetail(int questionNumber);

	// �Խñ� ����
	public void shoppingQuestionBoardUpdate(ShoppingQuestionBoardVo shoppingQuestionBoardVo);
	
	// �Խñ� ����
	public void shoppingQuestionBoardDelete(int questionNumber);
}
