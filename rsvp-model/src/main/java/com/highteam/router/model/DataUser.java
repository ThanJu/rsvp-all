package com.highteam.router.model;

import java.util.Date;

public class DataUser {
    private Integer dataUserId;

    private Date createTime;

    private Integer activityInfoId;

    private String weixinId;

    private String userName;

    public Integer getDataUserId() {
        return dataUserId;
    }

    public void setDataUserId(Integer dataUserId) {
        this.dataUserId = dataUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getActivityInfoId() {
        return activityInfoId;
    }

    public void setActivityInfoId(Integer activityInfoId) {
        this.activityInfoId = activityInfoId;
    }

    public String getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(String weixinId) {
        this.weixinId = weixinId == null ? null : weixinId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}