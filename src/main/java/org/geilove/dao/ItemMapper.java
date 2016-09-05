package org.geilove.dao;

import java.util.List;
import java.util.Map;

import org.geilove.pojo.Item;

public interface ItemMapper {
    int deleteByPrimaryKey(Integer itemid);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer itemid);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
     
    List<Item> getItemList(Map<String,Object> map);  //获取项目首页列表
    
    List<Item> loadMoreItemList(Map<String,Object> map); //加载更多
}