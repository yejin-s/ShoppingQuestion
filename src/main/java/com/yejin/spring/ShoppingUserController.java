package com.yejin.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yejin.spring.service.ShoppingUserService;
import com.yejin.spring.vo.ShoppingUserVo;

/**
 * @author 설예진
 * user 회원가입, 로그인 컨트롤러
 */
@Controller
public class ShoppingUserController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ShoppingUserController.class);
	
	@Autowired
	ShoppingUserService shoppingUserService;
	
	/**
	 * login 페이지로 가는 메서드
	 * @return userLoginPage
	 */
	@RequestMapping(value = "/shopping/loginPage", method = RequestMethod.GET)
	public String loginPage() {
		
		return "userLoginPage";
	}
	
	/**
	 * 회원가입 페이지로 가는 메서드
	 * @return userJoinPage
	 */
	@RequestMapping(value = "/shopping/joinPage", method = RequestMethod.POST)
	public String joinPage() {
		
		return "userJoinPage";
	}
	
	/**
	 * 회원가입 시 아이디 중복확인 하는 메서드
	 * @param shoppingUserVo
	 * @return idCheckResult
	 */
	@ResponseBody
	@RequestMapping(value = "/shopping/joinIdCheck", method = RequestMethod.POST)
	public String joinIdCheck(ShoppingUserVo shoppingUserVo) {
		
		String idCheckResult = shoppingUserService.joinIdCheck(shoppingUserVo);
		
		return idCheckResult;
	}
	
	/**
	 * 회원가입 하는 메서드
	 * @param shoppingUserVo
	 * @return loginPage
	 */
	@RequestMapping(value = "/shopping/userJoin", method = RequestMethod.POST)
	public String userJoin(ShoppingUserVo shoppingUserVo) {
		
		shoppingUserService.userJoin(shoppingUserVo);
		
		return "redirect:/shopping/loginPage";
	}
	
	/**
	 * 로그인 하는 메서드
	 * @param req
	 * @return resultLoginCheckYN
	 */
	@ResponseBody
	@RequestMapping(value = "/shopping/loginCheck", method = RequestMethod.POST)
	public String loginCheck(HttpServletRequest req) {
		
		ShoppingUserVo resultLoginCheck = shoppingUserService.loginCheck(req);
		String resultLoginCheckYN = "N";
		
		if(resultLoginCheck != null) {
			
			resultLoginCheckYN = "Y";
			
			// 로그인에 성공하면 Session을 생성해준다.
			HttpSession session = req.getSession();
			session.setAttribute("userId", resultLoginCheck.getUserId());
			session.setAttribute("userName", resultLoginCheck.getUserName());
		}
		
		return resultLoginCheckYN;
	}
}
