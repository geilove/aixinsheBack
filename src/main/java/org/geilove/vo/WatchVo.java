package org.geilove.vo;

import java.util.Date;

public class WatchVo {
	private Long userIDFollow;
	
	private Long userIDBeFouces;

	private Date payDate;

    private Byte payTag;

    private Byte groupID;

    private Byte specialFollow;

    private Byte doubleFans;

    public Long getUserIDFollow() {
		return userIDFollow;
	}

	public void setUserIDFollow(Long userIDFollow) {
		this.userIDFollow = userIDFollow;
	}

	public Long getUserIDBeFouces() {
		return userIDBeFouces;
	}

	public void setUserIDBeFouces(Long userIDBeFouces) {
		this.userIDBeFouces = userIDBeFouces;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Byte getPayTag() {
		return payTag;
	}

	public void setPayTag(Byte payTag) {
		this.payTag = payTag;
	}

	public Byte getGroupID() {
		return groupID;
	}

	public void setGroupID(Byte groupID) {
		this.groupID = groupID;
	}

	public Byte getSpecialFollow() {
		return specialFollow;
	}

	public void setSpecialFollow(Byte specialFollow) {
		this.specialFollow = specialFollow;
	}

	public Byte getDoubleFans() {
		return doubleFans;
	}

	public void setDoubleFans(Byte doubleFans) {
		this.doubleFans = doubleFans;
	}
	
}
