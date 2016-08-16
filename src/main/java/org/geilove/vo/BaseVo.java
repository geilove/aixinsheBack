package org.geilove.vo;

public class BaseVo {
	private  Integer  tag;//出错的数字标志
	private  String   reason;//出错的原因
	public Integer getTag() {
		return tag;
	}
	public void setTag(Integer tag) {
		this.tag = tag;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
