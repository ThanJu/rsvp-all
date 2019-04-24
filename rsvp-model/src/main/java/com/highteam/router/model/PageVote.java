package com.highteam.router.model;

import java.util.Date;

public class PageVote {
    private Integer pageVoteId;

    private Integer createId;

    private String createName;

    private Date createTime;

    private Integer pageTemplateId;

    private String title;

    private String content;

    private Integer order;

    private String coverImage;

    private String linkAddress;

    private Integer voteCount;

    private Integer ranking;

    public Integer getPageVoteId() {
        return pageVoteId;
    }

    public void setPageVoteId(Integer pageVoteId) {
        this.pageVoteId = pageVoteId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage == null ? null : coverImage.trim();
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress == null ? null : linkAddress.trim();
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
}