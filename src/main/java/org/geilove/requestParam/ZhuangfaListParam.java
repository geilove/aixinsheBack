package org.geilove.requestParam;

public class ZhuangfaListParam {
	 public String   proof;
	 public Integer  page;
	 public Integer  pageSize;
	 public Long	tweetid;
	public String getProof() {
		return proof;
	}
	public void setProof(String proof) {
		this.proof = proof;
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
	public Long getTweetid() {
		return tweetid;
	}
	public void setTweetid(Long tweetid) {
		this.tweetid = tweetid;
	}
}
