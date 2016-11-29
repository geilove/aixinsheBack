package org.geilove.response;

import org.geilove.pojo.GatherInfo;

public class GatherInfoRsp {
	
	 private GatherInfo data;
	 private Integer retcode ;
 	 private String msg;
 	 
	public GatherInfo getData() {
		return data;
	}
	public void setData(GatherInfo data) {
		this.data = data;
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
