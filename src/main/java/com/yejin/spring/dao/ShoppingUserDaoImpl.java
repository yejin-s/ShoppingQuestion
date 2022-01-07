package com.yejin.spring.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yejin.spring.vo.ShoppingUserVo;

/**
 * @author 설예진
 * 유저 로그인, 회원가입 Dao
 */
@Repository
public class ShoppingUserDaoImpl implements ShoppingUserDao{

	@Autowired
	SqlSession sqlSession;

	/**
	 * 아이디 중복확인
	 */
	@Override
	public ShoppingUserVo idCheck(String userId) {

		ShoppingUserVo shoppingUserVo = sqlSession.selectOne("joinIdCheck", userId);
		
		return shoppingUserVo;
	}

	/**
	 * 회원가입
	 */
	@Override
	public void userJoin(ShoppingUserVo shoppingUserVo) {
		
		sqlSession.insert("userJoin", shoppingUserVo);
	}

	/**
	 * 유저 정보 가져오기
	 */
	@Override
	public ShoppingUserVo loginUserInfomation(ShoppingUserVo shoppingUserVo) {
		
		ShoppingUserVo resultLoginCheckVo = sqlSession.selectOne("loginUserInfomation", shoppingUserVo);
		
		return resultLoginCheckVo;
	}
	
	
}
