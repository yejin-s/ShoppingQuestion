package com.yejin.spring.service;

import javax.servlet.http.HttpServletRequest;

import com.yejin.spring.vo.ShoppingUserVo;

public interface ShoppingUserService {
	
	public String joinIdCheck(ShoppingUserVo shoppingUserVo);
	
	public void userJoin(ShoppingUserVo shoppingUserVo);
	
	public ShoppingUserVo loginCheck(HttpServletRequest req);
	
//	public ShoppingUserVo loginUserInfomation(HttpServletRequest req);

}
