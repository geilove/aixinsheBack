package org.geilove.controller;
/*
 * "我要证实" 和举报一条推文，共用一张表
 * */
import org.geilove.pojo.Confirm;
import org.geilove.requestParam.ConfirmListParam;
import org.geilove.response.CommonRsp;
import org.geilove.response.ConfirmListRsp;
import org.geilove.service.ConfirmService;
import org.geilove.service.HelpService;
import org.geilove.service.RegisterLoginService;
import org.geilove.sqlpojo.OtherPartHelpPojo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("/confirm")
public class ConfirmController {

	@Resource
	private  ConfirmService confirmService;
	@Resource
	private HelpService helpService; //这个里面实现了获取部分人信心的功能，图省事
	@Resource
	private RegisterLoginService rlService;
	
	@RequestMapping(value="/getconfirmls",method=RequestMethod.POST)
	public @ResponseBody ConfirmListRsp  getConfirmLs(@RequestBody ConfirmListParam confirmParam ){
		
		ConfirmListRsp confirmLSRsp =new ConfirmListRsp();
		Map<String,Object> map=new HashMap<String,Object>();
		Long id =confirmParam.getId();
		Integer tag=confirmParam.getTag();
		Integer page=confirmParam.getPage();
		Integer pageSize=confirmParam.getPageSize();
		map.put("id",id);
		map.put("tag", tag);
		map.put("page", page);
		map.put("pageSize", pageSize);
		System.out.println(id);
		List<Confirm> lc=confirmService.getConfirmLists(map);
		//System.out.println(lc);
		if(lc==null || lc.isEmpty()){
			confirmLSRsp.setCount(0);
			confirmLSRsp.setLp(null);
			confirmLSRsp.setRetcode(2001);
			confirmLSRsp.setMsg("证明人为0");
			//System.out.println("证明人列表是空的");
			return  confirmLSRsp;
		}
		//从lc中获取userid列表，取得用户有关的信息，然后再放入到lc中
		List<Long> ll=new ArrayList<Long>(); 
		for(int i=0;i<lc.size();i++){
			ll.add(lc.get(i).getUserid());
		}
		//System.out.println(ll);
		//获取user表中的部分信息
		List<OtherPartHelpPojo> lp=new ArrayList<OtherPartHelpPojo>();
		lp=helpService.getOtherPartHelpList(ll); //根据id集合获取部分用户头像昵称等信息
		if(lp==null ||lp.isEmpty() ){
			confirmLSRsp.setCount(0);
			confirmLSRsp.setLp(null);
			confirmLSRsp.setRetcode(2001);
			confirmLSRsp.setMsg("获取证明人数lp出错，异常");
			System.out.println("lp");
			return  confirmLSRsp;
		}
		//把部分信息组合到lc中
		for(int k=0;k<ll.size();k++){
			for(int p=0;p<lp.size();p++){
				if(ll.get(k)==lp.get(p).getUserid()){
					lc.get(k).setConfirmbackupone(lp.get(p).getUsernickname());
					lc.get(k).setConfirmbackuptwo(lp.get(p).getUserphoto());
					lc.get(k).setConfirmbackupfour(new Integer(lp.get(p).getPhotoupload()));
					continue;
				}
			}
		}
		//获取confirm表中该推文或者项目的总条数，作为总的证实人数，放入到confirmLSRsp中
		Map<String,Object> mapcounts=new HashMap<String,Object>();
		Long idc =confirmParam.getId();
		Integer tagc=confirmParam.getTag();
		mapcounts.put("idc", idc);
		mapcounts.put("tagc", tagc);
		Integer counts=confirmService.getPeopleConfirms(mapcounts);
		
		//放入返回值中
		confirmLSRsp.setCount(counts);
		confirmLSRsp.setLp(lc);
		confirmLSRsp.setMsg("获取成功");
		confirmLSRsp.setRetcode(2000);
		return confirmLSRsp;		
	}
	
	// 我要证实和举报都是这个接口
	@RequestMapping(value="/report",method=RequestMethod.POST)
	public @ResponseBody CommonRsp addReport(HttpServletRequest request) throws IllegalStateException, IOException{
		CommonRsp commonRsp=new CommonRsp();
		Confirm confirm=new Confirm();
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
		String  content=request.getParameter("content") ;//证实或者举报的内容
		String ralation=request.getParameter("relation"); //用户与受助人关系，仅仅在证实中使用
		String mobile=request.getParameter("mobile");//证实人的手机号
		String tag=request.getParameter("tag"); //1代表证实，2代表举报
		String tuiwenid=request.getParameter("tuiwenid");
		confirm.setTuiwenid(Long.valueOf(tuiwenid).longValue()); //转换成Long类型
		confirm.setUserid(userid); //userid加入
		confirm.setPublishtime(new Date()); //本地生成用户发布的时间
		confirm.setContent(content);
		confirm.setTag(Integer.valueOf(tag).intValue()); //转换成Integer类型
		confirm.setMobile(mobile);
		confirm.setRelation(ralation);
		try{
			Integer inserTag=confirmService.addRecordSelective(confirm);
			if(inserTag!=1){
				commonRsp.setRetcode(2001);
				commonRsp.setMsg("增加一个举报出错了");
				return commonRsp;
			}
		}catch(Exception e){
			
		}		
		commonRsp.setMsg("成功了");
		commonRsp.setRetcode(2000);
		return commonRsp;
	}
	
}






