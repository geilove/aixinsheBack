package org.geilove.service;
import org.geilove.pojo.DiscussReply;
import java.util.ArrayList;
import java.util.List;
import  java.util.HashMap;
import java.util.Map;
import org.geilove.pojo.DiscussReply;
public interface CommentService {
	
	public Integer addComment(DiscussReply discussReply);
	
	public Integer delComment(Long commentid);
	
	public List<DiscussReply> getTweetComments(Map<String,Object> map);//一条推文的评论列表
	
}
