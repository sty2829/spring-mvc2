package com.test.sp1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.sp1.api.MovieAPI;
import com.test.sp1.service.MovieService;
import com.test.sp1.xml.movie.Result;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieAPI movieAPI;
	
	@Override
	public Result getResult() {
		return movieAPI.getResult();
	}

}
