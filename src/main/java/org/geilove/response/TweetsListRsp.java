package org.geilove.response;
import org.geilove.pojo.Tweet;
import java.util.List;
import org.geilove.vo.WeiBo;
public class TweetsListRsp {
	private List<WeiBo>  data;
	private Integer retcode ;
	private String msg;
	
	public List<WeiBo> getData() {
		return data;
	}
	public void setData(List<WeiBo> data) {
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
