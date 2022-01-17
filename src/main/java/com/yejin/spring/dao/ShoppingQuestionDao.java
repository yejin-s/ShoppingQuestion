package com.yejin.spring.dao;

import java.util.List;

import com.yejin.spring.vo.PagingVo;
import com.yejin.spring.vo.ShoppingQuestionVo;

/**
 * @author 설예진
 * 쇼핑몰 문의게시판 목록, 등록, 상세정보 보기, 수정, 삭제 Dao 인터페이스 
 *
 */
public interface ShoppingQuestionDao {

	/**
	 * 게시글 등록
	 * @param shoppingQuestionVo
	 */
	public void questionWriteEnrollment(ShoppingQuestionVo shoppingQuestionVo);
	
	/**
	 * 게시글 상세정보
	 * @param questionNumber
	 * @return ShoppingQuestionVo
	 */
	public ShoppingQuestionVo questionDetail(int questionNumber);

	/**
	 * 게시글 수정
	 * @param shoppingQuestionVo
	 */
	public void questionUpdate(ShoppingQuestionVo shoppingQuestionVo);
	
	/**
	 * 게시글 삭제
	 * @param questionNumber
	 */
	public void questionDelete(int questionNumber);
	
	/**
	 * 전체 게시글의 수 가져오기
	 * @return int
	 */
	public int qeustionTotalCount(PagingVo pagingVo);
	
	/**
	 * 페이징 처리한 쇼핑몰 문의 게시판 
	 * @param pagingVo
	 * @return List<ShoppingQuestionVo>
	 */
	public List<ShoppingQuestionVo> questionListPaging(PagingVo pagingVo);
	
	/**
	 * Json 값 가져오기
	 */
	public List<ShoppingQuestionVo> questionListJson();
}
