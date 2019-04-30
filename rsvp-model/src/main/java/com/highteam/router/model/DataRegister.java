package com.highteam.router.model;

import java.util.Date;

public class DataRegister {
    private Integer registerId;

    private Date createTime;

    private Integer activityInfoId;

    private String email;

    private String weixinId;

    private String userName;

    private String companyName;

    private String workPhone;

    private String position;

    private String description;

    private Integer prove;

    private String proveName;

    private Integer city;

    private String cityName;

    private Integer district;

    private String districtName;

    private String address;

    private Integer status;

    private String statusName;

    private String photoImg;

    private String qrCode;

    private Integer statusCount;

    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone == null ? null : workPhone.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getProve() {
        return prove;
    }

    public void setProve(Integer prove) {
        this.prove = prove;
    }

    public String getProveName() {
        return proveName;
    }

    public void setProveName(String proveName) {
        this.proveName = proveName == null ? null : proveName.trim();
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName == null ? null : statusName.trim();
    }

    public String getPhotoImg() {
        return photoImg;
    }

    public void setPhotoImg(String photoImg) {
        this.photoImg = photoImg == null ? null : photoImg.trim();
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode == null ? null : qrCode.trim();
    }

    public Integer getStatusCount() {
        return statusCount;
    }

    public void setStatusCount(Integer statusCount) {
        this.statusCount = statusCount;
    }
}