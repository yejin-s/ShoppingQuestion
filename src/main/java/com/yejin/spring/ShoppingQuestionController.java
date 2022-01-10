package com.yejin.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yejin.spring.paging.Criteria;
import com.yejin.spring.paging.PageVo;
import com.yejin.spring.service.ShoppingQuestionService;
import com.yejin.spring.vo.ShoppingQuestionVo;

/**
 * @author 설예진
 * 쇼핑몰 문의게시판 목록, 등록, 상세정보 보기, 수정, 삭제 컨트롤러
 */
@Controller
public class ShoppingQuestionController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ShoppingQuestionController.class);
	
	@Autowired
	ShoppingQuestionService shoppingQuestionService;
	
//	/**
//	 * 글 목록 컨트롤러
//	 * DB에 있는 모든 글정보를 가지고 home.jsp(글목록 페이지)로 이동.
//	 * @param model
//	 * @return home
//	 * 직접 브라우저에서 호출해야 하기때문에 GET방식으로 했다
//	 */
//	@RequestMapping(value = "/shopping/questionList", method = RequestMethod.GET)
//	public String questionList(Model model) {
//		
//		List<ShoppingQuestionVo> shoppingQuestionList = shoppingQuestionService.questionList();
//		
//		model.addAttribute("resultCode", "");
//		model.addAttribute("type",  "");
//		model.addAttribute("shoppingQuestionList", shoppingQuestionList);
//		
//		return "home";
//	}
	
	/**
	 * 글 쓰기 컨트롤러 /
	 * shoppingQuestionWrite.jsp(글쓰기 페이지)로 이동 /
	 * @return shoppingQuestion
	 */
	@RequestMapping(value = "/shopping/questionWrite", method = RequestMethod.POST)
	public String questionWrite() {
		 
		return "shoppingQuestionWrite";
	}
	
	/**
	 * 작성한 글 등록하는 컨트롤러 /
	 * 작성한 글 정보들을 가지고 DB에 insert 후 글 목록 컨트롤러로 이동	 /
	 * 작성 성공하면 alert창을 띄우기 위해 type을 보내준다 / 
	 * resultCode : 예외처리 코드 /
	 * @param shoppingQuestionVo
	 * @return boardList
	 */
	@RequestMapping(value = "/shopping/questionWriteEnrollment", method = RequestMethod.POST)
	public String questionWriteEnrollment(ShoppingQuestionVo shoppingQuestionVo, Model model) {
	
		LOG.info("[QUESTION] questionWriteEnrollment user: "+shoppingQuestionVo.getQuestionUser()
			+", title: "+shoppingQuestionVo.getQuestionTitle()+", content:"+shoppingQuestionVo.getQuestionContent());
		
		String resultCode = shoppingQuestionService.questionWriteEnrollment(shoppingQuestionVo);
		model.addAttribute("resultCode", resultCode);
		model.addAttribute("type",  "작성");
		
		List<ShoppingQuestionVo> shoppingQuestionList = shoppingQuestionService.questionList();
		model.addAttribute("shoppingQuestionList", shoppingQuestionList);
		
		return "home";
	}
	
	/**
	 * 글 제목 눌렀을 때, 상세정보 보여주는 컨트롤러 /
	 * 글 번호로 DB 접근 후 해당 정보를 가지고 shoppingQuestionDetail.jsp(상세 페이지)로 이동 /
	 * @param shoppingQuestionVo
	 * @param model
	 * @return shoppingQuestionDetail
	 */
	@RequestMapping(value = "/shopping/questionDetail", method = RequestMethod.POST)
	public String questionDetail(ShoppingQuestionVo shoppingQuestionVo, Model model) {
		
		LOG.info("[QUESTION] questionDetail questionNumber: "+  shoppingQuestionVo.getQuestionNumber());
		
		ShoppingQuestionVo shoppingQuestionDetail = shoppingQuestionService.questionDetail(shoppingQuestionVo);
		model.addAttribute("shoppingQuestionDetail", shoppingQuestionDetail);
		
		LOG.info("[QUESTION] questionDetail user: "+shoppingQuestionDetail.getQuestionUser()
		+", title: "+shoppingQuestionDetail.getQuestionTitle()+", content:"+shoppingQuestionDetail.getQuestionContent()
		+", questionNumber: "+shoppingQuestionDetail.getQuestionNumber()+", modifydate: "+shoppingQuestionDetail.getQuestionModityRegdate()
		+", regdate: "+shoppingQuestionDetail.getQuestionRegdate()+", deleteCheck: "+shoppingQuestionDetail.getQuestionDeleteCheck());
		
		return "shoppingQuestionDetail";
	}
	
	/** 
	 * 글 수정하는 페이지로 가는 컨트롤러 /
	 * 수정할 글의 정보를 가지고 shoppingQuestionUpdatePage.jsp(수정 페이지)로 이동 /
	 * @param shoppingQuestionVo
	 * @param model
	 * @return shoppingQuestionUpdatePage
	 */
	@RequestMapping(value = "/shopping/questionUpdatePage", method = RequestMethod.POST)
	public String questionUpdatePage(ShoppingQuestionVo shoppingQuestionVo, Model model) {
		
		LOG.info("[QUESTION] questionUpdatePage questionNumber: "+  shoppingQuestionVo.getQuestionNumber());
		
		ShoppingQuestionVo shoppingQuestionDetail = shoppingQuestionService.questionDetail(shoppingQuestionVo);
		model.addAttribute("shoppingQuestionDetail", shoppingQuestionDetail);
		
		LOG.info("[QUESTION] questionUpdatePage user: "+shoppingQuestionDetail.getQuestionUser()
		+", title: "+shoppingQuestionDetail.getQuestionTitle()+", content:"+shoppingQuestionDetail.getQuestionContent()
		+", questionNumber: "+shoppingQuestionDetail.getQuestionNumber()+", modifydate: "+shoppingQuestionDetail.getQuestionModityRegdate()
		+", regdate: "+shoppingQuestionDetail.getQuestionRegdate()+", deleteCheck: "+shoppingQuestionDetail.getQuestionDeleteCheck());
		
		return "shoppingQuestionUpdatePage";
	}
	
	/**
	 * 글 수정한 내용 업데이트하는 컨트롤러 /
	 * 수정한 내용과 글 정보 update 한 후 shoppingQuestionDetail.jsp(상세 페이지)로 이동 /
	 * resultCode : 예외처리 코드 /
	 * @param shoppingQuestionVo
	 * @param model
	 * @return shoppingQuestionDetail
	 */
	@RequestMapping(value = "/shopping/questionUpdate", method = RequestMethod.POST)
	public String questionUpdate(ShoppingQuestionVo shoppingQuestionVo, Model model) {
		
		LOG.info("[QUESTION] questionUpdate user: "+shoppingQuestionVo.getQuestionUser()
		+", title: "+shoppingQuestionVo.getQuestionTitle()+", content:"+shoppingQuestionVo.getQuestionContent());
		
		// 수정한 글로 업데이트 해준 후
		String resultCode = shoppingQuestionService.questionUpdate(shoppingQuestionVo);
		model.addAttribute("resultCode", resultCode);
		
		// 글 상세정보를 가져오는 서비스를 호출해준다
		ShoppingQuestionVo shoppingQuestionDetail = shoppingQuestionService.questionDetail(shoppingQuestionVo);
		model.addAttribute("shoppingQuestionDetail", shoppingQuestionDetail);
		
		LOG.info("[QUESTION] questionUpdatePage user: "+shoppingQuestionDetail.getQuestionUser()
		+", title: "+shoppingQuestionDetail.getQuestionTitle()+", content:"+shoppingQuestionDetail.getQuestionContent()
		+", questionNumber: "+shoppingQuestionDetail.getQuestionNumber()+", modifydate: "+shoppingQuestionDetail.getQuestionModityRegdate()
		+", regdate: "+shoppingQuestionDetail.getQuestionRegdate()+", deleteCheck: "+shoppingQuestionDetail.getQuestionDeleteCheck());
		
		return "shoppingQuestionDetail";
	}
	
	/**
	 * 글 삭제하는 컨트롤러 /
	 * 글 번호를 가지고 삭제 후 글 목록 컨트롤러로 이동 /
	 * 글 삭제는 N에서 Y로 변경 /
	 * 삭제 성공하면 alert창을 띄우기 위해 type을 보내준다 / 
	 * resultCode : 예외처리 코드 /
	 * @param shoppingQuestionVo
	 * @return boardList
	 */
	@RequestMapping(value = "/shopping/questionDelete", method = RequestMethod.POST)
	public String questionDelete(ShoppingQuestionVo shoppingQuestionVo, Model model) {
		
		LOG.info("[QUESTION] questionDelete questionNumber: "+  shoppingQuestionVo.getQuestionNumber());
		
		String resultCode = shoppingQuestionService.questionDelete(shoppingQuestionVo);
		model.addAttribute("resultCode", resultCode);
		model.addAttribute("type",  "삭제");
		
		List<ShoppingQuestionVo> shoppingQuestionList = shoppingQuestionService.questionList();
		model.addAttribute("shoppingQuestionList", shoppingQuestionList);
		
		return "home";
	}
	
	/**
	 * 페이징 처리한 쇼핑말 문의 게시판 / 
	 * 처음 게시판으로 들어갈 땐, alert창으로 알려줄 정보가 없기 때문에 resultCode와 type에 빈값을 넣어준다 /
	 * questionListPaging : mapper에서 페이징 처리한 정보 /
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/shopping/questionListPaging", method = RequestMethod.GET)
	public String questionListPaging(Model model) {
		
		List<ShoppingQuestionVo> questionListPaging = shoppingQuestionService.questionListStartPage(model);
		
		model.addAttribute("resultCode", "");
		model.addAttribute("type",  "");
		model.addAttribute("questionListPaging", questionListPaging);
		
		return "shoppingQeustionListPaging";
	}
	
	/**
	 * 글 목록 밑에 페이지 넘버를 눌렀을 때, 다른 페이지로 이동하기 위한 컨트롤러 /
	 * 처음 게시판으로 들어갈 땐, alert창으로 알려줄 정보가 없기 때문에 resultCode와 type에 빈값을 넣어준다 /
	 * questionListPaging : mapper에서 페이징 처리한 정보 /
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/shopping/pageMove", method = RequestMethod.GET)
	public String pageMove(HttpServletRequest req, Model model) {
		List<ShoppingQuestionVo> questionPageMoveList = shoppingQuestionService.pageMove(req, model);
		
		model.addAttribute("resultCode", "");
		model.addAttribute("type",  "");
		model.addAttribute("questionListPaging", questionPageMoveList);
		
		return "shoppingQeustionListPaging";
	}
	
}
