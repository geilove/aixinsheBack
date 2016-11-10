package org.geilove.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.geilove.vo.FollowVo;
import org.geilove.pojo.DoubleFans;
import org.geilove.requestParam.CancelWatchParam;
import org.geilove.requestParam.FollowParam;
import org.geilove.requestParam.WatchListParam;
import org.geilove.response.CommonRsp;
import org.geilove.response.WatchListRsp;
import org.geilove.service.RegisterLoginService;
import org.geilove.service.RelationService;
import org.geilove.service.WatchService;
/*
 * 这个用来提供关注一个人，取消关注一个人的接口,我的粉丝列表，我关注的列表功能
*/
@Controller
@RequestMapping("/watch")
public class WatchController {
	@Resource
	private WatchService watchService;	
	@Resource
	private RegisterLoginService rlService;
	@Resource
	private RelationService relationService;
	
	@RequestMapping(value="/dowatch",method=RequestMethod.POST)
	public @ResponseBody CommonRsp doWatch(@RequestBody FollowParam followParam ){//关注一个人
		CommonRsp commonRsp=new CommonRsp();
		String token=followParam.getToken(); //获取登录凭证
		String userPassword=token.substring(0,32); //token是password和userID拼接成的。
		String useridStr=token.substring(32);		
		Long userid=Long.valueOf(useridStr).longValue();		
		String passwdTrue=rlService.selectMD5Password(Long.valueOf(userid));
		if(!userPassword.equals(passwdTrue)){
			commonRsp.setRetcode(2001);
			commonRsp.setMsg("用户验证失败，非法");
			return commonRsp;
		}		
		DoubleFans  dbfans=new DoubleFans();
		dbfans.setUseridfollowe(followParam.getUserIDFollow());
	    dbfans.setUseridbefocus(followParam.getUserIDBeFocus());
	    dbfans.setPaytag(followParam.getPaytag());
	    Date date=new Date();
	    dbfans.setPaydate(date);
	    dbfans.setGroupid((byte)1);
	    dbfans.setSpecialfollow((byte)1);
	    dbfans.setDoublefans((byte)1);
	    try{
	    	 Integer tag=watchService.doWatch(dbfans);
	    	 if(tag!=1){
	    		 commonRsp.setMsg("关注失败");
	    		 commonRsp.setRetcode(2001);
	    	 }
	    }catch(Exception e){
	    	
	    }	
	    commonRsp.setMsg("关注成功");
	    commonRsp.setRetcode(2000);
		return commonRsp;
	}
    //关注人列表在peoplelistcontroller中
    //取消关注一个人
	@RequestMapping(value="/cancelwatch",method=RequestMethod.POST)
	public @ResponseBody CommonRsp getWatchList(@RequestParam CancelWatchParam cancelParam ){ 
		CommonRsp commonRsp=new CommonRsp();
		String token=cancelParam.getToken();
		String userPassword=token.substring(0,32); //token是password和userID拼接成的。
		String useridStr=token.substring(32);		
		Long userid=Long.valueOf(useridStr).longValue();		
		String passwdTrue=rlService.selectMD5Password(Long.valueOf(userid));
		if(!userPassword.equals(passwdTrue)){
			commonRsp.setRetcode(2001);
			commonRsp.setMsg("用户验证失败，非法");
			return commonRsp;
		}
		Long canceluserid=cancelParam.getBeCancel();
		//查询关注 和被关注列表
		//根据这组数据，选出id列表
		//用id列表到user表查询数据
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("userIDFollowe", userid);
		map.put("userIDBeFocus",canceluserid); //
		try{
			Integer returnTag=relationService.unWatchManService(map);
			System.out.println(returnTag);
		}catch(Exception e){
			
		}
		commonRsp.setMsg("取消关注成功");
		commonRsp.setRetcode(2000);
		return commonRsp;
	}
}














