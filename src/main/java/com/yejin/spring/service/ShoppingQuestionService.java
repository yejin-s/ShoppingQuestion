package com.yejin.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.yejin.spring.paging.Criteria;
import com.yejin.spring.vo.ShoppingQuestionVo;

/**
 * @author 설예진
 * 쇼핑몰 문의게시판 목록, 등록, 상세정보 보기, 수정, 삭제 Service 인터페이스
 */
public interface ShoppingQuestionService {

	/**
	 * 글 목록
	 * @param model
	 * @return List<ShoppingQuestionVo>
	 */
	public List<ShoppingQuestionVo> questionList();
	
	/**
	 * 글쓰기 등록
	 * @param shoppingQuestionVo
	 */
	public String questionWriteEnrollment(ShoppingQuestionVo shoppingQuestionVo);
	
	/**
	 * 글 상세정보
	 * @param shoppingQuestionVo
	 * @param model
	 * @return shoppingQuestionVo
	 */
	public ShoppingQuestionVo questionDetail(ShoppingQuestionVo shoppingQuestionVo);
	
	/**
	 * 글 수정
	 * @param shoppingQuestionVo
	 * @param model
	 */
	public String questionUpdate(ShoppingQuestionVo shoppingQuestionVo);
	
	/**
	 * 글 삭제
	 * @param shoppingQuestionVo
	 */
	public String questionDelete(ShoppingQuestionVo shoppingQuestionVo);
	
	public List<ShoppingQuestionVo> questionListStartPage(Model model);
	
	public List<ShoppingQuestionVo> pageMove(HttpServletRequest req, Model model);
}
