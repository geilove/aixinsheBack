package org.geilove.response;

import java.util.List;

import org.geilove.sqlpojo.DonaterPojo;
public class DonaterListRsp {
	private List<DonaterPojo> lp;
	private Integer retcode ;
	private String msg;
	public List<DonaterPojo> getLp() {
		return lp;
	}
	public void setLp(List<DonaterPojo> lp) {
		this.lp = lp;
	}
	public Integer getRetcode() {
		return retcode;
	}
	public void setRetcode(Integer retcode) {
		this.retcode = retcode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
