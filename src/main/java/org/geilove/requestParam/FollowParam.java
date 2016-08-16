package org.geilove.requestParam;

public class FollowParam {
	private Long  userIDFollow;
	private Long  userIDBeFocus;
    private Byte   paytag;//关注标志
    
	public Long getUserIDFollow() {
		return userIDFollow;
	}
	public void setUserIDFollow(Long userIDFollow) {
		this.userIDFollow = userIDFollow;
	}
	public Long getUserIDBeFocus() {
		return userIDBeFocus;
	}
	public void setUserIDBeFocus(Long userIDBeFocus) {
		this.userIDBeFocus = userIDBeFocus;
	}
	public Byte getPaytag() {
		return paytag;
	}
	public void setPaytag(Byte paytag) {
		this.paytag = paytag;
	}
    
}
