package org.geilove.requestParam;

public class FansParam {
	private Long     tweetid;
	private Integer tag; //1代表关注，2代表粉丝
	private Integer  page;
	private Integer  pageSize;
	public Long getTweetid() {
		return tweetid;
	}
	public void setTweetid(Long tweetid) {
		this.tweetid = tweetid;
	}
	public Integer getTag() {
		return tag;
	}
	public void setTag(Integer tag) {
		this.tag = tag;
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
