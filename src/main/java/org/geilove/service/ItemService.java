package org.geilove.service;

import org.geilove.pojo.Item;
import java.util.List;
import java.util.Map;

public interface ItemService {
	
	public  List<Item> getItemList(Map<String,Object> map);
}
