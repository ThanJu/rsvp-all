package com.highteam.router.model;

public class AppLogWithBLOBs extends AppLog {
    private String requestdata;

    private String responsedata;

    public String getRequestdata() {
        return requestdata;
    }

    public void setRequestdata(String requestdata) {
        this.requestdata = requestdata == null ? null : requestdata.trim();
    }

    public String getResponsedata() {
        return responsedata;
    }

    public void setResponsedata(String responsedata) {
        this.responsedata = responsedata == null ? null : responsedata.trim();
    }
}