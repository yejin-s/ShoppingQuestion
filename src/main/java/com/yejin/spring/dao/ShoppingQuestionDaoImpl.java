package com.yejin.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yejin.spring.vo.CommonCodeVo;
import com.yejin.spring.vo.PagingVo;
import com.yejin.spring.vo.ShoppingQuestionVo;

/**
 * @author 설예진
 * 쇼핑몰 문의게시판 목록, 등록, 상세정보 보기, 수정, 삭제 Dao
 */
@Repository
public class ShoppingQuestionDaoImpl implements ShoppingQuestionDao{

	@Autowired
	SqlSession sqlSession;
	
	/**
	 * 게시글 등록하기 /
	 * 입력 파라미터 : 작성한 글 정보 -> 작성자, 제목, 내용을 VO에 담아서 mapper로 이동
	 */
	@Override
	public void questionWriteEnrollment(ShoppingQuestionVo shoppingQuestionVo) {
		
		sqlSession.insert("questionWriteEnrollment", shoppingQuestionVo);
	}

	/**
	 * 게시글 상세보기 /
	 * 입력 파라미터 : 게시글 번호 /
	 * return : 게시글 정보 -> 글 번호, 작성자, 제목, 내용, 등록일, 수정일, 삭제여부를 VO에 담아서 리턴
	 */
	@Override
	public ShoppingQuestionVo questionDetail(int questionNumber) {
		
		ShoppingQuestionVo shoppingQuestionDatail = sqlSession.selectOne("questionDetail", questionNumber);
		
		return shoppingQuestionDatail;
	}

	/**
	 * 게시글 수정하기 /
	 * 입력 하파미터 : 수정한 글 정보 -> 글 번호, 제목, 내용을 VO에 담아서 mapper로 이동
	 */
	@Override
	public void questionUpdate(ShoppingQuestionVo shoppingQuestionVo) {
		sqlSession.update("questionUpdate", shoppingQuestionVo);
		
	}

	/**
	 * 게시글 삭제하기 /
	 * 입력 파라미터 : 게시글 번호 /
	 * 게시글 번호로 DB에서 해당하는 글을 찾아서 삭제여부를 N에서 Y로 업데이트 해준다
	 */
	@Override
	public void questionDelete(int questionNumber) {
		sqlSession.update("questionDelete", questionNumber);
		
	}

	/**
	 * 전체 게시글의 수 가져오기
	 */
	@Override
	public int qeustionTotalCount(PagingVo pagingVo) {
		
		int qeustionTotalCount = sqlSession.selectOne("qeustionTotalCount", pagingVo);
		return qeustionTotalCount;
	}
	
	/**
	 * 페이징 처리한 쇼핑몰 문의 게시판 
	 */
	@Override
	public List<ShoppingQuestionVo> questionListPaging(PagingVo pagingVo) {

		List<ShoppingQuestionVo> questionListPaging = sqlSession.selectList("questionListPaging", pagingVo);
 
		return questionListPaging;
	}
	
	/**
	 * Json 값 가져오기
	 */
	@Override
	public List<ShoppingQuestionVo> questionList() {
		List<ShoppingQuestionVo> questionListJson = sqlSession.selectList("questionList");
		return questionListJson;
	}

	@Override
	public List<CommonCodeVo> commonCodeList(CommonCodeVo commonCodeVo) {
		List<CommonCodeVo> commonCodeList = sqlSession.selectList("commonCodeList", commonCodeVo);
		return commonCodeList;
	}

}
