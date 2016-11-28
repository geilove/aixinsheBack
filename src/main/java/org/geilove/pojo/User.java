package org.geilove.pojo;

import java.util.Date;

public class User {
    private Long userid;

    private Long digital;

    private String usernickname;

    private String useremail;

    private String userpassword;

    private Byte usertype;

    private Byte certificatetype;

    private String realname;

    private String identitycard;

    private String sex;

    private String selfintroduce;

    private String usertag;

    private String university;

    private Date collegeyear;

    private String universitytwo;

    private Date collegeyeartwo;

    private String company;

    private String address;

    private String country;

    private Date registerdate; //这个在我帮助的人列表时，临时存储帮助的时间

    private Integer msgpubcount;

    private Integer boxcount;

    private Integer fanscount;

    private Integer followcount;

    private Byte notsay;

    private Date notsaytime;

    private Date cansaytime;

    private String userphoto;

    private Byte photoupload;

    private String backupone;

    private String backuptwo;

    private String backupthree;

    private String backupfour;

    private Integer backupfive;

    private Integer backupsix;
    //以下是修改表后新添加的字段
    private Integer userhelpsman;
    
    private Integer userdonate;
    
    private Integer  amountaccept;
    
    private Integer acceptmoney;
    
    private  Date  behelptime;  
    
    private Integer behelpedtype;
    //以下是修改表后新添加的字段
    private String backupseven;

    private String backupeight;

    private String backupnine;

    private String backupten;

    private Integer tobeuseone; //用户是否捐钱了

    private Integer tobeusetwo; //查看我帮助的人，或者帮助我的人，这个存储具体的钱数

    private Integer tobeusethree;
    
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
        this.usernickname = usernickname == null ? null : usernickname.trim();
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
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
        this.realname = realname == null ? null : realname.trim();
    }

    public String getIdentitycard() {
        return identitycard;
    }

    public void setIdentitycard(String identitycard) {
        this.identitycard = identitycard == null ? null : identitycard.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getSelfintroduce() {
        return selfintroduce;
    }

    public void setSelfintroduce(String selfintroduce) {
        this.selfintroduce = selfintroduce == null ? null : selfintroduce.trim();
    }

    public String getUsertag() {
        return usertag;
    }

    public void setUsertag(String usertag) {
        this.usertag = usertag == null ? null : usertag.trim();
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university == null ? null : university.trim();
    }

    public Date getCollegeyear() {
        return collegeyear;
    }

    public void setCollegeyear(Date collegeyear) {
        this.collegeyear = collegeyear;
    }

    public String getUniversitytwo() {
        return universitytwo;
    }

    public void setUniversitytwo(String universitytwo) {
        this.universitytwo = universitytwo == null ? null : universitytwo.trim();
    }

    public Date getCollegeyeartwo() {
        return collegeyeartwo;
    }

    public void setCollegeyeartwo(Date collegeyeartwo) {
        this.collegeyeartwo = collegeyeartwo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    public Integer getMsgpubcount() {
        return msgpubcount;
    }

    public void setMsgpubcount(Integer msgpubcount) {
        this.msgpubcount = msgpubcount;
    }

    public Integer getBoxcount() {
        return boxcount;
    }

    public void setBoxcount(Integer boxcount) {
        this.boxcount = boxcount;
    }

    public Integer getFanscount() {
        return fanscount;
    }

    public void setFanscount(Integer fanscount) {
        this.fanscount = fanscount;
    }

    public Integer getFollowcount() {
        return followcount;
    }

    public void setFollowcount(Integer followcount) {
        this.followcount = followcount;
    }

    public Byte getNotsay() {
        return notsay;
    }

    public void setNotsay(Byte notsay) {
        this.notsay = notsay;
    }

    public Date getNotsaytime() {
        return notsaytime;
    }

    public void setNotsaytime(Date notsaytime) {
        this.notsaytime = notsaytime;
    }

    public Date getCansaytime() {
        return cansaytime;
    }

    public void setCansaytime(Date cansaytime) {
        this.cansaytime = cansaytime;
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto == null ? null : userphoto.trim();
    }

    public Byte getPhotoupload() {
        return photoupload;
    }

    public void setPhotoupload(Byte photoupload) {
        this.photoupload = photoupload;
    }

    public String getBackupone() {
        return backupone;
    }

    public void setBackupone(String backupone) {
        this.backupone = backupone == null ? null : backupone.trim();
    }

    public String getBackuptwo() {
        return backuptwo;
    }

    public void setBackuptwo(String backuptwo) {
        this.backuptwo = backuptwo == null ? null : backuptwo.trim();
    }

    public String getBackupthree() {
        return backupthree;
    }

    public void setBackupthree(String backupthree) {
        this.backupthree = backupthree == null ? null : backupthree.trim();
    }

    public String getBackupfour() {
        return backupfour;
    }

    public void setBackupfour(String backupfour) {
        this.backupfour = backupfour == null ? null : backupfour.trim();
    }

    public Integer getBackupfive() {
        return backupfive;
    }

    public void setBackupfive(Integer backupfive) {
        this.backupfive = backupfive;
    }

    public Integer getBackupsix() {
        return backupsix;
    }

    public void setBackupsix(Integer backupsix) {
        this.backupsix = backupsix;
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

	public Integer getAmountaccept() {
		return amountaccept;
	}

	public void setAmountaccept(Integer amountaccept) {
		this.amountaccept = amountaccept;
	}

	public Integer getAcceptmoney() {
		return acceptmoney;
	}

	public void setAcceptmoney(Integer acceptmoney) {
		this.acceptmoney = acceptmoney;
	}

	public Date getBehelptime() {
		return behelptime;
	}

	public void setBehelptime(Date behelptime) {
		this.behelptime = behelptime;
	}

	public Integer getBehelpedtype() {
		return behelpedtype;
	}

	public void setBehelpedtype(Integer behelpedtype) {
		this.behelpedtype = behelpedtype;
	}

	 public String getBackupseven() {
	        return backupseven;
	    }

	    public void setBackupseven(String backupseven) {
	        this.backupseven = backupseven == null ? null : backupseven.trim();
	    }

	    public String getBackupeight() {
	        return backupeight;
	    }

	    public void setBackupeight(String backupeight) {
	        this.backupeight = backupeight == null ? null : backupeight.trim();
	    }

	    public String getBackupnine() {
	        return backupnine;
	    }

	    public void setBackupnine(String backupnine) {
	        this.backupnine = backupnine == null ? null : backupnine.trim();
	    }

	    public String getBackupten() {
	        return backupten;
	    }

	    public void setBackupten(String backupten) {
	        this.backupten = backupten == null ? null : backupten.trim();
	    }

	    public Integer getTobeuseone() {
	        return tobeuseone;
	    }

	    public void setTobeuseone(Integer tobeuseone) {
	        this.tobeuseone = tobeuseone;
	    }

	    public Integer getTobeusetwo() {
	        return tobeusetwo;
	    }

	    public void setTobeusetwo(Integer tobeusetwo) {
	        this.tobeusetwo = tobeusetwo;
	    }

	    public Integer getTobeusethree() {
	        return tobeusethree;
	    }

	    public void setTobeusethree(Integer tobeusethree) {
	        this.tobeusethree = tobeusethree;
	    }
    
}