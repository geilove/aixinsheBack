package org.geilove.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.geilove.pojo.Tweet;
import org.geilove.service.MainService;
import org.geilove.service.RegisterLoginService;
import org.geilove.sqlpojo.OtherPartHelpPojo;
import org.geilove.requestParam.WeiboParam;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.geilove.response.*;
import org.geilove.vo.WeiBo;
import org.geilove.vo.Tuiwen;

@Controller
@RequestMapping("/userpage")
public class WeiBoController {
	@Resource
	private MainService mainService;
	@Resource
	private RegisterLoginService rlService;
	@RequestMapping(value="/weibos/gettweetbyuserid")//用户查看对方主页的推文
	public  @ResponseBody TweetsListRsp getTweetByUserID(@RequestBody WeiboParam tweetListParam,HttpServletRequest request){
		TweetsListRsp tweetsListRsp=new TweetsListRsp();	
		Long userID=tweetListParam.getUserID();		
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
}
