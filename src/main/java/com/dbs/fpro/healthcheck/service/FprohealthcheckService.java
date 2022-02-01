package com.dbs.fpro.healthcheck.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dbs.fpro.healthcheck.model.FprohealthcheckResponse;
import com.dbs.fpro.healthcheck.repository.FprohealthcheckRepo;

@Service
@Component
@Configuration
public class FprohealthcheckService {

	@Autowired
	private FprohealthcheckResponse model;
	@Autowired
	private FprohealthcheckRepo repo;
	@Autowired
	private RestTemplate restTemplate = new RestTemplate();

	public void check(List<String> urls) throws Exception {
		System.out.println("URLs======>" + urls);
		urls.forEach(x -> {
			try {
				if (200 == verify(x)) {
					
					model = new FprohealthcheckResponse();
					model.setDate(LocalDateTime.now());
					model.setServiceUrl(x);
					model.setStatus("Success");
					System.out.println("url"+model.getServiceUrl()+"*****"+model.getStatus()+"*************"+model.getDate());
					repo.save(model);
					System.out.println("Loaded successfully");

				} else {
					model = new FprohealthcheckResponse();
					model.setDate(LocalDateTime.now());
					model.setServiceUrl(x);
					model.setStatus("Failed");
					repo.save(model);
					System.out.println("**********Failed***********");

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

	}

	public int verify(String url) throws Exception {

		try {
			URI uri = new URI(url);
			int responseCode = restTemplate.getForEntity(uri, String.class).getStatusCodeValue();
			System.out.println("responseCode======>"+responseCode);
			return responseCode;
		}

		catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return 0;
	}

}
