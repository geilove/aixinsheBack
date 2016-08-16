package org.geilove.service;
/*
 * 这里实现获取首页官网推文的功能，每次10条，这里会根据官网用户ID,标签，每次取得条数进行查找。
*/
import java.util.List;

import org.geilove.pojo.Tweet;

import java.util.Map;

public interface  MainService {
	public List<Tweet> getTweetList(Map<String, Object> map); //根据用户的id，获取一组推文
	
	public List<Tweet> getZhuanfaTweetList(Map<String,Object> map);// 根据SourceMsgID=tweetID获取一条推文的转发推文。
	
	public List<Tweet> getTweetByDiffIDs(List<Long> lst);
	
	public Integer updateTweetByKeySelective(Tweet recoord);//只更新记录不为空的字段
	
	public List<String> getPhotosByUserIDs(List<Long> useridList);//根据用户的id取得用户的头像地址
   
}
