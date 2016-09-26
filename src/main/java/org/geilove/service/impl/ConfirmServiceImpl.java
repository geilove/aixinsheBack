package org.geilove.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.geilove.pojo.Confirm;
import org.geilove.service.ConfirmService;
import org.springframework.stereotype.Service;
import org.geilove.dao.ConfirmMapper;
@Service("confirmservice")
public class ConfirmServiceImpl implements ConfirmService {
	
	 @Resource
	 private ConfirmMapper confirmMapper;
	
	 public List<Confirm> getConfirmLists(Map<String,Object> map){
		 
		List<Confirm> lc=new ArrayList<Confirm>();
		lc=confirmMapper.getConfirmList(map);
		
		return lc;
	 }
	 
	 public Integer getPeopleConfirms(Map<String,Object> map){
		 Integer counts=confirmMapper.getCount(map);
		 return counts;
	 }
}
