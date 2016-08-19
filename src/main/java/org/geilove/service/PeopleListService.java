package org.geilove.service;

import  java.util.List;
import java.util.Map;
import org.geilove.sqlpojo.PeopleNeedLovePojo;
import org.geilove.sqlpojo.LoveClubListPojo;
import org.geilove.sqlpojo.DonaterPojo;
public interface PeopleListService {
	public List<PeopleNeedLovePojo> needHelpPeopleList( Map<String,Object> map); //需要帮助人列表
	
	public List<LoveClubListPojo> loveClubPeopleList( Map<String,Object> map); //通用展示人的列表方法
	
	public List<DonaterPojo> donaterPeopleList(Map<String,Object> map); //慈善排行榜
	
}
