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
import org.geilove.requestParam.CommonPeopleListParam;
import org.geilove.sqlpojo.PeopleNeedLovePojo;
import org.geilove.response.NeedLovePeopleListRsp;
import org.geilove.sqlpojo.LoveClubListPojo;
import org.geilove.response.LoveClubPeopleListRsp;
import org.geilove.sqlpojo.DonaterPojo;
import org.geilove.response.DonaterListRsp;
/*
 *这里提供诸如爱心社列表 粉丝列表 公益排行榜列表 
 */

@Controller
@RequestMapping("/peoplelist")
public class PeopleListController {
	@Resource
	private PeopleListService peopleListService;
	//需要帮助的人列表
	@RequestMapping(value="/needlove")
	public @ResponseBody NeedLovePeopleListRsp getNeedLoveMen(@RequestBody CommonPeopleListParam commonPeopleListParam ){
		Integer tag=commonPeopleListParam.getTag();
		Integer page=commonPeopleListParam.getPage();
		Integer pageSize=commonPeopleListParam.getPageSize();
		NeedLovePeopleListRsp rsp=new NeedLovePeopleListRsp();		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("tag", tag);
		map.put("page", page);
		map.put("pageSize", pageSize);
		List<PeopleNeedLovePojo> lp=new ArrayList<PeopleNeedLovePojo>();	
		lp=peopleListService.needHelpPeopleList(map);
		rsp.setLp(lp);
		rsp.setMsg("获取需要帮助人列表成功");
		rsp.setRetcode(2000);
		return rsp;  //这个需要更改返回值
	}
	//爱心社列表
	@RequestMapping(value="/loveclub")
	public @ResponseBody LoveClubPeopleListRsp getLoveClubMen(@RequestBody CommonPeopleListParam commonPeopleListParam ){
		Integer tag=commonPeopleListParam.getTag();
		Integer page=commonPeopleListParam.getPage();
		Integer pageSize=commonPeopleListParam.getPageSize();
		LoveClubPeopleListRsp rsp=new LoveClubPeopleListRsp();		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("tag", tag);
		map.put("page", page);
		map.put("pageSize", pageSize);
		List<LoveClubListPojo> lp=new ArrayList<LoveClubListPojo>();
		//这里根据tag的值不同，进行不同的查询		
		lp=peopleListService.loveClubPeopleList(map);
		rsp.setLp(lp);
		rsp.setMsg("获取爱心社列表成功");
		rsp.setRetcode(2000);
		return rsp;  //这个需要更改返回值
	}
	//慈善排行榜
	@RequestMapping(value="/donater")
	public @ResponseBody DonaterListRsp getDonaterMen(@RequestBody CommonPeopleListParam commonPeopleListParam ){
		Integer tag=commonPeopleListParam.getTag();
		Integer page=commonPeopleListParam.getPage();
		Integer pageSize=commonPeopleListParam.getPageSize();
		DonaterListRsp rsp=new DonaterListRsp();		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("tag", tag); //tag=5 代表用户捐钱了,是慈善家
		map.put("page", page);
		map.put("pageSize", pageSize);
		List<DonaterPojo> lp=new ArrayList<DonaterPojo>();
		//这里根据tag的值不同，进行不同的查询		
		lp=peopleListService.donaterPeopleList(map);
		rsp.setLp(lp);
		rsp.setMsg("获取慈善家列表成功");
		rsp.setRetcode(2000);
		return rsp;  //这个需要更改返回值
	}

}








