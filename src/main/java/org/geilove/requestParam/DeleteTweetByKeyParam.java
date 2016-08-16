package org.geilove.requestParam;

public class DeleteTweetByKeyParam {

	private String useremail;
    private String userpassword;
    private Long   tweetid;
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public Long getTweetid() {
		return tweetid;
	}
	public void setTweetid(Long tweetid) {
		this.tweetid = tweetid;
	}
    
    
}
