package org.geilove.response;
import org.geilove.pojo.Tweet;
import java.util.List;

public class TweetsListRsp {
	private List<Tweet>  data;
	private Integer retcode ;
	private String msg;
	
	public List<Tweet> getData() {
		return data;
	}
	public void setData(List<Tweet> data) {
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
