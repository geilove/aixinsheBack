package org.geilove.pojo;

import java.util.Date;

public class ItemPgComment {
    private Long itempgcommentid;

    private Long itemprogressid;

    private Long userid;

    private Integer relationtag;

    private Date commenttime;

    private String content;

    private String backupone;

    private String backuptwo;

    private String backupthree;

    private String backupfour;

    private Integer backupfive;

    private Integer backupsix;

    public Long getItempgcommentid() {
        return itempgcommentid;
    }

    public void setItempgcommentid(Long itempgcommentid) {
        this.itempgcommentid = itempgcommentid;
    }

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

    public Integer getRelationtag() {
        return relationtag;
    }

    public void setRelationtag(Integer relationtag) {
        this.relationtag = relationtag;
    }

    public Date getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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