package org.geilove.response;

import java.util.List;
import org.geilove.pojo.User;

public class PeopleListRsp {
	
	private  List<User>  data;
	private Integer retcode ;	
	private String msg;
	
	public List<User> getData() {
		return data;
	}
	public void setData(List<User> data) {
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
