package com.dbs.fpro.healthcheck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dbs.fpro.healthcheck.service.FprohealthcheckService;

@Component
public class FprohealthcheckController {

	@Value("#{'${myapp.urls}'.split(',')}") 
	private List<String> urls;
	
	@Autowired
	private FprohealthcheckService service;

	@Scheduled(cron = ("${cron}"))
	public void healthCheck() throws Exception{

		service.check(urls);

	}

	
	/*
	 * @Bean public static FprohealthcheckService getServiceInstance() { return new
	 * FprohealthcheckService(); }
	 */
	 

}
