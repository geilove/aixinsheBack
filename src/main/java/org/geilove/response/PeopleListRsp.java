package org.geilove.response;

import java.util.List;
import org.geilove.pojo.User;

public class PeopleListRsp {
	
	private  List<User>  lp;
	private Integer retcode ;	
	private String msg;
	public List<User> getLp() {
		return lp;
	}
	public void setLp(List<User> lp) {
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
