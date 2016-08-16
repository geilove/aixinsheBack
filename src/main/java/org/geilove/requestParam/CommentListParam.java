package org.geilove.requestParam;

public class CommentListParam {
		private Integer  page;
		private Integer  pageSize;
		private Long     tweetid;
		
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
