package com.highteam.router.model;

import java.util.Date;

public class ActivityPage {
    private Integer activityPageId;

    private Integer createId;

    private String createName;

    private Date createTime;

    private String linkAddress;

    private Integer activityInfoId;

    private String title;

    private String pageType;

    private String pageTypeName;

    private String description;

    private Integer status;

    private String templateId;

    public Integer getActivityPageId() {
        return activityPageId;
    }

    public void setActivityPageId(Integer activityPageId) {
        this.activityPageId = activityPageId;
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

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress == null ? null : linkAddress.trim();
    }

    public Integer getActivityInfoId() {
        return activityInfoId;
    }

    public void setActivityInfoId(Integer activityInfoId) {
        this.activityInfoId = activityInfoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType == null ? null : pageType.trim();
    }

    public String getPageTypeName() {
        return pageTypeName;
    }

    public void setPageTypeName(String pageTypeName) {
        this.pageTypeName = pageTypeName == null ? null : pageTypeName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }
}