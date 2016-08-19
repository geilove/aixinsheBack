package org.geilove.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.geilove.dao.MoneySourceMapper;
import org.geilove.dao.UserMapper;
import org.geilove.service.HelpService;
import org.geilove.sqlpojo.OtherPartHelpPojo;
import org.geilove.sqlpojo.PartHelpPojo;
import org.springframework.stereotype.Service;
@Service("helpservice")
public class HelpServiceImpl implements HelpService{
	
	@Resource
	MoneySourceMapper moneySourceMapper;
	@Resource
	UserMapper userMapper;
	public List<PartHelpPojo> getPartHelpList(Map<String,Object> map){
		List<PartHelpPojo> lp=new ArrayList<PartHelpPojo>();
		lp=moneySourceMapper.selectHelpMen(map);
		return lp;
	}
	
	public List<OtherPartHelpPojo> getOtherPartHelpList(List<Long> lst){
		List<OtherPartHelpPojo> lp=new ArrayList<OtherPartHelpPojo>();
		lp=userMapper.selectUserPartProfile(lst);
		return lp;
	}
	
}
