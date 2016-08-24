package org.geilove.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.geilove.service.ItemService;
import org.geilove.dao.ItemMapper;
import org.geilove.pojo.Item;
import org.springframework.stereotype.Service;

@Service("itemservice")
public class ItemServiceImp implements ItemService {
	@Resource
	ItemMapper  iTemMapper;
	
	public  List<Item> getItemList(Map<String,Object> map){
		List<Item> lsItem=new ArrayList<Item>();
		lsItem=iTemMapper.getItemList(map);
		return lsItem;
	}
}
