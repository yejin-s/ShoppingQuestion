package com.yejin.spring.dao;

import java.util.List;

import com.yejin.spring.vo.ShoppingQuestionBoardVo;

public interface ShoppingQuestionBoardDao {
	
	// 게시글 목록 
	public List<ShoppingQuestionBoardVo> shoppingQuestionBoardList();
	
	// 게시글 등록
	public void boardWriteEnrollment(ShoppingQuestionBoardVo shoppingQuestionBoardVo);
	
	// 게시글 상세정보
	public ShoppingQuestionBoardVo boardDetail(int questionNumber);

	// 게시글 수정
	public void boardUpdate(ShoppingQuestionBoardVo updateShoppingQuestionBoardVo);
	
	// 게시글 삭제
	public void boardDelete(int questionNumber);
}
