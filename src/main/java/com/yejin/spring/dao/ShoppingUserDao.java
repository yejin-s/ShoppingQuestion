package com.yejin.spring.dao;

import com.yejin.spring.vo.ShoppingUserVo;

public interface ShoppingUserDao {
	
	public ShoppingUserVo idCheck(String userId);
	
	public void userJoin(ShoppingUserVo shoppingUserVo);
	
	public ShoppingUserVo loginUserInfomation(ShoppingUserVo shoppingUserVo);

}
