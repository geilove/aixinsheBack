package org.geilove.pojo;

public class Circle {
    private Long circleid;

    private String circlenickname;

    private Long useridadmin;

    private Byte circlenumber;

    private Byte circletype;

    private String circlephoto;

    private String backupone;

    private String backuptwo;

    private String backupthree;

    private String backupfour;

    private Integer backupfive;

    private Integer backupsix;

    public Long getCircleid() {
        return circleid;
    }

    public void setCircleid(Long circleid) {
        this.circleid = circleid;
    }

    public String getCirclenickname() {
        return circlenickname;
    }

    public void setCirclenickname(String circlenickname) {
        this.circlenickname = circlenickname == null ? null : circlenickname.trim();
    }

    public Long getUseridadmin() {
        return useridadmin;
    }

    public void setUseridadmin(Long useridadmin) {
        this.useridadmin = useridadmin;
    }

    public Byte getCirclenumber() {
        return circlenumber;
    }

    public void setCirclenumber(Byte circlenumber) {
        this.circlenumber = circlenumber;
    }

    public Byte getCircletype() {
        return circletype;
    }

    public void setCircletype(Byte circletype) {
        this.circletype = circletype;
    }

    public String getCirclephoto() {
        return circlephoto;
    }

    public void setCirclephoto(String circlephoto) {
        this.circlephoto = circlephoto == null ? null : circlephoto.trim();
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