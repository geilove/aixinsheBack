package org.geilove.service;

import java.util.Map;

import org.geilove.pojo.DoubleFans;

public interface RelationService {
	
	public Integer watchManService(DoubleFans doubleFans); //收听一个人时要调用这个方法
	
	public Integer unWatchManService(Map<String,Object> map); //取消收听一个人时，要调用这个方法。
}
