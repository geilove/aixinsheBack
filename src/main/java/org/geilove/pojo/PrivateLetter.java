package org.geilove.pojo;

import java.util.Date;

public class PrivateLetter {
    private Long privateletterid;

    private String privatemsgtext;

    private Date privatemsgtime;

    private String backupone;

    private String backuptwo;

    private String backupthree;

    private String backupfour;

    private Integer backupfive;

    private Integer backupsix;

    public Long getPrivateletterid() {
        return privateletterid;
    }

    public void setPrivateletterid(Long privateletterid) {
        this.privateletterid = privateletterid;
    }

    public String getPrivatemsgtext() {
        return privatemsgtext;
    }

    public void setPrivatemsgtext(String privatemsgtext) {
        this.privatemsgtext = privatemsgtext == null ? null : privatemsgtext.trim();
    }

    public Date getPrivatemsgtime() {
        return privatemsgtime;
    }

    public void setPrivatemsgtime(Date privatemsgtime) {
        this.privatemsgtime = privatemsgtime;
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