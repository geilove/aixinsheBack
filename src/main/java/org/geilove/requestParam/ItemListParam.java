package org.geilove.requestParam;

//项目页列表，请求参数

public class ItemListParam {
	private String proof; //以后使用这个接口
	private Long userID; 		//用户的ID
	private Integer page;		//开始的页
	private Integer pageSize;	//每页的大小
	
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
