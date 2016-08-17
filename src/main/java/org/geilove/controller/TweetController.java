/*
 * @author aihaitao
 * 这个用来显示首页，但不同于个人主页，它没有粉丝数推文数量等信息。
*/
package org.geilove.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.geilove.pojo.Tweet;
import org.geilove.requestParam.DeleteTweetByKeyParam;
import org.geilove.service.MainService;
import org.geilove.vo.TweetByTweetVo;
import org.geilove.requestParam.TweetListParam;
import org.geilove.requestParam.ZhuangfaListParam;
import org.geilove.requestParam.PublishTweetParam;
//import org.geilove.requestParam.DelTweetCommentParam;
import org.geilove.response.CommonRsp;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Resource;
import org.geilove.response.TweetsListRsp;
/*
 * 这个用来提供有关推文的操作
*/
@Controller
@RequestMapping("/weibos")
public class TweetController {
	@Resource
	private MainService mainService;
	
	@RequestMapping(value="/getTweetByUserID")//这个是在可直接获取用户ID时候用，比如查看用户自己发布、转发的推文
	public  @ResponseBody List<TweetByTweetVo> getTweetByUserID(@RequestBody TweetListParam tweetListParam ){
		Long	 userID=tweetListParam.getUserID();
		Integer  page=tweetListParam.getPage();
		Integer  pageSize=tweetListParam.getPageSize();
		List<TweetByTweetVo> tweetBytweets=new ArrayList<TweetByTweetVo>();	//这个是最终要返回的	
		Map<String,Object> map=new HashMap<String,Object>();//存放查询的参数，传给Mybatis
		map.put("userID", userID);
		map.put("page", page);
		map.put("pageSize", pageSize);
		
		List<Tweet> tweets=mainService.getTweetList(map);//首先取得推文，不带头像，不带转发
			
		List<Tweet> tweetlist=new ArrayList<Tweet>(tweets.size());//存放转发推文中的原始推文							
		//这个是用来在sql-where-in中循环传参数用的。MainService中的getTweetByDiffIDs
		List<Long> paramslist=new ArrayList<Long>();
		List<Long> useridList=new ArrayList<Long>();
		
		for(int i=0;i<tweets.size();i++){			
			if(tweets.get(i).equals(2)){//如果等于2，则是转发的推文				
				//取得所有要二次查询的推文的id号，因为他们大多数情况下是不一样的，也有可能一样的，所以用list
				paramslist.add(tweets.get(i).getSourcemsgid());//所有需要二次查询数据库获得转发中的推文ID放在这里								
			}		
			useridList.add(tweets.get(i).getUseridtweet());//这些是用户的id，根据这些可以找到用户的头像地址
			
		}
		List<String> userPhotos=mainService.getPhotosByUserIDs(useridList);//根据用户的ids找到用户的头像地址，自定义传入List参数查询
		for(int i=0;i<tweets.size();i++){
			tweetBytweets.get(i).setUserPhoto(userPhotos.get(i));
		}
		
		
		//连接数据库进行查询，返回所有被转发的推文
		tweetlist=mainService.getTweetByDiffIDs(paramslist); //paramslist是所有需要二次查询的推文id组成的列表
		
		/* -------，组合成最终要返回的tweetBytweets------------------------------------------------*/
		for(int i=0;i<tweets.size();i++){
			for(int j=0;j<paramslist.size();j++){
				if(tweets.get(i).getSourcemsgid()==tweetlist.get(j).getTweetid()){
					tweetBytweets.get(i).setTweet(tweetlist.get(j));
					continue;
				}
			}
		}
		return tweetBytweets;
	}
	/*这个仅仅用来测试，返回一组weibo，以便马上能写App信息流列表*/
	@RequestMapping(value="/getTweetLists")//这个是在可直接获取用户ID时候用
	public  @ResponseBody TweetsListRsp getTweetLists(@RequestBody TweetListParam tweetListParam ){
		Long	 userID=tweetListParam.getUserID();
		Integer  page=tweetListParam.getPage();
		Integer  pageSize=tweetListParam.getPageSize();
		Map<String,Object> map=new HashMap<String,Object>();//存放查询的参数
		map.put("userID", userID);
		map.put("page", page);
		map.put("pageSize", pageSize);
		TweetsListRsp tweetsListRsp=new TweetsListRsp();
		List<Tweet> tweets=mainService.getTweetList(map);//首先取得推文，不带头像，不带转发的推文
		if(tweets==null){
			tweetsListRsp.setData(tweets);
			tweetsListRsp.setMsg("用户没有发表推文哦");
			tweetsListRsp.setRetcode(2001);
		}else{
			tweetsListRsp.setData(tweets);
			tweetsListRsp.setMsg("获取数据成功");
			tweetsListRsp.setRetcode(2000);
		}
	    return tweetsListRsp;
	}
	
