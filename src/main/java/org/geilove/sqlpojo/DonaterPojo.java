package org.geilove.sqlpojo;

import java.util.Date;

public class DonaterPojo {
	 private Long userid;

    private String usernickname;

    private Byte usertype;

    private Byte certificatetype;

    private String selfintroduce;

    private String usertag;

    private Date registerdate;

    private String userphoto;

    private Byte photoupload;

    private Integer userhelpsman; //用户帮助的人
    
    private Integer userdonate; //用户捐钱总数

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

	public String getUsertag() {
		return usertag;
	}

	public void setUsertag(String usertag) {
		this.usertag = usertag;
	}

	public Date getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
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

	public Integer getUserhelpsman() {
		return userhelpsman;
	}

	public void setUserhelpsman(Integer userhelpsman) {
		this.userhelpsman = userhelpsman;
	}

	public Integer getUserdonate() {
		return userdonate;
	}

	public void setUserdonate(Integer userdonate) {
		this.userdonate = userdonate;
	}

}
