package com.highteam.router.model;

import java.util.Date;

public class AppLog {
    private Long logid;

    private String requestid;

    private String headers;

    private String businessname;

    private String responsecode;

    private Boolean responsestatus;

    private String responsemsg;

    private Date createtime;

    public Long getLogid() {
        return logid;
    }

    public void setLogid(Long logid) {
        this.logid = logid;
    }

    public String getRequestid() {
        return requestid;
    }

    public void setRequestid(String requestid) {
        this.requestid = requestid == null ? null : requestid.trim();
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers == null ? null : headers.trim();
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname == null ? null : businessname.trim();
    }

    public String getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(String responsecode) {
        this.responsecode = responsecode == null ? null : responsecode.trim();
    }

    public Boolean getResponsestatus() {
        return responsestatus;
    }

    public void setResponsestatus(Boolean responsestatus) {
        this.responsestatus = responsestatus;
    }

    public String getResponsemsg() {
        return responsemsg;
    }

    public void setResponsemsg(String responsemsg) {
        this.responsemsg = responsemsg == null ? null : responsemsg.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}