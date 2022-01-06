package com.yejin.spring.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yejin.spring.vo.ShoppingUserVo;

@Repository
public class ShoppingUserDaoImpl implements ShoppingUserDao{

	@Autowired
	SqlSession sqlSession;

	@Override
	public ShoppingUserVo idCheck(String userId) {

		ShoppingUserVo shoppingUserVo = sqlSession.selectOne("joinIdCheck", userId);
		
		return shoppingUserVo;
	}

	@Override
	public void userJoin(ShoppingUserVo shoppingUserVo) {
		
		sqlSession.insert("userJoin", shoppingUserVo);
	}

	@Override
	public ShoppingUserVo loginUserInfomation(ShoppingUserVo shoppingUserVo) {
		
		ShoppingUserVo resultLoginCheckVo = sqlSession.selectOne("loginUserInfomation", shoppingUserVo);
		
		return resultLoginCheckVo;
	}
	
	
}
