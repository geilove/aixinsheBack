package org.geilove.pojo;

import java.util.Date;

public class Item {
    private Integer itemid;

    private String itemname;

    private Long circleidstart;

    private Long circleidsupervise;

    private Long useridprincipal;

    private Date itemstart;

    private Date itemend;

    private Integer itemtargetmoney;

    private Integer itemrealmoney;

    private String itemdescription;

    private String itemphoto;

    private String backupone;

    private String backuptwo;

    private String backupthree;

    private String backupfour;

    private Integer backupfive;

    private Integer backupsix;

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public Long getCircleidstart() {
        return circleidstart;
    }

    public void setCircleidstart(Long circleidstart) {
        this.circleidstart = circleidstart;
    }

    public Long getCircleidsupervise() {
        return circleidsupervise;
    }

    public void setCircleidsupervise(Long circleidsupervise) {
        this.circleidsupervise = circleidsupervise;
    }

    public Long getUseridprincipal() {
        return useridprincipal;
    }

    public void setUseridprincipal(Long useridprincipal) {
        this.useridprincipal = useridprincipal;
    }

    public Date getItemstart() {
        return itemstart;
    }

    public void setItemstart(Date itemstart) {
        this.itemstart = itemstart;
    }

    public Date getItemend() {
        return itemend;
    }

    public void setItemend(Date itemend) {
        this.itemend = itemend;
    }

    public Integer getItemtargetmoney() {
        return itemtargetmoney;
    }

    public void setItemtargetmoney(Integer itemtargetmoney) {
        this.itemtargetmoney = itemtargetmoney;
    }

    public Integer getItemrealmoney() {
        return itemrealmoney;
    }

    public void setItemrealmoney(Integer itemrealmoney) {
        this.itemrealmoney = itemrealmoney;
    }

    public String getItemdescription() {
        return itemdescription;
    }

    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription == null ? null : itemdescription.trim();
    }

    public String getItemphoto() {
        return itemphoto;
    }

    public void setItemphoto(String itemphoto) {
        this.itemphoto = itemphoto == null ? null : itemphoto.trim();
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