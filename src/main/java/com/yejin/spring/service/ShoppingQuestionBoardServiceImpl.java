package com.yejin.spring.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

import com.yejin.spring.dao.ShoppingQuestionBoardDao;
import com.yejin.spring.vo.ShoppingQuestionBoardVo;

@Service
public class ShoppingQuestionBoardServiceImpl implements ShoppingQuestionBoardService {

	@Autowired 
	ShoppingQuestionBoardDao shppingQuestionBoardDao;
	
	// 게시글 목록에 보여줄 정보 가져오기
	// return : DB에 있는 모든 게시글 정보
	@Override
	public List<ShoppingQuestionBoardVo> shoppingQuestionBoardList(HttpServletRequest req, Model model) {
		
		List<ShoppingQuestionBoardVo> shoppingQuestionBoardList = null;
		
		try {
			shoppingQuestionBoardList = shppingQuestionBoardDao.shoppingQuestionBoardList();
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
		}
				

		return shoppingQuestionBoardList;
	}

	// 작성한 게시글 내용 등록하기
	// 입력 파라미터 : 작성한 게시글 정보 -> 작성자, 제목, 내용
	@Override
	public void boardWriteEnrollment(HttpServletRequest req, Model model) {
		
		ShoppingQuestionBoardVo shoppingQuestionBoardVo = new ShoppingQuestionBoardVo();
		shoppingQuestionBoardVo.setQuestionUser(req.getParameter("questionUser"));
		shoppingQuestionBoardVo.setQuestionTitle(req.getParameter("questionTitle"));
		shoppingQuestionBoardVo.setQuestionContent(req.getParameter("questionContent"));
	
		shppingQuestionBoardDao.boardWriteEnrollment(shoppingQuestionBoardVo);
	
	}

	// 클릭한 제목에 대한 게시글 정보 가져오기
	// 입력 파라미터 : 게시글 번호
	// return : 게시글 정보 -> 글번호, 작성자, 제목, 내용, 등록일, 수정일, 삭제여부
	@Override
	public ShoppingQuestionBoardVo boardDetail(HttpServletRequest req, Model model) {
		
		int boardNumber = Integer.parseInt(req.getParameter("questionNumber"));
		
		ShoppingQuestionBoardVo shoppingQeustionBoardDetail = null;
		
		try {
			shoppingQeustionBoardDetail = shppingQuestionBoardDao.boardDetail(boardNumber);
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
		}
		
		return shoppingQeustionBoardDetail;
	}

	// 게시글 수정하기
	// 입력 파라미터 : 게시글번호, 제목, 내용
	@Override
	public void boardUpdate(HttpServletRequest req, Model model) {
		
		int boardNumber = Integer.parseInt(req.getParameter("questionNumber"));
		String updateBoardTitle = req.getParameter("questionTitle");
		String updateBoardContent = req.getParameter("questionContent");
		
		ShoppingQuestionBoardVo updateShoppingQuestionBoardVo = new ShoppingQuestionBoardVo();
		updateShoppingQuestionBoardVo.setQuestionNumber(boardNumber);
		updateShoppingQuestionBoardVo.setQuestionTitle(updateBoardTitle);
		updateShoppingQuestionBoardVo.setQuestionContent(updateBoardContent);
		
		shppingQuestionBoardDao.boardUpdate(updateShoppingQuestionBoardVo);
		
		
	}

	// 게시글 삭제하기
	// 입력 파라미터 : 게시글 번호
	@Override
	public void boardDelete(HttpServletRequest req, Model model) {
		
		int questionNumber = Integer.parseInt(req.getParameter("questionNumber"));
		shppingQuestionBoardDao.boardDelete(questionNumber);
		
	}
}
