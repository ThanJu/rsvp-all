package com.highteam.router.model;

import java.util.Date;

public class PageResearchItem {
    private Integer pageResearchItemId;

    private Integer createId;

    private String createName;

    private Date createTime;

    private Integer pageTemplateId;

    private Integer pageResearchId;

    private String itemName;

    private String itemContent;

    public Integer getPageResearchItemId() {
        return pageResearchItemId;
    }

    public void setPageResearchItemId(Integer pageResearchItemId) {
        this.pageResearchItemId = pageResearchItemId;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent == null ? null : itemContent.trim();
    }
}