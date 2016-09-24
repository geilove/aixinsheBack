package org.geilove.pojo;

import java.util.Date;

public class Confirm {
    private Long confirmid;

    private Long items;

    private Long tuiwenid;

    private Integer tag;

    private Long userid;

    private Date publishtime;

    private Integer reportedtimes;

    private String content;

    private String relation;

    private String mobile;

    private String confirmbackupone;

    private String confirmbackuptwo;

    private String confirmbackupthree;

    private Integer confirmbackupfour;

    private Date confirmbackupfive;

    private Long confirmbackupsix;

    public Long getConfirmid() {
        return confirmid;
    }

    public void setConfirmid(Long confirmid) {
        this.confirmid = confirmid;
    }

    public Long getItems() {
        return items;
    }

    public void setItems(Long items) {
        this.items = items;
    }

    public Long getTuiwenid() {
        return tuiwenid;
    }

    public void setTuiwenid(Long tuiwenid) {
        this.tuiwenid = tuiwenid;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public Integer getReportedtimes() {
        return reportedtimes;
    }

    public void setReportedtimes(Integer reportedtimes) {
        this.reportedtimes = reportedtimes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getConfirmbackupone() {
        return confirmbackupone;
    }

    public void setConfirmbackupone(String confirmbackupone) {
        this.confirmbackupone = confirmbackupone == null ? null : confirmbackupone.trim();
    }

    public String getConfirmbackuptwo() {
        return confirmbackuptwo;
    }

    public void setConfirmbackuptwo(String confirmbackuptwo) {
        this.confirmbackuptwo = confirmbackuptwo == null ? null : confirmbackuptwo.trim();
    }

    public String getConfirmbackupthree() {
        return confirmbackupthree;
    }

    public void setConfirmbackupthree(String confirmbackupthree) {
        this.confirmbackupthree = confirmbackupthree == null ? null : confirmbackupthree.trim();
    }

    public Integer getConfirmbackupfour() {
        return confirmbackupfour;
    }

    public void setConfirmbackupfour(Integer confirmbackupfour) {
        this.confirmbackupfour = confirmbackupfour;
    }

    public Date getConfirmbackupfive() {
        return confirmbackupfive;
    }

    public void setConfirmbackupfive(Date confirmbackupfive) {
        this.confirmbackupfive = confirmbackupfive;
    }

    public Long getConfirmbackupsix() {
        return confirmbackupsix;
    }

    public void setConfirmbackupsix(Long confirmbackupsix) {
        this.confirmbackupsix = confirmbackupsix;
    }
}