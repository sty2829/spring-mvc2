package com.test.sp1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.sp1.entity.Papago;
import com.test.sp1.entity.papago.PapagoResult;
import com.test.sp1.service.PapagoService;

@Controller
public class PapagoController {

	private static final Logger log = LoggerFactory.getLogger(PapagoController.class);
	
	@Autowired
	private PapagoService papagoService;
	
	@RequestMapping(value = "/papago", method = RequestMethod.GET)
	public @ResponseBody PapagoResult getPapago(Papago papago) {
		log.debug("papago => {}", papago);
		return papagoService.getPapagoResult(papago);
	}
}
