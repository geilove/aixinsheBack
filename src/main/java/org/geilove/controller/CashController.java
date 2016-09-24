package org.geilove.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

import org.geilove.pojo.Cash;
import org.geilove.requestParam.CashParam;
import org.geilove.service.CashService;

@Controller
@RequestMapping("/cash")
public class CashController {
	@Resource
	private CashService cashService;
    /*如果推文是救助信息，这里获取有关救助的说明*/	
	@RequestMapping(value="/getcashrecord",method=RequestMethod.POST)
	public @ResponseBody Cash getCashRecord(@RequestBody CashParam cashparam){
		Cash cash=new Cash();		
		cash=cashService.getCashRecord(new Long(cashparam.getCashid()));  //转换为long类型
		return cash;
	}

}
