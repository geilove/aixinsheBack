package org.geilove.pojo;

public class AtLinkUser {
    private Long atlinkuserid;

    private Long tweetidatlinkuser;

    private String atstring;

    private Byte beattype;

    private String backupone;

    private String backuptwo;

    private String backupthree;

    private String backupfour;

    private Integer backupfive;

    private Integer backupsix;

    public Long getAtlinkuserid() {
        return atlinkuserid;
    }

    public void setAtlinkuserid(Long atlinkuserid) {
        this.atlinkuserid = atlinkuserid;
    }

    public Long getTweetidatlinkuser() {
        return tweetidatlinkuser;
    }

    public void setTweetidatlinkuser(Long tweetidatlinkuser) {
        this.tweetidatlinkuser = tweetidatlinkuser;
    }

    public String getAtstring() {
        return atstring;
    }

    public void setAtstring(String atstring) {
        this.atstring = atstring == null ? null : atstring.trim();
    }

    public Byte getBeattype() {
        return beattype;
    }

    public void setBeattype(Byte beattype) {
        this.beattype = beattype;
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