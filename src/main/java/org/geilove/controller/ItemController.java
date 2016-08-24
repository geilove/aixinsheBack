package org.geilove.controller;

//这个是项目表，提供项目相关的发布，删除等接口，
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Resource;

import org.geilove.pojo.Item;
import org.geilove.requestParam.ItemListParam;
import org.geilove.response.ItemListRsp;
import org.geilove.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Resource
	ItemService itemService;
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public @ResponseBody ItemListRsp getItemList(@RequestBody ItemListParam param ){
		//String proof=param.getProof();
		Long userID=param.getUserID();
		Integer page=param.getPage();
		Integer pageSize=param.getPageSize();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userID", userID);
		map.put("page", page);
		map.put("pageSize", pageSize);
		ItemListRsp rsp=new ItemListRsp();
		List<Item> lsitem=itemService.getItemList(map);
		rsp.setLp(lsitem); //需要进一步完善
		return rsp;		
	}

}
