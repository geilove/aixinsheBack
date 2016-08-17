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

/*
 *这里提供诸如爱心社列表 粉丝列表 公益排行榜列表 
 */

@Controller
@RequestMapping("/peoplelist")
public class PeopleListController {
	@Resource
	private PeopleListService peopleListService;
	
	@RequestMapping(value="/needLove")
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
		//这里根据tag的值不同，进行不同的查询
		if(tag==4){
			lp=peopleListService.needHelpPeopleList(map);
			rsp.setLp(lp);
			rsp.setMsg("获取需要帮助人列表成功");
			rsp.setRetcode(2000);
		}else if(tag==2){
			
		}
		return rsp;  //这个需要更改返回值
	}

}
