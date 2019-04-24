package com.highteam.router.m;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class UserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6818738597004272801L;
	
	private int userId;
	private String userAccount;
	private String userRealName;
	private List<String> companyIds;
	private String userLoginName;
	private boolean member;
	private boolean supplier;
	private boolean activityInfo;
	private boolean admin;
	private int curCompanyId;
	private String curCompanyName;
	private int curServiceId;
	private int curServiceType;
	private int curAccountManageId;
	
	private Map<String,Object> others;
	
	private List<String> userRoles;

	private List<String> baseRoles;

	
	private int deptId;
	
	private String deptName;
	
	public List<String> getBaseRoles() {
		return baseRoles;
	}

	public void setBaseRoles(List<String> baseRoles) {
		this.baseRoles = baseRoles;
	}

	public List<String> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<String> userRoles) {
		this.userRoles = userRoles;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public List<String> getCompanyIds() {
		return companyIds;
	}

	public void setCompanyIds(List<String> companyIds) {
		this.companyIds = companyIds;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public boolean isMember() {
		return member;
	}

	public void setMember(boolean member) {
		this.member = member;
	}

	public boolean isSupplier() {
		return supplier;
	}

	public void setSupplier(boolean supplier) {
		this.supplier = supplier;
	}

	public boolean isActivityInfo() {
		return activityInfo;
	}

	public void setActivityInfo(boolean activityInfo) {
		this.activityInfo = activityInfo;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public int getCurCompanyId() {
		return curCompanyId;
	}

	public void setCurCompanyId(int curCompanyId) {
		this.curCompanyId = curCompanyId;
	}

	public String getCurCompanyName() {
		return curCompanyName;
	}

	public void setCurCompanyName(String curCompanyName) {
		this.curCompanyName = curCompanyName;
	}

	public Map<String,Object> getOthers() {
		return others;
	}

	public void setOthers(Map<String,Object> others) {
		this.others = others;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getCurServiceId() {
		return curServiceId;
	}

	public void setCurServiceId(int curServiceId) {
		this.curServiceId = curServiceId;
	}

	public int getCurServiceType() {
		return curServiceType;
	}

	public void setCurServiceType(int curServiceType) {
		this.curServiceType = curServiceType;
	}

	public int getCurAccountManageId() {
		return curAccountManageId;
	}

	public void setCurAccountManageId(int curAccountManageId) {
		this.curAccountManageId = curAccountManageId;
	}
}
