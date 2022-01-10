package com.yejin.spring.service;

import javax.servlet.http.HttpServletRequest;

import com.yejin.spring.vo.ShoppingUserVo;

/**
 * @author 설예진
 * 유저 로그인, 회원가입 서비스 인터페이스
 */
public interface ShoppingUserService {
	
	/**
	 * 아이디 중복 확인
	 * @param shoppingUserVo
	 * @return String
	 */
	public String joinIdCheck(ShoppingUserVo shoppingUserVo);
	
	/**
	 * 회원가입
	 * @param shoppingUserVo
	 */
	public String userJoin(ShoppingUserVo shoppingUserVo);
	
	/**
	 * 로그인
	 * @param req
	 * @return ShoppingUserVo
	 */
	public ShoppingUserVo loginCheck(HttpServletRequest req);
	
}
