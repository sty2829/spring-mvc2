package com.test.sp1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.sp1.service.MovieService;
import com.test.sp1.xml.movie.Result;

@Controller
public class MovieController {

	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public @ResponseBody Result getResult() {
		System.out.println("오나");
		return movieService.getResult();
	}
}
