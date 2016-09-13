package org.geilove.vo;
import org.geilove.pojo.Tweet;
public class Tuiwen {
   
	private String usernickname; //昵称
    
    private String selfintroduce; //简介
    
    private String userphoto; //头像
    
    private Byte photoupload; //是否上传头像
    
    private Tweet tweet; 

	public Tweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
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
