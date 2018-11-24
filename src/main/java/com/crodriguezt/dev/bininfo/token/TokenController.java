package com.crodriguezt.dev.bininfo.token;

import java.util.Map;

import com.crodriguezt.dev.bininfo.token.common.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crodriguezt.dev.bininfo.token.common.RestPaths;
import com.crodriguezt.dev.bininfo.token.json.Token;
import com.crodriguezt.dev.bininfo.token.service.TokenService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(RestPaths.PATH_TOKENS)
public class TokenController {

	@Autowired
	TokenService tokenService;

	Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Token> getToken(@RequestBody Map<String, Object> data, HttpServletRequest httpServletRequest) {

		log.info("******************************************************");
		log.info("**************************************");
		log.info("Inicializando obtener token");
		String apiKey = httpServletRequest.getHeader(Constants.X_API_KEY);
		log.info("Ini getToken: " + data);
		ResponseEntity response = tokenService.getTokenService(data, apiKey);

				log.info("Response getToken: " + response);
		return response;
	}

}
