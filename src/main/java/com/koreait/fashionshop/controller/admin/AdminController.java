  
package com.koreait.fashionshop.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	//관리자모드 메인 요청
	@RequestMapping("/admin/main")
	public ModelAndView adminMain(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/main");
		
		return mav;
	}
}