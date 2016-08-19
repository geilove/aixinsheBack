package org.geilove.sqlpojo;

import java.util.Date;

public class LoveClubListPojo {
	private Long userid; 

    private String usernickname; //昵称

    private Byte usertype;   //用户类型

    private Byte certificatetype;  //认证标志

    private String selfintroduce; //用户简介

    private String address;   //当展示爱心社列表的时候，这个用到

    private String userphoto; //用户头像地址，需要

    private Byte photoupload; //用户是否上传头像，需要
   
    private Date registerdate; //用户的注册时间
    

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsernickname() {
		return usernickname;
	}

	public void setUsernickname(String usernickname) {
		this.usernickname = usernickname;
	}

	public Byte getUsertype() {
		return usertype;
	}

	public void setUsertype(Byte usertype) {
		this.usertype = usertype;
	}

	public Byte getCertificatetype() {
		return certificatetype;
	}

	public void setCertificatetype(Byte certificatetype) {
		this.certificatetype = certificatetype;
	}

	public String getSelfintroduce() {
		return selfintroduce;
	}

	public void setSelfintroduce(String selfintroduce) {
		this.selfintroduce = selfintroduce;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Date getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}
    
}
