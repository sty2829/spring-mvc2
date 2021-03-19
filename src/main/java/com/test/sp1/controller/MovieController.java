package com.test.sp1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.sp1.entity.movie.Result;
import com.test.sp1.service.MovieService;

@Controller
public class MovieController {

	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public @ResponseBody Result getResult() {
		return movieService.getResult();
	}
}
