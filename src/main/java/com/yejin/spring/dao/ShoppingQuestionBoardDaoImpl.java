package com.yejin.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yejin.spring.vo.ShoppingQuestionBoardVo;

@Repository
public class ShoppingQuestionBoardDaoImpl implements ShoppingQuestionBoardDao{

	@Autowired
	SqlSession sqlSession;
	
	// 게시글 목록 가져오기
	// return : 모든 게시글의 정보
	public List<ShoppingQuestionBoardVo> shoppingQuestionBoardList() {

		List<ShoppingQuestionBoardVo> shoppingQuestionBoardList = sqlSession.selectList("com.yejin.spring.dao.ShoppingQuestionBoardDao.shoppingQuestionBoardList");
				
		return shoppingQuestionBoardList;
	}

	// 게시글 등록하기
	// 입력 파라미터 : 작성한 글 정보 -> 작성자, 제목, 내용을 VO에 담아서 mapper로 이동
	@Override
	public void shoppingQeustionBoardWriteEnrollment(ShoppingQuestionBoardVo shoppingQuestionBoardVo) {
		
		sqlSession.insert("com.yejin.spring.dao.ShoppingQuestionBoardDao.shoppingQeustionBoardWriteEnrollment", shoppingQuestionBoardVo);
	}

	// 게시글 상세보기
	// 입력 파라미터 : 게시글 번호
	// return : 게시글 정보 -> 글 번호, 작성자, 제목, 내용, 등록일, 수정일, 삭제여부를 VO에 담아서 리턴
	@Override
	public ShoppingQuestionBoardVo shoppingQuestionBoardDetail(int questionNumber) {
		
		ShoppingQuestionBoardVo shoppingQuestionBoardDatail = sqlSession.selectOne("com.yejin.spring.dao.ShoppingQuestionBoardDao.shoppingQuestionBoardDetail", questionNumber);
		
		return shoppingQuestionBoardDatail;
	}

	// 게시글 수정하기
	// 입력 하파미터 : 수정한 글 정보 -> 글 번호, 제목, 내용을 VO에 담아서 mapper로 이동
	@Override
	public void shoppingQuestionBoardUpdate(ShoppingQuestionBoardVo shoppingQuestionBoardVo) {
		sqlSession.update("com.yejin.spring.dao.ShoppingQuestionBoardDao.shoppingQuestionBoardUpdate", shoppingQuestionBoardVo);
		
	}

	// 게시글 삭제하기
	// 입력 파라미터 : 게시글 번호
	// 게시글 번호로 DB에서 해당하는 글을 찾아서 삭제여부를 N에서 Y로 업데이트 해준다
	@Override
	public void shoppingQuestionBoardDelete(int questionNumber) {
		sqlSession.update("com.yejin.spring.dao.ShoppingQuestionBoardDao.shoppingQuestionBoardDelete", questionNumber);
		
	}

	
}
