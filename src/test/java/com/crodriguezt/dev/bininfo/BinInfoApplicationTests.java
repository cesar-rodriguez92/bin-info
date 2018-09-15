package com.crodriguezt.dev.bininfo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crodriguezt.dev.bininfo.token.common.Constants;
import com.crodriguezt.dev.bininfo.token.service.TokenService;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BinInfoApplicationTests extends TestCase {

	@Autowired
	private TokenService tokenService;

	@Test
	public void testNotNull() {
		Map<String, Object> data = new HashMap<>();
		data.put(Constants.PAN, "4444333322221111");
		data.put(Constants.EXP_YEAR, 2020);
		data.put(Constants.EXP_MONTH, 10);
		assertNotNull(tokenService.getTokenService(data));
	}

	@Test
	public void testVisa() {
		String scheme = "visa";
		Map<String, Object> data = new HashMap<>();
		data.put(Constants.PAN, "4111111111111111");
		data.put(Constants.EXP_YEAR, 2020);
		data.put(Constants.EXP_MONTH, 10);
		assertEquals(scheme, tokenService.getTokenService(data).getBrand());
	}

	@Test
	public void testMc() {
		String scheme = "mastercard";
		Map<String, Object> data = new HashMap<>();
		data.put(Constants.PAN, "5555555555554444");
		data.put(Constants.EXP_YEAR, 2020);
		data.put(Constants.EXP_MONTH, 10);
		assertEquals(scheme, tokenService.getTokenService(data).getBrand());
	}

}
