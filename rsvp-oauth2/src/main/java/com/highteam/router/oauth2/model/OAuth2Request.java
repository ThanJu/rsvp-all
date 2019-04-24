package com.highteam.router.oauth2.model;

import java.io.Serializable;

public class OAuth2Request implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3112535163174015519L;

	private Boolean status =false;
	
	private String code;
	
	private Object data;
	
	private String msg;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
