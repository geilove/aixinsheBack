package org.geilove.controller;
//这里提供收听、取消收听等
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.geilove.service.RelationService;
import org.geilove.vo.WatchVo;
import org.geilove.pojo.DoubleFans;
@Controller
@RequestMapping(value="/relation")
public class RelationController {
     
	@Resource 
	private RelationService relationService;
	//收听一个人，查看关系表，注意有多种情况。首先应该加入到关系表中，然后订阅收被收听人这个主题
	
	@RequestMapping(value="/watch",method=RequestMethod.POST)
	public @ResponseBody Integer watchMan(@RequestBody WatchVo watchVo){
		
		DoubleFans dbfans=new DoubleFans();
		Date paydate=new Date();		
		//将所有传输过来的信息放入dbfans对象中，其中时间用服务器时间，避免js， swift 的时间格式化问题	
		dbfans.setUseridfollowe(watchVo.getUserIDFollow());
		dbfans.setUseridbefocus(watchVo.getUserIDBeFouces());
		dbfans.setGroupid(watchVo.getGroupID());
		dbfans.setPaydate(paydate);
		dbfans.setPaytag(watchVo.getPayTag());
		dbfans.setSpecialfollow(watchVo.getSpecialFollow());
		dbfans.setDoublefans(watchVo.getDoubleFans());
		
		Integer codeTip=relationService.watchManService(dbfans);
		
		return codeTip;//返回这个收听是否成功标志		
	}
	//取消关注一个人，需要传入用户的ID和被取消关注人的ID,如果标志为2，则不允许取消关注。采用物理删除而不是逻辑删除。
	//后续引入redis，要取消订阅的一个主题
		@RequestMapping(value="/unwatch",method = RequestMethod.GET)
		public @ResponseBody Integer unWatchMan(Long userID,Long unwatchManID ){
			//调用service层的方法
			
			return 0;
		}
	
	
	
}
