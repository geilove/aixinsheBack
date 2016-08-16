package org.geilove.pojo;

import java.util.Date;

public class Box {
    private Long boxid;

    private Long useridbox;

    private Long tweetidbox;

    private Date boxtime;

    private String backupone;

    private String backuptwo;

    private String backupthree;

    private String backupfour;

    private Integer backupfive;

    private Integer backupsix;

    public Long getBoxid() {
        return boxid;
    }

    public void setBoxid(Long boxid) {
        this.boxid = boxid;
    }

    public Long getUseridbox() {
        return useridbox;
    }

    public void setUseridbox(Long useridbox) {
        this.useridbox = useridbox;
    }

    public Long getTweetidbox() {
        return tweetidbox;
    }

    public void setTweetidbox(Long tweetidbox) {
        this.tweetidbox = tweetidbox;
    }

    public Date getBoxtime() {
        return boxtime;
    }

    public void setBoxtime(Date boxtime) {
        this.boxtime = boxtime;
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