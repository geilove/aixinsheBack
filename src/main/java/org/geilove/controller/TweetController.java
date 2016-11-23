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
import org.geilove.requestParam.PublishTweetParam;
import org.geilove.service.MainService;
import org.geilove.service.RegisterLoginService;
import org.geilove.sqlpojo.OtherPartHelpPojo;
import org.geilove.vo.TweetByTweetVo;
import org.geilove.requestParam.TweetListParam;
import org.geilove.requestParam.WeiBoListParam;
import org.geilove.requestParam.ZhuangfaListParam;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.geilove.response.*;
import org.geilove.vo.WeiBo;
import org.geilove.vo.Tuiwen;
/*
 * 这个用来提供有关推文的操作
*/
@Controller
@RequestMapping("/weibos")
public class TweetController {
	@Resource
	private MainService mainService;
	@Resource
	private RegisterLoginService rlService;
	@RequestMapping(value="/gettweetbyuserid")//比如查看用户自己发布、转发的推文
	public  @ResponseBody TweetsListRsp getTweetByUserID(@RequestBody TweetListParam tweetListParam,HttpServletRequest request){
		TweetsListRsp tweetsListRsp=new TweetsListRsp();
		String token=tweetListParam.getToken(); //获取登录凭证
		String useridStr=token.substring(32); //获取userID
		//System.out.println(useridStr);
		Long userID=Long.valueOf(useridStr).longValue();		
		Integer  page=tweetListParam.getPage();
		Integer  pageSize=tweetListParam.getPageSize();
		List<Tweet>tweetlist=new ArrayList<Tweet>();//存放被转发的推文						
		//这个是用来在sql-where-in中循环传参数用的。MainService中的getTweetByDiffIDs
		List<Long> paramslist=new ArrayList<Long>(); //这个是存放被转发推文id的地方
		List<Long> useridList=new ArrayList<Long>(); //这个是存放发布用户
		List<Long> zhuanfaUseridList=new ArrayList<Long>(); //存放被转发的推文中的用户id
		
		Map<String,Object> map=new HashMap<String,Object>();//存放查询的参数，传给Mybatis
		map.put("userID", userID);
		map.put("page", page);
		map.put("pageSize", pageSize);	
		map.put("lastUpdate", tweetListParam.getLastUpdate());	   
		map.put("lastItemstart", tweetListParam.getLastItemstart());
		map.put("flag", tweetListParam.getFlag()); //1 是刷新，2是loadMore
		map.put("symbol",tweetListParam.getSymbol());
		List<Tweet> tweets=mainService.getTweetList(map);//首先取得推文，不带转发			
		
		/*1.先获取这组推文包含的用户id集合和被转发的推文主键id集合*/
		if(tweets.size()!=0){
			if(tweetListParam.getFlag()==1){ //1刷新是升序排序的，所以需要翻转，loadMore不需要
				Collections.reverse(tweets); 
			} 
			/*这里应该循环为图片补全完整地址*/
			for(int i=0;i<tweets.size();i++){	
				if(tweets.get(i).getTagid()==2){//如果等于2，则是转发的推文				
					//取得所有要二次查询的推文的id号，因为他们大多数情况下是不一样的，也有可能一样的，所以用list
					paramslist.add(tweets.get(i).getSourcemsgid());//所有需要二次查询数据库获得转发中的推文ID放在这里								
				}
				//这些是用户的id，根据这些可以找到用户的昵称头像等信息	
				useridList.add(tweets.get(i).getUseridtweet());		
			}
		}else{ //很可能用户没有关注任何人，所以微博是空的
			tweetsListRsp.setData(null);
		    tweetsListRsp.setMsg("数据为空");
		    tweetsListRsp.setRetcode(2002);
			return tweetsListRsp;
		}

		/*2.获取推文中需要展示的用户信息*/
		List<OtherPartHelpPojo> userPartProfile=new  ArrayList<OtherPartHelpPojo>();
		if(useridList.size()!=0){
			//System.out.println(useridList.size());
			
			userPartProfile=mainService.getProfileByUserIDs(useridList); //如果能到这一步说明useridList肯定是非空的
		} 
	    /*3.获取被转发的推文*/
	    if(paramslist.size()!=0){ //这个必须做判断，因为微博可能是全部原创的
	    	tweetlist=mainService.getTweetByDiffIDs(paramslist); //paramslist是所有需要二次查询的推文id组成的列表
	    	/*这里应该循环为图片补全完整地址*/
	    }else{ //说明不含被转发的微博，那么直接组装微博返回就可以了
		    /*5.合并推文和用户信息tweets 和 userPartProfile 到 lsWb*/
		    List<WeiBo>  lsWb=new ArrayList<WeiBo>();	    
		    for(int k=0;k<tweets.size();k++){
		    	//System.out.println(tweets.size());
		    	//System.out.println(userPartProfile.size());
		    	
		    	WeiBo wb=new WeiBo();//WeiBo中有两个数据域，一个是推文领一个是被转发的推文
		    	for(int l=0;l<userPartProfile.size();l++){
		    		Tuiwen tw=new Tuiwen();
		    		tw.setTweet(tweets.get(k)); //把tweet放入推文中
			    	if(tweets.get(k).getUseridtweet()==userPartProfile.get(l).getUserid()){
			    		/*其它部分放入到推文*/
			    		tw.setPhotoupload((Byte)userPartProfile.get(l).getPhotoupload());
			    		tw.setSelfintroduce(userPartProfile.get(l).getSelfintroduce()); //用户的简介加入到Tuiwen中
			    		tw.setUsernickname(userPartProfile.get(l).getUsernickname()); //用户的昵称加入到Tuiwen中去
			    		tw.setUserphoto(userPartProfile.get(l).getUserphoto()); //用户的头像地址		    		
			    	}
			    	wb.setTuiwen(tw); //推文被放入微博
		    	}	    	
		    	lsWb.add(wb);  //微博放入到微博列表中		    	
		    }
		    tweetsListRsp.setData(lsWb);
		    tweetsListRsp.setMsg("成功了");
		    tweetsListRsp.setRetcode(2000);
		    
	    	return tweetsListRsp;
	    }
	    /*4.获取被转发推文中的有关用户的信息*/
	    if(tweetlist.size()!=0){ //能走到这一步，说明含有被转发的微博
		    for(int j=0;j<tweetlist.size();j++){
		    	zhuanfaUseridList.add(tweetlist.get(j).getUseridtweet());
		    }
	    }
	    List<OtherPartHelpPojo> zhuanfaUserPartProfile=new  ArrayList<OtherPartHelpPojo>();
	    
	    if(zhuanfaUseridList.size()!=0){
	    	  zhuanfaUserPartProfile=mainService.getProfileByUserIDs(zhuanfaUseridList);
	    }	  
	    /*能走到这一步，说明是一组微博并且有若干被转发的微博在里面*/
	    /*5.合并推文和用户信息tweets 和 userPartProfile 到 lsWb*/
	    List<WeiBo>  lsWb=new ArrayList<WeiBo>();	    
	    for(int k=0;k<tweets.size();k++){
	    	WeiBo wb=new WeiBo();//WeiBo中有两个数据域，一个是推文领一个是被转发的推文
	    	for(int l=0;l<userPartProfile.size();l++){
	    		Tuiwen tw=new Tuiwen();
	    		tw.setTweet(tweets.get(k)); //把tweet放入推文中
		    	if(tweets.get(k).getUseridtweet()==userPartProfile.get(l).getUserid()){
		    		/*其它部分放入到推文*/
		    		tw.setPhotoupload((Byte)userPartProfile.get(l).getPhotoupload());
		    		tw.setSelfintroduce(userPartProfile.get(l).getSelfintroduce()); //用户的简介加入到Tuiwen中
		    		tw.setUsernickname(userPartProfile.get(l).getUsernickname()); //用户的昵称加入到Tuiwen中去
		    		tw.setUserphoto(userPartProfile.get(l).getUserphoto()); //用户的头像地址		    		
		    	}
		    	wb.setTuiwen(tw); //推文被放入微博
	    	}	    	
	    	lsWb.add(wb);  //微博放入到微博列表中		    	
	    } 
	    /* 合并被转发推文和用户信息tweetlist 和zhuanfaUserPartProfile到lsTw*/    
	    List<Tuiwen> lsTw=new ArrayList<Tuiwen>();
	    for(int n=0;n<tweetlist.size();n++){
	    	for(int m=0;m<zhuanfaUserPartProfile.size();m++){
		    	Tuiwen tw=new Tuiwen();
		    	tw.setTweet(tweetlist.get(n));
	    		if(tweetlist.get(n).getUseridtweet()==zhuanfaUserPartProfile.get(m).getUserid()){
	    			tw.setPhotoupload(zhuanfaUserPartProfile.get(m).getPhotoupload());
	    			tw.setSelfintroduce(zhuanfaUserPartProfile.get(m).getSelfintroduce());
	    			tw.setUsernickname(zhuanfaUserPartProfile.get(m).getUsernickname());
	    			tw.setUserphoto(zhuanfaUserPartProfile.get(m).getUserphoto());
	    		}
	    		lsTw.add(tw); //推文放入到推文列表中
	    	}
	    }
	    /*7.合并lsTw 到 lsWb*/
	    for(int p=0;p<lsWb.size();p++){	  //微博数一定多于转发的微博数量  	
	    	for(int q=0;q<lsTw.size();q++){
	    		if(lsWb.get(p).getTuiwen().getTweet().getSourcemsgid()==lsTw.get(q).getTweet().getTweetid()){
	    			lsWb.get(p).setZhuanfaTuiwen(lsTw.get(q));
	    		}
	    	}
	    }
	    
	    /* 8.返回tweetsListRsp*/
	    tweetsListRsp.setData(lsWb);
	    tweetsListRsp.setMsg("成功了");
	    tweetsListRsp.setRetcode(2000);
	    
		return tweetsListRsp;
	}
	
	
	/*
	 * 推文主页接口，先获取这个用户关注的人的id(按照关注时间排序)，然后用这组id获取推文(按照时间排序)20条，
	 * 如果是刷新还是这个接口，app端清空数据，
	 * 如果是加载更多应该换一个接口。
	 */
	@RequestMapping(value="/gettuiwenlists")
	public  @ResponseBody TweetsListRsp getTweetLists(@RequestBody WeiBoListParam tweetListParam ){
		TweetsListRsp tweetsListRsp=new TweetsListRsp();
		String token=tweetListParam.getToken(); //获取登录凭证
		String useridStr=token.substring(32); //获取userID	
		Long userID=Long.valueOf(useridStr).longValue();
		Integer  page=tweetListParam.getPage();
		Integer  pageSize=tweetListParam.getPageSize();
		Integer flag=tweetListParam.getFlag();
		String  lastUpdate=tweetListParam.getLastUpdate();
		String lastItemstart=tweetListParam.getLastItemstart();
		
		List<Tweet>tweetlist=new ArrayList<Tweet>();//存放被转发的推文						
		//这个是用来在sql-where-in中循环传参数用的。MainService中的getTweetByDiffIDs
		List<Long> paramslist=new ArrayList<Long>(); //这个是存放被转发推文id的地方
		List<Long> useridList=new ArrayList<Long>(); //这个是存放发布用户
		List<Long> zhuanfaUseridList=new ArrayList<Long>(); //存放被转发的推文中的用户id
		
		Map<String,Object> map=new HashMap<String,Object>();//存放查询的参数，传给Mybatis
		map.put("userID", userID);
		map.put("page", 0); //这里的page、pageSize要去掉，应该给maps用
		map.put("pageSize", 1000);	
		/*-1.先获取这个人关注的列表集合List<Long>，其实应该获取所有的关注的人*/
		List<Long> lsids=mainService.getWatcherIds(map); //这个map只用到了userID
		if(lsids.isEmpty()|| lsids==null){
			tweetsListRsp.setData(null);
			tweetsListRsp.setMsg("用户没有关注人");
			tweetsListRsp.setRetcode(2001);
			return tweetsListRsp;
		}
		/*0.然后用这个userid集合获取一组推文，*/
		Map<String,Object> maps=new HashMap<String,Object>();
		maps.put("page", page);
		maps.put("pageSize", pageSize);	
		maps.put("list", lsids); //列表参数
		maps.put("flag",flag);
		maps.put("lastUpdate", lastUpdate);
		maps.put("lastItemstart", lastItemstart);
		List<Tweet> tweets=mainService.getWeiBoList(maps);//首先取得推文，不带转发，这里应该传入map参数
		
		/*1.先获取这组推文包含的用户id集合和被转发的推文主键id集合*/
		if(tweets.size()!=0){
			if(tweetListParam.getFlag()==1){ //1刷新是升序排序的，所以需要翻转，loadMore不需要
				Collections.reverse(tweets); 
			}
			for(int i=0;i<tweets.size();i++){	
				if(tweets.get(i).getTagid()==2){//如果等于2，则是转发的推文				
					//取得所有要二次查询的推文的id号，因为他们大多数情况下是不一样的，也有可能一样的，所以用list
					paramslist.add(tweets.get(i).getSourcemsgid());//所有需要二次查询数据库获得转发中的推文ID放在这里								
				}
				//这些是用户的id，根据这些可以找到用户的昵称头像等信息	
				useridList.add(tweets.get(i).getUseridtweet());		
			}
		}else{ //很可能用户没有关注任何人，所以微博是空的
			tweetsListRsp.setData(null);
		    tweetsListRsp.setMsg("数据为空");
		    tweetsListRsp.setRetcode(2002);
			return tweetsListRsp;
		}

		/*2.获取推文中需要展示的用户信息*/
		List<OtherPartHelpPojo> userPartProfile=new  ArrayList<OtherPartHelpPojo>();
		if(useridList.size()!=0){
			//System.out.println(useridList.size());
			
			userPartProfile=mainService.getProfileByUserIDs(useridList); //如果能到这一步说明useridList肯定是非空的
		} 
	    /*3.获取被转发的推文*/
	    if(paramslist.size()!=0){ //这个必须做判断，因为微博可能是全部原创的
	    	tweetlist=mainService.getTweetByDiffIDs(paramslist); //paramslist是所有需要二次查询的推文id组成的列表
	    }else{ //说明不含被转发的微博，那么直接组装微博返回就可以了
		    /*5.合并推文和用户信息tweets 和 userPartProfile 到 lsWb*/
		    List<WeiBo>  lsWb=new ArrayList<WeiBo>();	    
		    for(int k=0;k<tweets.size();k++){
		    	//System.out.println(tweets.size());
		    	//System.out.println(userPartProfile.size());
		    	
		    	WeiBo wb=new WeiBo();//WeiBo中有两个数据域，一个是推文领一个是被转发的推文
		    	for(int l=0;l<userPartProfile.size();l++){
		    		Tuiwen tw=new Tuiwen();
		    		tw.setTweet(tweets.get(k)); //把tweet放入推文中
			    	if(tweets.get(k).getUseridtweet()==userPartProfile.get(l).getUserid()){
			    		/*其它部分放入到推文*/
			    		tw.setPhotoupload((Byte)userPartProfile.get(l).getPhotoupload());
			    		tw.setSelfintroduce(userPartProfile.get(l).getSelfintroduce()); //用户的简介加入到Tuiwen中
			    		tw.setUsernickname(userPartProfile.get(l).getUsernickname()); //用户的昵称加入到Tuiwen中去
			    		tw.setUserphoto(userPartProfile.get(l).getUserphoto()); //用户的头像地址		    		
			    	}
			    	wb.setTuiwen(tw); //推文被放入微博
		    	}	    	
		    	lsWb.add(wb);  //微博放入到微博列表中		    	
		    }
		    tweetsListRsp.setData(lsWb);
		    tweetsListRsp.setMsg("成功了");
		    tweetsListRsp.setRetcode(2000);
		    
	    	return tweetsListRsp;
	    }
	    /*4.获取被转发推文中的有关用户的信息*/
	    if(tweetlist.size()!=0){ //能走到这一步，说明含有被转发的微博
		    for(int j=0;j<tweetlist.size();j++){
		    	zhuanfaUseridList.add(tweetlist.get(j).getUseridtweet());
		    }
	    }
	    List<OtherPartHelpPojo> zhuanfaUserPartProfile=new  ArrayList<OtherPartHelpPojo>();
	    
	    if(zhuanfaUseridList.size()!=0){
	    	  zhuanfaUserPartProfile=mainService.getProfileByUserIDs(zhuanfaUseridList);
	    }	  
	    /*能走到这一步，说明是一组微博并且有若干被转发的微博在里面*/
	    /*5.合并推文和用户信息tweets 和 userPartProfile 到 lsWb*/
	    List<WeiBo>  lsWb=new ArrayList<WeiBo>();	    
	    for(int k=0;k<tweets.size();k++){
	    	WeiBo wb=new WeiBo();//WeiBo中有两个数据域，一个是推文领一个是被转发的推文
	    	for(int l=0;l<userPartProfile.size();l++){
	    		Tuiwen tw=new Tuiwen();
	    		tw.setTweet(tweets.get(k)); //把tweet放入推文中
		    	if(tweets.get(k).getUseridtweet()==userPartProfile.get(l).getUserid()){
		    		/*其它部分放入到推文*/
		    		tw.setPhotoupload((Byte)userPartProfile.get(l).getPhotoupload());
		    		tw.setSelfintroduce(userPartProfile.get(l).getSelfintroduce()); //用户的简介加入到Tuiwen中
		    		tw.setUsernickname(userPartProfile.get(l).getUsernickname()); //用户的昵称加入到Tuiwen中去
		    		tw.setUserphoto(userPartProfile.get(l).getUserphoto()); //用户的头像地址		    		
		    	}
		    	wb.setTuiwen(tw); //推文被放入微博
	    	}	    	
	    	lsWb.add(wb);  //微博放入到微博列表中		    	
	    } 
	    /* 合并被转发推文和用户信息tweetlist 和zhuanfaUserPartProfile到lsTw*/    
	    List<Tuiwen> lsTw=new ArrayList<Tuiwen>();
	    for(int n=0;n<tweetlist.size();n++){
	    	for(int m=0;m<zhuanfaUserPartProfile.size();m++){
		    	Tuiwen tw=new Tuiwen();
		    	tw.setTweet(tweetlist.get(n));
	    		if(tweetlist.get(n).getUseridtweet()==zhuanfaUserPartProfile.get(m).getUserid()){
	    			tw.setPhotoupload(zhuanfaUserPartProfile.get(m).getPhotoupload());
	    			tw.setSelfintroduce(zhuanfaUserPartProfile.get(m).getSelfintroduce());
	    			tw.setUsernickname(zhuanfaUserPartProfile.get(m).getUsernickname());
	    			tw.setUserphoto(zhuanfaUserPartProfile.get(m).getUserphoto());
	    		}
	    		lsTw.add(tw); //推文放入到推文列表中
	    	}
	    }
	    /*7.合并lsTw 到 lsWb*/
	    for(int p=0;p<lsWb.size();p++){	  //微博数一定多于转发的微博数量  	
	    	for(int q=0;q<lsTw.size();q++){
	    		if(lsWb.get(p).getTuiwen().getTweet().getSourcemsgid()==lsTw.get(q).getTweet().getTweetid()){
	    			lsWb.get(p).setZhuanfaTuiwen(lsTw.get(q));
	    		}
	    	}
	    }
	    
	    /* 8.返回tweetsListRsp*/
	    tweetsListRsp.setData(lsWb);
	    tweetsListRsp.setMsg("成功了");
	    tweetsListRsp.setRetcode(2000);
	    
		return tweetsListRsp;
	}
	
