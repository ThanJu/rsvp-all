package com.highteam.router.m;

import java.io.Serializable;

import com.highteam.router.s.RouteVersion;

public class BusinessParam implements Serializable {
    private static final long serialVersionUID = -7115407057446321113L;
    
    private String businessName;

    private String businessKey;

    private String businessType;

    private String businessAction;
    
    private String version = RouteVersion.VERSION.toString();
    
    public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
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