	/*这个是删除一条推文，因此需要用户名、密码、推文的ID，要授权才能删除，只做逻辑删除*/
	@RequestMapping(value="/deleteTweetByID")
	public @ResponseBody CommonRsp deleteTweetByID(@RequestBody DeleteTweetByKeyParam delTweetParam){
		//这里先检查用户名和密码是否存在并匹配
		// 然后调用Service，将删除标志更新为2
		CommonRsp rsp=new CommonRsp();
		Tweet tweet=new Tweet();
		tweet.setDeletetag((byte) 2);
		tweet.setTweetid(delTweetParam.getTweetid());//根据这个推文的ID更新
		Integer updateTag=mainService.updateTweetByKeySelective(tweet);	
		if(updateTag==0){
			rsp.setMsg("删除推文失败");
			rsp.setRetcode(2001);
		}else{
			rsp.setMsg("删除成功");
			rsp.setRetcode(2000);
		}
		return rsp;		
	}
	/*这是发布一条推文，转发推文也用这个接口*/
	@RequestMapping(value="/publishTweet")
	public @ResponseBody CommonRsp publishTweet(@RequestBody PublishTweetParam publishTweetParam){
		 String proof=publishTweetParam.getProof();
		 String userEmail=publishTweetParam.getUserEmail();
		 String userPassword=publishTweetParam.getUserPassword();
		 String tweetContent=publishTweetParam.getTweetContent();
		 CommonRsp rsp=new CommonRsp();
		 //这里应该验证请求凭证Proof的有效性，先省略
		 Tweet tweet=new Tweet();
		 tweet.setMsgcontent(tweetContent); //其它用默认的
		 Integer response=mainService.addTweet(tweet);
		if(response==0){
			rsp.setMsg("发布推文失败了");
			rsp.setRetcode(2003);
		}else{
			rsp.setMsg("发布成功");
			rsp.setRetcode(2000);
		}
		 return rsp;		 
	}
	/*这是一条推文的转发列表，本质上也是一组推文。不需要取得原推文内容，如果转发时输入为空，默认存储为“转发推文” */
	@RequestMapping(value="/listZhuanfa")
	public @ResponseBody TweetsListRsp getZhuanfaList(@RequestBody  ZhuangfaListParam zhuanfaListParam){
		String proofs=zhuanfaListParam.getProof();
		Long tweetid =zhuanfaListParam.getTweetid();
		Integer page=zhuanfaListParam.getPage();
		Integer pageSize=zhuanfaListParam.getPageSize();
		//这里应该验证proof的有效性
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("tweetid", tweetid);
		map.put("page", page);
		map.put("pageSize", pageSize);
		TweetsListRsp tweetsListRsp=new TweetsListRsp();
		List<Tweet> tweets=mainService.getZhuanfaTweetList(map); //首先取得推文，不带头像，不带转发的推文
		if(tweets==null || tweets.size() ==0 ){
			tweetsListRsp.setData(tweets);
			tweetsListRsp.setMsg("用户没有发表推文哦");
			tweetsListRsp.setRetcode(2001);
		}else{
			tweetsListRsp.setData(tweets);
			tweetsListRsp.setMsg("获取数据成功");
			tweetsListRsp.setRetcode(2000);
		}
		return tweetsListRsp;
	}
	
		
}
























