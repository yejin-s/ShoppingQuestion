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
	 * SHA-256 방법으로 비밀번호 암호화
	 */
	@Override
	public String userJoin(ShoppingUserVo shoppingUserVo) {
		
		Sha256 sha256 = new Sha256();
		String encryptPassword = null;
		String resultCode = "";
		
		try {
			// Sha256 객체를 만들어 입력한 비밀번호를 암호화 한다.
			encryptPassword = sha256.encrypt(shoppingUserVo.getUserPassword());
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		// 암호화한 비밀번호를 다시 Vo에 담아 insert 해준다.
		shoppingUserVo.setUserPassword(encryptPassword);
		
		try {
			shoppingUserDao.userJoin(shoppingUserVo);
			resultCode = QuestionEnum.RESULT_SUCCESS.getValue();
			LOG.info("[USER] userJoin : " +  resultCode);
			
		} catch (Exception e) {
			resultCode = QuestionEnum.RESULT_FAIL.getValue();
			LOG.error("[USER] userJoin : " +  resultCode);
		}
		
		
		return encryptPassword;
	}

	/**
	 * 로그인 /
	 * 로그인 페이지에서 가져온 비밀번호를 SHA-256 방식으로 암호화
	 */
	@Override
	public ShoppingUserVo loginCheck(HttpServletRequest req) {
		
		Sha256 sha256 = new Sha256();
		String encryptPassword = null;
		
		try {
			// 비밀번호를 Sha256객체로 암호화 해준다.
			encryptPassword = sha256.encrypt(req.getParameter("userPassword"));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		// 암호화 한 비밀번호를 Vo에 담아 select문에서 조건을 걸어준다.
		ShoppingUserVo shoppingUserVo = new ShoppingUserVo();
		shoppingUserVo.setUserId(req.getParameter("userId"));
		shoppingUserVo.setUserName(req.getParameter("userName"));
		shoppingUserVo.setUserPassword(encryptPassword);
			
		ShoppingUserVo resultLoginCheckVo = shoppingUserDao.loginUserInfomation(shoppingUserVo);
		 
		 return resultLoginCheckVo;
		
	}
}
