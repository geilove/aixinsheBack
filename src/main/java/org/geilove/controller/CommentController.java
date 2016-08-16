package org.geilove.controller;

import org.geilove.requestParam.AddCommentParam;
import org.geilove.service.CommentService;
import org.geilove.pojo.DiscussReply;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.geilove.requestParam.DelCommentParam;
import org.geilove.requestParam.CommentListParam;
import org.geilove.requestParam.ZhuangfaListParam;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import javax.annotation.Resource;
//实现对推文的评论，获取，删除等
@Controller
@RequestMapping("/tweetcomment")
public class CommentController {
	
	@Resource
	private  CommentService commentService;
	
	@RequestMapping("/addcomment")
	public @ResponseBody Integer addComment(@RequestBody AddCommentParam addCommentParam ){
		DiscussReply dr=new DiscussReply();
		   dr.setUseriddiscussreply(addCommentParam.getUseriddiscussreply());
		   dr.setTweetiddiscussreply(addCommentParam.getTweetiddiscussreply());
		   dr.setDiscussreplytype(addCommentParam.getDiscussreplytype());
		   dr.setDiscussreplytext(addCommentParam.getDiscussreplytext());
		   Date date=new Date();
		   dr.setDiscussreplytime(date);
		   int a=commentService.addComment(dr);
		   return a;//确认下插入成功后的返回值是什么
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
	public @ResponseBody List<DiscussReply> getCommentList(@RequestBody CommentListParam commentListParam){
		 List<DiscussReply> ls=new ArrayList<DiscussReply>();
		 Long tweetid=commentListParam.getTweetid();
		 Integer page=commentListParam.getPage();
		 Integer pageSize=commentListParam.getPageSize();
		 Map<String,Object> map=new HashMap<String,Object>();
		 map.put("tweetid", tweetid);
		 map.put("page", page);
		 map.put("pageSize", pageSize);
		 ls=commentService.getTweetComments(map);
		 return ls;
	}	
}











