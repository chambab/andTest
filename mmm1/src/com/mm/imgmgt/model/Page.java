package com.mm.imgmgt.model;

public class Page {

	public Page() {
		
	}
	public Page(java.util.Collection<Museum> objects, int currentPage, int totalCount) {
		this.objects = objects;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
	}
	public Page(java.util.Collection<Museum> objects, int currentPage, int totalCount, java.lang.String condition, java.lang.String search) {
		this.objects = objects;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.condition = condition;
		this.search = search;
	}
	
	 public Page(java.util.Collection<Museum> objects, int currentPage, int totalCount, int pageunit, int pagesize) {
			this.objects = objects;
			this.currentPage = currentPage;
			this.totalCount = totalCount;
			this.pageunit = pageunit;
			this.pagesize = pagesize;
	 }
	
	private java.util.Collection<Museum> objects;
	  
	private int currentPage;
	 
	private int totalCount;

	private int pageunit;
	  
	private int pagesize;
	  
	private int maxPage;
	  
	private int beginUnitPage;
	  
	private int endUnitPage;
	  
	private java.lang.String search;
	  
	private java.lang.String condition;

	public java.util.Collection<Museum> getObjects() {
		return objects;
	}

	public void setObjects(java.util.Collection<Museum> objects) {
		this.objects = objects;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageunit() {
		return pageunit;
	}

	public void setPageunit(int pageunit) {
		this.pageunit = pageunit;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getBeginUnitPage() {
		return beginUnitPage;
	}

	public void setBeginUnitPage(int beginUnitPage) {
		this.beginUnitPage = beginUnitPage;
	}

	public int getEndUnitPage() {
		return endUnitPage;
	}

	public void setEndUnitPage(int endUnitPage) {
		this.endUnitPage = endUnitPage;
	}

	public java.lang.String getSearch() {
		return search;
	}

	public void setSearch(java.lang.String search) {
		this.search = search;
	}

	public java.lang.String getCondition() {
		return condition;
	}

	public void setCondition(java.lang.String condition) {
		this.condition = condition;
	}	
	  
	  
}
