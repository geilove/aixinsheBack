package org.geilove.pojo;

import java.util.Date;

public class Cash {
    private Long cashid;

    private Long useridcash;

    private Integer useridcircle;

    private Byte countstate;

    private Integer targetcash;

    private Integer realcash;

    private Date opentime;

    private Date closetime;

    private Byte getmoneytag;

    private Byte cashok;

    private Integer spendmoney;

    private String backupone;

    private String backuptwo;

    private String backupthree;

    private String backupfour;

    private Integer backupfive;

    private Integer backupsix;

    public Long getCashid() {
        return cashid;
    }

    public void setCashid(Long cashid) {
        this.cashid = cashid;
    }

    public Long getUseridcash() {
        return useridcash;
    }

    public void setUseridcash(Long useridcash) {
        this.useridcash = useridcash;
    }

    public Integer getUseridcircle() {
        return useridcircle;
    }

    public void setUseridcircle(Integer integer) {
        this.useridcircle = integer;
    }

    public Byte getCountstate() {
        return countstate;
    }

    public void setCountstate(Byte countstate) {
        this.countstate = countstate;
    }

    public Integer getTargetcash() {
        return targetcash;
    }

    public void setTargetcash(Integer targetcash) {
        this.targetcash = targetcash;
    }

    public Integer getRealcash() {
        return realcash;
    }

    public void setRealcash(Integer realcash) {
        this.realcash = realcash;
    }

    public Date getOpentime() {
        return opentime;
    }

    public void setOpentime(Date opentime) {
        this.opentime = opentime;
    }

    public Date getClosetime() {
        return closetime;
    }

    public void setClosetime(Date closetime) {
        this.closetime = closetime;
    }

    public Byte getGetmoneytag() {
        return getmoneytag;
    }

    public void setGetmoneytag(Byte getmoneytag) {
        this.getmoneytag = getmoneytag;
    }

    public Byte getCashok() {
        return cashok;
    }

    public void setCashok(Byte cashok) {
        this.cashok = cashok;
    }

    public Integer getSpendmoney() {
        return spendmoney;
    }

    public void setSpendmoney(Integer spendmoney) {
        this.spendmoney = spendmoney;
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