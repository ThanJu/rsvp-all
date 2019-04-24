package com.highteam.router.oauth2.config;

import java.io.Serializable;

public class OAuth2Config implements Serializable {

	private static final long serialVersionUID = -7750365576041018001L;
	private String authUrl;

	private String accessTokenKey;
	
	private String refeshTokenKey;

	private String aesKey;

	private String domain;
	
	private int refeshTokenValidity =43200;
	
	private int accessTokenValidity =20;
	
	private boolean secure =false;
	
	private String homePage ="/index.html";
	
	private String app ="";


	/**
	 * 用户缓存cookie
	 */
	private String caf ="caf";
	
	public final static String ACCESS_TOKEN  ="access_token";
	
	public final static String REFESH_TOKEN  ="refesh_token";
	
	public final static String USER_CONTENT ="_user_content";
	
	private String grantType ="password";
	
	private String clientId ="";
	
	private String clientSecret ="";
	
	private String scope ="";
	
	//是否启用验证码功能
	private boolean enableVcode = true;
	
	private String vCodeParam ="verifyCode";
	
	private boolean enableTestUser = false;

	public boolean isEnableTestUser() {
		return enableTestUser;
	}

	public void setEnableTestUser(boolean enableTestUser) {
		this.enableTestUser = enableTestUser;
	}

	public String getvCodeParam() {
		return vCodeParam;
	}

	public void setvCodeParam(String vCodeParam) {
		this.vCodeParam = vCodeParam;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public boolean isEnableVcode() {
		return enableVcode;
	}

	public void setEnableVcode(boolean enableVcode) {
		this.enableVcode = enableVcode;
	}


	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	/**
	 * 认证通过后回调
	 */
	private String _callback ="_callback";

	public String get_callback() {
		return _callback;
	}

	public void set_callback(String _callback) {
		this._callback = _callback;
	}

	public int getRefeshTokenValidity() {
		return refeshTokenValidity;
	}

	public void setRefeshTokenValidity(int refeshTokenValidity) {
		this.refeshTokenValidity = refeshTokenValidity;
	}

	public int getAccessTokenValidity() {
		return accessTokenValidity;
	}

	public void setAccessTokenValidity(int accessTokenValidity) {
		this.accessTokenValidity = accessTokenValidity;
	}

	public String getAuthUrl() {
		return authUrl;
	}

	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}

	public String getAccessTokenKey() {
		return accessTokenKey;
	}

	public void setAccessTokenKey(String accessTokenKey) {
		this.accessTokenKey = accessTokenKey;
	}

	public String getAesKey() {
		return aesKey;
	}

	public void setAesKey(String aesKey) {
		this.aesKey = aesKey;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getRefeshTokenKey() {
		return refeshTokenKey;
	}

	public void setRefeshTokenKey(String refeshTokenKey) {
		this.refeshTokenKey = refeshTokenKey;
	}

	public boolean isSecure() {
		return secure;
	}

	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	public String getCaf() {
		return caf;
	}

	public void setCaf(String caf) {
		this.caf = caf;
	}

}
