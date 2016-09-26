package org.geilove.response;

import java.util.List;

import org.geilove.pojo.Confirm;

public class ConfirmListRsp {
	
	private List<Confirm> lp; //confirmbackupOne存储用户头像；confirmbackupTwo存储用户昵称
	
	private Integer count; //这个是证实人的总数量
	
	private Integer retcode ;
	
	private String msg;

	public List<Confirm> getLp() {
		return lp;
	}

	public void setLp(List<Confirm> lp) {
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
}
