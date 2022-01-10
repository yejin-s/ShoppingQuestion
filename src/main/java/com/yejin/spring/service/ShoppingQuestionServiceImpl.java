package com.yejin.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yejin.spring.ShoppingQuestionController;
import com.yejin.spring.dao.ShoppingQuestionDao;
import com.yejin.spring.paging.Criteria;
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
			resultCode = QuestionEnum.RESULT_SUCCESS.getValue();
			LOG.info("[QUESTION] questionWriteEnrollment : " + resultCode);
			
		} catch (Exception e) {
			
			resultCode = QuestionEnum.RESULT_FAIL.getValue();
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
			resultCode = QuestionEnum.RESULT_SUCCESS.getValue();
			LOG.info("[QUESTION] questionUpdate : " + resultCode);
			
		} catch (Exception e) {
			
			resultCode = QuestionEnum.RESULT_FAIL.getValue();
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
			resultCode = QuestionEnum.RESULT_SUCCESS.getValue();
			LOG.info("[QUESTION] questionDelete : " + resultCode);
			
		} catch (Exception e) {
			
			resultCode = QuestionEnum.RESULT_FAIL.getValue();
			LOG.error("[QUESTION] questionDelete : " + resultCode);		}
		
		return resultCode;
		
	}

	/**
	 * 페이징 처리한 쇼핑몰 문의게시판 목록 /
	 */
	@Override
	public List<ShoppingQuestionVo> questionListStartPage(Model model) {
		
		// 한페이지에 5개의 게시글을 보여준다.
		int endPage = 5;
		int startPage = 1;
		
		PagingVo pagingVo = new PagingVo();
		pagingVo.setEndPage(endPage);
		pagingVo.setStartPage(startPage);
		
		List<ShoppingQuestionVo> questionListPaging = shppingQuestionDao.questionListStartPage(pagingVo);
		
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
		model.addAttribute("nowPageNumber", 1);
		
		return questionListPaging;
	}

	/**
	 * 페이지 번호를 눌렀을 때, 해당 페이지의 해당 게시물을 보여주기 위해 사용하는 메서드
	 */
	@Override
	public List<ShoppingQuestionVo> pageMove(HttpServletRequest req, Model model) {
		
		model.addAttribute("nowPageNumber", req.getParameter("pageNumber"));
		
		// 현재 페이지 * 5 = 현재 페이지의 마지막 게시글 번호
		// 시작 게시글 = 마지막 게시글 - 4
		int endPage = Integer.parseInt(req.getParameter("pageNumber")) * 5;
		int startPage = endPage - 4;
		
		PagingVo pagingVo = new PagingVo();
		pagingVo.setEndPage(endPage);
		pagingVo.setStartPage(startPage);
		
		List<ShoppingQuestionVo> questionListPaging = shppingQuestionDao.questionListStartPage(pagingVo);
		
		int questionTotalCount = shppingQuestionDao.qeustionTotalCount();
		int pageNumber = questionTotalCount % 5;
		
		if(pageNumber > 0) {
			pageNumber = (questionTotalCount / 5) + 1;
		}else {
			pageNumber = questionTotalCount / 5;
		}
		
		model.addAttribute("pageNumber", pageNumber);
		
		List<Integer> questionNumber = new ArrayList<Integer>();
		
		for(int i=startPage; i > endPage; i++) {
			questionNumber.add(i);
		}
		model.addAttribute("questionNumber", questionNumber);
		
		return questionListPaging;
	}
}
