package com.yejin.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.yejin.spring.vo.ShoppingQuestionBoardVo;

public interface ShoppingQuestionBoardService {

	// 글 목록
	public List<ShoppingQuestionBoardVo> shoppingQuestionBoardList(Model model);
	
	// 글쓰기 등록
	public void shoppingQeustionBoardWriteEnrollment(ShoppingQuestionBoardVo shoppingQuestionBoardVo);
	
	// 글 상세정보
	public ShoppingQuestionBoardVo shoppingQuestionBoardDetail(ShoppingQuestionBoardVo shoppingQuestionBoardVo, Model model);
	
	// 글 수정
	public void shoppingQuestionBoardUpdate(ShoppingQuestionBoardVo shoppingQuestionBoardVo, Model model);
	
	// 글 삭제
	public void shoppingQuestionBoardDelete(ShoppingQuestionBoardVo shoppingQuestionBoardVo);
}
