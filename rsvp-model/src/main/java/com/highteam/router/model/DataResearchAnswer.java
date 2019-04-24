package com.highteam.router.model;

import java.util.Date;

public class DataResearchAnswer {
    private Integer answerId;

    private Date createTime;

    private Integer pageTemplateId;

    private Integer pageResearchId;

    private String pageResearchContent;

    private Integer pageResearchItemId;

    private String pageResearchItemName;

    private String pageResearchItemContent;

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPageTemplateId() {
        return pageTemplateId;
    }

    public void setPageTemplateId(Integer pageTemplateId) {
        this.pageTemplateId = pageTemplateId;
    }

    public Integer getPageResearchId() {
        return pageResearchId;
    }

    public void setPageResearchId(Integer pageResearchId) {
        this.pageResearchId = pageResearchId;
    }

    public String getPageResearchContent() {
        return pageResearchContent;
    }

    public void setPageResearchContent(String pageResearchContent) {
        this.pageResearchContent = pageResearchContent == null ? null : pageResearchContent.trim();
    }

    public Integer getPageResearchItemId() {
        return pageResearchItemId;
    }

    public void setPageResearchItemId(Integer pageResearchItemId) {
        this.pageResearchItemId = pageResearchItemId;
    }

    public String getPageResearchItemName() {
        return pageResearchItemName;
    }

    public void setPageResearchItemName(String pageResearchItemName) {
        this.pageResearchItemName = pageResearchItemName == null ? null : pageResearchItemName.trim();
    }

    public String getPageResearchItemContent() {
        return pageResearchItemContent;
    }

    public void setPageResearchItemContent(String pageResearchItemContent) {
        this.pageResearchItemContent = pageResearchItemContent == null ? null : pageResearchItemContent.trim();
    }
}