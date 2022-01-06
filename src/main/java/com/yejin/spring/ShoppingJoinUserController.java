package com.yejin.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yejin.spring.service.ShoppingJoinUserService;
import com.yejin.spring.vo.ShoppingJoinUserVo;

@Controller
public class ShoppingJoinUserController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ShoppingJoinUserController.class);
	
	@Autowired
	ShoppingJoinUserService shoppingJoinUserService;
	
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
	public String joinIdCheck(ShoppingJoinUserVo shoppingJoinUserVo, Model model) {
		
		String idCheckResult = shoppingJoinUserService.joinIdCheck(shoppingJoinUserVo, model);
		
		return idCheckResult;
	}
	
	@RequestMapping(value = "/shopping/userJoin", method = RequestMethod.POST)
	public String userJoin(ShoppingJoinUserVo shoppingJoinUserVo) {
		
		shoppingJoinUserService.userJoin(shoppingJoinUserVo);
		
		return "redirect:/shopping/loginPage";
	}
}
