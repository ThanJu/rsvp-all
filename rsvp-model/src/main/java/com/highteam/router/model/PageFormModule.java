package com.highteam.router.model;

import java.util.Date;

public class PageFormModule {
    private Integer pageFormModuleId;

    private Integer createId;

    private String createName;

    private Date createTime;

    private String pageTemplateId;

    private Integer moduleTemplateId;

    private Integer moduleType;

    private String id;

    private String title;

    private String defaultValue;

    private String description;

    private Boolean notNull;

    private String font;

    private String border;

    private String event;

    private String placeholder;

    private String extend;

    public Integer getPageFormModuleId() {
        return pageFormModuleId;
    }

    public void setPageFormModuleId(Integer pageFormModuleId) {
        this.pageFormModuleId = pageFormModuleId;
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

    public String getPageTemplateId() {
        return pageTemplateId;
    }

    public void setPageTemplateId(String pageTemplateId) {
        this.pageTemplateId = pageTemplateId == null ? null : pageTemplateId.trim();
    }

    public Integer getModuleTemplateId() {
        return moduleTemplateId;
    }

    public void setModuleTemplateId(Integer moduleTemplateId) {
        this.moduleTemplateId = moduleTemplateId;
    }

    public Integer getModuleType() {
        return moduleType;
    }

    public void setModuleType(Integer moduleType) {
        this.moduleType = moduleType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getNotNull() {
        return notNull;
    }

    public void setNotNull(Boolean notNull) {
        this.notNull = notNull;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font == null ? null : font.trim();
    }

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border == null ? null : border.trim();
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event == null ? null : event.trim();
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder == null ? null : placeholder.trim();
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
    }
}