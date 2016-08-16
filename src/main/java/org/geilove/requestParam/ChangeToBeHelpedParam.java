package org.geilove.requestParam;

import java.util.Date;

public class ChangeToBeHelpedParam {
	private String userEmail;//受助人的邮箱
	private Long   userID; //受助人的主键，这个应该废弃，暂时这么写吧
	private String difficult; //困难的原因，存放在cash表的backone字段
	private Integer targetCash; //需要的捐款金额
	private  Integer  userIDCircle;//开启这个受助人的社团ID
	private  Date closeTime;// 这个是账户的关闭时间，不能允许账户一直开着，一般设置为2个月左右
	private  Long userIDCash; //受助人的主键
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getDifficult() {
		return difficult;
	}
	public void setDifficult(String difficult) {
		this.difficult = difficult;
	}
	public Integer getTargetCash() {
		return targetCash;
	}
	public void setTargetCash(Integer targetCash) {
		this.targetCash = targetCash;
	}
	public Integer getUserIDCircle() {
		return userIDCircle;
	}
	public void setUserIDCircle(Integer userIDCircle) {
		this.userIDCircle = userIDCircle;
	}
	public Date getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
	public Long getUserIDCash() {
		return userIDCash;
	}
	public void setUserIDCash(Long userIDCash) {
		this.userIDCash = userIDCash;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	
	

}
