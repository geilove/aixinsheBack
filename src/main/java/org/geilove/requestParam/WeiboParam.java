package org.geilove.requestParam;

public class WeiboParam {
	private  Long 	   userID; 	 //用户的ID
	private  Integer   flag;     //1，代表刷新要使用lastUpdate 2,是加载更多，要使用lastItemstart
	private  String    lastUpdate;
	private  String    lastItemstart;
	private  Integer   page;		//开始的页
	private  Integer   pageSize;
	private  Integer   symbol;  //这个symbol在前端进行路由选择，后端在MainServiceImpl.java 的getTweetList方法里选择不同mapper方法
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
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
	public Integer getSymbol() {
		return symbol;
	}
	public void setSymbol(Integer symbol) {
		this.symbol = symbol;
	}
}
