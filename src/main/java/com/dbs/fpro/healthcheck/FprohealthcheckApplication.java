package com.dbs.fpro.healthcheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.dbs.fpro.healthcheck.controller.FprohealthcheckController;

@SpringBootApplication
@EnableScheduling
public class FprohealthcheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(FprohealthcheckApplication.class, args);
	}

	@EventListener
	public void onApplictionEvent(ContextStartedEvent e) throws Exception
	{
		FprohealthcheckController controller =new FprohealthcheckController();
		controller.healthCheck();
	}
	
	@Bean
	public RestTemplate restTemplate()  {
		return new RestTemplate();
	}
}
