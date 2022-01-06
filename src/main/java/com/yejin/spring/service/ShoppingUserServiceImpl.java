package com.yejin.spring.service;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yejin.spring.dao.ShoppingUserDao;
import com.yejin.spring.sha256.Sha256;
import com.yejin.spring.vo.ShoppingUserVo;

@Service
public class ShoppingUserServiceImpl implements ShoppingUserService{

	@Autowired
	ShoppingUserDao shoppingUserDao;

	@Override
	public String joinIdCheck(ShoppingUserVo shoppingUserVo) {
		
		String userId = shoppingUserVo.getUserId();
		
		ShoppingUserVo resultUserVo = shoppingUserDao.idCheck(userId);
	
		if(resultUserVo == null) {
			return "Y";
		}else {
			
			return "N";
		}
	}

	@Override
	public void userJoin(ShoppingUserVo shoppingUserVo) {
		
		Sha256 sha256 = new Sha256();
		String encryptPassword = null;
		
		try {
			encryptPassword = sha256.encrypt(shoppingUserVo.getUserPassword());
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		shoppingUserVo.setUserPassword(encryptPassword);
		

		shoppingUserDao.userJoin(shoppingUserVo);
		
	}

	@Override
	public ShoppingUserVo loginCheck(HttpServletRequest req) {
		
		Sha256 sha256 = new Sha256();
		String encryptPassword = null;
		
		try {
			encryptPassword = sha256.encrypt(req.getParameter("userPassword"));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		ShoppingUserVo shoppingUserVo = new ShoppingUserVo();
		shoppingUserVo.setUserId(req.getParameter("userId"));
		shoppingUserVo.setUserName(req.getParameter("userName"));
		shoppingUserVo.setUserPassword(encryptPassword);
			
		 ShoppingUserVo resultLoginCheckVo = shoppingUserDao.loginUserInfomation(shoppingUserVo);
		 
		 return resultLoginCheckVo;
		
	}

//	@Override
//	public ShoppingUserVo loginUserInfomation(HttpServletRequest req) {
//
//		ShoppingUserVo shoppingUserVo = new ShoppingUserVo();
//		shoppingUserVo.setUserId(req.getParameter("userId"));
//		shoppingUserVo.setUserName(req.getParameter("userName"));
//		shoppingUserVo.setUserPassword(req.getParameter("userPassword"));
//		
//		ShoppingUserVo loginUserInfomationVo = shoppingUserDao.loginUserInfomation(shoppingUserVo);
//		
//		return loginUserInfomationVo;
//	}
}
