package com.yejin.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

import com.google.gson.Gson;
import com.yejin.spring.ShoppingQuestionController;
import com.yejin.spring.dao.ShoppingQuestionDao;
import com.yejin.spring.util.ResultEnum;
import com.yejin.spring.vo.CommonCodeVo;
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
	 * 작성한 게시글 내용 등록하기 /
	 * 입력 파라미터 : 작성한 게시글 정보 -> 작성자, 제목, 내용
	 */
	@Override
	public String questionWriteEnrollment(ShoppingQuestionVo shoppingQuestionVo) {
	
		String resultCode = "";
		
		try {
			shppingQuestionDao.questionWriteEnrollment(shoppingQuestionVo);
			resultCode = ResultEnum.WRITE_SUCCESS.getValue();
			LOG.info("[QUESTION] questionWriteEnrollment : " + resultCode);
			
		} catch (Exception e) {
			
			resultCode = ResultEnum.WRITE_FAIL.getValue();
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
			resultCode = ResultEnum.UPDATE_SUCCESS.getValue();
			LOG.info("[QUESTION] questionUpdate : " + resultCode);
			
		} catch (Exception e) {
			
			resultCode = ResultEnum.UPDATE_FAIL.getValue();
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
			resultCode = ResultEnum.DELETE_SUCCESS.getValue();
			LOG.info("[QUESTION] questionDelete : " + resultCode);
			
		} catch (Exception e) {
			resultCode = ResultEnum.DELETE_FAIL.getValue();
			LOG.error("[QUESTION] questionDelete : " + resultCode);		
			
		}
		
		return resultCode;
		
	}

	/**
	 * 페이징 처리한 쇼핑몰 문의게시판 목록 /
	 */
	@Override
	public List<ShoppingQuestionVo> questionListPaging(PagingVo pagingVo, Model model) {
		
		int nowPageNumber = 1;
		
		// 한 페이지당 보여줄 게시글 수
		int pageTotalQuestionNumber = pagingVo.getPageTotalQuestionNumber();
		model.addAttribute("pageTotalQuestionNumber", pageTotalQuestionNumber);
		
		// 클릭한 페이지 번호
		// 0일때는 로그인 후 리스트로 들어왔을 때
		if(pagingVo.getPageNumber() != 0) {
			int endQuestionNumber = pagingVo.getPageNumber() * pageTotalQuestionNumber;
			int startQuestionNumber = endQuestionNumber - (pageTotalQuestionNumber - 1);
			
			pagingVo.setEndQuestionNumber(endQuestionNumber);
			pagingVo.setStartQuestionNumber(startQuestionNumber);
			
			nowPageNumber = pagingVo.getPageNumber();
			
		}
		
		List<ShoppingQuestionVo> questionListPaging = null;
		// 전체 게시글 수
		int qeustionTotalCount = 0;
		String resultCode = "";
		
		if(pagingVo.getSearchKeyword() == null) {
				model.addAttribute("searchYN", "N");
				model.addAttribute("dateSearchYN", "N");
				
		}else {
			model.addAttribute("searchYN", "Y");
			model.addAttribute("dateSearchYN", "Y");
			model.addAttribute("searchKeyword", pagingVo.getSearchKeyword());
			model.addAttribute("startDate", pagingVo.getStartDate());
			model.addAttribute("endDate", pagingVo.getEndDate());
		}
		
		try {
			// 게시글 리스트 가져오기
			questionListPaging = shppingQuestionDao.questionListPaging(pagingVo);
			// 전체 게시글 수를 가져오는 Dao
			qeustionTotalCount = shppingQuestionDao.qeustionTotalCount(pagingVo);
			
			resultCode = ResultEnum.GET_PAGE_SUCCESS.getValue();
			LOG.info("[QUESTION] questionListPaging : " + resultCode);
		} catch (Exception e) {
			resultCode = ResultEnum.GET_PAGE_FAIL.getValue();
			LOG.error("[QUESTION] questionListPaging : " + resultCode);
		}
		
		// pageNumber = 전체 게시글을 5로 나누면 나오는 나머지
		int pageNumber = qeustionTotalCount % pageTotalQuestionNumber;
		
		// 나머지가 0보다 크면 전체페이지 / 5를 한 뒤 1를 더해준 값으로 교체
		// 한페이지 당 5개의 게시글을 보여주는데 나머지가 있으면 5로 나누어 떨어지지 않으니 한페이지를 더 추가해준다.
		if(pageNumber > 0) {
			pageNumber = (qeustionTotalCount / pageTotalQuestionNumber) + 1;
		}else {
			pageNumber = qeustionTotalCount / pageTotalQuestionNumber;
		}
		
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("nowPageNumber", nowPageNumber);
		
		// DB공통코드 조회
		CommonCodeVo commonCodeVo = new CommonCodeVo();
		commonCodeVo.setCodeKind("SEARCHTYPE");
		
		List<CommonCodeVo> commonCodeList = shppingQuestionDao.commonCodeList(commonCodeVo);
		model.addAttribute("commonCodeList", commonCodeList);
		
		return questionListPaging;
	}
	
	/**
	 * Json 값 가져오기
	 */
	@Override
	public String questionListJson() {
		
		List<ShoppingQuestionVo> questionListJson = null;
		
		try {
			questionListJson = shppingQuestionDao.questionList();
			LOG.info("[QUESTION] questionListJson OK : " + questionListJson);
			
		} catch (Exception e) {
			LOG.error("[QUESTION] questionListJson ERROR");	
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(questionListJson);
		
		return json;
	}
}
