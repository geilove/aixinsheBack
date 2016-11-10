package org.geilove.controller;

import org.geilove.requestParam.AddCommentParam;
import org.geilove.service.CommentService;
import org.geilove.service.HelpService;
import org.geilove.service.RegisterLoginService;
import org.geilove.sqlpojo.OtherPartHelpPojo;
import org.geilove.pojo.Confirm;
import org.geilove.pojo.DiscussReply;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.geilove.requestParam.DelCommentParam;
import org.geilove.requestParam.CommentListParam;
import org.geilove.response.CommentsListRsp;
import org.geilove.response.CommonRsp;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
//实现对推文的评论，获取，删除等
@Controller
@RequestMapping("/tweetcomment")
public class CommentController {
	
	@Resource
	private  CommentService commentService;
	@Resource
	private HelpService helpService;
	@Resource
	private RegisterLoginService rlService;
	@RequestMapping("/addcomment")
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
	
		String content=request.getParameter("content");
		String tuiwenid=request.getParameter("tuiwenid");
		DiscussReply dr=new DiscussReply();
		dr.setTweetiddiscussreply(Long.valueOf(tuiwenid).longValue());
	    dr.setDiscussreplytext(content); 
        dr.setTweetiddiscussreply(userid);	   
	    dr.setDiscussreplytime(new Date());
	    dr.setDiscussreplyok(0); 
	    try{
	    	int a=commentService.addComment(dr);
	    	if(a!=1){
	    		commonRsp.setMsg("评论出错了");
	    		commonRsp.setRetcode(2001);
	    	}
	    }catch(Exception e){
	    	
	    }
	    commonRsp.setMsg("评论成功");
	    commonRsp.setRetcode(2000);
	    return commonRsp;//确认下插入成功后的返回值是什么
	}
	//根据微博客户端的设计，长按要删除的微博，松手后，如果是当前用户评论的会有删除选项，否则没有，
	//这个应该是长按的时候检测了下该评论是不是当前用户发布的。客户端就能完成。
	@RequestMapping("/delcomment")
	public @ResponseBody Integer delComment(@RequestBody DelCommentParam delCommentParam ){
		int err=0;
		err=commentService.delComment(delCommentParam.getCommentid());
		return err;
	}
/* 
 * 这个实现获取某条推文的评论列表的功能。
 * 	
*/
	@RequestMapping("listcomments")
	public @ResponseBody CommentsListRsp getCommentList(@RequestBody CommentListParam commentListParam){
		 CommentsListRsp rsp=new CommentsListRsp();
		 List<DiscussReply> ls=new ArrayList<DiscussReply>();
		 Long tweetid=commentListParam.getTweetid();
		 Integer page=commentListParam.getPage();
		 Integer pageSize=commentListParam.getPageSize();
		 Map<String,Object> map=new HashMap<String,Object>();
		 map.put("tweetid", tweetid);
		 map.put("page", page);
		 map.put("pageSize", pageSize);
		 ls=commentService.getTweetComments(map);
		 if(ls==null || ls.size()==0){
			 rsp.setData(ls);
			 rsp.setMsg("推文暂时没有评论哦");
			 rsp.setRetcode(2001);
			 return rsp;
		 }
		 //然后从ls里面获取评论者id，根据这组id取得用户的部分信息，组合返回
		 List<Long> ll=new ArrayList<Long>(); 
		 for(int i=0;i<ls.size();i++){
			 ll.add(ls.get(i).getUseriddiscussreply()); //评论者的id
		 }
		 //System.out.println(ll.size());
		 
		 List<OtherPartHelpPojo> lp=new ArrayList<OtherPartHelpPojo>();
		 lp=helpService.getOtherPartHelpList(ll); //根据id集合获取部分用户头像昵称等信息
		 
		 //System.out.println(lp.size());
		 
		 for(int k=0;k<ll.size();k++){
				for(int p=0;p<lp.size();p++){
					if(ll.get(k)==lp.get(p).getUserid()){
						ls.get(k).setBackupone(lp.get(p).getUsernickname());
						ls.get(k).setBackuptwo(lp.get(p).getUserphoto());						
					}
				}
			}
		 rsp.setData(ls);
		 //判断ls，然后返回不同的提示信息
		 if(ls==null || ls.size()==0){
			 rsp.setMsg("推文暂时没有评论哦");
			 rsp.setRetcode(2001);
		 }else{
			 rsp.setMsg("数据获取成功");
			 rsp.setRetcode(2000);
		 }
		 return rsp;
	}	
}











