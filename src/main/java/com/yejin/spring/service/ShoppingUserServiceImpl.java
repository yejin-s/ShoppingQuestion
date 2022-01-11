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
 * @author ������
 * ���� �α���, ȸ������ ����
 */
@Service
public class ShoppingUserServiceImpl implements ShoppingUserService{

	private static final Logger LOG = LoggerFactory.getLogger(ShoppingQuestionController.class);
	
	@Autowired
	ShoppingUserDao shoppingUserDao;

	/**
	 * ���̵� �ߺ�Ȯ�� / 
	 * ��� ������ ���̵� : "Y" / ��� �Ұ����� ���̵� : "N"
	 */
	@Override
	public String joinIdCheck(ShoppingUserVo shoppingUserVo) {
		
		String userId = shoppingUserVo.getUserId();
		
		ShoppingUserVo resultUserVo = shoppingUserDao.idCheck(userId);
	
		// �ߺ�Ȯ�� �� ���̵� DB�� ������ ��� ������ ���̵�� Y�� �������ְ�, DB�� ������ ��� �Ұ����� ���̵�� N�� �������ش�.
		if(resultUserVo == null) {
			return "Y";
		}else {
			
			return "N";
		}
	}

	/**
	 *	���� ȸ������ / 
	 * SHA-256 ������� Co���� ��й�ȣ ��ȣȭ
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
	 * �α��� /
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
