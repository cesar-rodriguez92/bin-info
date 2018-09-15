package com.crodriguezt.dev.bininfo.token.util;

import com.crodriguezt.dev.bininfo.token.common.Constants;

public class TokenUtil {

	public static String getBinFromCard(String cardNumber) {
		String bin = (cardNumber != null && !cardNumber.equals(Constants.VACIO)
				? cardNumber.substring(0, Constants.BIN_LENGTH) : null);
		System.out.println("BIN: " + bin);
		return bin;
	}

	public static String generateTokenLive(String pan, int expYear, int expMonth) {
		return String.format("%s%s-%s-%s", Constants.TKN_LIVE, pan, expYear, expMonth);
	}

}
