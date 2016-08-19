package org.geilove.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import  org.springframework.stereotype.Service;
import org.geilove.service.PeopleListService;
import org.geilove.dao.UserMapper;
import org.geilove.sqlpojo.DonaterPojo;
import org.geilove.sqlpojo.LoveClubListPojo;
import org.geilove.sqlpojo.PeopleNeedLovePojo;
import org.geilove.sqlpojo.DonaterPojo;

@Service("peoplelistservice")
public class PeopleListServiceImpl implements PeopleListService {

    @Resource
	private UserMapper  userMapper;
    
	public List<PeopleNeedLovePojo> needHelpPeopleList( Map<String,Object> map){
		
		List<PeopleNeedLovePojo> lp=userMapper.selectNeedLovePeople(map);
		
		return lp;
	}
	
	public List<LoveClubListPojo> loveClubPeopleList( Map<String,Object> map){
		List<LoveClubListPojo> lp=userMapper.selectLoveClubPeople(map);		
		return lp;
	}
	
	public List<DonaterPojo> donaterPeopleList(Map<String,Object> map){
		List<DonaterPojo>  lp=userMapper.selectDonaterPeople(map);
		return lp;
	}
}
