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
		Object flag=map.get("flag");
		Object symbol=map.get("symbol");
		//System.out.println(flag);
		List<Tweet> tweets=new ArrayList<Tweet>();
		if(symbol.equals(2)){ //2是查看自己发布的，可以看到未通过审核的救助推文
			map.remove("symbol");
			if(flag.equals(1)){
				map.remove("lastItemstart");
				map.remove("flag");				
				tweets=tweetMapper.selectByMainKey(map); 
			}else{
				map.remove("lastUpdate");
				map.remove("flag");
				tweets=tweetMapper.selectByMainKeyLoadMore(map); 
			}
		}else if(symbol.equals(3)){ //查看别人发布的微博
			map.remove("symbol");
			if(flag.equals(1)){
				map.remove("lastItemstart");
				map.remove("flag");				
				tweets=tweetMapper.selectByMainKeyShe(map); 
			}else{
				map.remove("lastUpdate");
				map.remove("flag");
				tweets=tweetMapper.selectByMainKeyLoadMoreSHe(map); 
			}
		}	 		
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
	public List<Long> getWatcherIdsListMen(Map<String,Object> map){//获取我关注的人的ids
		List<Long> lsids=new ArrayList<Long>();
		Object tag=map.get("loadMoreTag"); //1 刷新 2 加载更多
		if(tag.equals(1)){
			lsids=doubleFansMapper.getWatchidsListMen(map);
		}else{
			lsids=doubleFansMapper.getWatchidsListMenLoadMore(map);
		}
		return lsids;
	} 
	@Override
	public List<Long> getMyFansids(Map<String,Object> map){
		List<Long> lsids=new ArrayList<Long>();
		Object loadMoreTag=map.get("loadMoreTag");
		if(loadMoreTag.equals(1)){
			lsids=doubleFansMapper.getMyFansids(map);
		}else{
			lsids=doubleFansMapper.getMyFansidsLoadMore(map);
		}
				
		return lsids;
	}
	
	//这个是用户主页的查询所关注人的weibo接口。 参数应该为map类型
	public List<Tweet> getWeiBoList(Map<String,Object>maps){
		List<Tweet> lsTweet=new ArrayList<Tweet>();
		maps.remove("symbol");
		Object flag=maps.get("flag");
		if(flag.equals(1)){
			maps.remove("lastItemstart");
			maps.remove("flag");
			lsTweet=tweetMapper.findByUserIds(maps);
		}else{
			maps.remove("lastUpdate");
			maps.remove("flag");
			lsTweet=tweetMapper.findByUserIdsLoadMore(maps);
		}		
		return lsTweet;
	}
	
}












