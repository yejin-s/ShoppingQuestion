package com.yejin.spring.service;

import org.springframework.ui.Model;

import com.yejin.spring.vo.ShoppingJoinUserVo;

public interface ShoppingJoinUserService {
	
	public String joinIdCheck(ShoppingJoinUserVo shoppingJoinUserVo, Model model);
	
	public void userJoin(ShoppingJoinUserVo shoppingJoinUserVo);

}
