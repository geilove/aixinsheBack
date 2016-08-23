package org.geilove.service;
import java.util.List;
import java.util.Map;

import org.geilove.pojo.DoubleFans;
import org.geilove.sqlpojo.PartWatchPojo;
public interface WatchService {
 
	public Integer doWatch(DoubleFans dbfans);
	
	List<PartWatchPojo> getPartWatchInfo(Map<String,Object> map); //获得关注人信息
	
}
