package org.geilove.service.impl;
/*
 * 
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import  org.geilove.pojo.Tweet;
import  org.geilove.service.MainService;
import  org.geilove.sqlpojo.OtherPartHelpPojo;
import  org.geilove.pojo.Tweet;
import  org.geilove.dao.TweetMapper;
import  org.geilove.dao.UserMapper;
import  org.geilove.dao.DoubleFansMapper;
import  org.springframework.stereotype.Service;
import  org.geilove.vo.WeiBo;
@Service("tweetListService")
public class MainServiceImpl implements MainService {
	
	@Resource 
	private TweetMapper tweetMapper;
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private DoubleFansMapper doubleFansMapper;
         /* 先根据用户id，按照时间标签获取tweet，然后遍历tweet，如果是转发的，就请求数据库，
	      * 获取原tweet，合成一块返回,这里还要加上@带来的超链接。
	     */
	@Override
	public List<Tweet> getTweetList(Map<String,Object> map){
		//这里调用自定义的方法，取得推文列表，服务是最小的单元，复杂的数据获取在Controller调用服务完成，服务应该处理和数据库有关的错误等事件。
		List<Tweet> tweets=tweetMapper.selectByMainKey(map);  
		
		return tweets;		
	} 
	@Override
	public List<Tweet> getZhuanfaTweetList(Map<String,Object> map){
		List<Tweet> tweets=tweetMapper.selectBySourceMsgIDKey(map);  //根据推文的id，去得它的转发列表	
		return tweets;	
	}
	
	@Override
	public List<Tweet> getTweetByDiffIDs(List<Long> lst){
		List<Tweet> tweetsByIDs=tweetMapper.findByIdsMap(lst);
		return tweetsByIDs;
	}
	
	@Override
	public Integer updateTweetByKeySelective(Tweet record){
		Integer updateTag=tweetMapper.updateByPrimaryKeySelective(record);
		return updateTag;
	} 
	
	@Override
	public List<OtherPartHelpPojo> getProfileByUserIDs(List<Long> useridList){
		List<OtherPartHelpPojo> userPhotos=new ArrayList<OtherPartHelpPojo>();
		userPhotos=userMapper.selectUserPartProfile(useridList);              //通过用户表获取列表
		return userPhotos; 
	}
	
	@Override
	public Integer addTweet(Tweet tweet){    //发布一条推文
		int  response=tweetMapper.insert(tweet);
		return response;
	}
	@Override
	public List<Long> getWatcherIds(Map<String,Object> map){ //获取用户所关注的id
		List<Long> lsids=new ArrayList<Long>();
		lsids=doubleFansMapper.getWatchids(map);		
		return lsids;
	}
	@Override
	public List<Long> getMyFansids(Map<String,Object> map){
		List<Long> lsids=new ArrayList<Long>();
		lsids=doubleFansMapper.getMyFansids(map);		
		return lsids;
	}
	
	public List<Tweet> getWeiBoList(List<Long> ls){
		List<Tweet> lsTweet=new ArrayList<Tweet>();
		lsTweet=tweetMapper.findByUserIds(ls);
		return lsTweet;
	}
	
}












