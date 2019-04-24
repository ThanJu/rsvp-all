package com.highteam.router.model;

import java.util.Date;

public class PageResearch {
    private Integer pageResearchId;

    private Date createTime;

    private Integer pageTemplateId;

    private Integer issueType;

    private Integer selectType;

    private String researchContent;

    public Integer getPageResearchId() {
        return pageResearchId;
    }

    public void setPageResearchId(Integer pageResearchId) {
        this.pageResearchId = pageResearchId;
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

    public Integer getIssueType() {
        return issueType;
    }

    public void setIssueType(Integer issueType) {
        this.issueType = issueType;
    }

    public Integer getSelectType() {
        return selectType;
    }

    public void setSelectType(Integer selectType) {
        this.selectType = selectType;
    }

    public String getResearchContent() {
        return researchContent;
    }

    public void setResearchContent(String researchContent) {
        this.researchContent = researchContent == null ? null : researchContent.trim();
    }
}