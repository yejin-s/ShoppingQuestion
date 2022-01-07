package com.yejin.spring.dao;

import com.yejin.spring.vo.ShoppingUserVo;

/**
 * @author 설예진
 * 유저 로그인, 회원가임 Dao 인터페이스
 */
public interface ShoppingUserDao {
	
	/**
	 * 아이디 중복확인
	 * @param userId
	 * @return ShoppingUserVo
	 */
	public ShoppingUserVo idCheck(String userId);
	
	/**
	 * 회원가입
	 * @param shoppingUserVo
	 */
	public void userJoin(ShoppingUserVo shoppingUserVo);
	
	/**
	 * 유저 정보 가져오기
	 * @param shoppingUserVo
	 * @return ShoppingUserVo
	 */
	public ShoppingUserVo loginUserInfomation(ShoppingUserVo shoppingUserVo);

}
