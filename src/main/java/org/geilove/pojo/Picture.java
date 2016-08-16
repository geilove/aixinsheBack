package org.geilove.pojo;

import java.util.Date;

public class Picture {
    private Long pictureid;

    private Long photoidpicture;

    private Long itemidpicture;

    private String photoname;

    private String picturename;

    private Date pictureuploadtime;

    private String photodescription;

    private String photopath;

    private String backupone;

    private String backuptwo;

    private String backupthree;

    private String backupfour;

    private Integer backupfive;

    private Integer backupsix;

    public Long getPictureid() {
        return pictureid;
    }

    public void setPictureid(Long pictureid) {
        this.pictureid = pictureid;
    }

    public Long getPhotoidpicture() {
        return photoidpicture;
    }

    public void setPhotoidpicture(Long photoidpicture) {
        this.photoidpicture = photoidpicture;
    }

    public Long getItemidpicture() {
        return itemidpicture;
    }

    public void setItemidpicture(Long itemidpicture) {
        this.itemidpicture = itemidpicture;
    }

    public String getPhotoname() {
        return photoname;
    }

    public void setPhotoname(String photoname) {
        this.photoname = photoname == null ? null : photoname.trim();
    }

    public String getPicturename() {
        return picturename;
    }

    public void setPicturename(String picturename) {
        this.picturename = picturename == null ? null : picturename.trim();
    }

    public Date getPictureuploadtime() {
        return pictureuploadtime;
    }

    public void setPictureuploadtime(Date pictureuploadtime) {
        this.pictureuploadtime = pictureuploadtime;
    }

    public String getPhotodescription() {
        return photodescription;
    }

    public void setPhotodescription(String photodescription) {
        this.photodescription = photodescription == null ? null : photodescription.trim();
    }

    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath == null ? null : photopath.trim();
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