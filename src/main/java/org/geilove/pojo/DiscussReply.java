package org.geilove.pojo;

import java.util.Date;

public class DiscussReply {
    private Long discussreplyid;

    private Long tweetiddiscussreply;

    private Long useriddiscussreply;

    private Byte discussreplytype;

    private Integer discussreplyok;

    private Date discussreplytime;

    private String discussreplytext;

    private String backupone;

    private String backuptwo;

    private String backupthree;

    private String backupfour;

    private Integer backupfive;

    private Integer backupsix;

    public Long getDiscussreplyid() {
        return discussreplyid;
    }

    public void setDiscussreplyid(Long discussreplyid) {
        this.discussreplyid = discussreplyid;
    }

    public Long getTweetiddiscussreply() {
        return tweetiddiscussreply;
    }

    public void setTweetiddiscussreply(Long tweetiddiscussreply) {
        this.tweetiddiscussreply = tweetiddiscussreply;
    }

    public Long getUseriddiscussreply() {
        return useriddiscussreply;
    }

    public void setUseriddiscussreply(Long useriddiscussreply) {
        this.useriddiscussreply = useriddiscussreply;
    }

    public Byte getDiscussreplytype() {
        return discussreplytype;
    }

    public void setDiscussreplytype(Byte discussreplytype) {
        this.discussreplytype = discussreplytype;
    }

    public Integer getDiscussreplyok() {
        return discussreplyok;
    }

    public void setDiscussreplyok(Integer discussreplyok) {
        this.discussreplyok = discussreplyok;
    }

    public Date getDiscussreplytime() {
        return discussreplytime;
    }

    public void setDiscussreplytime(Date discussreplytime) {
        this.discussreplytime = discussreplytime;
    }

    public String getDiscussreplytext() {
        return discussreplytext;
    }

    public void setDiscussreplytext(String discussreplytext) {
        this.discussreplytext = discussreplytext == null ? null : discussreplytext.trim();
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