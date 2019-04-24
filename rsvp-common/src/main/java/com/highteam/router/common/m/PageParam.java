package com.highteam.router.common.m;

import java.io.Serializable;

public class PageParam<T> implements Serializable{

	private static final long serialVersionUID = 6032005172990776277L;

	private int start =0;

	private int limit =10;

	private String orderBy;

	private String sort;

	private T model;

	public PageParam(){}

	public PageParam(T model) {
		this.model = model;
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}


	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
}
