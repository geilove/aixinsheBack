package org.geilove.service;

import  java.util.List;
import java.util.Map;
import org.geilove.sqlpojo.PeopleNeedLovePojo;

public interface PeopleListService {
	public List<PeopleNeedLovePojo> needHelpPeopleList( Map<String,Object> map); //需要帮助人列表
	
}
