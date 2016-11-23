package org.geilove.requestParam;

public class CommentListParam {
	    private Integer tag;
		private Integer  page;
		private Integer  pageSize;
		private Long     tweetid;
		private String  lastCommentTime;
		
		public Integer getTag() {
			return tag;
		}
		public void setTag(Integer tag) {
			this.tag = tag;
		}
		public String getLastCommentTime() {
			return lastCommentTime;
		}
		public void setLastCommentTime(String lastCommentTime) {
			this.lastCommentTime = lastCommentTime;
		}
		public Integer getPage() {
			return page;
		}
		public void setPage(Integer page) {
			this.page = page;
		}
		public Integer getPageSize() {
			return pageSize;
		}
		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}
		public Long getTweetid() {
			return tweetid;
		}
		public void setTweetid(Long tweetid) {
			this.tweetid = tweetid;
		}
}
