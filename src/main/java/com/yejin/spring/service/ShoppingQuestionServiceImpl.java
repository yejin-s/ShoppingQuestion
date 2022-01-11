package com.yejin.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yejin.spring.ShoppingQuestionController;
import com.yejin.spring.dao.ShoppingQuestionDao;
import com.yejin.spring.util.QuestionEnum;
import com.yejin.spring.vo.PagingVo;
import com.yejin.spring.vo.ShoppingQuestionVo;

/**
 * @author 설예진
 * 쇼핑몰 문의게시판 목록, 등록, 상세정보 보기, 수정, 삭제 Service
 */
@Service
public class ShoppingQuestionServiceImpl implements ShoppingQuestionService {

	private static final Logger LOG = LoggerFactory.getLogger(ShoppingQuestionController.class);
	
	@Autowired 
	ShoppingQuestionDao shppingQuestionDao;
	
	/**
	 * 게시글 목록에 보여줄 정보 가져오기 /
	 * return : DB에 있는 모든 게시글 정보
	 */
	@Override
	public List<ShoppingQuestionVo> questionList() {
		
		List<ShoppingQuestionVo> shoppingQuestionList = null;
		
		try {
			shoppingQuestionList = shppingQuestionDao.questionList();
		} catch (Exception e) {
			
			LOG.error("[QUESTION] questionList : " + e.getMessage());
		}
				

		return shoppingQuestionList;
	}

	/**
	 * 작성한 게시글 내용 등록하기 /
	 * 입력 파라미터 : 작성한 게시글 정보 -> 작성자, 제목, 내용
	 */
	@Override
	public String questionWriteEnrollment(ShoppingQuestionVo shoppingQuestionVo) {
	
		String resultCode = "";
		
		try {
			shppingQuestionDao.questionWriteEnrollment(shoppingQuestionVo);
			resultCode = QuestionEnum.WRITE_SUCCESS.getValue();
			LOG.info("[QUESTION] questionWriteEnrollment : " + resultCode);
			
		} catch (Exception e) {
			
			resultCode = QuestionEnum.WRITE_FAIL.getValue();
			LOG.error("[QUESTION] questionWriteEnrollment : " + resultCode);
		}
		
		
		return resultCode;
	
	}

	/**
	 * 클릭한 제목에 대한 게시글 정보 가져오기 /
	 * 입력 파라미터 : 게시글 번호 /
	 * return : 게시글 정보 -> 글번호, 작성자, 제목, 내용, 등록일, 수정일, 삭제여부
	 */
	@Override
	public ShoppingQuestionVo questionDetail(ShoppingQuestionVo shoppingQuestionVo) {
		int boardNumber = shoppingQuestionVo.getQuestionNumber();
		
		ShoppingQuestionVo shoppingQeustionDetail = null;
		
		shoppingQeustionDetail = shppingQuestionDao.questionDetail(boardNumber);
		
		return shoppingQeustionDetail;
	}

	/**
	 * 게시글 수정하기 /
	 * 입력 파라미터 : 게시글번호, 제목, 내용
	 */
	@Override
	public String questionUpdate(ShoppingQuestionVo shoppingQuestionVo) {
		
		String resultCode = "";
		try {
			shppingQuestionDao.questionUpdate(shoppingQuestionVo);
			resultCode = QuestionEnum.UPDATE_SUCCESS.getValue();
			LOG.info("[QUESTION] questionUpdate : " + resultCode);
			
		} catch (Exception e) {
			
			resultCode = QuestionEnum.UPDATE_FAIL.getValue();
			LOG.error("[QUESTION] questionUpdate : " + resultCode);		}
		
		return resultCode;
	}

	/**
	 * 게시글 삭제하기 /
	 * 입력 파라미터 : 게시글 번호
	 */
	@Override
	public String questionDelete(ShoppingQuestionVo shoppingQuestionVo) {
		
		int questionNumber = shoppingQuestionVo.getQuestionNumber();
		String resultCode = "";
		
		try {
			shppingQuestionDao.questionDelete(questionNumber);
			resultCode = QuestionEnum.DELETE_SUCCESS.getValue();
			LOG.info("[QUESTION] questionDelete : " + resultCode);
			
		} catch (Exception e) {
			resultCode = QuestionEnum.DELETE_FAIL.getValue();
			LOG.error("[QUESTION] questionDelete : " + resultCode);		
			
		}
		
		return resultCode;
		
	}

	/**
	 * 페이징 처리한 쇼핑몰 문의게시판 목록 /
	 */
	@Override
	public List<ShoppingQuestionVo> questionListStartPage(HttpServletRequest req, Model model) {
		PagingVo pagingVo = new PagingVo();
		int nowPageNumber = 1;
		
		if(req.getParameter("pageNumber") != null) {
			int endPage = Integer.parseInt(req.getParameter("pageNumber")) * 5;
			int startPage = endPage - 4;
			
			pagingVo.setEndPage(endPage);
			pagingVo.setStartPage(startPage);
			
			nowPageNumber = Integer.parseInt(req.getParameter("pageNumber"));
			
		}
		
		List<ShoppingQuestionVo> questionListPaging = null;
		String resultCode = "";
		
		try {
			questionListPaging = shppingQuestionDao.questionListStartPage(pagingVo);
			LOG.info("[QUESTION] questionListStartPage : " + resultCode);
			
		} catch (Exception e) {
			LOG.error("[QUESTION] questionListStartPage : " + resultCode);	
		}
		
		// 전체 게시글 수를 가져오는 Dao
		int qeustionTotalCount = shppingQuestionDao.qeustionTotalCount();
		
		// pageNumber = 전체 게시글을 5로 나누면 나오는 나머지
		int pageNumber = qeustionTotalCount % 5;
		
		// 나머지가 0보다 크면 전체페이지 / 5를 한 뒤 1를 더해준 값으로 교체
		// 한페이지 당 5개의 게시글을 보여주는데 나머지가 있으면 5로 나누어 떨어지지 않으니 한페이지를 더 추가해준다.
		if(pageNumber > 0) {
			pageNumber = (qeustionTotalCount / 5) + 1;
		}else {
			pageNumber = qeustionTotalCount / 5;
		}
		
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("nowPageNumber", nowPageNumber);
		
		return questionListPaging;
	}
}
