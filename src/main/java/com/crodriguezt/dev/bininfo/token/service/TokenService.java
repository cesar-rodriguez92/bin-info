package com.crodriguezt.dev.bininfo.token.service;

import java.util.Map;

import com.crodriguezt.dev.bininfo.token.json.Token;
import org.springframework.http.ResponseEntity;

public interface TokenService {

	ResponseEntity getTokenService(Map<String, Object> data, String apiKey);

}
