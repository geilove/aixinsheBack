package org.geilove.requestParam;

public class TweetListParam {
	private Long userID; 		//用户的ID
	private Integer page;		//开始的页
	private Integer pageSize;	//每页的大小
	
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
