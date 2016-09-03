package org.geilove.response;

import java.util.List;

import org.geilove.sqlpojo.PicturePojo;

public class PicListRsp {
	
	List<PicturePojo> lp;
	private Integer retcode ;
	private String msg;
	
	public List<PicturePojo> getLp() {
		return lp;
	}
	public void setLp(List<PicturePojo> lp) {
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
