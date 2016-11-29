package org.geilove.controller;
import javax.annotation.Resource;

import org.geilove.pojo.GatherInfo;
import org.geilove.requestParam.GatherInfoParam;
import org.geilove.response.GatherInfoRsp;
import org.geilove.service.GatherInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/gatherinfo")
public class GatherInfoController {
	@Resource
	private GatherInfoService  gatherInfoService;   	
	
	@RequestMapping(value="/byid")
	public @ResponseBody GatherInfoRsp getMenList(@RequestBody GatherInfoParam gatherInfoParam ){
		GatherInfoRsp rsp=new GatherInfoRsp();
		Integer gatherinfoid=gatherInfoParam.getGatherinfoid();
		GatherInfo gatherInfo=new GatherInfo();
		try{
			gatherInfo=gatherInfoService.getinfo(gatherinfoid);
			if(gatherInfo==null){
				rsp.setData(null);
				rsp.setMsg("获取信息为空");
				rsp.setRetcode(2001);
				return rsp;
			}
		}catch(Exception e){
			System.out.println(e);
			rsp.setData(null);
			rsp.setMsg("获取信息为空");
			rsp.setRetcode(2001);
			return rsp;
		}
		rsp.setData(gatherInfo);
		rsp.setMsg("获取gatherInfo成功");
		rsp.setRetcode(2000);
		
		return rsp;
	}
}
