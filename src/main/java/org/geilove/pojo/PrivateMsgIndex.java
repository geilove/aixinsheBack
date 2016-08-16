package org.geilove.pojo;

public class PrivateMsgIndex {
    private Long privatemsgid;

    private Long useridsentmsg;

    private Long useridreceivemsg;

    private Long privateletteridmsg;

    private Byte contentstate;

    private String backupone;

    private String backuptwo;

    private String backupthree;

    private String backupfour;

    private Integer backupfive;

    private Integer backupsix;

    public Long getPrivatemsgid() {
        return privatemsgid;
    }

    public void setPrivatemsgid(Long privatemsgid) {
        this.privatemsgid = privatemsgid;
    }

    public Long getUseridsentmsg() {
        return useridsentmsg;
    }

    public void setUseridsentmsg(Long useridsentmsg) {
        this.useridsentmsg = useridsentmsg;
    }

    public Long getUseridreceivemsg() {
        return useridreceivemsg;
    }

    public void setUseridreceivemsg(Long useridreceivemsg) {
        this.useridreceivemsg = useridreceivemsg;
    }

    public Long getPrivateletteridmsg() {
        return privateletteridmsg;
    }

    public void setPrivateletteridmsg(Long privateletteridmsg) {
        this.privateletteridmsg = privateletteridmsg;
    }

    public Byte getContentstate() {
        return contentstate;
    }

    public void setContentstate(Byte contentstate) {
        this.contentstate = contentstate;
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