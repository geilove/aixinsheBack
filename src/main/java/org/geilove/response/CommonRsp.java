package org.geilove.response;
//对于所有的删除更新增加的返回结果可以共用这个

public class CommonRsp {
	private Integer retcode ;
	private String msg;
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
