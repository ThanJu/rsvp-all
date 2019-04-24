package com.highteam.router.model;

import java.util.Date;

public class DataVote {
    private Integer dataVoteId;

    private Date createTime;

    private Integer pageTemplateId;

    private Integer dataRegosterId;

    private String userName;

    private Integer pageVoteId;

    private String pageVoteTitle;

    public Integer getDataVoteId() {
        return dataVoteId;
    }

    public void setDataVoteId(Integer dataVoteId) {
        this.dataVoteId = dataVoteId;
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

    public Integer getDataRegosterId() {
        return dataRegosterId;
    }

    public void setDataRegosterId(Integer dataRegosterId) {
        this.dataRegosterId = dataRegosterId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getPageVoteId() {
        return pageVoteId;
    }

    public void setPageVoteId(Integer pageVoteId) {
        this.pageVoteId = pageVoteId;
    }

    public String getPageVoteTitle() {
        return pageVoteTitle;
    }

    public void setPageVoteTitle(String pageVoteTitle) {
        this.pageVoteTitle = pageVoteTitle == null ? null : pageVoteTitle.trim();
    }
}