package com.highteam.router.model;

import java.util.Date;

public class ActivitySignWay {
    private Integer signWayId;

    private Integer createId;

    private String createName;

    private Date createTime;

    private Integer activityInfoId;

    private String wayName;

    private Integer signType;

    private String signTypeName;

    private String description;

    public Integer getSignWayId() {
        return signWayId;
    }

    public void setSignWayId(Integer signWayId) {
        this.signWayId = signWayId;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
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

    public String getWayName() {
        return wayName;
    }

    public void setWayName(String wayName) {
        this.wayName = wayName == null ? null : wayName.trim();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}