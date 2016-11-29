package org.geilove.service.impl;

import javax.annotation.Resource;

import org.geilove.dao.GatherInfoMapper;
import org.geilove.pojo.GatherInfo;
import org.geilove.service.GatherInfoService;
import org.springframework.stereotype.Service;

@Service("gatherinfo")
public class GatherInfoServiceImpl implements GatherInfoService {
	@Resource
	private GatherInfoMapper gatherInfoMapper;
	
	public GatherInfo getinfo ( Integer gatherinfoid){
		GatherInfo gatherInfo=gatherInfoMapper.selectByPrimaryKey(gatherinfoid);
		return gatherInfo;
	}
}
