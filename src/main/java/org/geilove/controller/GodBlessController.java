package org.geilove.controller;
import org.geilove.pojo.Cash;
import org.geilove.requestParam.AddCommentParam;
import org.geilove.requestParam.ChangeToBeHelpedParam;
import org.geilove.vo.BaseVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import javax.annotation.Resource;

import org.geilove.service.ChangeManToBeHelpedService;
/*
 *这个提供爱心社更改普通用户为受助人用户的相关接口
 */
 
@Controller
@RequestMapping("/godbless")
public class GodBlessController {
	
	@Resource 
	private  ChangeManToBeHelpedService helpService;
	@RequestMapping("/changetobehelped")
    public @ResponseBody BaseVo changeToBeHelped(@RequestBody ChangeToBeHelpedParam param){
		helpService.changeSomeUserProfile((byte)4);
		Cash cash=new Cash();
		cash.setClosetime(param.getCloseTime());
		cash.setOpentime(new Date());
		cash.setCashid(param.getUserID());
		cash.setBackupone(param.getDifficult());
		cash.setUseridcircle(param.getUserIDCircle());
		cash.setTargetcash(param.getTargetCash());
		Integer tag=helpService.insertRecordIntoCashTable(cash);
		BaseVo bv=new BaseVo();
		bv.setTag(tag);
		bv.setReason("出错/或者正确");
		return bv; 
	}
}











