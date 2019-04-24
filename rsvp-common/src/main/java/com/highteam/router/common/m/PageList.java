package com.highteam.router.common.m;

import java.io.Serializable;
import java.util.List;

public class PageList<T> implements Serializable {

	private static final long serialVersionUID = -507998714L;
	private long totalCount;
	private int start;
	private int limit;
	private List<T> root;

	private int currentPage = 1;
	private int totalPage = 0;

	public void setting() {
		if (totalCount > 0 && limit > 0) {
			if (totalCount % limit == 0) {
				totalPage = (int) totalCount / limit;
			} else {
				totalPage = ((int) totalCount / limit) + 1;
			}

			currentPage = start / limit + 1;
		}
	}

	public int getCurrentPage() {

		return currentPage;
	}
	

	public PageList(){}
	
	private PageList(long totalCount, int start, int limit, List<T> root) {
		this.totalCount = totalCount;
		this.start = start;
		this.limit = limit;
		this.root = root;
		setting();
	}

	public static <T> PageList<T> createPageList(List<T> root, long totalCount,
			PageParam bean) {
		return new PageList<T>(totalCount, bean.getStart(), bean.getLimit(),
				root);
	}

	public long getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
		this.setting();
	}

	public int getStart() {
		return this.start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return this.limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List<T> getRoot() {
		return this.root;
	}

	public void setRoot(List<T> root) {
		this.root = root;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
