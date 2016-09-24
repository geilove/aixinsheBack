package org.geilove.controller;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.geilove.vo.FollowVo;
import org.geilove.pojo.DoubleFans;
import org.geilove.requestParam.FollowParam;
import org.geilove.requestParam.WatchListParam;
import org.geilove.response.WatchListRsp;
import org.geilove.service.WatchService;
/*
 * 这个用来提供关注一个人，取消关注一个人的接口,我的粉丝列表，我关注的列表功能
*/
@Controller
@RequestMapping("/watch")
public class WatchController {
	@Resource
	private WatchService watchService;	
	
	@RequestMapping(value="/dowatch",method=RequestMethod.POST)
	public @ResponseBody FollowVo doWatch(@RequestBody FollowParam followParam ){
		FollowVo followVo=new FollowVo();
		DoubleFans  dbfans=new DoubleFans();
		dbfans.setUseridfollowe(followParam.getUserIDFollow());
	    dbfans.setUseridbefocus(followParam.getUserIDBeFocus());
	    dbfans.setPaytag(followParam.getPaytag());
	    Date date=new Date();
	    dbfans.setPaydate(date);
	    dbfans.setGroupid((byte)1);
	    dbfans.setSpecialfollow((byte)1);
	    dbfans.setDoublefans((byte)1);
	    Integer tag=watchService.doWatch(dbfans);	
	    followVo.setWathctag(tag);
	    if(tag==1){	    	
	    	followVo.setWatchtips("关注成功了");
	    }else{
	    	followVo.setWatchtips("关注失败了");
	    }	    
		return followVo ;
	}

	@RequestMapping(value="/getwatchlist",method=RequestMethod.POST)
	public @ResponseBody WatchListRsp getWatchList(@RequestBody WatchListParam followParam ){
		WatchListRsp rsp=new WatchListRsp();
		Long userID=followParam.getUserID();
		//查询关注 和被关注列表
		//根据这组数据，选出id列表
		//用id列表到user表查询数据
		return rsp;
	}
}














