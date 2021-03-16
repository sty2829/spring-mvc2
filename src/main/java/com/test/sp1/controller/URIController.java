package com.test.sp1.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class URIController {

	private static final Logger log = LoggerFactory.getLogger(URIController.class);
	
	@RequestMapping(value = "/views/**", method = RequestMethod.GET)
	public String goPage(HttpServletRequest request) {
		String cmd = request.getRequestURI().substring(7);
		log.info("path => {}", cmd);
		return cmd;
	}
}
