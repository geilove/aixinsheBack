package org.geilove.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import  org.springframework.stereotype.Service;
import org.geilove.service.PeopleListService;
import org.geilove.dao.UserMapper;
import org.geilove.sqlpojo.PeopleNeedLovePojo;
@Service("peoplelistservice")
public class PeopleListServiceImpl implements PeopleListService {

    @Resource
	private UserMapper  userMapper;
    
	public List<PeopleNeedLovePojo> needHelpPeopleList( Map<String,Object> map){
		
		List<PeopleNeedLovePojo> lp=userMapper.selectNeedLovePeople(map);
		
		return lp;
	}
}
