package com.crodriguezt.dev.bininfo.token.service;

import java.util.Map;

import com.crodriguezt.dev.bininfo.token.json.Token;

public interface TokenService {

	Token getTokenService(Map<String, Object> data);

}
