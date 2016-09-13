package com.jaime.logs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping(path= "/log", method=RequestMethod.GET)
	public void hello(){
		
		for(int i=0; i<20;i++){
			if((i % 2) == 0)
				logger.info("Log desde el controller_" + i);
			else{
				logger.debug("Log desde el controller_" + i);
			}
		}
	}

}
