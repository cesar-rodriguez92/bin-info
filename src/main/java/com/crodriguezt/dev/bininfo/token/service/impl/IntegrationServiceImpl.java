package com.crodriguezt.dev.bininfo.token.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.crodriguezt.dev.bininfo.token.service.IntegrationService;

@Service("integrationService")
public class IntegrationServiceImpl implements IntegrationService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Value("${binlist.url}")
	private String url;

	@Override
	public Map<String, Object> getBinInfo(String bin) {

		Map<String, Object> responseData = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<?> httpEntity = new HttpEntity<Object>(null, null);
			ResponseEntity<Object> responseEntityObject = restTemplate.exchange(url + bin, HttpMethod.GET, httpEntity,
					Object.class);
			log.info("Response binList: " + responseEntityObject);
			responseData = (Map<String, Object>) responseEntityObject.getBody();
		} catch (Exception e) {
			log.error("Error en getBinInfo: ", e);
			responseData = null;
		}
		return responseData;
	}

}
