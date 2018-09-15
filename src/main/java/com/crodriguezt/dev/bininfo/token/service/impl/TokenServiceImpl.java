package com.crodriguezt.dev.bininfo.token.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crodriguezt.dev.bininfo.token.common.Constants;
import com.crodriguezt.dev.bininfo.token.json.Token;
import com.crodriguezt.dev.bininfo.token.service.IntegrationService;
import com.crodriguezt.dev.bininfo.token.service.TokenService;
import com.crodriguezt.dev.bininfo.token.util.TokenUtil;

@Service("tokenService")
public class TokenServiceImpl implements TokenService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IntegrationService integrationService;

	@Override
	public Token getTokenService(Map<String, Object> data) {

		Token tokenResponse = null;

		try {
			String pan = (String) data.get(Constants.PAN);
			int expYear = (int) data.get(Constants.EXP_YEAR);
			int expMonth = (int) data.get(Constants.EXP_MONTH);
			String bin = TokenUtil.getBinFromCard(pan);
			if (bin == null) {
				throw new Exception();
			}

			Map<String, Object> responseIntegration = integrationService.getBinInfo(bin);
			if (responseIntegration == null) {
				throw new Exception();
			}

			String scheme = (String) responseIntegration.get(Constants.SCHEME);
			SimpleDateFormat sdf = new SimpleDateFormat(Constants.TIME_FORMAT);
			String creationDate = sdf.format(new Date());
			String tkn_live = TokenUtil.generateTokenLive(pan, expYear, expMonth);
			tokenResponse = new Token(tkn_live, scheme, creationDate);
		} catch (Exception e) {
			log.error("Error en getBinInfoService: ", e);
			tokenResponse = new Token(Constants.ERROR, null, null);
		}

		return tokenResponse;
	}

}
