package org.geilove.requestParam;

public class TweetListParam {
	private  String token; //
	private  String    lastUpdate;
	private  String    lastItemstart;
	private  Integer   flag;
	private Integer page;		//开始的页
	private Integer pageSize;	//每页的大小
	private Integer symbol; //
	public Integer getSymbol() {
		return symbol;
	}
	public void setSymbol(Integer symbol) {
		this.symbol = symbol;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
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
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}

}
