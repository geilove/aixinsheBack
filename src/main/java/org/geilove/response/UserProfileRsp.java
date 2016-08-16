package org.geilove.response; 
import org.geilove.pojo.User;
//所有返回的数据库数据放在data字段，必须是data，前端好处理
public class UserProfileRsp {
	private User data;
	private Integer retcode ;
	private String msg;
	public User getData() {
		return data;
	}
	public void setData(User data) {
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
