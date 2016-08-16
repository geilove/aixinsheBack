package org.geilove.requestParam;
//评论的时间等字段，由服务器默认生成
public class AddCommentParam {
	 private Long tweetiddiscussreply;  //被评论的推文的id
	 private Long useriddiscussreply;   //评论人的id
     private Byte discussreplytype;     // 区分单纯评论还是回复评论的标志
	 private String discussreplytext;   //评论的内容
	 
	public Long getTweetiddiscussreply() {
		return tweetiddiscussreply;
	}
	public void setTweetiddiscussreply(Long tweetiddiscussreply) {
		this.tweetiddiscussreply = tweetiddiscussreply;
	}
	public Long getUseriddiscussreply() {
		return useriddiscussreply;
	}
	public void setUseriddiscussreply(Long useriddiscussreply) {
		this.useriddiscussreply = useriddiscussreply;
	}
	public Byte getDiscussreplytype() {
		return discussreplytype;
	}
	public void setDiscussreplytype(Byte discussreplytype) {
		this.discussreplytype = discussreplytype;
	}
	public String getDiscussreplytext() {
		return discussreplytext;
	}
	public void setDiscussreplytext(String discussreplytext) {
		this.discussreplytext = discussreplytext;
	}
	 
}
