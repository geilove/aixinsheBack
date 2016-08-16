package org.geilove.pojo;

import java.util.Date;

public class Topic {
    private Long topicid;

    private String topicname;

    private Long useridtopic;

    private String topicdesciption;

    private Long topicread;

    private Long topictalk;

    private String topicphoto;

    private Date topicdate;

    private String topicbackup;

    private String topicbackupone;

    private String topicbackuptwo;

    private String topicbackupthree;

    private Integer topicbackupfive;

    private Integer topicbackupsix;

    public Long getTopicid() {
        return topicid;
    }

    public void setTopicid(Long topicid) {
        this.topicid = topicid;
    }

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname == null ? null : topicname.trim();
    }

    public Long getUseridtopic() {
        return useridtopic;
    }

    public void setUseridtopic(Long useridtopic) {
        this.useridtopic = useridtopic;
    }

    public String getTopicdesciption() {
        return topicdesciption;
    }

    public void setTopicdesciption(String topicdesciption) {
        this.topicdesciption = topicdesciption == null ? null : topicdesciption.trim();
    }

    public Long getTopicread() {
        return topicread;
    }

    public void setTopicread(Long topicread) {
        this.topicread = topicread;
    }

    public Long getTopictalk() {
        return topictalk;
    }

    public void setTopictalk(Long topictalk) {
        this.topictalk = topictalk;
    }

    public String getTopicphoto() {
        return topicphoto;
    }

    public void setTopicphoto(String topicphoto) {
        this.topicphoto = topicphoto == null ? null : topicphoto.trim();
    }

    public Date getTopicdate() {
        return topicdate;
    }

    public void setTopicdate(Date topicdate) {
        this.topicdate = topicdate;
    }

    public String getTopicbackup() {
        return topicbackup;
    }

    public void setTopicbackup(String topicbackup) {
        this.topicbackup = topicbackup == null ? null : topicbackup.trim();
    }

    public String getTopicbackupone() {
        return topicbackupone;
    }

    public void setTopicbackupone(String topicbackupone) {
        this.topicbackupone = topicbackupone == null ? null : topicbackupone.trim();
    }

    public String getTopicbackuptwo() {
        return topicbackuptwo;
    }

    public void setTopicbackuptwo(String topicbackuptwo) {
        this.topicbackuptwo = topicbackuptwo == null ? null : topicbackuptwo.trim();
    }

    public String getTopicbackupthree() {
        return topicbackupthree;
    }

    public void setTopicbackupthree(String topicbackupthree) {
        this.topicbackupthree = topicbackupthree == null ? null : topicbackupthree.trim();
    }

    public Integer getTopicbackupfive() {
        return topicbackupfive;
    }

    public void setTopicbackupfive(Integer topicbackupfive) {
        this.topicbackupfive = topicbackupfive;
    }

    public Integer getTopicbackupsix() {
        return topicbackupsix;
    }

    public void setTopicbackupsix(Integer topicbackupsix) {
        this.topicbackupsix = topicbackupsix;
    }
}