	/*这个是删除一条推文，因此需要用户名、密码、推文的ID，要授权才能删除，只做逻辑删除*/
	@RequestMapping(value="/deleteTweetByID")
	public @ResponseBody CommonRsp deleteTweetByID(@RequestBody DeleteTweetByKeyParam delTweetParam){
		//这里先检查用户名和密码是否存在并匹配
		// 然后调用Service，将删除标志更新为2
		CommonRsp commonRsp=new CommonRsp();
		String token=delTweetParam.getToken();
		if(token.length()<33){
			commonRsp.setMsg("凭证不合法");
			commonRsp.setRetcode(2001);
			return commonRsp;
		}
		String userPassword=token.substring(0,32); //token是password和userID拼接成的。
		String useridStr=token.substring(32); //取得userid部分		
		Long userid=Long.valueOf(useridStr).longValue();  //转换成long类型
		//Long userid=Long.parseLong(useridstr);
		String passwdTrue=rlService.selectMD5Password(Long.valueOf(userid));
		//System.out.println(passwdTrue);
		if(!userPassword.equals(passwdTrue)){
			commonRsp.setRetcode(2001);
			commonRsp.setMsg("用户密码不对，非法");
			return commonRsp;
		}
		//这里应该查询下，是不是有这条信息，以及信息是不是用户的
		Tweet tweet=new Tweet();
		tweet.setDeletetag((byte) 2);
		tweet.setMsgcontent("此信息已被用户删除");
		tweet.setTweetid(delTweetParam.getTweetid());//根据这个推文的ID更新
		Integer updateTag=0;
		try{
			 updateTag=mainService.updateTweetByKeySelective(tweet);
		}catch(Exception e){
			System.out.println(e);
		}
		System.out.println(updateTag);
		if(updateTag==1){
			commonRsp.setMsg("删除推文成功");
			commonRsp.setRetcode(2000);
		}else{
			commonRsp.setMsg("删除失败");
			commonRsp.setRetcode(2001);
		}
		return commonRsp;		
	}
	
