package com.highteam.router.m;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.highteam.router.s.RouteVersion;

public class AppRequest implements Serializable {
	
	private static final long serialVersionUID = 1842830682094467739L;

	private String businessParam;
    
    private String version = RouteVersion.VERSION;
    
    private Map<String,Object> model = new HashMap<>();

	public String getBusinessParam() {
		return businessParam;
	}

	public void setBusinessParam(String businessParam) {
		this.businessParam = businessParam;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	
}
