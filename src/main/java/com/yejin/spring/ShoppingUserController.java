package com.yejin.spring;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yejin.spring.service.ShoppingUserService;
import com.yejin.spring.vo.ShoppingUserVo;

@Controller
public class ShoppingUserController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ShoppingUserController.class);
	
	@Autowired
	ShoppingUserService shoppingUserService;
	
	@RequestMapping(value = "/shopping/loginPage", method = RequestMethod.GET)
	public String loginPage() {
		
		return "userLoginPage";
	}
	
	@RequestMapping(value = "/shopping/joinPage", method = RequestMethod.POST)
	public String joinPage() {
		
		return "userJoinPage";
	}
	
	@ResponseBody
	@RequestMapping(value = "/shopping/joinIdCheck", method = RequestMethod.POST)
	public String joinIdCheck(ShoppingUserVo shoppingUserVo) {
		
		String idCheckResult = shoppingUserService.joinIdCheck(shoppingUserVo);
		
		return idCheckResult;
	}
	
	@RequestMapping(value = "/shopping/userJoin", method = RequestMethod.POST)
	public String userJoin(ShoppingUserVo shoppingUserVo) {
		
		shoppingUserService.userJoin(shoppingUserVo);
		
		return "redirect:/shopping/loginPage";
	}
	
	@ResponseBody
	@RequestMapping(value = "/shopping/loginCheck", method = RequestMethod.POST)
	public String loginCheck(HttpServletRequest req) {
		
		ShoppingUserVo resultLoginCheck = shoppingUserService.loginCheck(req);
		String resultLoginCheckYN = "N";
		
		if(resultLoginCheck != null) {
			
			resultLoginCheckYN = "Y";
			
			HttpSession session = req.getSession();
			session.setAttribute("userId", resultLoginCheck.getUserId());
			session.setAttribute("userName", resultLoginCheck.getUserName());
		}
		
		return resultLoginCheckYN;
	}
}
