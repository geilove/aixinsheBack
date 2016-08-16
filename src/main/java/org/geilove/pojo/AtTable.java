package org.geilove.pojo;

import java.util.Date;

public class AtTable {
    private Long atid;

    private Long useridat;

    private Long useridbeat;

    private Date beattime;

    private Long tweetidat;

    private Long discussreplyidat;

    private Byte tagat;

    private Byte readtag;

    private String backupone;

    private String backuptwo;

    private String backupthree;

    private String backupfour;

    private Integer backupfive;

    private Integer backupsix;

    public Long getAtid() {
        return atid;
    }

    public void setAtid(Long atid) {
        this.atid = atid;
    }

    public Long getUseridat() {
        return useridat;
    }

    public void setUseridat(Long useridat) {
        this.useridat = useridat;
    }

    public Long getUseridbeat() {
        return useridbeat;
    }

    public void setUseridbeat(Long useridbeat) {
        this.useridbeat = useridbeat;
    }

    public Date getBeattime() {
        return beattime;
    }

    public void setBeattime(Date beattime) {
        this.beattime = beattime;
    }

    public Long getTweetidat() {
        return tweetidat;
    }

    public void setTweetidat(Long tweetidat) {
        this.tweetidat = tweetidat;
    }

    public Long getDiscussreplyidat() {
        return discussreplyidat;
    }

    public void setDiscussreplyidat(Long discussreplyidat) {
        this.discussreplyidat = discussreplyidat;
    }

    public Byte getTagat() {
        return tagat;
    }

    public void setTagat(Byte tagat) {
        this.tagat = tagat;
    }

    public Byte getReadtag() {
        return readtag;
    }

    public void setReadtag(Byte readtag) {
        this.readtag = readtag;
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