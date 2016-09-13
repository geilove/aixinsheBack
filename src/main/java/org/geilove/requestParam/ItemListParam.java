package org.geilove.requestParam;

import java.util.Date;

//项目页列表，请求参数

public class ItemListParam {
	private  String    proof; //以后使用这个接口
	private  Long      userID; 		//用户的ID
	private  Integer   page;		//开始的页
	private  Integer   pageSize;	//每页的大小
	private  Integer   flag; //1，代表刷新要使用lastUpdate 2,是加载更多，要使用lastItemstart
	private  String    lastUpdate;
	private  String    lastItemstart;
	
	public Integer getFlag() {
		return flag;
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
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
//	public Long getLastUpdate() {
//		return lastUpdate;
//	}
//	public void setLastUpdate(Long lastUpdate) {
//		this.lastUpdate = lastUpdate;
//	}
	public String getProof() {
		return proof;
	}
	public Long getUserID() {
		return userID;
	}
	public Integer getPage() {
		return page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	
	
}
