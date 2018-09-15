package com.crodriguezt.dev.bininfo.token.json;

public class Token {

	private String token;
	private String brand;
	private String creation_dt;

	public Token() {
	}

	public Token(String token, String brand, String creation_dt) {
		this.token = token;
		this.brand = brand;
		this.creation_dt = creation_dt;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCreation_dt() {
		return creation_dt;
	}

	public void setCreation_dt(String creation_dt) {
		this.creation_dt = creation_dt;
	}

	@Override
	public String toString() {
		return "Token [token=" + token + ", brand=" + brand + ", creation_dt=" + creation_dt + "]";
	}

}
