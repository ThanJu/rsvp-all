package com.highteam.router.common.vcode;


import com.highteam.router.common.util.ConfigUtil;

public class ValidateCodeModel {

	private String encryptKey = "validateCode-cookies-key";

	private int age = -1;

	private String cookieName = "VCC_TRIP_LOGIN";

	private String domain = ".domain.me";
		
	public String getDomain() {
		return ConfigUtil.getConfigParam("domain");
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getCookieName() {
		return cookieName;
	}

	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}

	public String getEncryptKey() {
		return encryptKey;
	}

	public void setEncryptKey(String encryptKey) {
		this.encryptKey = encryptKey;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
