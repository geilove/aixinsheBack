package org.geilove.sqlpojo;

import java.util.Date;

public class PeopleNeedLovePojo {
 	private Long userid;

    private Long digital;

    private String usernickname;
    
    private Byte usertype;

    private Byte certificatetype;

    private String realname;

    private String identitycard;

	private String sex;
	
	private Date notsaytime;
	
    private String selfintroduce;

    private String usertag;
    
    private String address;

    private Byte notsay;

    private String userphoto;

    private Byte photoupload;
    
    public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getDigital() {
		return digital;
	}

	public void setDigital(Long digital) {
		this.digital = digital;
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

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getIdentitycard() {
		return identitycard;
	}

	public void setIdentitycard(String identitycard) {
		this.identitycard = identitycard;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSelfintroduce() {
		return selfintroduce;
	}

	public void setSelfintroduce(String selfintroduce) {
		this.selfintroduce = selfintroduce;
	}

	public String getUsertag() {
		return usertag;
	}

	public void setUsertag(String usertag) {
		this.usertag = usertag;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Byte getNotsay() {
		return notsay;
	}

	public void setNotsay(Byte notsay) {
		this.notsay = notsay;
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

	public Date getNotsaytime() {
		return notsaytime;
	}

	public void setNotsaytime(Date notsaytime) {
		this.notsaytime = notsaytime;
	}

}
