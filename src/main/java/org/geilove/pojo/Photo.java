package org.geilove.pojo;

import java.util.Date;

public class Photo {
    private Long photoid;

    private Long useridphoto;

    private Integer itemidphoto;

    private Byte phototype;

    private String photoname;

    private Date createtime;

    private String note;

    private Byte secret;

    private String passnumber;

    private Byte cansee;

    private String backupone;

    private String backuptwo;

    private String backupthree;

    private String backupfour;

    private Integer backupfive;

    private Integer backupsix;

    public Long getPhotoid() {
        return photoid;
    }

    public void setPhotoid(Long photoid) {
        this.photoid = photoid;
    }

    public Long getUseridphoto() {
        return useridphoto;
    }

    public void setUseridphoto(Long useridphoto) {
        this.useridphoto = useridphoto;
    }

    public Integer getItemidphoto() {
        return itemidphoto;
    }

    public void setItemidphoto(Integer itemidphoto) {
        this.itemidphoto = itemidphoto;
    }

    public Byte getPhototype() {
        return phototype;
    }

    public void setPhototype(Byte phototype) {
        this.phototype = phototype;
    }

    public String getPhotoname() {
        return photoname;
    }

    public void setPhotoname(String photoname) {
        this.photoname = photoname == null ? null : photoname.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Byte getSecret() {
        return secret;
    }

    public void setSecret(Byte secret) {
        this.secret = secret;
    }

    public String getPassnumber() {
        return passnumber;
    }

    public void setPassnumber(String passnumber) {
        this.passnumber = passnumber == null ? null : passnumber.trim();
    }

    public Byte getCansee() {
        return cansee;
    }

    public void setCansee(Byte cansee) {
        this.cansee = cansee;
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