package org.geilove.service;

import  java.util.List;
import java.util.Map;
import org.geilove.sqlpojo.PeopleNeedLovePojo;
import org.geilove.sqlpojo.LoveClubListPojo;
import org.geilove.pojo.User;
import org.geilove.sqlpojo.DonaterPojo;
public interface PeopleListService {
	public List<User> getMenList( Map<String,Object> map); //监督处爱心社等列表
	
	public List<User> getPayOrWatchMen( Map<String,Object> map); //我关注或者关注我的人列表
	
	public List<User> donaterPeopleList(Map<String,Object> map); //查询我帮助或者帮助我的人列表
	
}
