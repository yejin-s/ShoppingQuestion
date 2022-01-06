package com.yejin.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.yejin.spring.dao.ShoppingJoinUserDao;
import com.yejin.spring.vo.ShoppingJoinUserVo;

@Service
public class ShoppingJoinUserServiceImpl implements ShoppingJoinUserService{

	@Autowired
	ShoppingJoinUserDao shoppingJoinUserDao;

	@Override
	public String joinIdCheck(ShoppingJoinUserVo shoppingJoinUserVo, Model model) {
		
		String userId = shoppingJoinUserVo.getUserId();
		
		ShoppingJoinUserVo resultUserVo = shoppingJoinUserDao.joinIdCheck(userId);
	
		if(resultUserVo == null) {
			return "Y";
		}else {
			
			return "N";
		}
	}

	@Override
	public void userJoin(ShoppingJoinUserVo shoppingJoinUserVo) {

		shoppingJoinUserDao.userJoin(shoppingJoinUserVo);
		
	}
}
