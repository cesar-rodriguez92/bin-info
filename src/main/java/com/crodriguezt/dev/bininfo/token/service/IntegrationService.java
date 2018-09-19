package com.crodriguezt.dev.bininfo.token.service;

import java.util.Map;

public interface IntegrationService {

	Map<String, Object> getBinInfo(String bin);

	Map<String, Object> validateToken(String apiKey);

}
