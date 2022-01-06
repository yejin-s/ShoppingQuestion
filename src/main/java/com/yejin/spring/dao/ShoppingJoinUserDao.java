package com.yejin.spring.dao;

import com.yejin.spring.vo.ShoppingJoinUserVo;

public interface ShoppingJoinUserDao {
	
	public ShoppingJoinUserVo joinIdCheck(String userId);
	
	public void userJoin(ShoppingJoinUserVo shoppingJoinUserVo);

}
