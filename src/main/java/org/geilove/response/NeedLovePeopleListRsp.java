package org.geilove.response;

import org.geilove.sqlpojo.PeopleNeedLovePojo;
import java.util.List;
public class NeedLovePeopleListRsp {
	private List<PeopleNeedLovePojo> lp;
	private Integer retcode ;
	private String msg;
	public List<PeopleNeedLovePojo> getLp() {
		return lp;
	}
	public void setLp(List<PeopleNeedLovePojo> lp) {
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
