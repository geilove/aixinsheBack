///*
// * @author aihaitao
// * 这个用来显示主页面，而不是推文页面。
//*/
//package org.geilove.controller;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.geilove.pojo.Tweet;
//import org.geilove.requestParam.TweetByTweetParam;
//import org.geilove.service.MainService;
//import org.geilove.vo.TweetListVo;
//import org.geilove.util.TweetHandle;
//
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Map;
//import java.util.HashMap;
//@Controller
//@RequestMapping("/tweets")
//public class MainController {
//	@Resource
//	private MainService mainService;
//	public TweetHandle tweetHandle=new TweetHandle(); 
//	class TweetHelp{
//		private Long tweetID;
//		private Long sourceMsgID;
//		
//		public Long getTweetID() {
//			return tweetID;
//		}
//		public void setTweetID(Long tweetID) {
//			this.tweetID = tweetID;
//		}
//		public Long getSourceMsgID() {
//			return sourceMsgID;
//		}
//		public void setSourceMsgID(Long sourceMsgID) {
//			this.sourceMsgID = sourceMsgID;
//		}
//		
//	}
//	@RequestMapping(value="/getTweetByUserID")//这个是在可直接获取用户ID时候用
//	public  @ResponseBody List<TweetByTweetParam> getTweetByUserID(@RequestBody TweetListVo tweetListVo ){
//		Long	 userID=tweetListVo.getUserID();
//		Integer  page=tweetListVo.getPage();
//		Integer  pageSize=tweetListVo.getPageSize();
//		List<TweetByTweetParam> tweetBytweets=new ArrayList<TweetByTweetParam>();		
//		Map<String,Object> map=new HashMap<String,Object>();//存放查询的参数
//		map.put("userID", userID);
//		map.put("page", page);
//		map.put("pageSize", pageSize);
//		
///* ---------先取得这组原始推文，加上头像和超链接-------------------------------------------------------------*/
//		List<Tweet> tweets=mainService.getTweetList(map); 		
//		//根据推文的userID取得对应用户的头像，先用默认的吧。被转发的原始推文不需要取得头像 。并且为每一个被@的用户加上超链接。
//		for(Tweet tw:tweets){
//			System.out.println(tw.getTweetid());//打印查看下
//			String strMsg=tw.getMsgcontent().trim();//获取这个推文的内容	
//			String strWithSuperLink=tweetHandle.tweetAddAt(strMsg);//这个是进行加入超链接
//			tw.setMsgcontent(strWithSuperLink);//加入超链接后的推文放入原来的weibo中	
//		}
//		
///* ---------取得被转发的推文，加入超链接-----------------------------------------------------------------*/	
//		//根据原始推文中的，循环每一条推文，查看是否有转发的标志，若有，再次连接数据库取得，加入到TwetInTweetUo的Tweet数据域中
//		List<Tweet> tweetlist=new ArrayList<Tweet>();//存放转发推文中的原始推文			
//		List<TweetHelp> helps=new ArrayList<TweetHelp>();//这个存放转发和原始推文对应关系，以便取出原始推文后，好组合
//		TweetHelp help=new TweetHelp();
//		List<Long> paramslist=new ArrayList<Long>();//这个是用来在sql-where-in中循环传参数用的。
//		for(int i=0;i<tweets.size();i++){			
//			if(tweets.get(i).equals(2)){//如果等于2，则是转发的推文				
//				help.setTweetID(tweets.get(i).getTweetid());
//				help.setSourceMsgID(tweets.get(i).getSourcemsgid());
//				helps.add(help);//加入一个对应关系到列表中
//				//取得所有要二次查询的推文的id号，因为他们大多数情况下是不一样的，也有可能一样的，所以用list
//				paramslist.add(tweets.get(i).getSourcemsgid());//所有需要二次查询数据库获得转发中的推文ID放在这里								
//			}			
//		}
//		//连接数据库进行查询，返回所有被转发的推文
//		tweetlist=mainService.getTweetByDiffIDs(paramslist); //paramslist是所有需要二次查询的推文id组成的列表
//		
//		for(Tweet tw:tweetlist){
//			String strMsg=tw.getMsgcontent().trim();//获取这个推文的内容	
//			String strWithSuperLink=tweetHandle.tweetAddAt(strMsg);//这个是进行加入超链接
//			tw.setMsgcontent(strWithSuperLink);//加入超链接后的推文放入原来的weibo中		   
//		}
//			
///* -------根据helps中的关联关系，组合成最终要返回的tweetBytweets------------------------------------------------*/
//		//这个地方组合推文返回
//		
//		return tweetBytweets;
//	} 	
//	
//	
//	
//	
//	
//	
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
