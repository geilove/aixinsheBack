package org.geilove.response;

import org.geilove.pojo.Cash;

public class CashResponse {
     private Cash data;
     private Integer retcode ;
 	 private String msg;
	
	public Cash getData() {
		return data;
	}
	public void setData(Cash data) {
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
