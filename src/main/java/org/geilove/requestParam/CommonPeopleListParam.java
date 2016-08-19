package org.geilove.requestParam;
import org.geilove.sqlpojo.PeopleNeedLovePojo;

public class CommonPeopleListParam {
	 public String   proof;
	 public Integer  tag; //这个是一个标志，1代表需要帮助的人列表
	 public Integer  page;
	 public Integer  pageSize;
	 
	 public String getProof() {
		return proof;
	}
	public void setProof(String proof) {
		this.proof = proof;
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
