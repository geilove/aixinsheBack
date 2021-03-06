package org.geilove.dao;

import java.util.List;
import java.util.Map;
import org.geilove.pojo.Tweet;
import org.geilove.vo.WeiBo;

public interface TweetMapper {
    int deleteByPrimaryKey(Long tweetid); //根据主键删除推文

    int insert(Tweet record);    //发布 和转发推文的接口

    int insertSelective(Tweet record);

    Tweet selectByPrimaryKey(Long tweetid);
    
    List< Tweet> selectBySourceMsgIDKey(Map<String, Object> map); //根据推文的id，取得它的转发列表
        
    List<Tweet> findByIdsMap(List<Long> lst); //自定义方法，根据给定的一组不同的tweet的id查找出这组tweet，放在列表中

    int updateByPrimaryKeySelective(Tweet record);

    int updateByPrimaryKey(Tweet record); 
    /*查看自己发布的微博*/
    List<Tweet> selectByMainKey(Map<String, Object> map); //自定义方法,根据用户的id，取得一组推文列表,刷新和开始加载时候用
    List<Tweet> selectByMainKeyLoadMore(Map<String, Object> map); //自定义方法,根据用户的id，取得一组推文列表,loadMore使用
    /*查看别人发布的推文*/
    List<Tweet> selectByMainKeyShe(Map<String, Object> map); //
    List<Tweet> selectByMainKeyLoadMoreSHe(Map<String, Object> map);
    /*用户查看自己主页的推文，自己收听的*/
    List<Tweet> findByUserIds(Map<String,Object>maps); //根据获得的用户的一组userids 取出一组微博,开始与刷新  
    List<Tweet> findByUserIdsLoadMore(Map<String,Object>maps); //根据获得的用户的一组userids 取出一组微博,供加载更多用
    
    
    
}