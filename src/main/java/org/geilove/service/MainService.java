package org.geilove.service;
/*
 * 这里实现获取首页官网推文的功能，每次10条，这里会根据官网用户ID,标签，每次取得条数进行查找。
*/
import java.util.List;

import org.geilove.pojo.Tweet;
import org.geilove.sqlpojo.OtherPartHelpPojo;
import org.geilove.vo.WeiBo;
import java.util.Map;

public interface  MainService {
	public List<Tweet> getTweetList(Map<String, Object> map); //根据用户的id，获取一组推文
	
	public List<Tweet> getZhuanfaTweetList(Map<String,Object> map);// 根据SourceMsgID=tweetID获取一条推文的转发推文。
	
	public List<Tweet> getTweetByDiffIDs(List<Long> lst); //根据一组id，获取对应的微博，区别根据用户的id，获取一组推文
	
	public Integer updateTweetByKeySelective(Tweet recoord);//只更新记录不为空的字段
	
	public List<OtherPartHelpPojo> getProfileByUserIDs(List<Long> useridList); //根据用户的id取得用户的部分信息
	
	public Integer addTweet(Tweet tweet); //发布一条推文
	
	public List<Long> getWatcherIds(Map<String,Object> map); //获取我关注的人的ids
	
	public List<Long> getWatcherIdsListMen(Map<String,Object> map); //获取我关注的人的ids，供爱心社列表等使用
	
	public List<Long> getMyFansids(Map<String,Object> map);  //获取粉丝的ids
	
	public List<Tweet> getWeiBoList(Map<String,Object> maps);

   
}
