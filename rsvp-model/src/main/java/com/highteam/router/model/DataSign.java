package com.highteam.router.model;

import java.util.Date;

public class DataSign {
    private Integer dataSignId;

    private Date createTime;

    private Integer activityInfoId;

    private Integer dataRegisterId;

    private String userName;

    private Integer signType;

    private String signTypeName;

    private String keepRecord;

    public Integer getDataSignId() {
        return dataSignId;
    }

    public void setDataSignId(Integer dataSignId) {
        this.dataSignId = dataSignId;
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

    public Integer getDataRegisterId() {
        return dataRegisterId;
    }

    public void setDataRegisterId(Integer dataRegisterId) {
        this.dataRegisterId = dataRegisterId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getSignType() {
        return signType;
    }

    public void setSignType(Integer signType) {
        this.signType = signType;
    }

    public String getSignTypeName() {
        return signTypeName;
    }

    public void setSignTypeName(String signTypeName) {
        this.signTypeName = signTypeName == null ? null : signTypeName.trim();
    }

    public String getKeepRecord() {
        return keepRecord;
    }

    public void setKeepRecord(String keepRecord) {
        this.keepRecord = keepRecord == null ? null : keepRecord.trim();
    }
}