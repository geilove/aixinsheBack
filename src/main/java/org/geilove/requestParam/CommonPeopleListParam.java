package org.geilove.requestParam;

public class CommonPeopleListParam {
	// private String   token; //这个就是token，在查看我的粉丝 我帮助的人等需要用到userid 
	 private Long     userID; //
	 private Integer  tag; //1普通，2社团，3监督，4志愿者，5社会公益机构 10我关注的人 11我的粉丝 20助我的人 21我帮助的人
	 private Integer  loadMoreTag; //1代表刷新，2代表加载更多，即下一页
	 private Integer  page;
	 private Integer  pageSize;
	 private String   lastTime;//需要根据捐助的时间关注的时间注册的时间获取
 
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public Integer getLoadMoreTag() {
		return loadMoreTag;
	}
	public void setLoadMoreTag(Integer loadMoreTag) {
		this.loadMoreTag = loadMoreTag;
	}
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
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
