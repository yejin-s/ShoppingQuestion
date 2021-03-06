package com.yejin.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.ui.Model;

import com.yejin.spring.vo.CommonCodeVo;
import com.yejin.spring.vo.PagingVo;
import com.yejin.spring.vo.ShoppingQuestionVo;

/**
 * @author 설예진
 * 쇼핑몰 문의게시판 목록, 등록, 상세정보 보기, 수정, 삭제 Service 인터페이스
 */
public interface ShoppingQuestionService {

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
	
	/**
	 * 페이징 처리한 쇼핑몰 문의 게시판 
	 * @param model
	 * @return List<ShoppingQuestionVo>
	 */
	public List<ShoppingQuestionVo> questionListPaging(PagingVo pagingVo, Model model);
	
	/**
	 * Json 값 가져오기
	 * @return
	 */
	public String questionListJson();
	
}
