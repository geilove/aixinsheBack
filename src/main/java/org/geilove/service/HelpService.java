package org.geilove.service;

import java.util.List;
import java.util.Map;

import org.geilove.sqlpojo.PartHelpPojo;
import org.geilove.sqlpojo.OtherPartHelpPojo;
public interface HelpService {
	
	public List<PartHelpPojo> getPartHelpList(Map<String,Object> map); //获取帮助人-被帮助人关系对列表
	
	public List<OtherPartHelpPojo> getOtherPartHelpList(List<Long> lst);// 根据一组userid值，获得一组用户的部分信息
	
}
