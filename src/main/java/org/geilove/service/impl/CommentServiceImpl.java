package org.geilove.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import javax.annotation.Resource;

import  org.geilove.pojo.DiscussReply;
import  org.geilove.service.CommentService;
import  org.geilove.dao.DiscussReplyMapper;
import org.springframework.stereotype.Service;
//评论成功后，应该对相应推文的评论总数加1，这里没写，以后补上吧。
@Service("comment")
public class CommentServiceImpl implements CommentService{
	@Resource 
	private  DiscussReplyMapper replyMapper;
	@Override
	public Integer addComment(DiscussReply discussReply){
		int err=0;
		try{
	        err=replyMapper.insert(discussReply);
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
		return err;
		
	}
	
	@Override
	public Integer  delComment(Long commentid){
		int err=0;
		try{
	        err=replyMapper.deleteByPrimaryKey(commentid);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return err;
	}
	
	@Override
	public List<DiscussReply> getTweetComments(Map<String,Object> map){
		List<DiscussReply> ls=new ArrayList<DiscussReply>();
		Object tag=map.get("tag");
		if(tag.equals(1)){
			 ls=replyMapper.getTweetCommentList(map); //刷新，
		}else{
			 ls=replyMapper.getTweetCommentListloadMore(map);
		}		
		return ls;
	}
		
}
