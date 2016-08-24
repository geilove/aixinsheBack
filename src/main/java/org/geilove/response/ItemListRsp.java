package org.geilove.response;

import java.util.List;
import org.geilove.pojo.Item;

public class ItemListRsp {
	private List<Item> lp;
	
	private Integer retcode ;
	
	private String msg;

	public List<Item> getLp() {
		return lp;
	}

	public void setLp(List<Item> lp) {
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
