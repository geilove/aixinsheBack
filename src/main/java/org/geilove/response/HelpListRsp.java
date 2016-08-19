package org.geilove.response;

import java.util.List;

import org.geilove.sqlpojo.OtherPartHelpPojo;
import org.geilove.sqlpojo.PartHelpPojo;

public class HelpListRsp {
	
	private List<HelpPojo> lp;
	
	private Integer retcode ;
	
	private String msg;
	
	public List<HelpPojo> getLp() {
		return lp;
	}
	public void setLp(List<HelpPojo> lp) {
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

class HelpPojo extends PartHelpPojo{
	private String usernickname; //昵称
    
    private String selfintroduce; //简介
    
    private String userphoto; //头像
    
    private Byte photoupload; //是否上传头像

	public String getUsernickname() {
		return usernickname;
	}

	public void setUsernickname(String usernickname) {
		this.usernickname = usernickname;
	}

	public String getSelfintroduce() {
		return selfintroduce;
	}

	public void setSelfintroduce(String selfintroduce) {
		this.selfintroduce = selfintroduce;
	}

	public String getUserphoto() {
		return userphoto;
	}

	public void setUserphoto(String userphoto) {
		this.userphoto = userphoto;
	}

	public Byte getPhotoupload() {
		return photoupload;
	}

	public void setPhotoupload(Byte photoupload) {
		this.photoupload = photoupload;
	}
    
}