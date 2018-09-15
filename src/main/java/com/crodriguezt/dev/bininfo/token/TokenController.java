package com.crodriguezt.dev.bininfo.token;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crodriguezt.dev.bininfo.token.common.RestPaths;
import com.crodriguezt.dev.bininfo.token.json.Token;
import com.crodriguezt.dev.bininfo.token.service.TokenService;

@RestController
@RequestMapping(RestPaths.PATH_TOKENS)
public class TokenController {

	@Autowired
	TokenService tokenService;

	Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Token getToken(@RequestBody Map<String, Object> data) {

		log.info("Ini getToken: " + data);
		Token token = tokenService.getTokenService(data);
		log.info("Response getToken: " + token);
		return token;
	}

}
