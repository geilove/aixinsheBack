package org.geilove.response;

import java.util.List;

import org.geilove.sqlpojo.LoveClubListPojo;

public class LoveClubPeopleListRsp {
	private List<LoveClubListPojo> lp;
	private Integer retcode ;
	private String msg;
	public List<LoveClubListPojo> getLp() {
		return lp;
	}
	public void setLp(List<LoveClubListPojo> lp) {
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
