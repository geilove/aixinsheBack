package org.geilove.pojo;

import java.util.Date;

public class ItemCashSource {
    private Long itemcashsourceid;

    private Long helpitem;

    private Long useridgoodguy;

    private Integer cashnum;

    private Date helptime;

    private String backupone;

    private String backuptwo;

    private String backupthree;

    public Long getItemcashsourceid() {
        return itemcashsourceid;
    }

    public void setItemcashsourceid(Long itemcashsourceid) {
        this.itemcashsourceid = itemcashsourceid;
    }

    public Long getHelpitem() {
        return helpitem;
    }

    public void setHelpitem(Long helpitem) {
        this.helpitem = helpitem;
    }

    public Long getUseridgoodguy() {
        return useridgoodguy;
    }

    public void setUseridgoodguy(Long useridgoodguy) {
        this.useridgoodguy = useridgoodguy;
    }

    public Integer getCashnum() {
        return cashnum;
    }

    public void setCashnum(Integer cashnum) {
        this.cashnum = cashnum;
    }

    public Date getHelptime() {
        return helptime;
    }

    public void setHelptime(Date helptime) {
        this.helptime = helptime;
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
}