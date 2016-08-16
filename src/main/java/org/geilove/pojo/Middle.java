package org.geilove.pojo;

public class Middle {
    private Long middleid;

    private Byte circleid;

    private Long circleuserid;

    private Byte circletype;

    private Byte okworktag;

    private String backupone;

    private String backuptwo;

    private String backupthree;

    private String backupfour;

    private Integer backupfive;

    private Integer backupsix;

    public Long getMiddleid() {
        return middleid;
    }

    public void setMiddleid(Long middleid) {
        this.middleid = middleid;
    }

    public Byte getCircleid() {
        return circleid;
    }

    public void setCircleid(Byte circleid) {
        this.circleid = circleid;
    }

    public Long getCircleuserid() {
        return circleuserid;
    }

    public void setCircleuserid(Long circleuserid) {
        this.circleuserid = circleuserid;
    }

    public Byte getCircletype() {
        return circletype;
    }

    public void setCircletype(Byte circletype) {
        this.circletype = circletype;
    }

    public Byte getOkworktag() {
        return okworktag;
    }

    public void setOkworktag(Byte okworktag) {
        this.okworktag = okworktag;
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