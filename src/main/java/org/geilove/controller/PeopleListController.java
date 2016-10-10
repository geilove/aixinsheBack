package org.geilove.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.geilove.service.PeopleListService;
import org.geilove.pojo.User;
import org.geilove.requestParam.CommentListParam;
import org.geilove.requestParam.CommonPeopleListParam;
import org.geilove.sqlpojo.PeopleNeedLovePojo;
import org.geilove.response.NeedLovePeopleListRsp;
import org.geilove.response.PeopleListRsp;
import org.geilove.sqlpojo.LoveClubListPojo;
import org.geilove.response.LoveClubPeopleListRsp;
import org.geilove.sqlpojo.DonaterPojo;
import org.geilove.response.DonaterListRsp;
/*
 *这里提供诸如爱心社列表 青年志愿者协会  监督处列表 社会公益机构列表 公益排行榜列表  粉丝列表  我关注列表  我帮助  帮助我列表
 */

@Controller
@RequestMapping("/peoplelist")
public class PeopleListController {
	@Resource
	private PeopleListService peopleListService;
	//1普通，2社团，3监督，4志愿者，5社会公益机构 6需要帮助的人，7公益排行榜
	@RequestMapping(value="/lsmen")
	public @ResponseBody PeopleListRsp getMenList(@RequestBody CommonPeopleListParam commonPeopleListParam ){
		Integer tag=commonPeopleListParam.getTag();
		Integer page=commonPeopleListParam.getPage();
		Integer pageSize=commonPeopleListParam.getPageSize();
		PeopleListRsp rsp=new PeopleListRsp();		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("tag", tag);
		map.put("page", page);
		map.put("pageSize", pageSize);
		List<User> lp=new ArrayList<User>();		
		lp=peopleListService.getMenList(map);
		
		rsp.setLp(lp);
		if(lp==null || lp.size()==0){
			rsp.setMsg("获取Men列表失败");
			rsp.setRetcode(2001);
		}else{
			rsp.setMsg("获取Men列表成功");
			rsp.setRetcode(2000);
		}
		
		return rsp;  //这个需要更改返回值
	}
	
	
	//我关注的人列表 以及粉丝列表
	@RequestMapping(value="/payorwatch")
	public @ResponseBody PeopleListRsp getLoveClubMen(@RequestBody CommentListParam commonPeopleListParam ){
		Long tweetid=commonPeopleListParam.getTweetid();
		Integer page=commonPeopleListParam.getPage();
		Integer pageSize=commonPeopleListParam.getPageSize();		
		PeopleListRsp rsp=new PeopleListRsp();		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("tweetid", tweetid);
		map.put("page", page);
		map.put("pageSize", pageSize);
		List<User> lp=new ArrayList<User>();
		//先到关注表查询关注关心，获取到一组id，用这组id获取关注人列表已有现成代码	
		lp=peopleListService.getPayOrWatchMen(map);
		rsp.setLp(lp);
		rsp.setMsg("获取关注人或者我的粉丝列表成功");
		rsp.setRetcode(2000);
		return rsp;  //这个需要更改返回值
	}
	//我帮助的以及帮助我的人列表
	@RequestMapping(value="/donater")
	public @ResponseBody PeopleListRsp getDonaterMen(@RequestBody CommonPeopleListParam commonPeopleListParam ){
		Integer tag=commonPeopleListParam.getTag();
		Integer page=commonPeopleListParam.getPage();
		Integer pageSize=commonPeopleListParam.getPageSize();
		PeopleListRsp rsp=new PeopleListRsp();		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("tag", tag); //tag=5 代表用户捐钱了
		map.put("page", page);
		map.put("pageSize", pageSize);
		List<User> lp=new ArrayList<User>();
				
		//先到捐钱人列表进行查询，得到一组id列表，然后用这组列表到User表查询moneysource表
		lp=peopleListService.donaterPeopleList(map);
		rsp.setLp(lp);
		rsp.setMsg("获取我帮助或者帮助我的人列表成功");
		rsp.setRetcode(2000);
		return rsp;  //这个需要更改返回值
	}

}








