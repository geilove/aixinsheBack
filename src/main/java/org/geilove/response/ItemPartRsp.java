package org.geilove.response;
import java.util.List;

import org.geilove.sqlpojo.OtherPartHelpPojo;
public class ItemPartRsp {
	
	private List<OtherPartHelpPojo> lp;
	private Integer retcode ;	
	private String msg;
	public List<OtherPartHelpPojo> getLp() {
		return lp;
	}
	public void setLp(List<OtherPartHelpPojo> lp) {
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
