package org.geilove.sqlpojo;

public class OtherPartHelpPojo {
    private Long userid; //
	
	private String usernickname; //昵称
    
    private String selfintroduce; //简介
    
    private String userphoto; //头像
    
    private Byte photoupload; //是否上传头像
    
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
