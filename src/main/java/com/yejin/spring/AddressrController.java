package com.yejin.spring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 설예진
 * 주소 컨트롤러
 */
@Controller
public class AddressrController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AddressrController.class);
	
	/**
	 * 주소 입력 페이지로 가는 메서드
	 * @return userLoginPage
	 */
	@RequestMapping(value = "/addressPage", method = RequestMethod.GET)
	public String addressPage() {
		
		return "addressPage";
	}
	
}
