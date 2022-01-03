package com.yejin.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yejin.spring.service.ShoppingQuestionBoardService;
import com.yejin.spring.vo.ShoppingQuestionBoardVo;

@Controller
public class HomeController {
	
	@Autowired
	ShoppingQuestionBoardService shoppingQuestionBoardService;
	
	// 글 목록 컨트롤러
	// DB에 있는 모든 글정보를 가지고 home.jsp(글목록 페이지)로 이동.
	@RequestMapping(value = "/shoppingQuestion/boardList")
	public String boardList(HttpServletRequest req, Model model) {
		List<ShoppingQuestionBoardVo> shoppingQuestionBoardList = shoppingQuestionBoardService.shoppingQuestionBoardList(req, model);
		
		model.addAttribute("shoppingQuestionBoardList", shoppingQuestionBoardList);
		
		return "home";
	}
	
	// 글 쓰기 컨트롤러
	// shoppingQuestionBoardWrite.jsp(글쓰기 페이지)로 이동
	@RequestMapping(value = "/shoppingQuestion/boardWrite")
	public String boardWrite(HttpServletRequest req, Model model) {
		
		return "shoppingQuestionBoardWrite";
	}
	
	// 작성한 글 등록하는 컨트롤러
	// 작성한 글 정보들을 가지고 DB에 insert 후 글 목록 컨트롤러로 이동
	@RequestMapping(value = "/shoppingQuestion/boardWriteEnrollment")
	public String boardWriteEnrollment(HttpServletRequest req, Model model) {
	
		shoppingQuestionBoardService.boardWriteEnrollment(req, model);

		return "redirect:/shoppingQuestion/boardList";
	}
	
	// 글 제목 눌렀을 때, 상세정보 보여주는 컨트롤러
	// 글 번호로 DB 접근 후 해당 정보를 가지고 shoppingQuestionBoardDetail.jsp(상세 페이지)로 이동
	@RequestMapping(value = "/shoppingQuestion/boardDetail")
	public String boardDetail(HttpServletRequest req, Model model) {
		
		ShoppingQuestionBoardVo shoppingQuestionBoardDetail = shoppingQuestionBoardService.boardDetail(req, model);
		
		model.addAttribute("shoppingQuestionBoardDetail", shoppingQuestionBoardDetail);

		return "shoppingQuestionBoardDetail";
	}
	
	// 글 수정하는 페이지로 가는 컨트롤러
	// 수정할 글의 정보를 가지고 shoppingQuestionBoardUpdatePage.jsp(수정 페이지)로 이동
	@RequestMapping(value = "/shoppingQuestion/boardUpdatePage")
	public String boardUpdatePage(HttpServletRequest req, Model model) {
		
		ShoppingQuestionBoardVo shoppingQuestionBoardDetail = shoppingQuestionBoardService.boardDetail(req, model);
		
		model.addAttribute("shoppingQuestionBoardDetail", shoppingQuestionBoardDetail);
		
		return "shoppingQuestionBoardUpdatePage";
	}
	
	// 글 수정한 내용 업데이트하는 컨트롤러
	// 수정한 내용과 글 정보 update 한 후 shoppingQuestionBoardDetail.jsp(상세 페이지)로 이동
	@RequestMapping(value = "/shoppingQuestion/boardUpdate")
	public String boardUpdate(HttpServletRequest req, Model model) {
		
		shoppingQuestionBoardService.boardUpdate(req, model);
		
		ShoppingQuestionBoardVo shoppingQuestionBoardDetail = shoppingQuestionBoardService.boardDetail(req, model);
		
		model.addAttribute("shoppingQuestionBoardDetail", shoppingQuestionBoardDetail);
		
		return "shoppingQuestionBoardDetail";
	}
	
	// 글 삭제하는 컨트롤러
	// 글 번호를 가지고 삭제 후 글 목록 컨트롤러로 이동
	// 글 삭제는 N에서 Y로 변경
	@RequestMapping(value = "/shoppingQuestion/boardDelete")
	public String boardDelete(HttpServletRequest req, Model model) {
		
		shoppingQuestionBoardService.boardDelete(req, model);
		
		return "redirect:/shoppingQuestion/boardList";
	}
}
