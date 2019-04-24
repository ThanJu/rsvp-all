package com.highteam.router.oauth2.model;

import java.io.Serializable;

public class UserAccessToken implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1170678072329394067L;

	private String access_token;
	
	private String token_type;
	
	private String refresh_token;
	
	private int expires_in;
	
	private String error;
	
	private String error_description;
	
	private String scope;
	
	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	private boolean success;

	public boolean isSuccess() {
		this.setting();
		return success;
	}

    private void setting(){
    	if( null!=access_token &&!"".equals(access_token)){
    		this.success = true;
    	}
    }
	

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getError_description() {
		return error_description;
	}

	public void setError_description(String error_description) {
		this.error_description = error_description;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	
}
