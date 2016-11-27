package org.geilove.requestParam;
//专门为公益排行榜做的请求参数
public class DonaterListParam {
	 private String   token; //这个就是token，在查看我的粉丝 我帮助的人等需要用到userid
	 private Integer  tag; //对应user表tobeuserone，1未捐钱 2捐钱了
	 private Integer  loadMoreTag; //1代表刷新，2代表加载更多，即下一页
	 private Integer  page;
	 private Integer  pageSize;
	 private Integer  money;//用户捐钱的多少
	 
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getTag() {
		return tag;
	}
	public void setTag(Integer tag) {
		this.tag = tag;
	}
	public Integer getLoadMoreTag() {
		return loadMoreTag;
	}
	public void setLoadMoreTag(Integer loadMoreTag) {
		this.loadMoreTag = loadMoreTag;
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
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
}
