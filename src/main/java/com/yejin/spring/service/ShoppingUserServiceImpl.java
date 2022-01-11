package com.yejin.spring.service;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yejin.spring.ShoppingQuestionController;
import com.yejin.spring.dao.ShoppingUserDao;
import com.yejin.spring.sha256.Sha256;
import com.yejin.spring.util.QuestionEnum;
import com.yejin.spring.vo.ShoppingUserVo;

/**
 * @author 설예진
 * 유저 로그인, 회원가입 서비스
 */
@Service
public class ShoppingUserServiceImpl implements ShoppingUserService{

	private static final Logger LOG = LoggerFactory.getLogger(ShoppingQuestionController.class);
	
	@Autowired
	ShoppingUserDao shoppingUserDao;

	/**
	 * 아이디 중복확인 / 
	 * 사용 가능한 아이디 : "Y" / 사용 불가능한 아이디 : "N"
	 */
	@Override
	public String joinIdCheck(ShoppingUserVo shoppingUserVo) {
		
		String userId = shoppingUserVo.getUserId();
		
		ShoppingUserVo resultUserVo = shoppingUserDao.idCheck(userId);
	
		// 중복확인 할 아이디가 DB에 없으면 사용 가능한 아이디로 Y를 리턴해주고, DB에 있으면 사용 불가능한 아이디로 N을 리턴해준다.
		if(resultUserVo == null) {
			return "Y";
		}else {
			
			return "N";
		}
	}

	/**
	 *	유저 회원가입 / 
	 * SHA-256 방법으로 Co에서 비밀번호 암호화
	 */
	@Override
	public String userJoin(ShoppingUserVo shoppingUserVo) {
		
		String resultCode = "";
		
		try {
			shoppingUserDao.userJoin(shoppingUserVo);
			resultCode = QuestionEnum.JOIN_SUCCESS.getValue();
			LOG.info("[USER] userJoin : " +  resultCode);
			
		} catch (Exception e) {
			resultCode = QuestionEnum.JOIN_FAIL.getValue();
			LOG.error("[USER] userJoin : " +  resultCode);
		}
		
		return resultCode;
	}

	/**
	 * 로그인 /
	 */
	@Override
	public ShoppingUserVo loginCheck(HttpServletRequest req) {
		
		ShoppingUserVo shoppingUserVo = new ShoppingUserVo();
		
		shoppingUserVo.setUserId(req.getParameter("userId"));
		shoppingUserVo.setUserName(req.getParameter("userName"));
		shoppingUserVo.setUserPassword(req.getParameter("userPassword"));
			
		ShoppingUserVo resultLoginCheckVo = shoppingUserDao.loginUserInfomation(shoppingUserVo);
		 
		 return resultLoginCheckVo;
		
	}
}
