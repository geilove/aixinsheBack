package org.geilove.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import  org.springframework.stereotype.Service;
import org.geilove.service.PeopleListService;
import org.geilove.dao.UserMapper;
import org.geilove.pojo.User;
import org.geilove.sqlpojo.DonaterPojo;
import org.geilove.sqlpojo.LoveClubListPojo;
import org.geilove.sqlpojo.PeopleNeedLovePojo;
import org.geilove.sqlpojo.DonaterPojo;

@Service("peoplelistservice")
public class PeopleListServiceImpl implements PeopleListService {

    @Resource
	private UserMapper  userMapper;
    
	public List<User> getMenList( Map<String,Object> map){
		
		List<User> lp=userMapper.selectMenList(map);
		
		return lp;
	}
	
	public List<User> getPayOrWatchMen( List<Long> ll){
		List<User> lp=userMapper.getPayOrWatchPeople(ll);		
		return lp;
	}
	
	public List<User> donaterPeopleList(List<Long> ll){
		List<User>  lp=userMapper.getPayOrWatchPeople(ll);
		return lp;
	}
}
