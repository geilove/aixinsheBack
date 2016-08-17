package org.geilove.response;

import org.geilove.pojo.DiscussReply;
import java.util.List;
public class CommentsListRsp {
	private List<DiscussReply>  data;
	private Integer retcode;
	private String msg;
	public List<DiscussReply> getData() {
		return data;
	}
	public void setData(List<DiscussReply> data) {
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
