package org.geilove.controller;

import org.geilove.pojo.Confirm;
import org.geilove.requestParam.ConfirmListParam;
import org.geilove.response.ConfirmListRsp;
import org.geilove.service.ConfirmService;
import org.geilove.service.HelpService;
import org.geilove.sqlpojo.OtherPartHelpPojo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Resource;
@Controller
@RequestMapping("/confirm")
public class ConfirmController {

	@Resource
	private  ConfirmService confirmService;
	@Resource
	private HelpService helpService;
	
	
	@RequestMapping(value="/getconfirmls",method=RequestMethod.POST)
	public @ResponseBody ConfirmListRsp  getConfirmLs(@RequestBody ConfirmListParam confirmParam ){
		System.out.println("aaa");
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
		List<Confirm> lc=confirmService.getConfirmLists(map);
		//从lc中获取userid列表，取得用户有关的信息，然后再放入到lc中
		List<Long> ll=new ArrayList<Long>();
		for(int i=0;i<lc.size();i++){
			ll.add(lc.get(i).getUserid());
		}
		//获取user表中的部分信息
		List<OtherPartHelpPojo> lp=new ArrayList<OtherPartHelpPojo>();
		lp=helpService.getOtherPartHelpList(ll);
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
}






