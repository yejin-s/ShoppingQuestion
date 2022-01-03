package com.yejin.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.yejin.spring.vo.ShoppingQuestionBoardVo;

public interface ShoppingQuestionBoardService {

	// 굴 목록
	public List<ShoppingQuestionBoardVo> shoppingQuestionBoardList(HttpServletRequest req, Model model);
	
	// 글쓰기 등록
	public void boardWriteEnrollment(HttpServletRequest req, Model model);
	
	// 글 상세정보
	public ShoppingQuestionBoardVo boardDetail(HttpServletRequest req, Model model);
	
	// 글 수정
	public void boardUpdate(HttpServletRequest req, Model model);
	
	// 글 삭제
	public void boardDelete(HttpServletRequest req, Model model);
}
