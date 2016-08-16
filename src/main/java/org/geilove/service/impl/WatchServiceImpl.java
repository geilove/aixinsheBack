package org.geilove.service.impl;

import javax.annotation.Resource;

import org.geilove.pojo.DoubleFans;
import org.geilove.service.WatchService;
import org.geilove.dao.DoubleFansMapper;
import org.springframework.stereotype.Service;
@Service("dowatch")
public class WatchServiceImpl implements WatchService{
	
    private Integer watchtag;
	@Resource
	private DoubleFansMapper dbMapper;
	
	@Override
	public Integer doWatch(DoubleFans dbfans){
		watchtag=dbMapper.insert(dbfans);
		System.out.print(watchtag);//打印下，看看插入成功和失败的返回值
		return watchtag;
	}
}
