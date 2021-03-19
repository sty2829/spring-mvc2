package com.test.sp1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.sp1.api.PapagoAPI;
import com.test.sp1.entity.Papago;
import com.test.sp1.entity.papago.PapagoResult;
import com.test.sp1.service.PapagoService;

@Service
public class PapagoServiceImpl implements PapagoService {

	@Autowired
	private PapagoAPI papagoAPI;
	
	@Override
	public PapagoResult getPapagoResult(Papago papago) {
		return papagoAPI.getPapagoResult(papago);
	}

}
