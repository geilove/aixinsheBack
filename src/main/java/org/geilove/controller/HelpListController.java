package org.geilove.controller;
/*
 * 这里提供查询帮助人数，接收帮助人数查询等相关的接口
 * */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Resource;
import org.geilove.service.HelpService;
import org.geilove.sqlpojo.PartHelpPojo;
import org.geilove.response.HelpListRsp;
import org.geilove.requestParam.HelpParam;
@Controller
@RequestMapping("/help")
public class HelpListController {
	@Resource
	private HelpService helpService;
	
	@RequestMapping(value="/helpother")
	public  @ResponseBody HelpListRsp  getHelpList(@RequestBody HelpParam helpParam){
		HelpListRsp rsp=new HelpListRsp();
		Map<String,Object> map=new HashMap<String,Object>();
		
		List<PartHelpPojo> php=helpService.getPartHelpList(map);
		//提取出php的userID，组成列表lst,然后查询其余Profile
		//List<OtherPartPojo> profile=helpService.getOtherPartHelpList(lst);
		//将php和profile的值合并在一起，存放在rsp中，然后返回
		
		return rsp;
	}
}









