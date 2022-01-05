package com.yejin.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

import com.yejin.spring.HomeController;
import com.yejin.spring.dao.ShoppingQuestionDao;
import com.yejin.spring.vo.ShoppingQuestionVo;

/**
 * @author 설예진
 * 쇼핑몰 문의게시판 목록, 등록, 상세정보 보기, 수정, 삭제 Service
 */
@Service
public class ShoppingQuestionServiceImpl implements ShoppingQuestionService {

	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired 
	ShoppingQuestionDao shppingQuestionDao;
	
	/**
	 * 게시글 목록에 보여줄 정보 가져오기 /
	 * return : DB에 있는 모든 게시글 정보
	 */
	@Override
	public List<ShoppingQuestionVo> questionList(Model model) {
		
		List<ShoppingQuestionVo> shoppingQuestionList = null;
		
		try {
			shoppingQuestionList = shppingQuestionDao.questionList();
		} catch (Exception e) {
			
			LOG.error("[QUESTION] questionList");
			System.err.println("Exception : " + e.getMessage());
		}
				

		return shoppingQuestionList;
	}

	/**
	 * 작성한 게시글 내용 등록하기 /
	 * 입력 파라미터 : 작성한 게시글 정보 -> 작성자, 제목, 내용
	 */
	@Override
	public void questionWriteEnrollment(ShoppingQuestionVo shoppingQuestionVo) {
	
		shppingQuestionDao.questionWriteEnrollment(shoppingQuestionVo);
	
	}

	/**
	 * 클릭한 제목에 대한 게시글 정보 가져오기 /
	 * 입력 파라미터 : 게시글 번호 /
	 * return : 게시글 정보 -> 글번호, 작성자, 제목, 내용, 등록일, 수정일, 삭제여부
	 */
	@Override
	public ShoppingQuestionVo questionDetail(ShoppingQuestionVo shoppingQuestionVo, Model model) {
		
		int boardNumber = shoppingQuestionVo.getQuestionNumber();
		
		ShoppingQuestionVo shoppingQeustionDetail = null;
		
		try {
			shoppingQeustionDetail = shppingQuestionDao.questionDetail(boardNumber);
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
		}
		
		return shoppingQeustionDetail;
	}

	/**
	 * 게시글 수정하기 /
	 * 입력 파라미터 : 게시글번호, 제목, 내용
	 */
	@Override
	public void questionUpdate(ShoppingQuestionVo shoppingQuestionVo, Model model) {
		
		shppingQuestionDao.questionUpdate(shoppingQuestionVo);
		
	}

	/**
	 * 게시글 삭제하기 /
	 * 입력 파라미터 : 게시글 번호
	 */
	@Override
	public void questionDelete(ShoppingQuestionVo shoppingQuestionVo) {
		
		int questionNumber = shoppingQuestionVo.getQuestionNumber();
		shppingQuestionDao.questionDelete(questionNumber);
		
	}
}