	/*这是发布一条推文,--已废弃，发布推文在FileUploadController里面*/
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
	@RequestMapping("/zhuanfaTweet")
	public @ResponseBody CommonRsp addComment(HttpServletRequest request){
		CommonRsp commonRsp=new CommonRsp();
		String token=request.getParameter("token");			
		String userPassword=token.substring(0,32); //token是password和userID拼接成的。
		String useridStr=token.substring(32);		
		Long userid=Long.valueOf(useridStr).longValue();
		String passwdTrue=rlService.selectMD5Password(Long.valueOf(userid));		
		if(!userPassword.equals(passwdTrue)){
			commonRsp.setRetcode(2001);
			commonRsp.setMsg("用户密码不对，非法");
			return commonRsp;
		}	
		String tweetContent=request.getParameter("content");//转发时输入的内容
		String sourceMsgID=request.getParameter("sourceMsgID");
		Tweet tweet=new Tweet();
		tweet.setUseridtweet(userid); //转发推文人的id
		tweet.setSourcemsgid(Long.valueOf(sourceMsgID).longValue());
		tweet.setTagid((byte)2); //2代表是转发的
		tweet.setMsgcontent(tweetContent); //转发时输入的内容
		tweet.setPublishtime(new Date());		
		tweet.setTopic(new Long(1)); //话题，默认是1
		
		//这里插入一条推文，待实现
		try{
			int insertCode=mainService.addTweet(tweet);
			if(insertCode!=1){
				commonRsp.setMsg("发布推文出错了");
				commonRsp.setRetcode(20001);
			}
		}catch(Exception e){	
				commonRsp.setMsg("发布推文出错了");
				commonRsp.setRetcode(20001);
				return commonRsp;
		}
			
		commonRsp.setRetcode(2000);
		commonRsp.setMsg("转发成功了");
		return commonRsp;
	}
	
	/*这是一条推文的转发列表，本质上也是一组推文。不需要取得原推文内容，如果转发时输入为空，默认存储为“转发推文” */
	@RequestMapping(value="/listZhuanfa")
	public @ResponseBody TweetsListRsp getZhuanfaList(@RequestBody  ZhuangfaListParam zhuanfaListParam){
		String proofs=zhuanfaListParam.getProof(); //登录凭证，暂时不用
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
			
			tweetsListRsp.setMsg("用户没有发表推文哦");
			tweetsListRsp.setRetcode(2001);
		}else{
			
			tweetsListRsp.setMsg("获取数据成功");
			tweetsListRsp.setRetcode(2000);
		}
		return tweetsListRsp;
	}
	
		
}
























