package com.highteam.router.m;

import java.io.Serializable;


import com.highteam.router.s.RouteVersion;

public class RequestPath implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5901410439469106914L;

	private String appModule;
	
	private String businessType;
	
	private String businessAction;
	
	private String version =RouteVersion.VERSION;
	
	public RequestPath() {
		
	}
	
    public RequestPath(String r) {
		String[] s =  r.split("-");
		if(r!=null && r.length()>2) {
			this.appModule = s[0];
			this.businessType = s[1];
			this.businessAction = s[2];
		}
    	
	}
    public RequestPath(String r,String version) {
		String[] s =  r.split("-");
		if(r!=null && r.length()>2) {
			this.appModule = s[0];
			this.businessType = s[1];
			this.businessAction = s[2];
		}
    	
		this.version =version;
	}
    
	public RequestPath(String appModule, String businessType, String businessAction) {
		this.appModule = appModule;
		this.businessType = businessType;
		this.businessAction = businessAction;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(appModule+"#");
		sb.append(businessType+"#");
		sb.append(businessAction+"#");
		sb.append(version);
		return sb.toString();
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAppModule() {
		return appModule;
	}

	public void setAppModule(String appModule) {
		this.appModule = appModule;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getBusinessAction() {
		return businessAction;
	}

	public void setBusinessAction(String businessAction) {
		this.businessAction = businessAction;
	}

}
