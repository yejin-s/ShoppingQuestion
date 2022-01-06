package com.yejin.spring.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yejin.spring.vo.ShoppingJoinUserVo;

@Repository
public class ShoppingJoinUserDaoImpl implements ShoppingJoinUserDao{

	@Autowired
	SqlSession sqlSession;

	@Override
	public ShoppingJoinUserVo joinIdCheck(String userId) {

		ShoppingJoinUserVo shoppingJoinUserVo = sqlSession.selectOne("joinIdCheck", userId);
		
		return shoppingJoinUserVo;
	}

	@Override
	public void userJoin(ShoppingJoinUserVo shoppingJoinUserVo) {
		
		sqlSession.insert("userJoin", shoppingJoinUserVo);
	}
	
	
}
