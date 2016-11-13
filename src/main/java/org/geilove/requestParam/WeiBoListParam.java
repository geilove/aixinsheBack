package org.geilove.requestParam;

public class WeiBoListParam {
	private  String    token; //以后使用这个接口
	private  Integer   flag; //1，代表刷新要使用lastUpdate 2,是加载更多，要使用lastItemstart
	private  String    lastUpdate;
	private  String    lastItemstart;
//	private  Long 	   userID; 		//用户的ID
	private  Integer   page;		//开始的页
	private  Integer   pageSize;
   
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getLastItemstart() {
		return lastItemstart;
	}
	public void setLastItemstart(String lastItemstart) {
		this.lastItemstart = lastItemstart;
	}
//	public Long getUserID() {
//		return userID;
//	}
//	public void setUserID(Long userID) {
//		this.userID = userID;
//	}
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
