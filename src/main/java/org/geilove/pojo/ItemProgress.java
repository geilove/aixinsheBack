package org.geilove.pojo;

import java.util.Date;

public class ItemProgress {
    private Long itemprogressid;

    private Long userid;

    private Long itemid;

    private Integer relationtag;

    private Date updatetime;

    private String content;

    private String imgaddressone;

    private String imgaddresstwo;

    private String imgaddressthree;

    private String imgaddressfour;

    private String imgaddressfive;

    private String imgaddresssix;

    private String backupone;

    private String backuptwo;

    private String backupthree;

    private String backupfour;

    private Integer backupfive;

    private Integer backupsix;

    public Long getItemprogressid() {
        return itemprogressid;
    }

    public void setItemprogressid(Long itemprogressid) {
        this.itemprogressid = itemprogressid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getItemid() {
        return itemid;
    }

    public void setItemid(Long itemid) {
        this.itemid = itemid;
    }

    public Integer getRelationtag() {
        return relationtag;
    }

    public void setRelationtag(Integer relationtag) {
        this.relationtag = relationtag;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getImgaddressone() {
        return imgaddressone;
    }

    public void setImgaddressone(String imgaddressone) {
        this.imgaddressone = imgaddressone == null ? null : imgaddressone.trim();
    }

    public String getImgaddresstwo() {
        return imgaddresstwo;
    }

    public void setImgaddresstwo(String imgaddresstwo) {
        this.imgaddresstwo = imgaddresstwo == null ? null : imgaddresstwo.trim();
    }

    public String getImgaddressthree() {
        return imgaddressthree;
    }

    public void setImgaddressthree(String imgaddressthree) {
        this.imgaddressthree = imgaddressthree == null ? null : imgaddressthree.trim();
    }

    public String getImgaddressfour() {
        return imgaddressfour;
    }

    public void setImgaddressfour(String imgaddressfour) {
        this.imgaddressfour = imgaddressfour == null ? null : imgaddressfour.trim();
    }

    public String getImgaddressfive() {
        return imgaddressfive;
    }

    public void setImgaddressfive(String imgaddressfive) {
        this.imgaddressfive = imgaddressfive == null ? null : imgaddressfive.trim();
    }

    public String getImgaddresssix() {
        return imgaddresssix;
    }

    public void setImgaddresssix(String imgaddresssix) {
        this.imgaddresssix = imgaddresssix == null ? null : imgaddresssix.trim();
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
}